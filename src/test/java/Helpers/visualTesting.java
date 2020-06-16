package Helpers;

import org.testng.annotations.Test;
import utilities.commonOps;
import utilities.helperMethods;
import workFlows.webFlows;

public class visualTesting extends commonOps
{

    @Test
    public void creatScreenShot()
    {
        webFlows.login("admin ", "admin");
        helperMethods.takeElementsScreenShot(grafanaLeftMeun.img_Avatar , "grafanaAvatar");



    }
}
