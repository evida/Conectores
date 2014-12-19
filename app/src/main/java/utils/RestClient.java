package utils;


import android.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

public class RestClient {

    public static String executeHttpOauthPost(String uri, List<NameValuePair> nameValuePairs) throws Exception {

        BufferedReader in = null;

        try {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost request = new HttpPost();
            request.setURI(new URI(uri));
            request.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
            HttpResponse response = httpclient.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");

            while ((line = in.readLine()) != null) {

                sb.append(line + NL);
            }

            in.close();
            String page = sb.toString();
//			System.out.println(page);
            return page;
        } finally {

            if (in != null) {

                try {

                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
