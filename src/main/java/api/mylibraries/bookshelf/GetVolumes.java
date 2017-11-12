package api.mylibraries.bookshelf;

import api.BaseAPI;

import static io.restassured.RestAssured.given;

/**
 * Created by kohlih on 12-11-2017.
 */
public class GetVolumes extends BaseAPI {

    String apiPath="/mylibrary/bookshelves/{shelfId}/volumes";
    String accessToken;
    int shelfId;

    public GetVolumes(String baseURI,String accessToken) {
        super(baseURI);
        this.accessToken = accessToken;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    @Override
    protected void createRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecBuilder.addPathParam("shelfId",shelfId);
        requestSpecification=requestSpecBuilder.build();
    }

    @Override
    protected void executeRequest() {
        apiResponse = given().spec(requestSpecification).auth().oauth2(accessToken).get();
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification=responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }
}
