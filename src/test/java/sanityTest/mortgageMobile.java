package sanityTest;

import extensions.verification;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.commonOps;
import workFlows.mobileFlows;
import workFlows.webFlows;

public class mortgageMobile extends commonOps
{
    @Test(description = "Test01: Verify mortgage")
    @Description("Test description: Fill in form & calculate Mortgage")
    public static void test01_verifyRepayment()
    {
        mobileFlows.calculate("1000", "3" ,"4");
        verification.textInElement(mortgageMain.txt_repayment, "£30.03");
    }
}
