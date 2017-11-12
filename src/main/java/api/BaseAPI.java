package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

/**
 * Created by kohlih on 12-11-2017.
 */
public abstract class BaseAPI {

    protected String baseURI;
    protected RequestSpecBuilder requestSpecBuilder;
    protected RequestSpecification requestSpecification;
    protected ResponseSpecBuilder responseSpecBuilder;
    protected ResponseSpecification responseSpecification;
    protected Response apiResponse;
    protected int expectedStatusCode;

    public BaseAPI(String baseURI){
        this.baseURI=baseURI;
        requestSpecBuilder=new RequestSpecBuilder();
        responseSpecBuilder=new ResponseSpecBuilder();
    }

    protected Response getApiResponse() {
        return apiResponse;
    }

    public String getApiResponseAsString() {
        return apiResponse.asString();
    }

    public <T> T getAPIResponseAsPOJO(Class<T> type) throws IOException {
        return new ObjectMapper().readValue(getApiResponseAsString(),type);
    }

    public int getExpectedStatusCode() {
        return expectedStatusCode;
    }

    public void setExpectedStatusCode(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    protected abstract void createRequest();
    protected abstract void executeRequest();
    protected abstract void validateResponse();

    public void perform(){
        createRequest();
        executeRequest();
        validateResponse();
    }
}
