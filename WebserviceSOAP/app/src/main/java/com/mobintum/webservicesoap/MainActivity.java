package com.mobintum.webservicesoap;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mobintum.webservicesoap.models.Nacionalidad;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SOAPAsynTask.AsyncCallback {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        invokeAsyncTask();
    }

    //create and execute asynctask to get response from W3school server
    private void invokeAsyncTask() {
        new SOAPAsynTask(MainActivity.this,new String[]{"usuario","password"}, this).execute("policia","12345");
    }

    @Override
    public void setResponse(ArrayList<Nacionalidad> nacionalidades) {
        for (Nacionalidad nacionalidad : nacionalidades){
            textView.append(nacionalidad.getNombre()+" "+nacionalidad.getCodigo()+"\n");
        }
    }
}
