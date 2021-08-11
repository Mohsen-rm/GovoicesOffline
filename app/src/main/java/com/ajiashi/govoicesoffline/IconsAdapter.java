package com.ajiashi.govoicesoffline;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class IconsAdapter extends RecyclerView.Adapter<IconsAdapter.viewHolder> {

    Context context;
    ArrayList<itemModel> arrayList;
    MediaPlayer m = new MediaPlayer();

    public IconsAdapter(Context context, ArrayList<itemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public  IconsAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.icon_list, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public  void onBindViewHolder(IconsAdapter.viewHolder viewHolder,int position) {
        //viewHolder.iconName.setText(arrayList.get(position).getName());
        viewHolder.icon.setImageResource(arrayList.get(position).getImage());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                playBeep(arrayList.get(position).getName());
                viewHolder.icon.setImageResource(arrayList.get(position).getImagered());
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return false;
            }
        });
    }
    public void playBeep(String path) {
        try {
            if (m.isPlaying()){
                m.stop();
                m.release();
                m = new MediaPlayer();
            }

            AssetFileDescriptor descriptor = context.getAssets().openFd(path);
            m.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            m.prepare();
            m.setVolume(1f, 1f);
            m.start();
            m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    m.stop();
                    m.release();
                    m = new MediaPlayer();
                    notifyDataSetChanged();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        ImageView icon;
        TextView iconName;

        public viewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            iconName = (TextView) itemView.findViewById(R.id.icon_name);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.icon_sound);
        }
    }

    public void stopSound(){
        m.stop();
        m.release();
        m = new MediaPlayer();
    }

}