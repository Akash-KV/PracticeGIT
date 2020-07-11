package Controllers;

import Helpers.DriverHelper;
import Pom.Dashboard;
import org.junit.Assert;

public class DashboardController {

    Dashboard dashboard = new Dashboard();

    public void verifyDashboard() {
        boolean page = DriverHelper.checkElementDisplayByXpath(dashboard.getIlluminateLogo(), "DashboardPage");
        Assert.assertTrue(page);
    }
}
