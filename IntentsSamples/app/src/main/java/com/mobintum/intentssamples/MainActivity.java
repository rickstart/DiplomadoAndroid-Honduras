package com.mobintum.intentssamples;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnTwitter, btnEmail, btnMaps, btnScreen, btnCamera, btnPhone, btnWhats, btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTwitter = (ImageButton) findViewById(R.id.btnTwitter);
        btnEmail = (ImageButton) findViewById(R.id.btnEmail);
        btnMaps = (ImageButton) findViewById(R.id.btnMaps);
        btnScreen = (ImageButton) findViewById(R.id.btnScreen);
        btnCamera = (ImageButton) findViewById(R.id.btnCamera);
        btnPhone = (ImageButton) findViewById(R.id.btnPhone);
        btnWhats = (ImageButton) findViewById(R.id.btnWhats);
        btnScreen = (ImageButton) findViewById(R.id.btnScreen);
        btnSms = (ImageButton) findViewById(R.id.btnSms);


        btnTwitter.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnMaps.setOnClickListener(this);
        btnScreen.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnWhats.setOnClickListener(this);
        btnSms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnTwitter:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=rickstart"));

                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    intent = new Intent (Intent.ACTION_VIEW, Uri.parse("market://details?id=com.twitter.android"));
                    try {
                        startActivity(intent);
                    }catch (ActivityNotFoundException k){
                        Toast.makeText(this,"Hey sorry you need Play Store to use this feature",Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.btnEmail:
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ricardo.centeno@mobintum.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Title");
                intent.putExtra(Intent.EXTRA_TEXT, "This is a test please any injure look with Olvin");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"agarcia@grupovision.org", "malacantara@grupovision.org", "onunez@grupovision.org"});
                startActivity(intent);
                break;
            case R.id.btnMaps:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=37.7749,-122.4194"));
                startActivity(intent);
                break;
            case R.id.btnScreen:
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra("text", "Hello From the Otherside");
                startActivity(intent);
                break;
            case R.id.btnCamera:
                if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }else
                    Toast.makeText(this, "Sorry you don't have needed hardware :(", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnPhone:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5215514382887"));
                if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "You doesn't have permission, please check", Toast.LENGTH_SHORT).show();
                        return;
                    } else
                        startActivity(intent);
                }else
                    Toast.makeText(this, "Sorry you don't have needed hardware :(", Toast.LENGTH_SHORT).show();


                break;
            case R.id.btnWhats:
                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "This is a test from Honduras");
                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    intent = new Intent (Intent.ACTION_VIEW, Uri.parse("market://details?id=com.whatsapp"));
                    try {
                        startActivity(intent);
                    }catch (ActivityNotFoundException k){
                        Toast.makeText(this,"Hey sorry you need Play Store to use this feature",Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.btnSms:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:5514382887"));
                intent.putExtra("sms_body", "Body of message");
                startActivity(intent);
                break;
        }

    }
}
