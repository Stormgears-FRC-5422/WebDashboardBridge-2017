import com.google.gson.JsonElement;
import org.stormgears.WebDashboard.GameControl.*;
import org.stormgears.WebDashboard.RecordListener;
import org.stormgears.WebDashboard.WebDashboard;

/**
 * Created by andrew on 12/29/16.
 */
public class WebDashboardTester {
	public static void main(String[] args) throws Exception {
		WebDashboard.init("localhost:5802");
		System.out.println(WebDashboard.getDouble("motor"));
		WebDashboard.subscribeRecord("motor", new RecordListener() {
			@Override
			public void recordChanged(String path, JsonElement data) {
				System.out.println(data);
			}
		});


		WebDashboard.set("config", "game", new GameControl[]{
				new Slider("Test Slider", "motor", 0, 1, 0.1, 0.1),
				new Radios.Builder()
						.setPath("radioTest")
						.setWidth(6)
						.setLabel("Test Radio Buttons")
						.setLarge(true)
						.setToggleType(ToggleType.SWITCH)
						.setEntries(new Radios.Radio[]{
								new Radios.Radio("meow", "Cat", true),
								new Radios.Radio("woof", "Dog", true),
								new Radios.Radio("quack", "Duck", false)
						}).createRadios(),
				new Progress.Builder()
						.setPath("motor")
						.setLabel("Motor Progress")
						.setWidth(6)
						.setIntent(Intent.WARNING)
						.createProgress()
		});
	}
}
