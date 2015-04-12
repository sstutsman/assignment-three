package com.example.julio.albumstore;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;


public class MainActivity  extends Activity {


    private RecyclerView albumsRecyclerView;
    private RecyclerView.Adapter albumReyclerViewAdpter;
    StaggeredGridLayoutManager layoutManager;
    private List<Album> dataSetList;

    private static final String clientID = "6b7e14da031f4d72b6a3301c262f5647";
    private static final String clientSecret = "a00298d93f164681b308aa3192909b19";
    private SharedPreferences userData;
    private HttpClient httpClient;
    private CurrentSession currentSession;
    private HttpResponse response;
    private String userCode;
    private String refreshResponseString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userData = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        currentSession = new Gson().fromJson(userData.getString("session", null), CurrentSession.class);
        dataSetList = new ArrayList<Album>();


        //download album data
        new DownloadAlbums().execute("https://accounts.spotify.com/api/token");

        //set up recycler view
        albumsRecyclerView = (RecyclerView) findViewById(R.id.albumRecycleView);
        albumsRecyclerView.setHasFixedSize(true);
        albumReyclerViewAdpter = new AlbumAdapter(this, dataSetList);
        albumsRecyclerView.setAdapter(albumReyclerViewAdpter);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        albumsRecyclerView.setLayoutManager(layoutManager);

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
            String authHeader = clientID + ":" + clientSecret;
            HttpEntity tokenEnity;
            String responseString;

            if (currentSession == null) {


                try {
                    //set post parameters for getting token
                    userCode = userData.getString("code", null);
                    nameValuePairs.add(new BasicNameValuePair("code", userCode));
                    nameValuePairs.add(new BasicNameValuePair("redirect_uri", "http://topalbums"));
                    String encodedString = Base64.encodeToString(authHeader.getBytes("UTF-8"), Base64.DEFAULT).replaceAll("\\s", "");
                    httpPost.setHeader("Authorization", "Basic " + encodedString);
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    response = httpClient.execute(httpPost);
                    tokenEnity = response.getEntity();
                    responseString = EntityUtils.toString(tokenEnity);

                    currentSession = new Gson().fromJson(responseString, CurrentSession.class);
                    // startTimer();


                    SharedPreferences.Editor editor = userData.edit();
                    editor.putString("session", responseString);
                    editor.commit();


                    getNewReleases();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                getNewReleases();

            }


            return currentSession.getAllAlbums();
        }





        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            setProgress(values[0]);

            ProgressDialog dialog = new ProgressDialog(getApplication());
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading. Please wait...");
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
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





    private void refreshToken() {

        HttpPost httpPost = new HttpPost("https://accounts.spotify.com/api/token");
        HttpClient client =  new DefaultHttpClient();
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("grant_type","refresh_token"));
        nameValuePairs.add(new BasicNameValuePair("refresh_token",currentSession.getRefresh_token()));
        String authHeader = clientID + ":" + clientSecret;

        try {
            String encodedString = Base64.encodeToString(authHeader.getBytes("UTF-8"), Base64.DEFAULT).replaceAll("\\s", "");
            httpPost.setHeader("Authorization", "Basic " + encodedString);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(httpPost);
            refreshResponseString = EntityUtils.toString(response.getEntity());
            String refreshToken = currentSession.getRefresh_token();
            currentSession =  new Gson().fromJson(refreshResponseString,CurrentSession.class);
            currentSession.setRefresh_token(refreshToken);



        }catch (Exception e){
            e.printStackTrace();
        }
    }






    private void getNewReleases() {

        try {


            //get albums
            HttpGet httpGet = new HttpGet("https://api.spotify.com/v1/browse/new-releases");

            String bearer = String.format("Bearer %s", currentSession.getAccess_token());

            httpGet.setHeader("Authorization", bearer);
            response = httpClient.execute(httpGet);
            HttpEntity albumResponseEntity = response.getEntity();
            String responseString = EntityUtils.toString(albumResponseEntity);
            JsonParser parser = new JsonParser();
            JsonObject obj = parser.parse(responseString).getAsJsonObject();
            if (obj.has("error")) {
                refreshToken();
                getNewReleases();
            } else {
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
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
