package com.mobintum.intentssamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtOut;
    private String chain ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtOut = (TextView) findViewById(R.id.txtOut);
        if(getIntent()!=null)
            if(getIntent().getExtras()!=null)
                if(getIntent().getExtras().getString("text")!=null)
                    chain = getIntent().getExtras().getString("text");

        txtOut.setText(chain);
    }
}
