package com.csc.lesson1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    public static final String IMAGE_URL = "https://avatars1.githubusercontent.com/u/4986998";
    private boolean imageLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (networkConnected(getApplicationContext()))
            downloadImage();
    }

    public boolean networkConnected(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        System.out.println(networkInfo != null && networkInfo.isConnected());
        return networkInfo != null && networkInfo.isConnected();
    }

    public void downloadImage() {
        if (!imageLoaded) {
            ImageView imageView = (ImageView) findViewById(R.id.image);
            Picasso.with(getApplicationContext()).load(IMAGE_URL).into(imageView);
            imageLoaded = true;
        }
    }
}
