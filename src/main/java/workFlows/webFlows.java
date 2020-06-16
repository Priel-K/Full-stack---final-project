package workFlows;

import extensions.dbActions;
import extensions.uiAction;
import io.qameta.allure.Step;
import utilities.commonOps;

public class webFlows extends commonOps
{
    @Step("Login Grafana flow")
    public static void login(String user, String pass)
    {
        uiAction.updateText(grafanaLogin.txt_userName,user);
        uiAction.updateText(grafanaLogin.txt_password,pass);
        uiAction.click(grafanaLogin.btn_login);
        uiAction.click(grafanaLogin.btn_skip);


    }

    @Step("Login Grafana flow with DB ")
    public static void loginDB()
    {
        dbActions.getCredentials("selectuser_name,password from  credentials");
       // uiAction.updateText(grafanaLogin.txt_userName,user);
        //uiAction.updateText(grafanaLogin.txt_password,pass);
        //uiAction.click(grafanaLogin.btn_login);
        //uiAction.click(grafanaLogin.btn_skip);



    }

    @Step("Create a new user")
    public static void createUser(String name, String email,String user,  String pass)
    {
        uiAction.click(grafanaServerAdminMainPage.btn_newUser);
        uiAction.updateText(grafanaUserListPage.txt_name, name);
        uiAction.updateText(grafanaUserListPage.txt_email, email);
        uiAction.updateText(grafanaUserListPage.txt_login, user);
        uiAction.updateText(grafanaUserListPage.txt_password, pass);
        uiAction.click(grafanaUserListPage.btn_create);
    }

    @Step("Delete a user")
    public static void deleteLastUser()
    {
        uiAction.click(grafanaServerAdminMainPage.rows.get(grafanaServerAdminMainPage.rows.size()-1));
        uiAction.click(grafanaUserListPage.btn_delete);
        uiAction.click(grafanaUserListPage.btn_confirmDelete);

    }

}
