package workFlows;


import extensions.uiAction;
import io.qameta.allure.Step;
import utilities.commonOps;

public class mobileFlows extends commonOps
{
    @Step("Fill in form & calculate Mortgage")
    public static void calculate(String amount, String tern, String rate)
    {
        uiAction.updateText(mortgageMain.txt_amount, amount);
        uiAction.updateText(mortgageMain.txt_term, tern);
        uiAction.updateText(mortgageMain.txt_rate, rate);
        uiAction.click(mortgageMain.btn_calculate);


    }
}