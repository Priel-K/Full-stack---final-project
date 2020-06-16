package extensions;

import io.qameta.allure.Step;
import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.commonOps;


public class uiAction extends commonOps
{
    @Step("Click on element")
    public static void click (WebElement elem)
    {
        if(!getData("PlatFormName").equalsIgnoreCase("mobile") && !getData("PlatFormName").equalsIgnoreCase("electron"))
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Send text to text-field")
    public static void updateText(WebElement elem, String value)
    {
        if(!getData("PlatFormName").equalsIgnoreCase("mobile"))
           wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Update dropdown filed")
    public static void updateDropDown(WebElement elem, String value)
    {
        if(!getData("PlatFormName").equalsIgnoreCase("mobile"))
          wait.until(ExpectedConditions.visibilityOf(elem));
        Select myValue= new Select(elem);
        myValue.selectByVisibleText(value);
    }

    @Step("MouseHover element")
    public static void mouseHoverElement(WebElement elem1, WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();


    }


    }





