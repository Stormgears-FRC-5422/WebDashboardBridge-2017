import com.google.gson.JsonElement;
import org.stormgears.WebDashboard.GameControl.*;
import org.stormgears.WebDashboard.RecordListener;
import org.stormgears.WebDashboard.WebDashboard;

/**
 * Created by andrew on 12/29/16.
 */
public class WebDashboardTester {
	public static void main(String[] args) throws Exception {
		WebDashboard.init();
//		System.out.println(WebDashboard.getDouble("motor"));
//		WebDashboard.subscribeRecord("motor", new RecordListener() {
//			@Override
//			public void recordChanged(String path, JsonElement data) {
//				System.out.println(data);
//			}
//		});


		WebDashboard.set("config", "game", new GameControl[]{
				new Radios.Builder()
						.setLabel("Alliance")
						.setPath("alliance")
						.setWidth(4)
						.setEntries(new Radios.Radio[]{
								new Radios.Radio("red", "Red"),
								new Radios.Radio("blue", "Blue")
						})
						.createRadios(),
				new Radios.Builder()
						.setLabel("Gear Placement")
						.setPath("gearPlacement")
						.setWidth(4)
						.setEntries(new Radios.Radio[]{
								new Radios.Radio("left", "Place Gear Left"),
								new Radios.Radio("center", "Place Gear Center", false),
								new Radios.Radio("right", "Place Gear Right")
						})
						.createRadios(),
				new Radios.Builder()
						.setLabel("Drop-Off Location")
						.setPath("gearDropOff")
						.setWidth(4)
						.setEntries(new Radios.Radio[]{
								new Radios.Radio("gearPickup", "Drop Off at Gear Pickup"),
								new Radios.Radio("baseline", "Drop Off at Baseline")
						})
						.createRadios(),
				new Select.Builder()
						.setLabel("Testing select box")
						.setPath("selectTest")
						.setLarge(true)
						.setEnabled(true)
						.setWidth(12)
						.setOptions(new Select.Option[]{
								new Select.Option("MEOW", "cat"),
								new Select.Option("WOOF", "dog")
						})
						.createSelect(),
				new Spacer(4),
				new Checkboxes.Builder()
						.setLabel("Test checkboxes")
						.setPath("checkboxTest")
						.setWidth(6)
						.setEntries(new Checkboxes.Checkbox[]{
								new Checkboxes.Checkbox("one", "Option one"),
								new Checkboxes.Checkbox("two", "Option two")
						})
						.createCheckboxes(),
				new Text.Builder()
						.setLabel("Testing text")
						.setPath("textTest")
						.setWidth(2)
						.setEditable(true)
						.setNumbersOnly(true)
						.setLarge(true)
						.createText(),
				new TextField.Builder()
						.setLabel("Testing textfield")
						.setPath("textFieldTest")
						.setWidth(8)
						.setFill(true)
						.setNumbersOnly(true)
						.createTextField(),
				new TextArea.Builder().setLabel("Textarea Test").setWidth(4).setPath("textAreaTest").createTextArea()
		});
		System.out.println("meow");
	}
}
