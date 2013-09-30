

import java.io.InputStream;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class GetMethodMyExample {

    public static void main(String[] args) throws Exception {
    
    	CloseableHttpClient httpclient = HttpClients.createDefault();
    	HttpGet httpget = new HttpGet("http://localhost:8080/examples/servlets/servlet/HelloWWW");
    	
    	CloseableHttpResponse response = httpclient.execute(httpget);
    	try {
    	System.out.println("In the GetMethodMyExample.java");
    	
    	System.out.println(response.getProtocolVersion());
    	System.out.println(response.getStatusLine().getStatusCode());
    	System.out.println(response.getStatusLine().getReasonPhrase());
    	System.out.println(response.getStatusLine().toString());
    	
	    	HttpEntity entity = response.getEntity();
	    	if (entity != null) {
	    		long len = entity.getContentLength();
	    		if (len != -1 && len < 2048) {
	    		System.out.println(EntityUtils.toString(entity));
	    		} else {
	    		// Stream content out
	    		}
	    	}
    	} finally {
    	response.close();
    	}
 
    }
}