package com.ajiashi.govoicesoffline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearhorror , linearLayoutanimls , linearcars , linearFunny , linearnatural , linearsound , linearthink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearhorror = (LinearLayout)findViewById(R.id.linearhorror);
        linearLayoutanimls = (LinearLayout)findViewById(R.id.linearanmils);
        linearcars = (LinearLayout)findViewById(R.id.linearcars);
        linearFunny = (LinearLayout)findViewById(R.id.linearfunny);
        linearnatural = (LinearLayout)findViewById(R.id.linearnatural);
        linearsound = (LinearLayout)findViewById(R.id.linearsound);
        linearthink = (LinearLayout)findViewById(R.id.linearthink);

        linearhorror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RunSound.class);
                intent.putExtra("type",0);
                intent.putExtra("phat","horror");
                startActivity(intent);
            }
        });


        linearLayoutanimls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RunSound.class);
                intent.putExtra("type",1);
                intent.putExtra("phat","animls");
                startActivity(intent);
            }
        });

        linearcars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RunSound.class);
                intent.putExtra("type",2);
                intent.putExtra("phat","cars");
                startActivity(intent);
            }
        });

        linearFunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RunSound.class);
                intent.putExtra("type",3);
                intent.putExtra("phat","Funny");
                startActivity(intent);
            }
        });

        linearnatural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RunSound.class);
                intent.putExtra("type",4);
                intent.putExtra("phat","natural");
                startActivity(intent);
            }
        });

        linearsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RunSound.class);
                intent.putExtra("type",5);
                intent.putExtra("phat","sound");
                startActivity(intent);
            }
        });

        linearthink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RunSound.class);
                intent.putExtra("type",6);
                intent.putExtra("phat","think");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.ratting:
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
                return true;
            case R.id.privacy_policy:

                String url = getString(R.string.privacypolicy) ;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                return true;

            case R.id.msg_with_me:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"appamt703@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Hi Team Know "+getString(R.string.app_name));
                email.putExtra(Intent.EXTRA_TEXT, "");

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}