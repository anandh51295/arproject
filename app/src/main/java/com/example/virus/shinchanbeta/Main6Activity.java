package com.example.virus.shinchanbeta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {
    TextView tv,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        tv=(TextView)findViewById(R.id.textView11);
        tv1=(TextView)findViewById(R.id.textView12);


    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @SuppressLint("NewApi") @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.about:
                Intent intent =new Intent(Main6Activity.this,Main6Activity.class);
                startActivity(intent);
                return (true);
            case R.id.exit:
                finish();
                System.exit(0);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}
