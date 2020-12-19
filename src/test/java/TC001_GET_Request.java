import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class TC001_GET_Request {

    @Test
    void getweatherDetails()
    {

        //Especificar la URI base
        RestAssured.baseURI="https://reqres.in/api/users/";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET,"/5");

        //print response in console window
        String responseBody=response.getBody().asPrettyString();
        System.out.println("Response body is : "+ responseBody);

        //Status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is : "+ statusCode);

        Assert.assertEquals(statusCode, 200);

        //Status line verification
        String statusLine=response.getStatusLine();
        System.out.println("status line is: "+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

}
