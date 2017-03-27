package com.example.jarojas.example;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sun.mail.smtp.SMTPMessage;

import javax.mail.Message;

public class ContactActivity extends AppCompatActivity {

    private TextInputEditText tvContactName;
    private TextInputEditText tvContactEmail;
    private TextInputEditText tvContactComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_pets);

        initViews();
    }

    private void initViews() {
        tvContactName = (TextInputEditText)findViewById(R.id.tvContactName);
        tvContactEmail = (TextInputEditText)findViewById(R.id.tvContactEmail);
        tvContactComment = (TextInputEditText)findViewById(R.id.tvContactComment);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto:"));

        intent.putExtra(Intent.EXTRA_EMAIL, "reivaj.mist@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Comment from" + tvContactEmail.getText());
        intent.putExtra(Intent.EXTRA_TEXT,String.format("%s escribio:\n %s",tvContactName, tvContactComment.getText()));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
