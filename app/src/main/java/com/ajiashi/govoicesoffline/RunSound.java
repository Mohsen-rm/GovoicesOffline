package com.ajiashi.govoicesoffline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class RunSound extends AppCompatActivity {

    ArrayList<itemModel> arrayList, arrayList1;
    RecyclerView recyclerView, recyclerView1;
    //int icons[] = {R.drawable.facebook,R.drawable.facebook,R.drawable.facebook,R.drawable.facebook,R.drawable.facebook,R.drawable.facebook,R.drawable.facebook,R.drawable.facebook,R.drawable.facebook};
    String iconsName[] = {"Chrome", "Google Drive", "Facebook", "Twitter", "Google Maps", "WhatsApp", "LinkedIn", "Google+", "Instagram"};
    String name[] = { "Alex Thomson", "Steven Croft", "Rob Jones", "Stephen Parry", "James Anderson", "Sam Hain","jhdfjkdjk"};
    //int icons[];
    String nameound [];
    int TYPE = 0 ;
    String ptha;
    IconsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_sound);

        Intent type = getIntent();

        TYPE = type.getExtras().getInt("type");
        ptha = type.getExtras().getString("phat");

        switch (ptha){
            case "animls":
                nameound = getResources().getStringArray(R.array.animls);
                Run(0,ptha);
                break;
            case "horror":
                nameound = getResources().getStringArray(R.array.horror);
                Run(1,ptha);
                break;
            case "cars":
                nameound = getResources().getStringArray(R.array.cars);
                Run(0,ptha);
                break;
            case "Funny":
                nameound = getResources().getStringArray(R.array.Funny);
                Run(0,ptha);
                break;
            case "natural":
                nameound = getResources().getStringArray(R.array.natural);
                Run(0,ptha);
                 break;
            case "sound":
                nameound = getResources().getStringArray(R.array.sound);
                Run(0,ptha);
                 break;
            case "think":
                nameound = getResources().getStringArray(R.array.think);
                Run(0,ptha);
                break;
            default:
                break;
        }
    }

    private void Run(int number,String ptha) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view1);
        arrayList = new ArrayList<>();
        //arrayList1 = new ArrayList<>();
        //icons = getResources().getIntArray(R.array.hoore);
        addIcons(ptha);
        //addServices();
    }

    public void addIcons(String ptha) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0; i < nameound.length; i++) {
            itemModel itemModel = new itemModel();
            itemModel.setImage(R.drawable.ic_baseline_volume_up_24);
            itemModel.setName(ptha+"/"+nameound[i]);
            itemModel.setImagered(R.drawable.ic_baseline_volume_up_read_24);
            arrayList.add(itemModel);
        }

        adapter = new IconsAdapter(getApplicationContext(), arrayList);
        recyclerView.setAdapter(adapter);;
    }
    //    public void addServices() {
//        recyclerView1.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView1.setItemAnimator(new DefaultItemAnimator());
//        for (int i = 0; i < name.length; i++) {
//            itemModel itemModel = new itemModel();
//            itemModel.setName(name[i]);
//            itemModel.setRating(rating[i]);
//            itemModel.setPrice(price[i]);
//            itemModel.setService(service[i]);
//            arrayList1.add(itemModel);
//        }
//
//        ServicesAdapter adapter = new ServicesAdapter(getApplicationContext(), arrayList1);
//        recyclerView1.setAdapter(adapter);
//    }


    @Override
    protected void onPause() {
        adapter.stopSound();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        adapter.stopSound();
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        adapter.stopSound();
        super.onStop();
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
}