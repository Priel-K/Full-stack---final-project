package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilities.commonOps;

public class apiActions extends commonOps
{

    @Step("Get data from server")
    public static Response get(String paramValues)
    {
        response = httpRequest.get(paramValues);
        return response;
    }



    @Step("Extract value from json format")
    public static String extractFromJSON(Response response, String path)
    {
        jp= response.jsonPath();
       return jp.get(path).toString();

    }


    @Step("Post data from server")
    public static void  post(JSONObject params, String resource)
    {
    httpRequest.header("content-Type", "application/json");
    httpRequest.body(params.toJSONString());
    response= httpRequest.post("resource");
        System.out.println(response.prettyPrint());
    }


    @Step("Update data in server")
    public static void  put(JSONObject params, String resource)
    {
        httpRequest.header("content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response= httpRequest.put("resource");
        System.out.println(response.prettyPrint());
    }


    @Step("Delete data from server")
    public static void  delete(String id)
    {

        response = httpRequest.delete("/api/teams/" + id);
        System.out.println(response.prettyPrint());
    }


}
