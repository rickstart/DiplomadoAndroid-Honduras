package com.mobintum.exercisegallery;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgGallery;
    private Button btnBack, btnNext;
    private String [] images= {"img_elephant","img_jiraf","img_lion"};
    private int pos=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnNext = (Button) findViewById(R.id.btnNext);
        imgGallery = (ImageView) findViewById(R.id.imgGallery);
        btnBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBack:
                if(pos>0) {
                    pos--;
                    Resources resources = getApplicationContext().getResources();
                    final int resourceId = resources.getIdentifier(images[pos], "drawable",
                            getApplicationContext().getPackageName());
                    imgGallery.setImageDrawable(resources.getDrawable(resourceId));
                }
                break;
            case R.id.btnNext:
                if(pos< images.length-1) {
                    pos++;
                    Resources resources = getApplicationContext().getResources();
                    final int resourceId = resources.getIdentifier(images[pos], "drawable",
                            getApplicationContext().getPackageName());
                    imgGallery.setImageDrawable(resources.getDrawable(resourceId));
                }
                break;
        }
    }
}
