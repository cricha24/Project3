package com.example.covidsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button searchCOVID;
    EditText enterCountry;
    ListView lv_Stats;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign value to each control
        searchCOVID = findViewById((R.id.searchCOVID));

        // click listener
        searchCOVID.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url ="https://coronavirus-19-api.herokuapp.com/countries";

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        String printInfo = "";
                        try {
                            for(int index = 0; index < 220; index++) {
                                  JSONObject current = request.getJSONObject(index);
                                  if(current.getString("country").equals(enterCountry.getText().toString())) {
                                    JSONObject info = response.getJSONObject(index);
                                    printInfo = info.getString("country");
                               }
                            }
                            //JSONObject info = response.getJSONObject(0);
                            //printInfo = info.getString("cases");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(MainActivity.this, "country = " + printInfo, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();

                    }
                });

                RequestSingleton.getInstance(MainActivity.this).addToRequestQueue(request);






            }

        });

    }
}