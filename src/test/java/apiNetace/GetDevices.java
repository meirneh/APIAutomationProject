package apiNetace;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class GetDevices extends BaseTest {
	@Test(priority = 5, description = "get a device from inventory by id", enabled = true)
	public void tc05getDeviceinventoryById() {

		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/devices/inventory/id/1?deviceId=1");

		response.prettyPrint();

		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		SoftAssert softAssert = new SoftAssert();
		// Verify all the fields:
		// id
		String id = response.jsonPath().getString("id");
		softAssert.assertEquals(id, "[1]", "id should be 1 but it's not!!");

		// operStatus
		String operStatus = response.jsonPath().getString("operStatus");
		softAssert.assertEquals(operStatus, "[MINOR]", "operStatus should be MINOR but it's not!!");
		// extStatus
		String extStatus = response.jsonPath().getString("extStatus");
		softAssert.assertEquals(extStatus, "[Managed]", "extStatus should be Managed but it's not!!");
		// name
		String name = response.jsonPath().getString("name");
		softAssert.assertEquals(name, "[MX240-0.3]", "name should be MX240-0.3 but it's not!!");
		// deviceType
		String deviceType = response.jsonPath().getString("deviceType");
		softAssert.assertEquals(deviceType, "[Juniper-MX240]", "deviceType should be Juniper-MX240 but it's not!!");
		System.out.println("deviceType: " + deviceType);
		// swVersion
		String swVersion = response.jsonPath().getString("swVersion");
		softAssert.assertEquals(swVersion, "[JUNOS Base OS Software Suite [13.3R5.9]]",
				"swVersion in response is not expected");
		// hwVersion
		String hwVersion = response.jsonPath().getString("hwVersion");
		softAssert.assertEquals(hwVersion, "[]", "hwVersion should be empty but it's not!!");
		// sysOID
		String sysOID = response.jsonPath().getString("sysOID");
		softAssert.assertEquals(sysOID, "[1.3.6.1.4.1.2636.1.1.1.2.29]",
				"sysOID should be 1.3.6.1.4.1.2636.1.1.1.2.29 but is not");
		// vendor
		String vendor = response.jsonPath().getString("vendor");
		softAssert.assertEquals(vendor, "[Juniper]", "vendor should be Juniper but it's not!!!");
		// connectivity
		String connectivity = response.jsonPath().getString("connectivity");
		softAssert.assertEquals(connectivity, "[OK]", "connectivityshould be OK but it's not!!!");
		// inventoryProperties

		// serialNumber
		String serialNumber = response.jsonPath().getString("inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber, "[JN1154937AFC]", "serialNumber should be [JN1154937AFC] but is not!!!");
		// sWVersion
		String sWVersion = response.jsonPath().getString("inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion, "[JUNOS Base OS Software Suite [13.3R5.9]]",
				"sWVersion in response is not expected");
		// model
		String model = response.jsonPath().getString("inventoryProperties.model");
		softAssert.assertEquals(model, "[Juniper MX240 Internet Backbone Router]",
				"model should be Juniper MX240 Internet Backbone Router but it's not!!");
		// externalLabel
		String externalLabel = response.jsonPath().getString("externalLabel");
		softAssert.assertEquals(externalLabel, "[90.0.0.3]", "externalLabel should be 90.0.0.3 but it's not!!");
		// externalLabel2
		String externalLabel2 = response.jsonPath().getString("externalLabel2");
		softAssert.assertEquals(externalLabel2, "[90.0.0.3]", "externalLabel2 should be 90.0.0.3 but it's not!!");
		// ipAddress
		String ipAddress = response.jsonPath().getString("ipAddress");
		softAssert.assertEquals(ipAddress, "[90.0.0.3]", "ipAddress should be 90.0.0.3 but it's not!!");
		softAssert.assertAll();

	}

	@Test(priority = 6, description = "get a device from inventory by ip", enabled = true)
	public void tc6getDeviceinventoryByIP() {

		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/devices/inventory/ip/90.0.0.3");

		response.prettyPrint();
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		SoftAssert softAssert = new SoftAssert();
		// Verify all the fields:
		// id
		String id = response.jsonPath().getString("id");
		softAssert.assertEquals(id, "[1]", "id should be 1 but it's not!!");
		// operStatus
		String operStatus = response.jsonPath().getString("operStatus");
		softAssert.assertEquals(operStatus, "[MINOR]", "operStatus should be MINOR but it's not!!");
		// extStatus
		String extStatus = response.jsonPath().getString("extStatus");
		softAssert.assertEquals(extStatus, "[Managed]", "extStatus should be Managed but it's not!!");
		// name
		String name = response.jsonPath().getString("name");
		softAssert.assertEquals(name, "[MX240-0.3]", "name should be MX240-0.3 but it's not!!");
		// deviceType
		String deviceType = response.jsonPath().getString("deviceType");
		softAssert.assertEquals(deviceType, "[Juniper-MX240]", "deviceType should be Juniper-MX240 but it's not!!");
		// swVersion
		String swVersion = response.jsonPath().getString("swVersion");
		softAssert.assertEquals(swVersion, "[JUNOS Base OS Software Suite [13.3R5.9]]",
				"swVersion in response is not expected");
		// hwVersion
		String hwVersion = response.jsonPath().getString("hwVersion");
		softAssert.assertEquals(hwVersion, "[]", "hwVersion should be empty but it's not!!");
		// sysOID
		String sysOID = response.jsonPath().getString("sysOID");
		softAssert.assertEquals(sysOID, "[1.3.6.1.4.1.2636.1.1.1.2.29]",
				"sysOID should be 1.3.6.1.4.1.2636.1.1.1.2.29 but is not");
		// vendor
		String vendor = response.jsonPath().getString("vendor");
		softAssert.assertEquals(vendor, "[Juniper]", "vendor should be Juniper but it's not!!!");
		System.out.println("vendor: " + vendor);
		// connectivity
		String connectivity = response.jsonPath().getString("connectivity");
		softAssert.assertEquals(connectivity, "[OK]", "connectivityshould be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties = response.jsonPath().getString("inventoryProperties");

		// serialNumber
		String serialNumber = response.jsonPath().getString("inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber, "[JN1154937AFC]", "serialNumber should be [JN1154937AFC] but is not!!!");
		// sWVersion
		String sWVersion = response.jsonPath().getString("inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion, "[JUNOS Base OS Software Suite [13.3R5.9]]",
				"sWVersion in response is not expected");
		System.out.println("sWVersion: " + sWVersion);
		// model
		String model = response.jsonPath().getString("inventoryProperties.model");
		softAssert.assertEquals(model, "[Juniper MX240 Internet Backbone Router]",
				"model should be Juniper MX240 Internet Backbone Router but it's not!!");
		// externalLabel
		String externalLabel = response.jsonPath().getString("externalLabel");
		softAssert.assertEquals(externalLabel, "[90.0.0.3]", "externalLabel should be 90.0.0.3 but it's not!!");
		// externalLabel2
		String externalLabel2 = response.jsonPath().getString("externalLabel2");
		softAssert.assertEquals(externalLabel2, "[90.0.0.3]", "externalLabel2 should be 90.0.0.3 but it's not!!");
		// ipAddress
		String ipAddress = response.jsonPath().getString("ipAddress");
		softAssert.assertEquals(ipAddress, "[90.0.0.3]", "ipAddress should be 90.0.0.3 but it's not!!");
		softAssert.assertAll();
	}

	@Test(priority = 7, description = "get a device from inventory by name", enabled = true)
	public void tc7getgetDeviceinventoryByName() throws InterruptedException {

		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/devices/inventory/name/MX240-0.3");
		response.prettyPrint();
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		SoftAssert softAssert = new SoftAssert();
		// Verify all the fields:
		// id
		String id = response.jsonPath().getString("id");
		softAssert.assertEquals(id, "[1]", "id should be 1 but it's not!!");
		// operStatus
		String operStatus = response.jsonPath().getString("operStatus");
		softAssert.assertEquals(operStatus, "[MINOR]", "operStatus should be MINOR but it's not!!");
		// extStatus
		String extStatus = response.jsonPath().getString("extStatus");
		softAssert.assertEquals(extStatus, "[Managed]", "extStatus should be Managed but it's not!!");
		// name
		String name = response.jsonPath().getString("name");
		softAssert.assertEquals(name, "[MX240-0.3]", "name should be MX240-0.3 but it's not!!");
		// deviceType
		String deviceType = response.jsonPath().getString("deviceType");
		softAssert.assertEquals(deviceType, "[Juniper-MX240]", "deviceType should be Juniper-MX240 but it's not!!");
		// swVersion
		String swVersion = response.jsonPath().getString("swVersion");
		softAssert.assertEquals(swVersion, "[JUNOS Base OS Software Suite [13.3R5.9]]",
				"swVersion in response is not expected");
		// hwVersion
		String hwVersion = response.jsonPath().getString("hwVersion");
		softAssert.assertEquals(hwVersion, "[]", "hwVersion should be empty but it's not!!");
		// sysOID
		String sysOID = response.jsonPath().getString("sysOID");
		softAssert.assertEquals(sysOID, "[1.3.6.1.4.1.2636.1.1.1.2.29]",
				"sysOID should be 1.3.6.1.4.1.2636.1.1.1.2.29 but is not");
		// vendor
		String vendor = response.jsonPath().getString("vendor");
		softAssert.assertEquals(vendor, "[Juniper]", "vendor should be Juniper but it's not!!!");
		// connectivity
		String connectivity = response.jsonPath().getString("connectivity");
		softAssert.assertEquals(connectivity, "[OK]", "connectivityshould be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties = response.jsonPath().getString("inventoryProperties");

		// serialNumber
		String serialNumber = response.jsonPath().getString("inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber, "[JN1154937AFC]", "serialNumber should be [JN1154937AFC] but is not!!!");
		// sWVersion
		String sWVersion = response.jsonPath().getString("inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion, "[JUNOS Base OS Software Suite [13.3R5.9]]",
				"sWVersion in response is not expected");
		System.out.println("sWVersion: " + sWVersion);
		// model
		String model = response.jsonPath().getString("inventoryProperties.model");
		softAssert.assertEquals(model, "[Juniper MX240 Internet Backbone Router]",
				"model should be Juniper MX240 Internet Backbone Router but it's not!!");
		// externalLabel
		String externalLabel = response.jsonPath().getString("externalLabel");
		softAssert.assertEquals(externalLabel, "[90.0.0.3]", "externalLabel should be 90.0.0.3 but it's not!!");
		// externalLabel2
		String externalLabel2 = response.jsonPath().getString("externalLabel2");
		softAssert.assertEquals(externalLabel2, "[90.0.0.3]", "externalLabel2 should be 90.0.0.3 but it's not!!");
		// ipAddress
		String ipAddress = response.jsonPath().getString("ipAddress");
		softAssert.assertEquals(ipAddress, "[90.0.0.3]", "ipAddress should be 90.0.0.3 but it's not!!");
		softAssert.assertAll();

		Thread.sleep(240000);

	}

	@Test(priority = 8, description = "get all the devices from inventory", enabled = true)
	public void tc8getDevicesInventoryList() throws InterruptedException {

		// Get response
		Response response = given().spec(spec).log().headers().auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/devices/inventory/list?ids=1,2,3,4,5,6,7,8,9&excludeInvProp=false");

		response.prettyPrint();
		response.getBody();
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		SoftAssert softAssert = new SoftAssert();
		// Verify all the fields:
		System.out.println("----------------------------DEVICE NUM 1 -----------------------------------------------");
		// id
		String id1 = response.jsonPath().getString("[0].id");
		softAssert.assertEquals(id1, "1", "id1 should be 1 but it's not!!");
		// operStatus
		String operStatus1 = response.jsonPath().getString("[0].operStatus");
		softAssert.assertEquals(operStatus1, "MINOR", "operStatus1 should be MINOR but it's not!!");
		// extStatus
		String extStatus1 = response.jsonPath().getString("[0].extStatus");
		softAssert.assertEquals(extStatus1, "Managed", "extStatus1 should be Managed but it's not!!");
		// name
		String name1 = response.jsonPath().getString("[0].name");
		softAssert.assertEquals(name1, "MX240-0.3", "name1 should be MX240-0.3 but it's not!!");
		// deviceType
		String deviceType1 = response.jsonPath().getString("[0].deviceType");
		softAssert.assertEquals(deviceType1, "Juniper-MX240", "deviceType1 should be Juniper-MX240 but it's not!!");
		// swVersion
		String swVersion1 = response.jsonPath().getString("[0].swVersion");
		softAssert.assertEquals(swVersion1, "JUNOS Base OS Software Suite [13.3R5.9]",
				"swVersion in response is not expected");
		// hwVersion
		String hwVersion1 = response.jsonPath().getString("[0].hwVersion");
		softAssert.assertEquals(hwVersion1, "", "hwVersion1 should be empty but it's not!!");
		// sysOID
		String sysOID1 = response.jsonPath().getString("[0].sysOID");
		softAssert.assertEquals(sysOID1, "1.3.6.1.4.1.2636.1.1.1.2.29",
				"sysOID1 should be 1.3.6.1.4.1.2636.1.1.1.2.29 but is not");
		// vendor
		String vendor1 = response.jsonPath().getString("[0].vendor");
		softAssert.assertEquals(vendor1, "Juniper", "vendor should be Juniper but it's not!!!");
		// connectivity
		String connectivity1 = response.jsonPath().getString("[0].connectivity");
		softAssert.assertEquals(connectivity1, "OK", "connectivity1 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties1 = response.jsonPath().getString("[0].inventoryProperties");

		System.out.println("inventoryProperties1: " + inventoryProperties1);
		// serialNumber
		String serialNumber1 = response.jsonPath().getString("[0].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber1, "JN1154937AFC", "serialNumber1 should be JN1154937AFC but is not!!!");
		// sWVersion
		String sWVersion1 = response.jsonPath().getString("[0].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion1, "JUNOS Base OS Software Suite [13.3R5.9]",
				"sWVersion1 in response is not expected");
		// model
		String model1 = response.jsonPath().getString("[0].inventoryProperties.model");
		softAssert.assertEquals(model1, "Juniper MX240 Internet Backbone Router",
				"model1 should be Juniper MX240 Internet Backbone Router but it's not!!");
		// externalLabel
		String externalLabel1 = response.jsonPath().getString("[0].externalLabel");
		softAssert.assertEquals(externalLabel1, "90.0.0.3", "externalLabel1 should be 90.0.0.3 but it's not!!");
		// externalLabel2
		String externalLabel21 = response.jsonPath().getString("[0].externalLabel2");
		softAssert.assertEquals(externalLabel21, "90.0.0.3", "externalLabel21 should be 90.0.0.3 but it's not!!");
		// ipAddress
		String ipAddress1 = response.jsonPath().getString("[0].ipAddress");
		softAssert.assertEquals(ipAddress1, "90.0.0.3", "ipAddress1 should be 90.0.0.3 but it's not!!");
		System.out.println("----------------------------DEVICE NUM 2 -----------------------------------------------");
		// id
		String id2 = response.jsonPath().getString("[1].id");
		softAssert.assertEquals(id2, "2", "id1 should be 2 but it's not!!");
		// operStatus
		String operStatus2 = response.jsonPath().getString("[1].operStatus");
		softAssert.assertEquals(operStatus2, "NORMAL", "operStatus2 should be NORMAL but it's not!!");
		// extStatus
		String extStatus2 = response.jsonPath().getString("[1].extStatus");
		softAssert.assertEquals(extStatus2, "Managed", "extStatus2 should be Managed but it's not!!");
		// name
		String name2 = response.jsonPath().getString("[1].name");
		softAssert.assertEquals(name2, "MX240-0.4", "name2 should be MX240-0.4 but it's not!!");
		// deviceType
		String deviceType2 = response.jsonPath().getString("[1].deviceType");
		softAssert.assertEquals(deviceType2, "Juniper-MX240", "deviceType2 should be Juniper-MX240 but it's not!!");
		// swVersion
		String swVersion2 = response.jsonPath().getString("[1].swVersion");
		softAssert.assertEquals(swVersion2, "JUNOS Base OS Software Suite [13.3R9.13]",
				"swVersion2 in response is not expected");
		// hwVersion
		String hwVersion2 = response.jsonPath().getString("[1].hwVersion");
		softAssert.assertEquals(hwVersion2, "", "hwVersion2 should be empty but it's not!!");
		// sysOID
		String sysOID2 = response.jsonPath().getString("[1].sysOID");
		softAssert.assertEquals(sysOID2, "1.3.6.1.4.1.2636.1.1.1.2.29",
				"sysOID1 should be 1.3.6.1.4.1.2636.1.1.1.2.29 but is not");
		// vendor
		String vendor2 = response.jsonPath().getString("[1].vendor");
		softAssert.assertEquals(vendor2, "Juniper", "vendor2 should be Juniper but it's not!!!");
		// connectivity
		String connectivity2 = response.jsonPath().getString("[1].connectivity");
		softAssert.assertEquals(connectivity2, "OK", "connectivity2 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties2 = response.jsonPath().getString("[1].inventoryProperties");
		// serialNumber
		String serialNumber2 = response.jsonPath().getString("[1].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber2, "JN112D7CCAFC", "serialNumber2 should be JN112D7CCAFC but is not!!!");
		// sWVersion
		String sWVersion2 = response.jsonPath().getString("[1].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion2, "JUNOS Base OS Software Suite [13.3R9.13]",
				"sWVersion2 in response is not expected");
		// model
		String model2 = response.jsonPath().getString("[1].inventoryProperties.model");
		softAssert.assertEquals(model2, "Juniper MX240 Internet Backbone Router",
				"model2 should be Juniper MX240 Internet Backbone Router but it's not!!");
		// externalLabel
		String externalLabel2 = response.jsonPath().getString("[1].externalLabel");
		softAssert.assertEquals(externalLabel2, "90.0.0.4", "externalLabel2 should be 90.0.0.4 but it's not!!");
		// externalLabel2
		String externalLabel22 = response.jsonPath().getString("[1].externalLabel2");
		softAssert.assertEquals(externalLabel22, "90.0.0.4", "externalLabel22 should be 90.0.0.4 but it's not!!");
		// ipAddress
		String ipAddress2 = response.jsonPath().getString("[1].ipAddress");
		softAssert.assertEquals(ipAddress2, "90.0.0.4", "ipAddress2 should be 90.0.0.4 but it's not!!");
		System.out.println("----------------------------DEVICE NUM 3 -----------------------------------------------");
		// id
		String id3 = response.jsonPath().getString("[2].id");
		softAssert.assertEquals(id3, "3", "id3 should be 3 but it's not!!");
		// operStatus
		String operStatus3 = response.jsonPath().getString("[2].operStatus");
		softAssert.assertEquals(operStatus3, "CRITICAL", "operStatus3 should be CRITICAL but it's not!!");
		// extStatus
		String extStatus3 = response.jsonPath().getString("[2].extStatus");
		softAssert.assertEquals(extStatus3, "Managed", "extStatus3 should be Managed but it's not!!");
		// name
		String name3 = response.jsonPath().getString("[2].name");
		softAssert.assertEquals(name3, "MX60", "name3 should be MX60 but it's not!!");
		// deviceType
		String deviceType3 = response.jsonPath().getString("[2].deviceType");
		softAssert.assertEquals(deviceType3, "Juniper-MX240", "deviceType3 should be Juniper-MX240 but it's not!!");
		// swVersion
		String swVersion3 = response.jsonPath().getString("[2].swVersion");
		softAssert.assertEquals(swVersion3, "JUNOS Base OS Software Suite [11.4R6-S1]",
				"swVersion3 in response is not expected");
		// hwVersion
		String hwVersion3 = response.jsonPath().getString("[2].hwVersion");
		softAssert.assertEquals(hwVersion3, "", "hwVersion3 should be empty but it's not!!");
		// sysOID
		String sysOID3 = response.jsonPath().getString("[2].sysOID");
		softAssert.assertEquals(sysOID3, "1.3.6.1.4.1.2636.1.1.1.2.29",
				"sysOID1 should be 1.3.6.1.4.1.2636.1.1.1.2.29 but is not");
		// vendor
		String vendor3 = response.jsonPath().getString("[2].vendor");
		softAssert.assertEquals(vendor3, "Juniper", "vendor3 should be Juniper but it's not!!!");
		// connectivity
		String connectivity3 = response.jsonPath().getString("[2].connectivity");
		softAssert.assertEquals(connectivity3, "OK", "connectivity3 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties3 = response.jsonPath().getString("[2].inventoryProperties");
		// serialNumber
		String serialNumber3 = response.jsonPath().getString("[2].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber3, "JN114D64BAFC", "serialNumber3 should be JN114D64BAFC but is not!!!");
		// sWVersion
		String sWVersion3 = response.jsonPath().getString("[2].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion3, "JUNOS Base OS Software Suite [11.4R6-S1]",
				"sWVersion3 in response is not expected");
		// model
		String model3 = response.jsonPath().getString("[2].inventoryProperties.model");
		softAssert.assertEquals(model3, "Juniper MX240 Backplane Internet Backbone Router",
				"model3 should be Juniper MX240 Backplane Internet Backbone Router but it's not!!");
		// externalLabel
		String externalLabel3 = response.jsonPath().getString("[2].externalLabel");
		softAssert.assertEquals(externalLabel3, "172.16.121.60",
				"externalLabel3 should be 172.16.121.60 but it's not!!");
		// externalLabel2
		String externalLabel23 = response.jsonPath().getString("[2].externalLabel2");
		softAssert.assertEquals(externalLabel23, "172.16.121.60",
				"externalLabel23 should be 172.16.121.60 but it's not!!");
		// ipAddress
		String ipAddress3 = response.jsonPath().getString("[2].ipAddress");
		softAssert.assertEquals(ipAddress3, "172.16.121.60", "ipAddress3 should be 172.16.121.60 but it's not!!");
		System.out.println("----------------------------DEVICE NUM 4 -----------------------------------------------");
		// id
		String id4 = response.jsonPath().getString("[3].id");
		softAssert.assertEquals(id4, "4", "id4 should be 4 but it's not!!");
		// operStatus
		String operStatus4 = response.jsonPath().getString("[3].operStatus");
		softAssert.assertEquals(operStatus4, "NORMAL", "operStatus4 should be NORMAL but it's not!!");
		// extStatus
		String extStatus4 = response.jsonPath().getString("[3].extStatus");
		softAssert.assertEquals(extStatus4, "Managed", "extStatus4 should be Managed but it's not!!");
		// name
		String name4 = response.jsonPath().getString("[3].name");
		softAssert.assertEquals(name4, "Cisco7613-0.1", "name4 should be Cisco7613-0.1 but it's not!!");
		// deviceType
		String deviceType4 = response.jsonPath().getString("[3].deviceType");
		softAssert.assertEquals(deviceType4, "Cisco7613", "deviceType4 should be Cisco7613 but it's not!!");
		// swVersion
		String swVersion4 = response.jsonPath().getString("[3].swVersion");
		softAssert.assertEquals(swVersion4, "", "hwVersion4 should be empty but it's not!!");
		// hwVersion
		String hwVersion4 = response.jsonPath().getString("[3].hwVersion");
		softAssert.assertEquals(hwVersion4, "V03", "hwVersion4 should be V03 but is not!!");
		// sysOID
		String sysOID4 = response.jsonPath().getString("[3].sysOID");
		softAssert.assertEquals(sysOID4, "1.3.6.1.4.1.9.1.528", "sysOID1 should be 1.3.6.1.4.1.9.1.528 but is not");
		// vendor
		String vendor4 = response.jsonPath().getString("[3].vendor");
		softAssert.assertEquals(vendor4, "Cisco", "vendor4 should be Cisco but it's not!!!");
		// connectivity
		String connectivity4 = response.jsonPath().getString("[3].connectivity");
		softAssert.assertEquals(connectivity4, "OK", "connectivity4 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties4 = response.jsonPath().getString("[3].inventoryProperties");
		softAssert.assertEquals(inventoryProperties4,
				"[spesificModel:7600-ES+20G3C 20 ports 7600 ES+ Rev. 1.3, " + "serialNumber:JAE14100DMR, "
						+ "sWVersion:, hWVersion:V03, model:CISCO7613]",
				"inventoryProperties4 in response is not expected");
		// serialNumber
		String serialNumber4 = response.jsonPath().getString("[3].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber4, "JAE14100DMR", "serialNumber4 should be JAE14100DMR but is not!!!");
		// sWVersion
		String sWVersion4 = response.jsonPath().getString("[3].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion4, "", "sWVersion4 should be empty but it's not!!");
		// model
		String model4 = response.jsonPath().getString("[3].inventoryProperties.model");
		softAssert.assertEquals(model4, "CISCO7613", "model4 should be CISCO7613 but it's not!!");
		// externalLabel
		String externalLabel4 = response.jsonPath().getString("[3].externalLabel");
		softAssert.assertEquals(externalLabel4, "90.0.0.1", "externalLabel4 should be 90.0.0.1 but it's not!!");
		// externalLabel2
		String externalLabel24 = response.jsonPath().getString("[3].externalLabel2");
		softAssert.assertEquals(externalLabel24, "90.0.0.1", "externalLabel24 should be 90.0.0.1 but it's not!!");
		// ipAddress
		String ipAddress4 = response.jsonPath().getString("[3].ipAddress");
		softAssert.assertEquals(ipAddress4, "90.0.0.1", "ipAddress4 should be 90.0.0.1 but it's not!!");
		System.out.println("----------------------------DEVICE NUM 5 -----------------------------------------------");
		// id
		String id5 = response.jsonPath().getString("[4].id");
		softAssert.assertEquals(id5, "5", "id5 should be 5 but it's not!!");
		// operStatus
		String operStatus5 = response.jsonPath().getString("[4].operStatus");
		softAssert.assertEquals(operStatus5, "NORMAL", "operStatus5 should be NORMAL but it's not!!");
		// extStatus
		String extStatus5 = response.jsonPath().getString("[4].extStatus");
		softAssert.assertEquals(extStatus5, "Managed", "extStatus5 should be Managed but it's not!!");
		// name
		String name5 = response.jsonPath().getString("[4].name");
		softAssert.assertEquals(name5, "Cisco7613-0.2", "name5 should be Cisco7613-0.2 but it's not!!");
		// deviceType
		String deviceType5 = response.jsonPath().getString("[4].deviceType");
		softAssert.assertEquals(deviceType5, "Cisco7613", "deviceType5 should be Cisco7613 but it's not!!");
		// swVersion
		String swVersion5 = response.jsonPath().getString("[4].swVersion");
		softAssert.assertEquals(swVersion5, "", "swVersion5 should be empty but it's not!!");
		// hwVersion
		String hwVersion5 = response.jsonPath().getString("[4].hwVersion");
		softAssert.assertEquals(hwVersion5, "V03", "hwVersion5 should be V03 but is not!!");
		// sysOID
		String sysOID5 = response.jsonPath().getString("[4].sysOID");
		softAssert.assertEquals(sysOID5, "1.3.6.1.4.1.9.1.528", "sysOID1 should be 1.3.6.1.4.1.9.1.528 but is not");
		// vendor
		String vendor5 = response.jsonPath().getString("[4].vendor");
		softAssert.assertEquals(vendor5, "Cisco", "vendor5 should be Cisco but it's not!!!");
		// connectivity
		String connectivity5 = response.jsonPath().getString("[4].connectivity");
		softAssert.assertEquals(connectivity5, "OK", "connectivity5 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties5 = response.jsonPath().getString("[4].inventoryProperties");
		softAssert.assertEquals(inventoryProperties5,
				"[spesificModel:7600-ES+20G3C 20 ports 7600 ES" + "+ Rev. 1.3, serialNumber:JAE14200VRV, "
						+ "sWVersion:, hWVersion:V03, model:CISCO7613]",
				"inventoryProperties5 in response is not expected");
		// serialNumber
		String serialNumber5 = response.jsonPath().getString("[4].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber5, "JAE14200VRV", "serialNumber5 should be JAE14200VRV but is not!!!");
		// sWVersion
		String sWVersion5 = response.jsonPath().getString("[4].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion5, "", "sWVersion5 should be empty but it's not!!");
		// model
		String model5 = response.jsonPath().getString("[4].inventoryProperties.model");
		softAssert.assertEquals(model5, "CISCO7613", "model5 should be CISCO7613 but it's not!!");
		// externalLabel
		String externalLabel5 = response.jsonPath().getString("[4].externalLabel");
		softAssert.assertEquals(externalLabel5, "90.0.0.2", "externalLabel5 should be 90.0.0.2 but it's not!!");
		// externalLabel2
		String externalLabel25 = response.jsonPath().getString("[4].externalLabel2");
		softAssert.assertEquals(externalLabel25, "90.0.0.2", "externalLabel25 should be 90.0.0.2 but it's not!!");
		// ipAddress
		String ipAddress5 = response.jsonPath().getString("[4].ipAddress");
		softAssert.assertEquals(ipAddress5, "90.0.0.2", "ipAddress5 should be 90.0.0.2 but it's not!!");
		System.out.println("----------------------------DEVICE NUM 6 -----------------------------------------------");
		// id
		String id6 = response.jsonPath().getString("[5].id");
		softAssert.assertEquals(id6, "6", "id6 should be 6 but it's not!!");
		// operStatus
		String operStatus6 = response.jsonPath().getString("[5].operStatus");
		softAssert.assertEquals(operStatus6, "NORMAL", "operStatus6 should be NORMAL but it's not!!");
		// extStatus
		String extStatus6 = response.jsonPath().getString("[5].extStatus");
		softAssert.assertEquals(extStatus6, "Managed", "extStatus6 should be Managed but it's not!!");
		// name
		String name6 = response.jsonPath().getString("[5].name");
		softAssert.assertEquals(name6, "CiscoME3400-0.8", "name6 should be CiscoME3400-0.8 but it's not!!");
		// deviceType
		String deviceType6 = response.jsonPath().getString("[5].deviceType");
		softAssert.assertEquals(deviceType6, "CiscoME3400", "deviceType6 should be CiscoME3400 but it's not!!");
		// swVersion
		String swVersion6 = response.jsonPath().getString("[5].swVersion");
		softAssert.assertEquals(swVersion6, "12.2(50)SE4", "swVersion6 should be 12.2(50)SE4 but it's not!!");
		// hwVersion
		String hwVersion6 = response.jsonPath().getString("[5].hwVersion");
		softAssert.assertEquals(hwVersion6, "V01", "hwVersion6 should be V01 but is not!!");
		// sysOID
		String sysOID6 = response.jsonPath().getString("[5].sysOID");
		softAssert.assertEquals(sysOID6, "1.3.6.1.4.1.9.1.736", "sysOID1 should be 1.3.6.1.4.1.9.1.736 but is not");
		// vendor
		String vendor6 = response.jsonPath().getString("[5].vendor");
		softAssert.assertEquals(vendor6, "Cisco", "vendor6 should be Cisco but it's not!!!");
		// connectivity
		String connectivity6 = response.jsonPath().getString("[5].connectivity");
		softAssert.assertEquals(connectivity6, "OK", "connectivity6 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties6 = response.jsonPath().getString("[5].inventoryProperties");
		softAssert.assertEquals(inventoryProperties6,
				"[serialNumber:FOC1127U08U, sWVersion:12.2(50)SE4, " + "hWVersion:V01, model:ME-3400-24TS-A]",
				"inventoryProperties6 in response is not expected");
		// serialNumber
		String serialNumber6 = response.jsonPath().getString("[5].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber6, "FOC1127U08U", "serialNumber6 should be FOC1127U08U but is not!!!");
		// sWVersion
		String sWVersion6 = response.jsonPath().getString("[5].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion6, "12.2(50)SE4", "sWVersion6 should be 12.2(50)SE4 but it's not!!");
		// model
		String model6 = response.jsonPath().getString("[5].inventoryProperties.model");
		softAssert.assertEquals(model6, "ME-3400-24TS-A", "model6 should be ME-3400-24TS-A but it's not!!");
		// externalLabel
		String externalLabel6 = response.jsonPath().getString("[5].externalLabel");
		softAssert.assertEquals(externalLabel6, "90.0.0.8", "externalLabel6 should be 90.0.0.8 but it's not!!");
		// externalLabel2
		String externalLabel26 = response.jsonPath().getString("[5].externalLabel2");
		softAssert.assertEquals(externalLabel26, "90.0.0.8", "externalLabel26 should be 90.0.0.8 but it's not!!");
		// ipAddress
		String ipAddress6 = response.jsonPath().getString("[5].ipAddress");
		softAssert.assertEquals(ipAddress6, "90.0.0.8", "ipAddress6 should be 90.0.0.8 but it's not!!");
		System.out.println("----------------------------DEVICE NUM 7 -----------------------------------------------");
		// id
		String id7 = response.jsonPath().getString("[6].id");
		softAssert.assertEquals(id7, "7", "id7 should be 7 but it's not!!");
		// operStatus
		String operStatus7 = response.jsonPath().getString("[6].operStatus");
		softAssert.assertEquals(operStatus7, "NORMAL", "operStatus7 should be NORMAL but it's not!!");
		// extStatus
		String extStatus7 = response.jsonPath().getString("[6].extStatus");
		softAssert.assertEquals(extStatus7, "Managed", "extStatus7 should be Managed but it's not!!");
		// name
		String name7 = response.jsonPath().getString("[6].name");
		softAssert.assertEquals(name7, "CiscoME3400-0.9", "name7 should be CiscoME3400-0.9 but it's not!!");
		// deviceType
		String deviceType7 = response.jsonPath().getString("[6].deviceType");
		softAssert.assertEquals(deviceType7, "CiscoME3400", "deviceType7 should be CiscoME3400 but it's not!!");
		// swVersion
		String swVersion7 = response.jsonPath().getString("[6].swVersion");
		softAssert.assertEquals(swVersion7, "12.2(50)SE4", "swVersion7 should be 12.2(50)SE4 but it's not!!");
		// hwVersion
		String hwVersion7 = response.jsonPath().getString("[6].hwVersion");
		softAssert.assertEquals(hwVersion7, "V01", "hwVersion7 should be V01 but is not!!");
		System.out.println("hwVersion7: " + hwVersion7);
		// sysOID
		String sysOID7 = response.jsonPath().getString("[6].sysOID");
		softAssert.assertEquals(sysOID7, "1.3.6.1.4.1.9.1.736", "sysOID1 should be 1.3.6.1.4.1.9.1.736 but is not");
		// vendor
		String vendor7 = response.jsonPath().getString("[6].vendor");
		softAssert.assertEquals(vendor7, "Cisco", "vendor7 should be Cisco but it's not!!!");
		// connectivity
		String connectivity7 = response.jsonPath().getString("[6].connectivity");
		softAssert.assertEquals(connectivity7, "OK", "connectivity7 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties7 = response.jsonPath().getString("[6].inventoryProperties");
		softAssert.assertEquals(inventoryProperties7,
				"[serialNumber:FOC1114U1QN, sWVersion:12.2(50)SE4, " + "hWVersion:V01, model:ME-3400-24TS-A]",
				"inventoryProperties7 in response is not expected");
		// serialNumber
		String serialNumber7 = response.jsonPath().getString("[6].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber7, "FOC1114U1QN", "serialNumber7 should be FOC1114U1QN but is not!!!");
		// sWVersion
		String sWVersion7 = response.jsonPath().getString("[6].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion7, "12.2(50)SE4", "sWVersion7 should be 12.2(50)SE4 but it's not!!");
		// model
		String model7 = response.jsonPath().getString("[6].inventoryProperties.model");
		softAssert.assertEquals(model7, "ME-3400-24TS-A", "model7 should be ME-3400-24TS-A but it's not!!");
		System.out.println("model7: " + model7);
		// externalLabel
		String externalLabel7 = response.jsonPath().getString("[6].externalLabel");
		softAssert.assertEquals(externalLabel7, "90.0.0.9", "externalLabel7 should be 90.0.0.9 but it's not!!");
		// externalLabel2
		String externalLabel27 = response.jsonPath().getString("[6].externalLabel2");
		softAssert.assertEquals(externalLabel27, "90.0.0.9", "externalLabel27 should be 90.0.0.9 but it's not!!");
		// ipAddress
		String ipAddress7 = response.jsonPath().getString("[6].ipAddress");
		softAssert.assertEquals(ipAddress7, "90.0.0.9", "ipAddress7 should be 90.0.0.9 but it's not!!");
		System.out.println("----------------------------DEVICE NUM 8 -----------------------------------------------");
		// id
		String id8 = response.jsonPath().getString("[7].id");
		softAssert.assertEquals(id8, "8", "id8 should be 8 but it's not!!");
		// operStatus
		String operStatus8 = response.jsonPath().getString("[7].operStatus");
		softAssert.assertEquals(operStatus8, "NORMAL", "operStatus8 should be NORMAL but it's not!!");
		// extStatus
		String extStatus8 = response.jsonPath().getString("[7].extStatus");
		softAssert.assertEquals(extStatus8, "Managed", "extStatus8 should be Managed but it's not!!");
		// name
		String name8 = response.jsonPath().getString("[7].name");
		softAssert.assertEquals(name8, "ALU-0.5", "name8 should be ALU-0.5 but it's not!!");
		// deviceType
		String deviceType8 = response.jsonPath().getString("[7].deviceType");
		softAssert.assertEquals(deviceType8, "ALU-7705-SAR-8", "deviceType8 should be ALU-7705-SAR-8 but it's not!!");
		// swVersion
		String swVersion8 = response.jsonPath().getString("[7].swVersion");
		softAssert.assertEquals(swVersion8, "noSuchObject", "swVersion8 should be noSuchObject but it's not!!");
		// hwVersion
		String hwVersion8 = response.jsonPath().getString("[7].hwVersion");
		softAssert.assertEquals(hwVersion8, "noSuchObject", "hwVersion8 should be noSuchObject but is not!!");
		// sysOID
		String sysOID8 = response.jsonPath().getString("[7].sysOID");
		softAssert.assertEquals(sysOID8, "1.3.6.1.4.1.6527.6.1.1.2.1",
				"sysOID1 should be 1.3.6.1.4.1.6527.6.1.1.2.1 but is not");
		// vendor
		String vendor8 = response.jsonPath().getString("[7].vendor");
		softAssert.assertEquals(vendor8, "Alcatel-Lucent", "vendor8 should be Alcatel-Lucent but it's not!!!");
		// connectivity
		String connectivity8 = response.jsonPath().getString("[7].connectivity");
		softAssert.assertEquals(connectivity8, "OK", "connectivity8 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties8 = response.jsonPath().getString("[7].inventoryProperties");
		softAssert.assertEquals(inventoryProperties8, "[modelDescription:8-Slot Chassis: 6 Adapter slots, 2 CSM slots, "
				+ "serialNumber:noSuchObject, sWVersion:noSuchObject, " + "hWVersion:noSuchObject, model:7705 SAR-8]",
				"inventoryProperties8 in response is not expected");
		// serialNumber
		String serialNumber8 = response.jsonPath().getString("[7].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber8, "noSuchObject", "serialNumber8 should be noSuchObject but is not!!!");
		// sWVersion
		String sWVersion8 = response.jsonPath().getString("[7].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion8, "noSuchObject", "sWVersion8 should be noSuchObject but it's not!!");
		// model
		String model8 = response.jsonPath().getString("[7].inventoryProperties.model");
		softAssert.assertEquals(model8, "7705 SAR-8", "model8 should be 7705 SAR-8 but it's not!!");
		// externalLabel
		String externalLabel8 = response.jsonPath().getString("[7].externalLabel");
		softAssert.assertEquals(externalLabel8, "90.0.0.5", "externalLabel8 should be 90.0.0.5 but it's not!!");
		// externalLabel2
		String externalLabel28 = response.jsonPath().getString("[7].externalLabel2");
		softAssert.assertEquals(externalLabel28, "90.0.0.5", "externalLabel28 should be 90.0.0.5 but it's not!!");
		// ipAddress
		String ipAddress8 = response.jsonPath().getString("[7].ipAddress");
		softAssert.assertEquals(ipAddress8, "90.0.0.5", "ipAddress8 should be 90.0.0.5 but it's not!!");
		System.out.println("----------------------------DEVICE NUM 9 -----------------------------------------------");
		// id
		String id9 = response.jsonPath().getString("[8].id");
		softAssert.assertEquals(id9, "9", "id8 should be 9 but it's not!!");
		// operStatus
		String operStatus9 = response.jsonPath().getString("[8].operStatus");
		softAssert.assertEquals(operStatus9, "NORMAL", "operStatus9 should be NORMAL but it's not!!");
		// extStatus
		String extStatus9 = response.jsonPath().getString("[8].extStatus");
		softAssert.assertEquals(extStatus9, "Managed", "extStatus9 should be Managed but it's not!!");
		// name
		String name9 = response.jsonPath().getString("[8].name");
		softAssert.assertEquals(name9, "ALU-0.6", "name9 should be ALU-0.6 but it's not!!");
		// deviceType
		String deviceType9 = response.jsonPath().getString("[8].deviceType");
		softAssert.assertEquals(deviceType9, "ALU-7705-SAR-8", "deviceType9 should be ALU-7705-SAR-8 but it's not!!");
		// swVersion
		String swVersion9 = response.jsonPath().getString("[8].swVersion");
		softAssert.assertEquals(swVersion9, "noSuchObject", "swVersion8 should be noSuchObject but it's not!!");
		// hwVersion
		String hwVersion9 = response.jsonPath().getString("[8].hwVersion");
		softAssert.assertEquals(hwVersion9, "noSuchObject", "hwVersion9 should be noSuchObject but is not!!");
		// sysOID
		String sysOID9 = response.jsonPath().getString("[8].sysOID");
		softAssert.assertEquals(sysOID9, "1.3.6.1.4.1.6527.6.1.1.2.1",
				"sysOID9 should be 1.3.6.1.4.1.6527.6.1.1.2.1 but is not");
		// vendor
		String vendor9 = response.jsonPath().getString("[8].vendor");
		softAssert.assertEquals(vendor9, "Alcatel-Lucent", "vendor9 should be Alcatel-Lucent but it's not!!!");
		// connectivity
		String connectivity9 = response.jsonPath().getString("[8].connectivity");
		softAssert.assertEquals(connectivity9, "OK", "connectivity9 should be OK but it's not!!!");
		// inventoryProperties
		String inventoryProperties9 = response.jsonPath().getString("[8].inventoryProperties");
		softAssert.assertEquals(inventoryProperties9, "[modelDescription:8-Slot Chassis: 6 Adapter slots, 2 CSM slots, "
				+ "serialNumber:noSuchObject, sWVersion:noSuchObject, " + "hWVersion:noSuchObject, model:7705 SAR-8]",
				"inventoryProperties9 in response is not expected");
		// serialNumber
		String serialNumber9 = response.jsonPath().getString("[8].inventoryProperties.serialNumber");
		softAssert.assertEquals(serialNumber9, "noSuchObject", "serialNumber9 should be noSuchObject but is not!!!");
		System.out.println("serialNumber9: " + serialNumber9);
		// sWVersion
		String sWVersion9 = response.jsonPath().getString("[8].inventoryProperties.sWVersion");
		softAssert.assertEquals(sWVersion9, "noSuchObject", "sWVersion9 should be noSuchObject but it's not!!");
		// model
		String model9 = response.jsonPath().getString("[8].inventoryProperties.model");
		softAssert.assertEquals(model9, "7705 SAR-8", "model9 should be 7705 SAR-8 but it's not!!");
		// externalLabel
		String externalLabel9 = response.jsonPath().getString("[8].externalLabel");
		softAssert.assertEquals(externalLabel9, "90.0.0.6", "externalLabel9 should be 90.0.0.6 but it's not!!");
		// externalLabel2
		String externalLabel29 = response.jsonPath().getString("[8].externalLabel2");
		softAssert.assertEquals(externalLabel29, "90.0.0.6", "externalLabel29 should be 90.0.0.6 but it's not!!");
		// ipAddress
		String ipAddress9 = response.jsonPath().getString("[8].ipAddress");
		softAssert.assertEquals(ipAddress9, "90.0.0.6", "ipAddress8 should be 90.0.0.6 but it's not!!");
		softAssert.assertAll();

	}

}
