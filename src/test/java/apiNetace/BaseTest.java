package apiNetace;

import org.testng.annotations.BeforeMethod;

import apiNetaceSupport.Link;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	protected RequestSpecification spec;
	private static final String MY_BACKEND_SERVER ="http://172.18.11.10:7777";
	private static final String GENADY_BACKEND_SERVER ="backendserver";//place holder

	@BeforeMethod
	public void setUP() {

		spec = new RequestSpecBuilder().setBaseUri(MY_BACKEND_SERVER)
				.addFilter(new AllureRestAssured())
				.build();


	}

	public Link getLinkByName(Link[] links, String name) {

		for (int i = 0; i < links.length; i++) {

			if (name.equals(links[i].getName())) {
				return links[i];
			}
		}

		return null;

	}

}
