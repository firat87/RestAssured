package API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ServiceAutomation {
	
	@Test
	public void Test1(){
		
		//RestAssured.baseURI="http://mnprepo-route-documentum-transition.mcloud-esy.vodafone.local/getMnpDocument";
		RequestSpecification httpRequest= RestAssured.given();
		Response rsp = httpRequest.get("http://mnprepo-route-documentum-transition.mcloud-esy.vodafone.local/getMnpDocument?reqId=AVEA-2020-9974304124&docType=01");
		//Response rsp = httpRequest.get("/?reqId=AVEA-2020-9974304124&docType=01");
		ResponseBody body = rsp.getBody();
		 String bodyAsString = body.asString();
			System.out.println("body is " + bodyAsString);
		JsonPath jsonPathEvaluator = rsp.jsonPath();
		String id=jsonPathEvaluator.get("contentId");
		
		System.out.println("id is " + id);
		
	
		
		given().queryParam("reqId", "AVEA-2020-9974304124").queryParam("docType", "01").when().
		get("http://mnprepo-route-documentum-transition.mcloud-esy.vodafone.local/getMnpDocument").then().log().body();
		
	
							

		
		
		//given().queryParam("reqId", "AVEA-2020-9974304124").then().body(arg0, arg1, arg2, arg3)
		
	}

}
