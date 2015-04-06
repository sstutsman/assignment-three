package com.example.julio.albumstore;

import android.app.Activity;
import android.content.Context;
import android.content.Entity;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.LogWriter;
import android.support.v7.widget.*;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;





public class MainActivity  extends Activity {



    private RecyclerView albumsRecyclerView;
    private RecyclerView.Adapter albumReyclerViewAdpter;
    StaggeredGridLayoutManager layoutManager;
    private Album[] dataSet;
    private List<Album> dataSetList;

    private static final String clientID = "6b7e14da031f4d72b6a3301c262f5647";
    private static final String clientSecret = "a00298d93f164681b308aa3192909b19";
    private SharedPreferences userData;
    private HttpClient httpClient;
    private String userToken;
    private CurrentSession currentSession;
    private Map<String, Object> albumsMap;
    private HttpResponse response;



    private String[] albums;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentSession = new CurrentSession();

          dataSetList = new ArrayList<Album>();

        userData = getSharedPreferences("UserData", Context.MODE_PRIVATE);

        //download album data
        new DownloadAlbums().execute("https://accounts.spotify.com/api/token");

         //set up recycler view
        albumsRecyclerView = (RecyclerView) findViewById(R.id.albumRecycleView);
        albumsRecyclerView.setHasFixedSize(true);
        albumReyclerViewAdpter = new AlbumAdapter(this, dataSetList);
        albumsRecyclerView.setAdapter(albumReyclerViewAdpter);
        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        albumsRecyclerView.setLayoutManager(layoutManager);





    }

    public void asyncComplete(boolean success){
        albumReyclerViewAdpter.notifyDataSetChanged();

    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private class DownloadAlbums extends AsyncTask<String, Integer, Album[]> {


        @Override
        protected Album[] doInBackground(String... params) {


            httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(params[0]);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
            nameValuePairs.add(new BasicNameValuePair("grant_type", "authorization_code"));
            String userCode = userData.getString("userAuthCode", null);
            String authHeader = clientID + ":" + clientSecret;
            HttpEntity tokenEnity;
            String responseString;
            userToken = userData.getString("userToken",null);


            nameValuePairs.add(new BasicNameValuePair("code", userCode));

            nameValuePairs.add(new BasicNameValuePair("redirect_uri", "http://topalbums"));

            try {
                String encodedString = Base64.encodeToString(authHeader.getBytes("UTF-8"), Base64.DEFAULT).replaceAll("\\s", "");
                httpPost.setHeader("Authorization", "Basic " + encodedString);
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();


            }


            try {
                if(userToken == null) {
                    response = httpClient.execute(httpPost);
                    tokenEnity = response.getEntity();
                     responseString = EntityUtils.toString(tokenEnity).replace("{", "");
                    responseString = responseString.replace("}", "");
                    userToken = responseString.split(",")[0].split(":")[1].replace("\"", "");
                    currentSession.setAuthToken(userToken);
                    SharedPreferences.Editor editor = userData.edit();
                    editor.putString("userToken", userToken);
                    editor.commit();



                    getNewReleases();
                }
                else{

                    getNewReleases();

                }




            } catch (Exception e) {
                e.printStackTrace();
            }


            return currentSession.getAllAlbums();
        }

        private void getNewReleases() {

try {


    HttpGet httpGet = new HttpGet("https://api.spotify.com/v1/browse/new-releases");
    String bearer = String.format("Bearer %s", userToken);
    httpGet.setHeader("Authorization", bearer);


    response = httpClient.execute(httpGet);
    HttpEntity albumResponseEntity = response.getEntity();
    String responseString = EntityUtils.toString(albumResponseEntity);



    JsonParser parser = new JsonParser();
    JsonObject obj = parser.parse(responseString).getAsJsonObject();
    int albumsNumber = obj.get("albums").getAsJsonObject().get("items").getAsJsonArray().size();
    Uri[] albumUrlArray = new Uri[20];
    String albumIDString = "";
    for (int i = 0; i < albumUrlArray.length; i++) {

        albumUrlArray[i] = Uri.parse(obj.get("albums").getAsJsonObject().get("items").getAsJsonArray()
                .get(i).getAsJsonObject().get("href").toString().replace("\"", ""));
        if (i == 19) {
            albumIDString += albumUrlArray[i].getLastPathSegment();
        } else {
            albumIDString += albumUrlArray[i].getLastPathSegment() + ",";
        }

    }
    albumIDString = albumIDString.replaceAll(" , $", "");


    httpGet.setURI(new URI("https://api.spotify.com/v1/albums?ids=" + albumIDString));
    response = httpClient.execute(httpGet);
    albumResponseEntity = response.getEntity();
    responseString = EntityUtils.toString(albumResponseEntity);


    responseString = parser.parse(responseString).getAsJsonObject().get("albums").toString();

    Gson gson = new Gson();
    currentSession.setAllAlbums(gson.fromJson(responseString, Album[].class));
}catch (Exception e){
    e.printStackTrace();
}

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Album[] result)
        {


            dataSetList.addAll(Arrays.asList(result));

albumReyclerViewAdpter.notifyDataSetChanged();

        }

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
