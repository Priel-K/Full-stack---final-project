package sanityTest;

import extensions.verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.commonOps;
import workFlows.webFlows;
@Listeners(utilities.listeners.class)

public class grafanaWebDB extends commonOps
{

    @Test(description = "Test01:Login to Grafana with DB")
    @Description("Test description: Login to Grafana web application with DB")
    public static void test_loginDB()
    {
        webFlows.loginDB();
      //  verification.textInElement(grafanaMain.txt_mainHeading, "Home Dashboard");

    }

}
