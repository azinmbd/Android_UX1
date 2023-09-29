package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Gesture DEMO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtViewSample = findViewById(R.id.TextViewSample);
        ImageView imgViewSample = findViewById(R.id.imageViewSample);

        Log.d(TAG, "Started Gesture Demo");

        try {

        } catch (Exception ex){
            Log.e(TAG, "File error");

            ex.printStackTrace();
        }

        Drawable img = ResourcesCompat.getDrawable(getResources(),
                                                    R.drawable.border, getTheme());

        Objects.requireNonNull(img, "Somehow image is null");
        img.setBounds(0, 0, img.getIntrinsicWidth(), img.getIntrinsicHeight());

        txtViewSample.setCompoundDrawables(img, null,img, null);
        txtViewSample.setCompoundDrawablePadding(8);
        txtViewSample.setAlpha(1.0f);

        Button btnShowTextOrImage = findViewById(R.id.buttonShowTextOrImage);
        Button btnShowBoth = findViewById(R.id.button2);

        btnShowTextOrImage.setOnClickListener((View view) -> {
              if (btnShowTextOrImage.getText().toString().equals("Show Text")){
                  txtViewSample.setVisibility(View.VISIBLE);
                  imgViewSample.setVisibility(View.INVISIBLE);
                  btnShowTextOrImage.setText(getResources().getText(R.string.txtShowImage));
              } else{
                  imgViewSample.setVisibility(View.VISIBLE);
                  txtViewSample.setVisibility(View.GONE);
                  btnShowTextOrImage.setText(getResources().getText(R.string.txtShowText));
              }



        });

        btnShowBoth.setOnClickListener((View view) -> {
            txtViewSample.setVisibility(View.VISIBLE);
            imgViewSample.setVisibility(View.VISIBLE);

        });

    }
}