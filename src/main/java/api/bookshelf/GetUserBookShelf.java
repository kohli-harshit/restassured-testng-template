package api.bookshelf;

import api.BaseAPI;

import static io.restassured.RestAssured.given;

/**
 * Created by kohlih on 12-11-2017.
 */
public class GetUserBookShelf extends BaseAPI {

    String apiPath="/users/{userId}/bookshelves/{shelfId}";
    String accessToken;
    String userId;
    String shelfId;

    public GetUserBookShelf(String baseURI,String accessToken) {
        super(baseURI);
        this.accessToken = accessToken;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    @Override
    protected void createRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecBuilder.addPathParam("userId",userId);
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
