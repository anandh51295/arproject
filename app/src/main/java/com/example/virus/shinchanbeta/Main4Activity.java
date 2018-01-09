package com.example.virus.shinchanbeta;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Main4Activity extends AppCompatActivity {
    String type,play,vid;
    ArrayAdapter<String> adapter;
    ArrayList<String> items;

    private ProgressDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Bundle bundle = getIntent().getExtras();
        type = bundle.getString("type");
        play = bundle.getString("play");

        ListView listView=(ListView)findViewById(R.id.listv);
        items=new ArrayList<String>();
        adapter=new ArrayAdapter(this, R.layout.item_layout,R.id.txt,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(Main7Activity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(Main7Activity.this, type+" "+play, Toast.LENGTH_SHORT).show();
                String[] separated = parent.getItemAtPosition(position).toString().split("ID:");
                vid=separated[1].trim();

                Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", vid);
                bundle.putString("play", play);
                intent.putExtras(bundle);
                startActivity(intent);
                //System.exit(0);


                //Toast.makeText(Main7Activity.this, separated[1].trim(), Toast.LENGTH_SHORT).show();
            }
        });

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
                Intent intent =new Intent(Main4Activity.this,Main6Activity.class);
                startActivity(intent);
                return (true);
            case R.id.exit:
                finish();
                System.exit(0);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
    //Toast.makeText(Main7Activity.this, type +" " +play, Toast.LENGTH_LONG).show();


    public void onStart(){
        super.onStart();
        loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);
        items.clear();

        String url = value.DATA_URL+type+"&play="+play;
        //Toast.makeText(getApplicationContext(), "url"+url, Toast.LENGTH_LONG).show();
        //loading.dismiss();
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);

                //Toast.makeText(getApplicationContext(), "Data Arrived"+response, Toast.LENGTH_LONG).show();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                        Toast.makeText(Main4Activity.this,"Check internet connection", Toast.LENGTH_LONG).show();
                        //Toast.makeText(Main3Activity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String name="";
        String id="";

        //loading.dismiss();
        JSONArray result;
        for(int i=0;i<response.length();i++) {
            try {

                JSONObject jsonObject = new JSONObject(response);
                result = jsonObject.getJSONArray(value.JSON_ARRAY);
                JSONObject collegeData = result.getJSONObject(i);
                name = collegeData.getString(value.KEY_NAME);
                id = collegeData.getString(value.KEY_NAME1);



                //Toast.makeText(getApplicationContext(), result + "", Toast.LENGTH_LONG).show();

                items.add("\n"+"Title:\t" + name+" "+"ID:\t" + id+"\n");


            } catch (JSONException e) {
                loading.dismiss();
                e.printStackTrace();
            }
            //textViewResult.setText("Message:\t"+name);

        }
        adapter.notifyDataSetChanged();
    }

}
