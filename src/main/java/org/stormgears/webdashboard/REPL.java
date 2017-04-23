package org.stormgears.webdashboard;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import io.deepstream.RpcRequestedListener;
import io.deepstream.RpcResponse;
import jdk.internal.dynalink.beans.StaticClass;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by andrew on 4/21/17.
 */
public class REPL {
	private static NashornScriptEngineFactory engineFactory = new NashornScriptEngineFactory();
	private static ScriptEngine engine = engineFactory.getScriptEngine();

	private static ArrayList<String> imports = new ArrayList<>();
	private static ClassTree classTree;

	public static void init() {
		System.out.println("webdashboard:repl: Initializing REPL");

		resetShell();

		/*
		!!! WARNING WARNING WARNING !!!
		This RPC API is NOT PUBLIC (yet)
		Do not use unless you want to badly break your code each time you update WebDashboard!
		 */
		WebDashboard.client.rpc.provide("repl-eval", new RpcRequestedListener() {
			@Override
			public void onRPCRequested(String s, Object o, RpcResponse rpcResponse) {
				String code = o.toString();
				try {
					rpcResponse.send(engine.eval(code));
				} catch (Throwable e) {
					rpcResponse.send("Exception occurred.");
					e.printStackTrace();
				}
			}
		});

		WebDashboard.client.rpc.provide("repl-reset", new RpcRequestedListener() {
			@Override
			public void onRPCRequested(String s, Object o, RpcResponse rpcResponse) {
				resetShell();
				rpcResponse.send(null);
			}
		});

		WebDashboard.client.rpc.provide("repl-autocomplete", new RpcRequestedListener() {
			@Override
			public void onRPCRequested(String s, Object o, RpcResponse rpcResponse) {
				String in = o.toString().trim();

				Set<String> response = new HashSet<>();

				String[] path = in.split("\\.");
				ClassTree curr = classTree;

				if (!in.isEmpty()) {
					// First try evaluating it directly
					try {
						Object eval = engine.eval(in);
						if (eval instanceof ScriptObjectMirror) {
							ScriptObjectMirror obj = (ScriptObjectMirror) eval;
							Collections.addAll(response, obj.getOwnKeys(true));
//							if (obj.getClassName().equals("JavaPackage")) {
//								// should be caught by the other one
//							}
						} else if (eval instanceof StaticClass) {
							// mmm...reflection
							StaticClass staticClass = (StaticClass) eval;
							Class<?> representedClass = staticClass.getRepresentedClass();

							for (Method m : representedClass.getMethods()) {
								response.add(m.getName());
							}
							for (Field f : representedClass.getFields()) {
								response.add(f.getName());
							}
							for (Class c : representedClass.getClasses()) {
								response.add(c.getName());
							}
						} else {
//							Class<?> representedClass = eval.getClass();
//
//							for (Method m : representedClass.getMethods()) {
//								response.add(m.getName());
//							}
//							for (Field f : representedClass.getFields()) {
//								response.add(f.getName());
//							}
//							for (Class c : representedClass.getClasses()) {
//								response.add(c.getName());
//							}
						}
					} catch (Exception ignored) {

					}

					// Crawl the class tree
					for (String p : path) {
						if (curr != null && curr.tree.containsKey(p)) {
							curr = curr.tree.get(p);
						} else {
							curr = null;
							break;
//							rpcResponse.error("Not found");
//							return;
						}
					}

					if (curr != null) {
						response.addAll(curr.tree.keySet());
					}
				} else {
					// get everything at the root
					try {
						ScriptObjectMirror global = (ScriptObjectMirror) engine.eval("this");
						Collections.addAll(response, global.getOwnKeys(true));
					} catch (ScriptException e) {
						e.printStackTrace();
					}
					response.addAll(classTree.tree.keySet()); // might not be necessary, oh well
				}

				rpcResponse.send(response);
			}
		});

		// Get list of classes
		System.out.println("webdashboard:repl: Scanning classes");
		try {
			ClassPath loader = ClassPath.from(Thread.currentThread().getContextClassLoader());
			ImmutableSet<ClassPath.ClassInfo> allClasses = loader.getTopLevelClasses();
			ClassTree tree = new ClassTree();
			for (ClassPath.ClassInfo info : allClasses) {
				tree.addClass(Arrays.asList(info.getName().split("\\.")));
			}
			classTree = tree;
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Initialized REPL");
	}

	public static void resetShell() {
		engine = engineFactory.getScriptEngine();
	}

	public static void addImport(String packageName) {
		// TODO
	}


	private static class ClassTree {
		HashMap<String, ClassTree> tree = new HashMap<>();

		public void addClass(List<String> className) {
			if (!tree.containsKey(className.get(0))) {
				if (className.size() == 1) {
					tree.put(className.get(0), null);
				} else {
					tree.put(className.get(0), new ClassTree());
				}
			}

			if (className.size() > 1) {
				tree.get(className.get(0)).addClass(className.subList(1, className.size()));
			}
		}
	}
}
