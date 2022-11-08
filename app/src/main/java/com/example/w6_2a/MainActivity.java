package com.example.w6_2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] images = new int[] {R.drawable.image01, R.drawable.image02, R.drawable.image03, R.drawable.image04};
    String[] randomWords = new String[] {"A","B","C","D"};
    SharedPreferences currentdata;
    private int imageNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.randomImage);
        TextView textView = (TextView) findViewById(R.id.randomText);

        currentdata = getSharedPreferences("randInfo",MODE_PRIVATE);
        int num = currentdata.getInt("randNum",imageNum);
        imageView.setBackgroundResource(images[num]);
        textView.setText(randomWords[num]);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageNum = (int)(Math.random() * images.length);
                imageView.setBackgroundResource(images[imageNum]);
                textView.setText(randomWords[imageNum]);
            }
        });
    } //End of onCreate

    @Override
    protected void onDestroy(){
        super.onDestroy();
        currentdata = getSharedPreferences("randInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = currentdata.edit();

        editor.putInt("randNum", imageNum);
        editor.apply();

    }
}

//D. When the device is restarted or force closed then the data will be reset which is fail to restore the information.