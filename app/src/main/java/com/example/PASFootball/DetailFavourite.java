package com.example.PASFootball;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailFavourite extends AppCompatActivity {

    Realm realm;
    RealmHelper realmHelper;
    ModelMovieRealm movieModel;


    Bundle extras;
    String title;
    String date;
    String deskripsi;
    String path;
    String id;

    TextView tvteam;
    ImageView ivbadge;
    TextView txtdeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favourite);
        extras = getIntent().getExtras();
        tvteam = (TextView)findViewById(R.id.tvteam);
        txtdeskripsi = (TextView)findViewById(R.id.txtdeskripsi);
        ivbadge = (ImageView) findViewById(R.id.ivbadge);

        if (extras != null) {
            title = extras.getString("judul");
            id = extras.getString("id");
            date = extras.getString("date");
            deskripsi = extras.getString("deskripsi");
            path = extras.getString("badge");
            tvteam.setText(title);
            txtdeskripsi.setText(deskripsi);
            Glide.with(com.example.PASFootball.DetailFavourite.this)
                    .load(path)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivbadge);
            // and get whatever type user account id is
        }

        //Set up Realm
        Realm.init(com.example.PASFootball.DetailFavourite.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

    }
}