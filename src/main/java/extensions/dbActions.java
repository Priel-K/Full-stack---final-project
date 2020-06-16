package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.commonOps;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class dbActions extends commonOps
{

    @Step("Get the creadentials from DB")
    public static void getCredentials (String query)
    {
        List<String> credentials = new ArrayList<String>();
        try
        {
            rs = stmt.executeQuery(query);
            rs.next();
           // System.out.println(rs.getString(1));
            //System.out.println(rs.getString(2));
        }
        catch (Exception e)
        {
            System.out.println("error printing table data"+e);



        }



    }
}
