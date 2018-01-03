package com.example.virus.shinchanbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
