package sanityTest;

import extensions.verification;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.commonOps;
import workFlows.apiFlows;

public class grafanaAPI extends commonOps
{
    @Test(description = "Test01: Get Team from Grafana")
    @Description("Test description: Login to Grafana and get team")
    public void test01_GetTeam()
    {
        verification.text(apiFlows.getTeamProperty("teams[0].name"), "pri");

    }


    @Test(description = "Test02: Add Team & verify it  ")
    @Description("Test description: Add Team to Grafana & verify it")
    public void test02_addTeamAndVerify()
    {
        apiFlows.postTeam("priel", "prili@gmail.com");
        verification.text(apiFlows.getTeamProperty("teams[0].name"),"priel");

    }


    @Test(description = "Test03: update team & verify it  ")
    @Description("Test description: update team in Grafana & verify it")
    public void test03_updateTeamAndVerify()
    {
        apiFlows.updateTeam("priel11", "prili101@gmail.com" , "6");
        verification.text(apiFlows.getTeamProperty("teams[0].name"),"priel11");

    }



    @Test(description = "Test04: delete team & verify it  ")
    @Description("Test description: delete team in Grafana & verify it")
    public void test04_deleteTeamAndVerify()
    {
        apiFlows.deleteTeam("6");
        verification.text(apiFlows.getTeamProperty("totalCount"),"0");

    }

}
