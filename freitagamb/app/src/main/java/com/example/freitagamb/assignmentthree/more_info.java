package com.example.freitagamb.assignmentthree;

        import android.content.Intent;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;


public class more_info extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_info);/*
        String sum = getIntent().getStringExtra("sum");
        String ave = getIntent().getStringExtra("ave");
        TextView ans = (TextView)findViewById(R.id.answer);
        TextView average = (TextView)findViewById(R.id.ave);
        average.setText(ave);
        ans.setText(sum);

        TextView backBtn;
        backBtn = (TextView) findViewById(R.id.try_again);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });*/
    }


        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
}