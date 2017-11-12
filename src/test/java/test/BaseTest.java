package test;

import api.auth.PostToken;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import utils.PropertiesManager;

public class BaseTest {

	public static final Logger logger = Logger.getLogger(BaseTest.class);
	protected static String accessToken;
	
	@BeforeSuite(alwaysRun=true)
	public void BeforeSuite() throws Exception
	{
        PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
		PropertiesManager.initializeProperties();
	    logger.info("Properties Initialized");

		PostToken postToken = new PostToken(PropertiesManager.getProperty("baseURI"));
		postToken.setContentType("application/x-www-form-urlencoded");
		postToken.addBodyParam("client_id",PropertiesManager.getProperty("client_id"));
		postToken.addBodyParam("client_secret",PropertiesManager.getProperty("client_secret"));
		postToken.addBodyParam("grant_type",PropertiesManager.getProperty("grant_type"));
		postToken.addBodyParam("refresh_token",PropertiesManager.getProperty("refresh_token"));
		postToken.setExpectedStatusCode(200);
		postToken.perform();
		accessToken = postToken.getAccessToken();
	    logger.info("OAuth Token Received = " + accessToken);
	}
}