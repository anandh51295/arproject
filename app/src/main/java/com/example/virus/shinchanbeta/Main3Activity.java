package com.example.virus.shinchanbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    String type;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");
        b1=(Button)findViewById(R.id.button5);
        b2=(Button)findViewById(R.id.button6);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myintent=new Intent(Main3Activity.this,Main5Activity.class);
                //startActivity(myintent);
                Intent intent =new Intent(Main3Activity.this,Main4Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("type",type);
                bundle.putString("play","current");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myintent=new Intent(Main3Activity.this,Main5Activity.class);
                //startActivity(myintent);
                Intent intent =new Intent(Main3Activity.this,Main4Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("type",type);
                bundle.putString("play","playlist");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
