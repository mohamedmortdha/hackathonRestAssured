package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.*;

public class StepsDefinition {
    static RequestSpecification request;
    static Date date = new Date();
    static SimpleDateFormat DateFor = new SimpleDateFormat("MM_dd_yyyy_hh_mm");
    static String runDate = "_" + DateFor.format(date);
    static Response response;

    static JSONObject jobParams = new JSONObject();
    static JSONObject jobUpdateParams = new JSONObject();
    static JSONObject requestParams = new JSONObject();



    @Given("I set base url {string}")
    public void iSetBaseUrl(String endPoint) {
        // host url
        RestAssured.baseURI = "http://192.168.1.73:9090" + endPoint;
        request = RestAssured.given().relaxedHTTPSValidation();
        request.header("Content-Type", "application/json");
    }

    @And("I set product name {string} and price {string}")
    public void iSetProductNameAndPrice(String name, String price) {
        jobParams.put("name", name+runDate);
        jobParams.put("price", Integer.parseInt(price));
        System.out.println(jobParams.toJSONString());
    }

    @When("I post product")
    public void iPostProduct() {
        request.body(jobParams.toJSONString());
        response = request.post();
    }

    @Then("Post product response should be {string}")
    public void postProductResponseShouldBe(String status) {
        System.out.println("response" + response.asPrettyString().toString());
        Assert.assertEquals("Status code should be" + status, Integer.parseInt(status), response.statusCode());
    }
}
