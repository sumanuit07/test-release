package sumanu.it;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;

import sumanu.release.App;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataListIntegrationTest {

    @LocalServerPort
    private int port;
    
	@Before
    public void setUp() throws Exception {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;

    }

	@Test
	public void call_integration_test1() {
		System.out.println("call_integration_test1");
		assertEquals(1L, 1L);
	}

	@Test
	public void createClient() {
		get("/greet?name=SuManU")
			.then()
				.statusCode(200)
				.body(equalTo("Hello SuManU"));
	}
}