package apiNetace;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import apiNetaceSupport.Link;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetLinks extends BaseTest {
	@Test(priority = 9, description = "count of the links between the devices", enabled = true)
	public void tc9getLinksCount() {

		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/links/count");
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		String count = response.getBody().asString();

		response.prettyPrint();

		response.getStatusCode();

		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");
		// Verify the quantity of 15 links in the response
		Assert.assertEquals(count, "15", "the number of links between the devices must be 15 but is not!!!!");
	}

	@Test(priority = 10, description = "get the link between the devices by id ", enabled = true)
	public void tc10getLinksdeviceById() {

		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/links/inventory/device/id/1");

		response.prettyPrint();
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		SoftAssert softAssert = new SoftAssert();
		// Verify the name,status,speed and linkType of the links in the response:
		System.out.println(
				"--------------------------------LINK 1 ---------------------------------------------------------------");
		// name
		String name1 = response.jsonPath().getString("[0].name");
		softAssert.assertEquals(name1, "172.16.121.60:ge-2/1/0-90.0.0.3:ge-2/0/0-LLDP",
				"The name1 should be 172.16.121.60:ge-2/1/0-90.0.0.3:ge-2/0/0-LLDP but it's not!!!");

		// status
		String status1 = response.jsonPath().getString("[0].status");
		softAssert.assertEquals(status1, "OK", "status1 should be OK but it's not!!!!");
		// speed
		String speed1 = response.jsonPath().getString("[0].speed");
		softAssert.assertEquals(speed1, "1000", "speed1 should be 1000 but it's not!!!");
		// linkType
		String linkType1 = response.jsonPath().getString("[0].linkType");
		softAssert.assertEquals(linkType1, "LLDP", "linkType1 should be LLDP but it's not!!!");
		System.out.println(
				"--------------------------------LINK 2 ---------------------------------------------------------------");
		// name
		String name2 = response.jsonPath().getString("[1].name");
		softAssert.assertEquals(name2, "90.0.0.1:Gi13/2-90.0.0.3:ge-2/1/0-OSPF",
				"The name2 should be 90.0.0.1:Gi13/2-90.0.0.3:ge-2/1/0-OSPF but it's not!!!");
		// status
		String status2 = response.jsonPath().getString("[1].status");
		softAssert.assertEquals(status2, "OK", "status2 should be OK but it's not!!!!");
		// speed
		String speed2 = response.jsonPath().getString("[1].speed");
		softAssert.assertEquals(speed2, "1000", "speed2 should be 1000 but it's not!!!");
		// linkType
		String linkType2 = response.jsonPath().getString("[1].linkType");
		softAssert.assertEquals(linkType2, "OSPF", "linkType2 should be OSPF but it's not!!!");

		System.out.println(
				"--------------------------------LINK 3 ---------------------------------------------------------------");
		// name
		String name3 = response.jsonPath().getString("[2].name");
		softAssert.assertEquals(name3, "90.0.0.3:ge-2/1/1-90.0.0.9:Gi0/1-LLDP",
				"The name3 should be 90.0.0.3:ge-2/1/1-90.0.0.9:Gi0/1-LLDP but it's not!!!");
		// status
		String status3 = response.jsonPath().getString("[2].status");
		softAssert.assertEquals(status3, "OK", "status3 should be OK but it's not!!!!");
		// speed
		String speed3 = response.jsonPath().getString("[2].speed");
		softAssert.assertEquals(speed3, "1000", "speed3 should be 1000 but it's not!!!");
		// linkType
		String linkType3 = response.jsonPath().getString("[2].linkType");
		softAssert.assertEquals(linkType3, "LLDP", "linkType3 should be LLDP but it's not!!!");
		System.out.println(
				"--------------------------------LINK 4 ---------------------------------------------------------------");
		// name
		String name4 = response.jsonPath().getString("[3].name");
		softAssert.assertEquals(name4, "90.0.0.3:xe-2/3/0-90.0.0.4:xe-1/3/0-LLDP",
				"The name4 should be 90.0.0.3:xe-2/3/0-90.0.0.4:xe-1/3/0-LLDP but it's not!!!");
		// status
		String status4 = response.jsonPath().getString("[3].status");
		softAssert.assertEquals(status4, "OK", "status4 should be OK but it's not!!!!");
		// speed
		String speed4 = response.jsonPath().getString("[3].speed");
		softAssert.assertEquals(speed4, "10000", "speed4 should be 10000 but it's not!!!");
		// linkType
		String linkType4 = response.jsonPath().getString("[3].linkType");
		softAssert.assertEquals(linkType4, "LLDP", "linkType4 should be LLDP but it's not!!!");
		System.out.println(
				"--------------------------------LINK 5 ---------------------------------------------------------------");
		// name
		String name5 = response.jsonPath().getString("[4].name");
		softAssert.assertEquals(name5, "90.0.0.3:xe-1/1/0-90.0.0.4:xe-1/2/0-LLDP",
				"The name5 should be  90.0.0.3:xe-1/1/0-90.0.0.4:xe-1/2/0-LLDP but it's not!!!");
		// status
		String status5 = response.jsonPath().getString("[4].status");
		softAssert.assertEquals(status5, "OK", "status4 should be OK but it's not!!!!");
		// speed
		String speed5 = response.jsonPath().getString("[4].speed");
		softAssert.assertEquals(speed5, "10000", "speed5 should be 10000 but it's not!!!");
		// linkType
		String linkType5 = response.jsonPath().getString("[4].linkType");
		softAssert.assertEquals(linkType5, "LLDP", "linkType4 should be LLDP but it's not!!!");
		softAssert.assertAll();

	}

	@Test(priority = 11, description = "get the link between the devices by ip ", enabled = true)
	public void tc11getLinksdeviceByIp() {

		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/links/inventory/device/ip/90.0.0.3");

		response.prettyPrint();
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		SoftAssert softAssert = new SoftAssert();
		// Verify the name,status,speed and linkType of the links in the response:
		System.out.println(
				"--------------------------------LINK 1 ---------------------------------------------------------------");
		// name
		String name1 = response.jsonPath().getString("[0].name");
		softAssert.assertEquals(name1, "172.16.121.60:ge-2/1/0-90.0.0.3:ge-2/0/0-LLDP",
				"The name1 should be 172.16.121.60:ge-2/1/0-90.0.0.3:ge-2/0/0-LLDP but it's not!!!");

		// status
		String status1 = response.jsonPath().getString("[0].status");
		softAssert.assertEquals(status1, "OK", "status1 should be OK but it's not!!!!");
		// speed
		String speed1 = response.jsonPath().getString("[0].speed");
		softAssert.assertEquals(speed1, "1000", "speed1 should be 1000 but it's not!!!");
		// linkType
		String linkType1 = response.jsonPath().getString("[0].linkType");
		softAssert.assertEquals(linkType1, "LLDP", "linkType1 should be OSPF but it's not!!!");
		System.out.println(
				"--------------------------------LINK 2 ---------------------------------------------------------------");
		// name
		String name2 = response.jsonPath().getString("[1].name");
		softAssert.assertEquals(name2, "90.0.0.1:Gi13/2-90.0.0.3:ge-2/1/0-OSPF",
				"The name2 should be 90.0.0.1:Gi13/2-90.0.0.3:ge-2/1/0-OSPF but it's not!!!");
		// status
		String status2 = response.jsonPath().getString("[1].status");
		softAssert.assertEquals(status2, "OK", "status2 should be OK but it's not!!!!");
		// speed
		String speed2 = response.jsonPath().getString("[1].speed");
		softAssert.assertEquals(speed2, "1000", "speed2 should be 1000 but it's not!!!");
		// linkType
		String linkType2 = response.jsonPath().getString("[1].linkType");
		softAssert.assertEquals(linkType2, "OSPF", "linkType2 should be OSPF but it's not!!!");

		System.out.println(
				"--------------------------------LINK 3 ---------------------------------------------------------------");
		// name
		String name3 = response.jsonPath().getString("[2].name");
		softAssert.assertEquals(name3, "90.0.0.3:ge-2/1/1-90.0.0.9:Gi0/1-LLDP",
				"The name3 should be 90.0.0.3:ge-2/1/1-90.0.0.9:Gi0/1-LLDP but it's not!!!");
		// status
		String status3 = response.jsonPath().getString("[2].status");
		softAssert.assertEquals(status3, "OK", "status3 should be OK but it's not!!!!");
		// speed
		String speed3 = response.jsonPath().getString("[2].speed");
		softAssert.assertEquals(speed3, "1000", "speed3 should be 1000 but it's not!!!");
		// linkType
		String linkType3 = response.jsonPath().getString("[2].linkType");
		softAssert.assertEquals(linkType3, "LLDP", "linkType3 should be LLDP but it's not!!!");
		System.out.println(
				"--------------------------------LINK 4 ---------------------------------------------------------------");
		// name
		String name4 = response.jsonPath().getString("[3].name");
		softAssert.assertEquals(name4, "90.0.0.3:xe-2/3/0-90.0.0.4:xe-1/3/0-LLDP",
				"The name4 should be 90.0.0.3:xe-2/3/0-90.0.0.4:xe-1/3/0-LLDP but it's not!!!");
		// status
		String status4 = response.jsonPath().getString("[3].status");
		softAssert.assertEquals(status4, "OK", "status4 should be OK but it's not!!!!");
		// speed
		String speed4 = response.jsonPath().getString("[3].speed");
		softAssert.assertEquals(speed4, "10000", "speed4 should be 10000 but it's not!!!");
		// linkType
		String linkType4 = response.jsonPath().getString("[3].linkType");
		softAssert.assertEquals(linkType4, "LLDP", "linkType4 should be LLDP but it's not!!!");
		System.out.println(
				"--------------------------------LINK 5 ---------------------------------------------------------------");
		// name
		String name5 = response.jsonPath().getString("[4].name");
		softAssert.assertEquals(name5, "90.0.0.3:xe-1/1/0-90.0.0.4:xe-1/2/0-LLDP",
				"The name5 should be  90.0.0.3:xe-1/1/0-90.0.0.4:xe-1/2/0-LLDP but it's not!!!");
		// status
		String status5 = response.jsonPath().getString("[4].status");
		softAssert.assertEquals(status5, "OK", "status4 should be OK but it's not!!!!");
		// speed
		String speed5 = response.jsonPath().getString("[4].speed");
		softAssert.assertEquals(speed5, "10000", "speed5 should be 10000 but it's not!!!");
		// linkType
		String linkType5 = response.jsonPath().getString("[4].linkType");
		softAssert.assertEquals(linkType5, "LLDP", "linkType4 should be LLDP but it's not!!!");
		softAssert.assertAll();

	}

	@Test(priority = 12, description = "get the link between the devices by name ", enabled = true)
	public void tc12getLinksdeviceByname() {

		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/links/inventory/device/name/MX240-0.3");

		response.prettyPrint();
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		SoftAssert softAssert = new SoftAssert();
		// Verify the name,status,speed and linkType of the links in the response:
		System.out.println(
				"--------------------------------LINK 1 ---------------------------------------------------------------");
		// name
		String name1 = response.jsonPath().getString("[0].name");
		softAssert.assertEquals(name1, "172.16.121.60:ge-2/1/0-90.0.0.3:ge-2/0/0-LLDP",
				"The name1 should be 172.16.121.60:ge-2/1/0-90.0.0.3:ge-2/0/0-LLDP but it's not!!!");

		// status
		String status1 = response.jsonPath().getString("[0].status");
		softAssert.assertEquals(status1, "OK", "status1 should be OK but it's not!!!!");
		// speed
		String speed1 = response.jsonPath().getString("[0].speed");
		softAssert.assertEquals(speed1, "1000", "speed1 should be 1000 but it's not!!!");
		// linkType
		String linkType1 = response.jsonPath().getString("[0].linkType");
		softAssert.assertEquals(linkType1, "LLDP", "linkType1 should be OSPF but it's not!!!");
		System.out.println(
				"--------------------------------LINK 2 ---------------------------------------------------------------");
		// name
		String name2 = response.jsonPath().getString("[1].name");
		softAssert.assertEquals(name2, "90.0.0.1:Gi13/2-90.0.0.3:ge-2/1/0-OSPF",
				"The name2 should be 90.0.0.1:Gi13/2-90.0.0.3:ge-2/1/0-OSPF but it's not!!!");
		// status
		String status2 = response.jsonPath().getString("[1].status");
		softAssert.assertEquals(status2, "OK", "status2 should be OK but it's not!!!!");
		// speed
		String speed2 = response.jsonPath().getString("[1].speed");
		softAssert.assertEquals(speed2, "1000", "speed2 should be 1000 but it's not!!!");
		// linkType
		String linkType2 = response.jsonPath().getString("[1].linkType");
		softAssert.assertEquals(linkType2, "OSPF", "linkType2 should be OSPF but it's not!!!");

		System.out.println(
				"--------------------------------LINK 3 ---------------------------------------------------------------");
		// name
		String name3 = response.jsonPath().getString("[2].name");
		softAssert.assertEquals(name3, "90.0.0.3:ge-2/1/1-90.0.0.9:Gi0/1-LLDP",
				"The name3 should be 90.0.0.3:ge-2/1/1-90.0.0.9:Gi0/1-LLDP but it's not!!!");
		// status
		String status3 = response.jsonPath().getString("[2].status");
		softAssert.assertEquals(status3, "OK", "status3 should be OK but it's not!!!!");
		// speed
		String speed3 = response.jsonPath().getString("[2].speed");
		softAssert.assertEquals(speed3, "1000", "speed3 should be 1000 but it's not!!!");
		// linkType
		String linkType3 = response.jsonPath().getString("[2].linkType");
		softAssert.assertEquals(linkType3, "LLDP", "linkType3 should be LLDP but it's not!!!");
		System.out.println(
				"--------------------------------LINK 4 ---------------------------------------------------------------");
		// name
		String name4 = response.jsonPath().getString("[3].name");
		softAssert.assertEquals(name4, "90.0.0.3:xe-2/3/0-90.0.0.4:xe-1/3/0-LLDP",
				"The name4 should be 90.0.0.3:xe-2/3/0-90.0.0.4:xe-1/3/0-LLDP but it's not!!!");
		// status
		String status4 = response.jsonPath().getString("[3].status");
		softAssert.assertEquals(status4, "OK", "status4 should be OK but it's not!!!!");
		// speed
		String speed4 = response.jsonPath().getString("[3].speed");
		softAssert.assertEquals(speed4, "10000", "speed4 should be 10000 but it's not!!!");
		// linkType
		String linkType4 = response.jsonPath().getString("[3].linkType");
		softAssert.assertEquals(linkType4, "LLDP", "linkType4 should be LLDP but it's not!!!");
		System.out.println(
				"--------------------------------LINK 5 ---------------------------------------------------------------");
		// name
		String name5 = response.jsonPath().getString("[4].name");
		softAssert.assertEquals(name5, "90.0.0.3:xe-1/1/0-90.0.0.4:xe-1/2/0-LLDP",
				"The name5 should be  90.0.0.3:xe-1/1/0-90.0.0.4:xe-1/2/0-LLDP but it's not!!!");
		// status
		String status5 = response.jsonPath().getString("[4].status");
		softAssert.assertEquals(status5, "OK", "status4 should be OK but it's not!!!!");
		// speed
		String speed5 = response.jsonPath().getString("[4].speed");
		softAssert.assertEquals(speed5, "10000", "speed5 should be 10000 but it's not!!!");
		// linkType
		String linkType5 = response.jsonPath().getString("[4].linkType");
		softAssert.assertEquals(linkType5, "LLDP", "linkType4 should be LLDP but it's not!!!");
		softAssert.assertAll();

	}

	@Test(priority = 13, description = "get all the links of the inventory", enabled = true)
	public void tc13getLinksList() {

		// Get response
		Response response = RestAssured.given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/links/inventory/list");
		response.prettyPrint();
		System.out.println(

				"------------------------------------------------------------------------------------------------");

		Link link0 = new Link("90.0.0.3:xe-1/1/0-90.0.0.4:xe-1/2/0-LLDP", "OK", "10000", "LLDP");
		Link link1 = new Link("172.16.121.60:ge-2/1/0-90.0.0.3:ge-2/0/0-LLDP", "OK", "1000", "LLDP");
		Link link2 = new Link("90.0.0.3:ge-2/1/1-90.0.0.9:Gi0/1-LLDP", "OK", "1000", "LLDP");
		Link link3 = new Link("90.0.0.3:xe-2/3/0-90.0.0.4:xe-1/3/0-LLDP", "OK", "10000", "LLDP");
		Link link4 = new Link("90.0.0.4:ge-1/0/5-90.0.0.4:ge-1/0/6-LLDP", "OK", "1000", "LLDP");
		Link link5 = new Link("90.0.0.1:Gi13/8-90.0.0.2:Gi13/8-CDP", "OK", "1000", "CDP");
		Link link6 = new Link("90.0.0.1:Gi13/1-90.0.0.2:Gi13/1-CDP", "OK", "1000", "CDP");
		Link link7 = new Link("90.0.0.2:Fa1/41-90.0.0.8:Fa0/20-CDP", "OK", "100", "CDP");
		Link link8 = new Link("90.0.0.8:Fa0/23-90.0.0.9:Fa0/24-CDP", "OK", "100", "CDP");
		Link link9 = new Link("90.0.0.1:Gi13/2-90.0.0.3:ge-2/1/0-OSPF", "OK", "1000", "OSPF");
		Link link10 = new Link("90.0.0.2:Gi13/3-90.0.0.4:ge-1/1/0-OSPF", "OK", "1000", "OSPF");
		Link link11 = new Link("90.0.0.1:Gi13/1-90.0.0.2:Gi13/1-OSPF", "OK", "1000", "OSPF");
		Link link12 = new Link("90.0.0.2:Gi13/2-90.0.0.6:to-MX111-OSPF", "OK", "1000", "OSPF");
		Link link13 = new Link("90.0.0.8:Fa0/23-90.0.0.9:Fa0/24-OSPF", "OK", "100", "OSPF");
		Link link14 = new Link("90.0.0.5:to-7705-2-90.0.0.6:to-7705-1-OSPF", "OK", "100", "OSPF");

		Link[] links = new Link[15];

		links[0] = link0;
		links[1] = link1;
		links[2] = link2;
		links[3] = link3;
		links[4] = link4;
		links[5] = link5;
		links[6] = link6;
		links[7] = link7;
		links[8] = link8;
		links[9] = link9;
		links[10] = link10;
		links[11] = link11;
		links[12] = link12;
		links[13] = link13;
		links[14] = link14;

		System.out.println("--------------------------------------------------------------------------");
		// Verify Status Code 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not!!!!");
		SoftAssert softAssert = new SoftAssert();
		// Verify links
		System.out.println("---------------------------------LINK 0  ----------------------------------------------");
		String linkname0 = response.jsonPath().getString("[0].name");
		String linkstatus0 = response.jsonPath().getString("[0].status");
		String linkspeed0 = response.jsonPath().getString("[0].speed");
		String linkType0 = response.jsonPath().getString("[0].linkType");
		Link linkdev0 = getLinkByName(links, linkname0);
		Assert.assertNotNull(linkdev0, "the link  not exist in the array");
		softAssert.assertEquals(linkdev0.getName(), linkname0, "the name of link 0 in the respond is not the expected");
		softAssert.assertEquals(linkdev0.getStatus(), linkstatus0, "the status of link  0 should be OK but it's not!!");
		softAssert.assertEquals(linkdev0.getSpeed(), linkspeed0,
				"the speed of link 0 in the respond is not the expected");
		softAssert.assertEquals(linkdev0.getLinkType(), linkType0,
				"the linkType of link 0 in the respond is not the expected");
		System.out.println("---------------------------------LINK 1  ----------------------------------------------");
		String linkname1 = response.jsonPath().getString("[1].name");
		String linkstatus1 = response.jsonPath().getString("[1].status");
		String linkspeed1 = response.jsonPath().getString("[1].speed");
		String linkType1 = response.jsonPath().getString("[1].linkType");
		Link linkdev1 = getLinkByName(links, linkname1);
		Assert.assertNotNull(linkdev1, "the link  not exist in the array");
		softAssert.assertEquals(linkdev1.getName(), linkname1, "the name of link 1 in the respond is not the expected");
		softAssert.assertEquals(linkdev1.getStatus(), linkstatus1, "the status of link  1 should be OK but it's not!!");
		softAssert.assertEquals(linkdev1.getSpeed(), linkspeed1,
				"the speed of link 1 in the respond is not the expected");
		softAssert.assertEquals(linkdev1.getLinkType(), linkType1,
				"the linkType of link 1 in the respond is not the expected");
		System.out.println("---------------------------------LINK 2  ----------------------------------------------");
		String linkname2 = response.jsonPath().getString("[2].name");
		String linkstatus2 = response.jsonPath().getString("[2].status");
		String linkspeed2 = response.jsonPath().getString("[2].speed");
		String linkType2 = response.jsonPath().getString("[2].linkType");
		Link linkdev2 = getLinkByName(links, linkname2);
		Assert.assertNotNull(linkdev2, "the link  not exist in the array");
		softAssert.assertEquals(linkdev2.getName(), linkname2, "the name of link 2 in the respond is not the expected");
		softAssert.assertEquals(linkdev2.getStatus(), linkstatus2, "the status of link  2 should be OK but it's not!!");
		softAssert.assertEquals(linkdev2.getSpeed(), linkspeed2,
				"the speed of link 2 in the respond is not the expected");
		softAssert.assertEquals(linkdev2.getLinkType(), linkType2,
				"the linkType of link 2 in the respond is not the expected");
		System.out.println("---------------------------------LINK 3  ----------------------------------------------");
		String linkname3 = response.jsonPath().getString("[3].name");
		String linkstatus3 = response.jsonPath().getString("[3].status");
		String linkspeed3 = response.jsonPath().getString("[3].speed");
		String linkType3 = response.jsonPath().getString("[3].linkType");
		Link linkdev3 = getLinkByName(links, linkname3);
		Assert.assertNotNull(linkdev3, "the link  not exist in the array");
		softAssert.assertEquals(linkdev3.getName(), linkname3, "the name of link 3 in the respond is not the expected");
		softAssert.assertEquals(linkdev3.getStatus(), linkstatus3, "the status of link 3 should be OK but it's not!!");
		softAssert.assertEquals(linkdev3.getSpeed(), linkspeed3,
				"the speed of link 3 in the respond is not the expected");
		softAssert.assertEquals(linkdev3.getLinkType(), linkType3,
				"the linkType of link 3 in the respond is not the expected");
		System.out.println("---------------------------------LINK 4  ----------------------------------------------");
		String linkname4 = response.jsonPath().getString("[4].name");
		String linkstatus4 = response.jsonPath().getString("[4].status");
		String linkspeed4 = response.jsonPath().getString("[4].speed");
		String linkType4 = response.jsonPath().getString("[4].linkType");
		Link linkdev4 = getLinkByName(links, linkname4);
		Assert.assertNotNull(linkdev4, "the link  not exist in the array");
		softAssert.assertEquals(linkdev4.getName(), linkname4, "the name of link 4 in the respond is not the expected");
		softAssert.assertEquals(linkdev4.getStatus(), linkstatus4, "the status of link 4 should be OK but it's not!!");
		softAssert.assertEquals(linkdev4.getSpeed(), linkspeed4,
				"the speed of link 4 in the respond is not the expected");
		softAssert.assertEquals(linkdev4.getLinkType(), linkType4,
				"the linkType of link 4 in the respond is not the expected");
		System.out.println("---------------------------------LINK 5  ----------------------------------------------");
		String linkname5 = response.jsonPath().getString("[5].name");
		String linkstatus5 = response.jsonPath().getString("[5].status");
		String linkspeed5 = response.jsonPath().getString("[5].speed");
		String linkType5 = response.jsonPath().getString("[5].linkType");
		Link linkdev5 = getLinkByName(links, linkname5);
		Assert.assertNotNull(linkdev5, "the link  not exist in the array");
		softAssert.assertEquals(linkdev5.getName(), linkname5, "the name of link 5 in the respond is not the expected");
		softAssert.assertEquals(linkdev5.getStatus(), linkstatus5, "the status of link 5 should be OK but it's not!!");
		softAssert.assertEquals(linkdev5.getSpeed(), linkspeed5,
				"the speed of link 5 in the respond is not the expected");
		softAssert.assertEquals(linkdev5.getLinkType(), linkType5,
				"the linkType of link 5 in the respond is not the expected");
		System.out.println("---------------------------------LINK 6  ----------------------------------------------");
		String linkname6 = response.jsonPath().getString("[6].name");
		String linkstatus6 = response.jsonPath().getString("[6].status");
		String linkspeed6 = response.jsonPath().getString("[6].speed");
		String linkType6 = response.jsonPath().getString("[6].linkType");
		Link linkdev6 = getLinkByName(links, linkname6);
		Assert.assertNotNull(linkdev6, "the link  not exist in the array");
		softAssert.assertEquals(linkdev6.getName(), linkname6, "the name of link 6 in the respond is not the expected");
		softAssert.assertEquals(linkdev6.getStatus(), linkstatus6, "the status of link 6 should be OK but it's not!!");
		softAssert.assertEquals(linkdev6.getSpeed(), linkspeed6,
				"the speed of link 6 in the respond is not the expected");
		softAssert.assertEquals(linkdev6.getLinkType(), linkType6,
				"the linkType of link 6 in the respond is not the expected");
		System.out.println("---------------------------------LINK 7  ----------------------------------------------");
		String linkname7 = response.jsonPath().getString("[7].name");
		String linkstatus7 = response.jsonPath().getString("[7].status");
		String linkspeed7 = response.jsonPath().getString("[7].speed");
		String linkType7 = response.jsonPath().getString("[7].linkType");
		Link linkdev7 = getLinkByName(links, linkname7);
		Assert.assertNotNull(linkdev7, "the link  not exist in the array");
		softAssert.assertEquals(linkdev7.getName(), linkname7, "the name of link 7 in the respond is not the expected");
		softAssert.assertEquals(linkdev7.getStatus(), linkstatus7, "the status of link 7 should be OK but it's not!!");
		softAssert.assertEquals(linkdev7.getSpeed(), linkspeed7,
				"the speed of link 7 in the respond is not the expected");
		softAssert.assertEquals(linkdev7.getLinkType(), linkType7,
				"the linkType of link 7 in the respond is not the expected");
		System.out.println("---------------------------------LINK 8  ----------------------------------------------");
		String linkname8 = response.jsonPath().getString("[8].name");
		String linkstatus8 = response.jsonPath().getString("[8].status");
		String linkspeed8 = response.jsonPath().getString("[8].speed");
		String linkType8 = response.jsonPath().getString("[8].linkType");
		Link linkdev8 = getLinkByName(links, linkname8);
		Assert.assertNotNull(linkdev8, "the link  not exist in the array");
		softAssert.assertEquals(linkdev8.getName(), linkname8, "the name of link 8 in the respond is not the expected");
		softAssert.assertEquals(linkdev8.getStatus(), linkstatus8, "the status of link 8 should be OK but it's not!!");
		softAssert.assertEquals(linkdev8.getSpeed(), linkspeed8,
				"the speed of link 8 in the respond is not the expected");
		softAssert.assertEquals(linkdev8.getLinkType(), linkType8,
				"the linkType of link 8 in the respond is not the expected");
		System.out.println("---------------------------------LINK 9  ----------------------------------------------");
		String linkname9 = response.jsonPath().getString("[9].name");
		String linkstatus9 = response.jsonPath().getString("[9].status");
		String linkspeed9 = response.jsonPath().getString("[9].speed");
		String linkType9 = response.jsonPath().getString("[9].linkType");
		Link linkdev9 = getLinkByName(links, linkname9);
		Assert.assertNotNull(linkdev9, "the link  not exist in the array");
		softAssert.assertEquals(linkdev9.getName(), linkname9, "the name of link 9 in the respond is not the expected");
		softAssert.assertEquals(linkdev9.getStatus(), linkstatus9, "the status of link 9 should be OK but it's not!!");
		softAssert.assertEquals(linkdev9.getSpeed(), linkspeed9,
				"the speed of link 9 in the respond is not the expected");
		softAssert.assertEquals(linkdev9.getLinkType(), linkType9,
				"the linkType of link 9 in the respond is not the expected");
		System.out.println("---------------------------------LINK 10  ----------------------------------------------");
		String linkname10 = response.jsonPath().getString("[10].name");
		String linkstatus10 = response.jsonPath().getString("[10].status");
		String linkspeed10 = response.jsonPath().getString("[10].speed");
		String linkType10 = response.jsonPath().getString("[10].linkType");
		Link linkdev10 = getLinkByName(links, linkname10);
		Assert.assertNotNull(linkdev10, "the link  not exist in the array");
		softAssert.assertEquals(linkdev10.getName(), linkname10,
				"the name of link 10 in the respond is not the expected");
		softAssert.assertEquals(linkdev10.getStatus(), linkstatus10,
				"the status of link 10 should be OK but it's not!!");
		softAssert.assertEquals(linkdev10.getSpeed(), linkspeed10,
				"the speed of link 10 in the respond is not the expected");
		softAssert.assertEquals(linkdev10.getLinkType(), linkType10,
				"the linkType of link 10 in the respond is not the expected");
		System.out.println("---------------------------------LINK 11  ----------------------------------------------");
		String linkname11 = response.jsonPath().getString("[11].name");
		String linkstatus11 = response.jsonPath().getString("[11].status");
		String linkspeed11 = response.jsonPath().getString("[11].speed");
		String linkType11 = response.jsonPath().getString("[11].linkType");
		Link linkdev11 = getLinkByName(links, linkname11);
		Assert.assertNotNull(linkdev11, "the link  not exist in the array");
		softAssert.assertEquals(linkdev11.getName(), linkname11,
				"the name of link 11 in the respond is not the expected");
		softAssert.assertEquals(linkdev11.getStatus(), linkstatus11,
				"the status of link 11 should be OK but it's not!!");
		softAssert.assertEquals(linkdev11.getSpeed(), linkspeed11,
				"the speed of link 12 in the respond is not the expected");
		softAssert.assertEquals(linkdev11.getLinkType(), linkType11,
				"the linkType of link 11 in the respond is not the expected");
		System.out.println("---------------------------------LINK 12  ----------------------------------------------");
		String linkname12 = response.jsonPath().getString("[12].name");
		String linkstatus12 = response.jsonPath().getString("[12].status");
		String linkspeed12 = response.jsonPath().getString("[12].speed");
		String linkType12 = response.jsonPath().getString("[12].linkType");
		Link linkdev12 = getLinkByName(links, linkname12);
		Assert.assertNotNull(linkdev12, "the link  not exist in the array");
		softAssert.assertEquals(linkdev12.getName(), linkname12,
				"the name of link 12 in the respond is not the expected");
		softAssert.assertEquals(linkdev12.getStatus(), linkstatus12,
				"the status of link 12 should be OK but it's not!!");
		softAssert.assertEquals(linkdev12.getSpeed(), linkspeed12,
				"the speed of link 12 in the respond is not the expected");
		softAssert.assertEquals(linkdev12.getLinkType(), linkType12,
				"the linkType of link 12 in the respond is not the expected");
		System.out.println("---------------------------------LINK 13  ----------------------------------------------");
		String linkname13 = response.jsonPath().getString("[13].name");
		String linkstatus13 = response.jsonPath().getString("[13].status");
		String linkspeed13 = response.jsonPath().getString("[13].speed");
		String linkType13 = response.jsonPath().getString("[13].linkType");
		Link linkdev13 = getLinkByName(links, linkname13);
		Assert.assertNotNull(linkdev13, "the link  not exist in the array");
		softAssert.assertEquals(linkdev13.getName(), linkname13,
				"the name of link 13 in the respond is not the expected");
		softAssert.assertEquals(linkdev13.getStatus(), linkstatus13,
				"the status of link 13 should be OK but it's not!!");
		softAssert.assertEquals(linkdev13.getSpeed(), linkspeed13,
				"the speed of link 13 in the respond is not the expected");
		softAssert.assertEquals(linkdev13.getLinkType(), linkType13,
				"the linkType of link 13 in the respond is not the expected");
		System.out.println("---------------------------------LINK 14  ----------------------------------------------");
		String linkname14 = response.jsonPath().getString("[14].name");
		String linkstatus14 = response.jsonPath().getString("[14].status");
		String linkspeed14 = response.jsonPath().getString("[14].speed");
		String linkType14 = response.jsonPath().getString("[14].linkType");
		Link linkdev14 = getLinkByName(links, linkname14);
		Assert.assertNotNull(linkdev14, "the link  not exist in the array");
		softAssert.assertEquals(linkdev14.getName(), linkname14,
				"the name of link 14 in the respond is not the expected");
		softAssert.assertEquals(linkdev14.getStatus(), linkstatus14,
				"the status of link 14 should be OK but it's not!!");
		softAssert.assertEquals(linkdev14.getSpeed(), linkspeed14,
				"the speed of link 14 in the respond is not the expected");
		softAssert.assertEquals(linkdev14.getLinkType(), linkType14,
				"the linkType of link 14 in the respond is not the expected");
		softAssert.assertAll();

	}

	@Test(priority = 14, description = "delete all the devices of the list", enabled = true)
	public void tc14deleteDevices() {

		// Get response
		Response response = RestAssured.given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.delete("/devices/delete?ids=1,2,3,4,5,6,7,8,9");
		response.prettyPrint();
		// Verify Status Code 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not!!!!");
	}

	@Test(priority = 15, description = "count of the devices after delete", enabled = true)
	public void tc15getDevicesCountafterDelete() {

		// Get response
		Response response = given().spec(spec).auth().preemptive().basic("admin", "Netace2021!").when()
				.get("/devices/count");
		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
		String count = response.getBody().asString();

		response.prettyPrint();
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		System.out.println(count);
		response.getStatusCode();

		// Verify response 200
		Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");
		// Verify the quantity of 0 devices in the response after the deletion
		Assert.assertEquals(count, "0", "the number of devices must be 0 but is not!!!!");

	}
}
