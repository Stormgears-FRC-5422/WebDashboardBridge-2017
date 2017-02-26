import com.google.gson.JsonElement;
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
	}
}
