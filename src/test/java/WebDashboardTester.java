import org.stormgears.WebDashboard.WebDashboard;

/**
 * Created by andrew on 12/29/16.
 */
public class WebDashboardTester {
	public static void main(String[] args) throws Exception {
		WebDashboard.init("localhost:6020");
		System.out.println(WebDashboard.getDouble("motor"));
		WebDashboard.subscribeRecord();
	}
}
