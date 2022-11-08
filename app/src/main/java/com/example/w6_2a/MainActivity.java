package com.example.w6_2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] images = new int[] {R.drawable.image01, R.drawable.image02, R.drawable.image03, R.drawable.image04};
    String[] randomWords = new String[] {"A","B","C","D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.randomImage);
        TextView textView = (TextView) findViewById(R.id.randomText);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int imageNum = (int)(Math.random() * images.length);
                imageView.setBackgroundResource(images[imageNum]);
                textView.setText(randomWords[imageNum]);
            }
        });


    }
}