package com.mobintum.visioncontacts;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Contact contact = new Contact("Ricardo Centeno", "http://www.mobintum.com", "(521) 5514382887", "ricardo.centeno@mobintum.com", "rickstart" , "ricardo.centenolugo", "@rickstart", "me") ;
    private TextView txtName, txtCompany, txtPhone, txtEmail, txtGithub, txtFacebook, txtTwitter;
    private ImageButton btnPhone, btnEmail, btnGithub, btnFacebook, btnTwitter;
    private ImageView imgPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);
        txtName = (TextView) findViewById(R.id.txtName);
        txtCompany = (TextView) findViewById(R.id.txtCompany);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtGithub = (TextView) findViewById(R.id.txtGithub);
        txtFacebook = (TextView) findViewById(R.id.txtFacebook);
        txtTwitter = (TextView) findViewById(R.id.txtTwitter);
        btnPhone = (ImageButton) findViewById(R.id.btnPhone);
        btnEmail = (ImageButton) findViewById(R.id.btnEmail);
        btnGithub = (ImageButton) findViewById(R.id.btnGithub);
        btnTwitter = (ImageButton) findViewById(R.id.btnTwitter);
        btnFacebook = (ImageButton) findViewById(R.id.btnFacebook);

        btnPhone.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnGithub.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        txtCompany.setOnClickListener(this);


        txtName.setText(contact.getName());
        txtCompany.setText(contact.getCompany());
        txtPhone.setText(contact.getPhone());
        txtEmail.setText(contact.getEmail());
        txtFacebook.setText(contact.getFacebook());
        txtTwitter.setText(contact.getTwitter());
        txtGithub.setText(contact.getGithub());

        Resources resources = getApplicationContext().getResources();
        final int resourceId = resources.getIdentifier(contact.getPhoto(), "drawable",
                getApplicationContext().getPackageName());
        imgPhoto.setImageDrawable(resources.getDrawable(resourceId));



    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnPhone:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+contact.getPhone()));
                if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "You doesn't have permission, please check", Toast.LENGTH_SHORT).show();
                        return;
                    } else
                        startActivity(intent);
                }else
                    Toast.makeText(this, "Sorry you don't have needed hardware :(", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnEmail:
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+contact.getEmail()));
                startActivity(intent);
                break;
            case R.id.btnGithub:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.github.com/"+contact.getGithub()));
                startActivity(intent);
                break;
            case R.id.btnFacebook:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.facebook.com/"+contact.getFacebook()));
                startActivity(intent);

                break;
            case R.id.txtCompany:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(contact.getCompany()));
                startActivity(intent);

                break;
            case R.id.btnTwitter:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=rickstart"));
                try {
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.twitter.android"));
                    try{
                        startActivity(intent);
                    }catch(ActivityNotFoundException k){
                        Toast.makeText(this, "No tienes market instalado", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

    }
}
