package api.mylibraries.bookshelf;

import api.BaseAPI;

import static io.restassured.RestAssured.given;

/**
 * Created by kohlih on 12-11-2017.
 */
public class PostAddVolume extends BaseAPI{

    String apiPath="mylibrary/bookshelves/{shelfId}/addVolume";
    String accessToken;
    int shelfId;
    String volumeId;

    public PostAddVolume(String baseURI,String accessToken) {
        super(baseURI);
        this.accessToken=accessToken;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    @Override
    protected void createRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecBuilder.addPathParam("shelfId",shelfId);
        requestSpecBuilder.addQueryParam("volumeId",volumeId);
        requestSpecification = requestSpecBuilder.build();
    }

    @Override
    protected void executeRequest() {
        apiResponse = given().spec(requestSpecification).auth().oauth2(accessToken).post();
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification=responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }
}
