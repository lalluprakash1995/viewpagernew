package com.example.lallu.viewpagernew;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout indicator;
    private List<Integer> imageites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        indicator=(TabLayout)findViewById(R.id.indicator);
        imageites=new ArrayList<>();
        imageites.add(R.mipmap.image1);
        imageites.add(R.mipmap.image11);
        imageites.add(R.mipmap.image3);
        imageites.add(R.mipmap.image4);
        viewPager.setAdapter(new SliderAdapter(this,imageites));
        indicator.setupWithViewPager(viewPager,true);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),3000,3000);


    }
    class SliderTimer extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()<imageites.size()-1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
