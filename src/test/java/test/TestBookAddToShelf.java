package test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pojo.bookshelf.Books;
import utils.PropertiesManager;
import api.mylibraries.bookshelf.*;

import java.io.IOException;

/**
 * Created by kohlih on 12-11-2017.
 */
public class TestBookAddToShelf extends BaseTest {

    public static final Logger logger = Logger.getLogger(TestBookAddToShelf.class);

    @Test(groups={"Regression"})
    public void addTop5BooksForYouToReadingList() throws IOException {

        //Clear 'To Read' Shelf
        PostClearVolumes postClearVolumes = new PostClearVolumes(PropertiesManager.getProperty("booksBaseURI"),accessToken);
        postClearVolumes.setShelfId(2);
        postClearVolumes.setExpectedStatusCode(204);
        postClearVolumes.perform();
        logger.info( "'To Read' Shelf cleared successfully");

        //Get Volumes from 'Books For You'
        GetVolumes getVolumes = new GetVolumes(PropertiesManager.getProperty("booksBaseURI"),accessToken);
        getVolumes.setShelfId(8);
        getVolumes.setExpectedStatusCode(200);
        getVolumes.perform();
        Books recommendedBooks = getVolumes.getAPIResponseAsPOJO(Books.class);

        //Add top 5 books to 'To Read' Shelf
        for(int bookCounter=1;bookCounter<=5;bookCounter++){
            String bookName = recommendedBooks.getItems().get(bookCounter-1).getVolumeInfo().getTitle();
            logger.info("Book Fetched from 'Books for You' shelf = " + bookName);
            PostAddVolume postAddVolume = new PostAddVolume(PropertiesManager.getProperty("booksBaseURI"),accessToken);
            postAddVolume.setShelfId(2);
            postAddVolume.setVolumeId(recommendedBooks.getItems().get(bookCounter-1).getId());
            postAddVolume.setExpectedStatusCode(204);
            postAddVolume.perform();
            logger.info( bookName + " added to 'To Read' shelf successfully");
        }
    }
}