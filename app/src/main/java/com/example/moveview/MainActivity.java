package com.example.moveview;

import android.app.AppComponentFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView img = (ImageView) findViewById(R.id.img_square50px);
        final Button btnRight = (Button) findViewById(R.id.btnRight);
        final Button btnLeft = (Button) findViewById(R.id.btnLeft);

        final RelativeLayout container = (RelativeLayout) findViewById(R.id.rl);

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make the TextView empty

                //.....Get the device screen size in pixel.....
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);


                //Get the Container Right Edge
                float containerRightEdge = container.getWidth() - container.getPaddingRight();
                //Get the Square Image Width
                float imgWidth = img.getWidth();
                //Calculate the ultimate X position of Square Image
                float imgUltimateX = containerRightEdge-imgWidth;


                //Move Square Image from Container (ViewGroup) Top left to Top Right
                img.animate().x(imgUltimateX).setDuration(500).start();
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make the TextView empty

                //.....Get the device screen size in pixel.....
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);


                //Get the Container Right Edge
                float containerRightEdge = 0 + container.getPaddingRight();
                //Get the Square Image Width
                float imgWidth = img.getWidth();
                //Calculate the ultimate X position of Square Image
                float imgUltimateX = containerRightEdge;


                //Move Square Image from Container (ViewGroup) Top left to Top Right
                img.animate().x(imgUltimateX).setDuration(500).start();
            }
        });
    }

}
