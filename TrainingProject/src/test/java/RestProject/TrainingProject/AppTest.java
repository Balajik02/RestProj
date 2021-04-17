package RestProject.TrainingProject;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
//import org.junit.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void shouldAnswerWithTrue()
    {
    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    	 RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON);
    	 Response response = httpRequest.when().get("/posts/1");
    	 
    	 // First get the JsonPath object instance from the Response interface
    	 JsonPath jsonPathEvaluator = response.jsonPath();
    	 
    	 // Then simply query the JsonPath object to get a String value of the node
    	 // specified by JsonPath: City (Note: You should not put $. in the Java code)
    	 String actTitle = jsonPathEvaluator.get("title");
    	 String expTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
    	 // Let us print the city variable to see what we got
    	 
    	 // Validate the response
    	 assertTrue(expTitle.contains(actTitle), "title mismatch");
    	 
    }
}
