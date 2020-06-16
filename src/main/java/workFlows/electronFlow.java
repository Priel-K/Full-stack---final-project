package workFlows;

import extensions.uiAction;
import io.qameta.allure.Step;
import utilities.commonOps;

public class electronFlow extends commonOps

{
    @Step("Get screen info(Resolution)")
public static void getScreenInfo()
{
    uiAction.click(electronMain.btn_windows);
    uiAction.click(electronMain.btn_info);
    uiAction.click(electronMain.btn_demo_toggle);
    uiAction.click(electronMain.btn_demo_toggle);
    uiAction.click(electronMain.btn_screen_info);
}


}
