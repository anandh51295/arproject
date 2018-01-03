package com.example.virus.shinchanbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1=(Button)findViewById(R.id.button3);
        btn2=(Button)findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent myintent=new Intent(Main3Activity.this,Main5Activity.class);
                //startActivity(myintent);
                Intent intent =new Intent(Main2Activity.this,Main3Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("type","movies");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Main2Activity.this,Main3Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("type","episodes");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
