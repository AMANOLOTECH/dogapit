import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DogApiTests {
    @BeforeTest
    public void setupBaseURL(){
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://dog.ceo/api";
    }
    @Test
    public void ListAllAnimalBreeds()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/breeds/list/all");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body containing a list of all breeds =>  " + responseBody);

    }
    @Test
    public void ListAllRetrieverBreeds()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/breed/retriever/list");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body containing a list of all retriever breeds =>  " + responseBody);

    }
    @Test
    public void retrieveRandomImage()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/breed/retriever/golden/images/random");

        String responseBody = response.getBody().asString();
        System.out.println("Random image =>  " + responseBody);

    }
    @Test
    public void VerifyRetrieverIsWithinList()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/breeds/list/all");
        String responseBody = response.getBody().asString();
        boolean retriever = responseBody.contains("retriever");
        // Validate the response
        Assert.assertEquals(retriever, true, "Retriever is within list");

    }

}
