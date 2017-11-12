package test;

import api.bookshelf.GetUserBookShelf;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.BookShelf;
import utils.CSVAnnotation;
import utils.GenericDataProvider;
import utils.PropertiesManager;

import java.io.IOException;
import java.util.Map;

/**
 * Created by kohlih on 12-11-2017.
 */
public class TestBookShelf extends BaseTest {

    @Test(groups={"Smoke","Regression"},dataProvider = "dataproviderForTestCase", dataProviderClass = GenericDataProvider.class)
    @CSVAnnotation.CSVFileParameters(path = "src\\test\\java\\test-data\\BookShelfInfo.csv", delimiter = "###")
    public void checkTitles(int rowNo, Map<String, String> inputData) throws IOException {

        //Get Book Shelf based on input shelf Id
        GetUserBookShelf getUserBookShelf = new GetUserBookShelf(PropertiesManager.getProperty("booksBaseURI"),accessToken);
        getUserBookShelf.setUserId(PropertiesManager.getProperty("userid"));
        getUserBookShelf.setShelfId(inputData.get("ShelfId"));
        getUserBookShelf.setExpectedStatusCode(200);
        getUserBookShelf.perform();

        //Verify that Shelf Title matches the one present in the input data
        BookShelf bookShelf = getUserBookShelf.getAPIResponseAsPOJO(BookShelf.class);
        String actualTitle=bookShelf.getTitle();
        String expectedTitle=inputData.get("Title");
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
