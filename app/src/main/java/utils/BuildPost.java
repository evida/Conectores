package utils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BuildPost {

    public static List<NameValuePair> buildPost (JSONObject source){

        List<NameValuePair> nvp = new ArrayList<NameValuePair>();

        @SuppressWarnings("unchecked") //using leagacy API
        Iterator<String> keys = source.keys();

        while(keys.hasNext()){
            String key = keys.next();
            String value = "";
            try {
                value = source.getString(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            nvp.add(new BasicNameValuePair(key, value));
        }

        return nvp;
    }

    public static List<NameValuePair> buildPut(String notes) {
        List<NameValuePair> nvp = new ArrayList <NameValuePair> ();
        nvp.add(new BasicNameValuePair("notes", notes));
        return nvp;
    }

}
