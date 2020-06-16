package sanityTest;

import extensions.verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.commonOps;
import workFlows.electronFlow;
import workFlows.webFlows;

@Listeners(utilities.listeners.class)
public class electronDemo extends commonOps
{
    @Test(description = "Get screen info Resolution")
    @Description("Test description: Getting the Resolution from app and verify it ")
    public static void test01_electron()
    {
        electronFlow.getScreenInfo();
        verification.textInElement(electronMain.fild_screen_info, "Your screen is: 1366px x 768px");
    }
}
