package api.auth;

import api.BaseAPI;
import com.google.common.base.Joiner;
import com.jayway.jsonpath.JsonPath;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by kohlih on 12-11-2017.
 */
public class PostToken extends BaseAPI {

    String apiPath="/oauth2/v4/token";
    String contentType;
    Map<String,String> bodyParams;
    String accessToken;

    public PostToken(String baseURI) {
        super(baseURI);
        bodyParams = new HashMap<String, String>();
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public void addBodyParam(String key, String value) {
        bodyParams.put(key,value);
    }
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    protected void createRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecBuilder.setContentType(contentType);
        requestSpecBuilder.setBody(Joiner.on("&").withKeyValueSeparator("=").join(bodyParams));
        requestSpecification = requestSpecBuilder.build();
    }

    @Override
    protected void executeRequest() {
        apiResponse = given().spec(requestSpecification).post();
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification = responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
        accessToken= JsonPath.read(apiResponse.asString(),"$.access_token");
    }
}
