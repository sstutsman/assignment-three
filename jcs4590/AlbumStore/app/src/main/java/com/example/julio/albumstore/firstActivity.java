package com.example.julio.albumstore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;


public class firstActivity extends Activity {

    protected Button logInButton;
    private Uri uriData;
    private SharedPreferences userData;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        userData = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        editor = userData.edit();


        logInButton = (Button) findViewById(R.id.button);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SpotifyWebLogInActivity.class);
                startActivityForResult(i,100);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        uriData = getIntent().getData();
        if(uriData != null){
            String authCode = uriData.getQueryParameter("code");
            editor.putString("userAuthCode",authCode);
            editor.commit();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i,null);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
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
