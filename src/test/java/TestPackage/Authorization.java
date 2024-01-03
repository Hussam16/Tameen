package TestPackage;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Authorization {



    @Test(description = "Login with valid username and password")
    public void login(){


        String url="https://testfawrybrokerageapi.eg-insurtech.com/api";
        SHAFT.API api = new SHAFT.API(url);

        JSONObject body = new JSONObject();
        body.put("Username", "01120112011");
        body.put("Password", "P@ssw0rd");
        Response reponse = api.post("/Authenticate/login").setRequestBody(body).setContentType(ContentType.JSON).setTargetStatusCode(200).perform();
        api.assertThatResponse().matchesSchema("JsonSchemes/login.json").perform();


    }
}
