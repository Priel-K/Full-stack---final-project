package utilities;


import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
public static void init()
{

    grafanaLogin= PageFactory.initElements(driver,pageObjects.Grafana.logInPage.class);
    grafanaMain= PageFactory.initElements(driver,pageObjects.Grafana.mainPage.class);
    grafanaLeftMeun= PageFactory.initElements(driver,pageObjects.Grafana.leftMenuPage.class);
    grafanaServerAdminMenuPage = PageFactory.initElements(driver,pageObjects.Grafana.serverAdminMenuPage.class);
    grafanaServerAdminMainPage = PageFactory.initElements(driver,pageObjects.Grafana.serverAdminMainPage.class);
    grafanaUserListPage= PageFactory.initElements(driver,pageObjects.Grafana.userListPage.class);

    mortgageMain = PageFactory.initElements(driver,pageObjects.Mortgage.mainPage.class);
    electronMain= PageFactory.initElements(driver,pageObjects.ElectronDemo.mainPage.class);
    calcmain = PageFactory.initElements(driver,pageObjects.Calculator.mainPage.class);

}

}
