package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utilities.commonOps;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class verification extends commonOps
{
   @Step("Verify text in element")
    public static void textInElement(WebElement elem ,String expectedValue)
    {
        if(!getData("PlatFormName").equalsIgnoreCase("mobile") && !getData("PlatFormName").equalsIgnoreCase("electron"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expectedValue);
    }

    @Step("Verify Number of element")
    public static void numberOfElement(List<WebElement> elems, int expectedValue)
    {
        if(!getData("PlatFormName").equalsIgnoreCase("mobile"))
           wait.until(ExpectedConditions.visibilityOf(elems.get((elems.size())-1)));
        assertEquals(elems.size(),expectedValue);
    }

    @Step("Verify Element visually")
    public static void visualElement(WebElement imageElement , String expectedImageName)
    {
        BufferedImage expectedImage= null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("imageRepo") + expectedImageName +"png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file" + e );
        }

        Screenshot imageScreenShot = new AShot(). takeScreenshot(driver , imageElement);
        BufferedImage actualImage = imageScreenShot. getImage();
        diff= imgDiff.makeDiff(actualImage ,expectedImage );
        assertFalse("images are not the same", diff.hasDiff());

    }

    @Step("Verify text with text")
    public static void text(String actualText, String expectedText)
    {
        assertEquals(actualText,expectedText );
    }

}
