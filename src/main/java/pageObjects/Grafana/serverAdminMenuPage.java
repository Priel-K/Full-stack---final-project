package pageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class serverAdminMenuPage
{

    @FindBy(how= How.CSS, using="a[href='/admin/users']")
    public WebElement link_users;

    @FindBy(how= How.CSS, using="a[href='/admin/org']")
    public WebElement link_org;

    @FindBy(how= How.CSS, using="a[href='/admin/settings']")
    public WebElement link_settings;

    @FindBy(how= How.CSS, using="a[href='/admin/stats']")
    public WebElement link_stats;


}
