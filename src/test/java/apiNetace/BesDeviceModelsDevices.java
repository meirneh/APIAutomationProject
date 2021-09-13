package apiNetace;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BesDeviceModelsDevices extends BaseTest {
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "Netace2021!";
	
	@Test(priority = 1, description = "add a Backend server", enabled = true)
	public void tc01postaddBES() {

		// Create JSON Body
		JSONObject body = new JSONObject();

		body.put("ip", "172.18.11.10");
		body.put("port", "13772");
		body.put("regionId", "2");

		// Get response
		Response response = RestAssured.given().spec(spec).auth().preemptive().basic(USERNAME, PASSWORD)
				.contentType(ContentType.JSON).body(body.toString())
				.post("/server/backendServer/add?ip=172.18.11.10&port=13772&regionId=2");
		response.prettyPrint();
		// Verifications
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		// Fields verifications:
		SoftAssert softAssert = new SoftAssert();
		String errorLevel = response.jsonPath().getString("errorLevel");
		softAssert.assertEquals(errorLevel, "OK", "errorLevel should be OK but it's not!!!");
		System.out.println("errorLevel:" + errorLevel);
		boolean isOk = response.jsonPath().getBoolean("isOk");
		softAssert.assertEquals(isOk, true, "isOk should be true but it's not!!!");
		System.out.println("isOk:" + isOk);
		softAssert.assertAll();

	}

	@Test(priority = 2, description = "add a Elements Models", enabled = true)
	public void tc02postaddElements() {

		File file = new File("C:/Program Files/Atrinet/NetACE_8.0.0/NetMgr/gui/data/device_models.zip");
		// Get response
		Response response = RestAssured.given().spec(spec).auth().preemptive().basic("admin", "Netace2021!")
				.multiPart("file", file, "multipart/form-data").when()
				.post("/device-models/import/models?rediscoverElements=true").thenReturn();
		response.prettyPrint();

		// Verifications
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		// Fields body verifications:
		SoftAssert softAssert = new SoftAssert();
		String status = response.jsonPath().getString("status");
		softAssert.assertEquals(status, "OK", "the status should be OK but it's not!!!");

		String message = response.jsonPath().getString("message");
		softAssert.assertEquals(message, "Imported total of [14] models.",
				"the message in the response is not expected");

		String exception = response.jsonPath().getString("exception");
		softAssert.assertEquals(exception, "", "exception should be empty but it's not!!!");
		int id = response.jsonPath().getInt("id");
		softAssert.assertEquals(id, -1, "id should be -1 but it's not!!!");

		softAssert.assertAll();

	}

	@Test(priority = 3, description = "add a list of devices", enabled = true)
	public void tc03postaddListofDevices() throws InterruptedException {

		// Create JSON array of JSON objects
		// Create JSON Body
		JSONArray body = new JSONArray();

		JSONObject device1 = new JSONObject();
		device1.put("ip", "90.0.0.3");
		device1.put("name", "MX240-0.3");
		body.put(device1);
		JSONObject device2 = new JSONObject();
		device2.put("ip", "90.0.0.4");
		device2.put("name", "MX240-0.4");
		body.put(device2);
		JSONObject device3 = new JSONObject();
		device3.put("ip", "172.16.121.60");
		device3.put("name", "MX60");
		body.put(device3);
		JSONObject device4 = new JSONObject();
		device4.put("ip", "90.0.0.1");
		device4.put("name", "Cisco7613-0.1");
		body.put(device4);
		JSONObject device5 = new JSONObject();
		device5.put("ip", "90.0.0.2");
		device5.put("name", "Cisco7613-0.2");
		body.put(device5);
		JSONObject device6 = new JSONObject();
		device6.put("ip", "90.0.0.8");
		device6.put("name", "CiscoME3400-0.8");
		body.put(device6);
		JSONObject device7 = new JSONObject();
		device7.put("ip", "90.0.0.9");
		device7.put("name", "CiscoME3400-0.9");
		body.put(device7);
		JSONObject device8 = new JSONObject();
		device8.put("ip", "90.0.0.5");
		device8.put("name", "ALU-0.5");
		body.put(device8);
		JSONObject device9 = new JSONObject();
		device9.put("ip", "90.0.0.6");
		device9.put("name", "ALU-0.6");
		body.put(device9);
		// Get response
		Response response = RestAssured.given().spec(spec).auth().preemptive().basic("admin", "Netace2021!")
				.contentType(ContentType.JSON).body(body.toString()).post("/devices/add/list");
		response.prettyPrint();

		// Verifications

		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		// Verify all fields
		SoftAssert softAssert = new SoftAssert();
		// device 1
		String status1 = response.jsonPath().getString("[0].status");
		softAssert.assertEquals(status1, "OK", "status1 should be OK but it's not!!!");
		String message1 = response.jsonPath().getString("[0].message");
		softAssert.assertEquals(message1, "Device 90.0.0.3 was added. Id: 1",
				"message1 in the response it's not expected");
		String exception1 = response.jsonPath().getString("[0].exception");
		softAssert.assertEquals(exception1, "", "exception1 should be empty but it's not!!!");
		int id1 = response.jsonPath().getInt("[0].id");
		softAssert.assertEquals(id1, 1, "id1 should be 1 but it's not!!");
		System.out.println("id1:" + id1);
		// device 2
		String status2 = response.jsonPath().getString("[1].status");
		softAssert.assertEquals(status2, "OK", "status2 should be OK but it's not!!!");
		System.out.println("status2:" + status2);
		String message2 = response.jsonPath().getString("[1].message");
		softAssert.assertEquals(message2, "Device 90.0.0.4 was added. Id: 2",
				"message2 in the response it's not expected");
		String exception2 = response.jsonPath().getString("[1].exception");
		softAssert.assertEquals(exception2, "", "exception2 should be empty but it's not!!!");
		System.out.println("exception2:" + exception2);
		int id2 = response.jsonPath().getInt("[1].id");
		softAssert.assertEquals(id2, 2, "id2 should be 2 but it's not!!");
		// device 3
		String status3 = response.jsonPath().getString("[2].status");
		softAssert.assertEquals(status3, "OK", "status3 should be OK but it's not!!!");
		String message3 = response.jsonPath().getString("[2].message");
		softAssert.assertEquals(message3, "Device 172.16.121.60 was added. Id: 3",
				"message3 in the response it's not expected");
		System.out.println("message3:" + message3);
		String exception3 = response.jsonPath().getString("[2].exception");
		softAssert.assertEquals(exception3, "", "exception3 should be empty but it's not!!!");
		System.out.println("exception3:" + exception3);
		int id3 = response.jsonPath().getInt("[2].id");
		softAssert.assertEquals(id3, 3, "id3 should be 3 but it's not!!");
		// device4
		String status4 = response.jsonPath().getString("[3].status");
		softAssert.assertEquals(status4, "OK", "status4 should be OK but it's not!!!");
		System.out.println("status4:" + status4);
		String message4 = response.jsonPath().getString("[3].message");
		softAssert.assertEquals(message4, "Device 90.0.0.1 was added. Id: 4",
				"message4 in the response it's not expected");
		System.out.println("message4:" + message4);
		String exception4 = response.jsonPath().getString("[3].exception");
		softAssert.assertEquals(exception4, "", "exception4 should be empty but it's not!!!");
		int id4 = response.jsonPath().getInt("[3].id");
		softAssert.assertEquals(id4, 4, "id4 should be 4 but it's not!!");
		// device5
		String status5 = response.jsonPath().getString("[4].status");
		softAssert.assertEquals(status5, "OK", "status5 should be OK but it's not!!!");
		String message5 = response.jsonPath().getString("[4].message");
		softAssert.assertEquals(message5, "Device 90.0.0.2 was added. Id: 5",
				"message5 in the response it's not expected");
		System.out.println("message5:" + message5);
		String exception5 = response.jsonPath().getString("[4].exception");
		softAssert.assertEquals(exception5, "", "exception5 should be empty but it's not!!!");
		System.out.println("exception5:" + exception5);
		int id5 = response.jsonPath().getInt("[4].id");
		softAssert.assertEquals(id5, 5, "id5 should be 5 but it's not!!");
		// device6
		String status6 = response.jsonPath().getString("[5].status");
		softAssert.assertEquals(status6, "OK", "status6 should be OK but it's not!!!");
		String message6 = response.jsonPath().getString("[5].message");
		softAssert.assertEquals(message6, "Device 90.0.0.8 was added. Id: 6",
				"message6 in the response it's not expected");
		String exception6 = response.jsonPath().getString("[5].exception");
		softAssert.assertEquals(exception6, "", "exception6 should be empty but it's not!!!");
		System.out.println("exception6:" + exception6);
		int id6 = response.jsonPath().getInt("[5].id");
		softAssert.assertEquals(id6, 6, "id6 should be 6 but it's not!!");
		// device7
		String status7 = response.jsonPath().getString("[6].status");
		softAssert.assertEquals(status7, "OK", "status7 should be OK but it's not!!!");
		String message7 = response.jsonPath().getString("[6].message");
		softAssert.assertEquals(message7, "Device 90.0.0.9 was added. Id: 7",
				"message7 in the response it's not expected");
		String exception7 = response.jsonPath().getString("[6].exception");
		softAssert.assertEquals(exception7, "", "exception7 should be empty but it's not!!!");
		System.out.println("exception7:" + exception7);
		int id7 = response.jsonPath().getInt("[6].id");
		softAssert.assertEquals(id7, 7, "id7 should be 7 but it's not!!");
		// device8
		String status8 = response.jsonPath().getString("[7].status");
		softAssert.assertEquals(status8, "OK", "status8 should be OK but it's not!!!");
		String message8 = response.jsonPath().getString("[7].message");
		softAssert.assertEquals(message8, "Device 90.0.0.5 was added. Id: 8",
				"message8 in the response it's not expected");
		String exception8 = response.jsonPath().getString("[7].exception");
		softAssert.assertEquals(exception8, "", "exception8 should be empty but it's not!!!");
		int id8 = response.jsonPath().getInt("[7].id");
		softAssert.assertEquals(id8, 8, "id8 should be 8 but it's not!!");
		System.out.println("id8:" + id8);
		// device9
		String status9 = response.jsonPath().getString("[8].status");
		softAssert.assertEquals(status9, "OK", "status9 should be OK but it's not!!!");
		String message9 = response.jsonPath().getString("[8].message");
		softAssert.assertEquals(message9, "Device 90.0.0.6 was added. Id: 9",
				"message9 in the response it's not expected");
		String exception9 = response.jsonPath().getString("[8].exception");
		softAssert.assertEquals(exception9, "", "exception9 should be empty but it's not!!!");
		System.out.println("exception9:" + exception9);
		int id9 = response.jsonPath().getInt("[8].id");
		softAssert.assertEquals(id9, 9, "id9 should be 9 but it's not!!");
		softAssert.assertAll();

		softAssert.assertAll();
		Thread.sleep(15000);
	}

	@Test(priority = 4, description = "count of the devices", enabled = true)
	public void tc04getDevicesCount() throws InterruptedException {
		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/devices/count");

		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		String count = response.getBody().asString();

		response.prettyPrint();

		response.getStatusCode();

		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");
		// Verify the quantity of 9 devices in the response
		Assert.assertEquals(count, "9", "the number of devices must be 9 but is not!!!!");
		Thread.sleep(90000);

	}

}
