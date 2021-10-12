import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Haker {

    public static void main(String[] args) throws Exception {

        String path = "http://localhost:8080/on-deploy/bmi_session";

        URL url = new URL(path);

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestProperty("Cookie" , "JSESSIONID=4997EBA5F213CD9AF551D858A5D596DE");
        conn.connect();
        InputStream is = conn.getInputStream();
        System.out.println(IOUtils.toString(is,"utf-8"));

    }


}
