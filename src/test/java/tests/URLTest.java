package tests;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest {
	
	public int getResponseCode(String urlString) throws IOException {
	    URL u = new URL(urlString); 
	    HttpURLConnection huc =  (HttpURLConnection)  u.openConnection(); 
	    huc.setRequestMethod("GET"); 
	    huc.connect(); 
	    return huc.getResponseCode();
	}

}
