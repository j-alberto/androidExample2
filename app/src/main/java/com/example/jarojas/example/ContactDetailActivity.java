package com.example.jarojas.example;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvEmail;
    TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Bundle params = getIntent().getExtras();
        String name = params.getString(MainActivity.KEY_NAME);
        String email = params.getString(MainActivity.KEY_EMAIL);
        String phone = params.getString(MainActivity.KEY_PHONE);

        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);

        tvName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);
    }

    public void makeCall(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(
                Intent.ACTION_CALL,
                Uri.parse("tel:" + tvPhone.getText().toString())));
    }

    public void sendEmail(View view){
        startActivity(Intent.createChooser(
                new Intent(Intent.ACTION_SEND)
                    .setData(Uri.parse("mailto:"))
                    .setType("message/rfc822")
                    .putExtra(Intent.EXTRA_EMAIL, tvEmail.getText().toString()),
                "Choose App"));
    }
}
