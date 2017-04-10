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
								new Radios.Radio("center", "Place Gear Center"),
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
						.createRadios()
		});
		System.out.println("meow");
	}
}
