package itts.voltapg.mockyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private Button btnRequest;

    private RequestQueue queue;
    private StringRequest stringRequest;
    private String url ="https://run.mocky.io/v3/19cb0477-585c-455f-8e02-89dcca6ce082";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnRequest = (Button)  findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }
 private void getData(){
        //1) creare una nuova RICHIESTA HTTP da associare all'activity
        // DA ASSOCIARE ALLA ACTIVITY
        // DA ACCODARE ALLE ALTRE RICHIESTE
         // ISTANZA DELLA CODA
     final TextView textView = (TextView) findViewById(R.id.text);
 queue= Volley.newRequestQueue( this);

 //2 COSTRUZIONE DELLA RICHIESTA
     //String request initialized

   stringRequest = new StringRequest(Request.Method.GET, url,
           new Response.Listener<String>() {
       //RISPOSTA IN CASO DI RESULT CODE
                 @Override
                 public void onResponse(String response) {

                     Toast.makeText(getApplicationContext(),"Response :" + response.toString(),
                             Toast.LENGTH_LONG).show();

                     // Display the first 500 characters of the response string.

                 }
             }, new Response.ErrorListener() {
         @Override
         public void onErrorResponse(VolleyError error) {
           Log.i("TAG", "Error :" + error.toString());
         }
     });
     queue.add(stringRequest);
 }



}
