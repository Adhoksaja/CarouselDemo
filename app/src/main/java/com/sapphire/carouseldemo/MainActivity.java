package com.sapphire.carouseldemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow,coverFlow1,coverFlow2;
    private CoverFlowAdapter adapter;
    private ArrayList<Game> games;

    public final static int LOOPS = 1000;

    public CarouselPagerAdapter2 adapter2;
    public ViewPager pager2;
    public static int count = 10; //ViewPager items size
    public static int FIRST_PAGE = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        coverFlow1 = (FeatureCoverFlow) findViewById(R.id.coverflow1);
       // coverFlow2 = (FeatureCoverFlow) findViewById(R.id.coverflow2);

        pager2 = (ViewPager) findViewById(R.id.myviewpager2);

        settingDummyData();
        adapter = new CoverFlowAdapter(this, games);
        coverFlow.setAdapter(adapter);
        coverFlow1.setAdapter(adapter);
       // coverFlow2.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
        coverFlow1.setOnScrollPositionListener(onScrollListener());
       // coverFlow2.setOnScrollPositionListener(onScrollListener());



        ///////////////////
        //set page margin between pages for viewpager
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = ((metrics.widthPixels / 4) * 2);


        pager2.setPageMargin(-pageMargin);


        adapter2 = new CarouselPagerAdapter2(this, getSupportFragmentManager());


        pager2.setAdapter(adapter2);


        adapter2.notifyDataSetChanged();


        pager2.addOnPageChangeListener(adapter2);

        // Set current item to the middle page so we can fling to both
        // directions left and right

        pager2.setCurrentItem(FIRST_PAGE);

        pager2.setOffscreenPageLimit(5);


        /////////////////
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        games = new ArrayList<>();
        games.add(new Game(R.drawable.dd_1, "Assassin Creed 3"));
        games.add(new Game(R.drawable.dd2, "Avatar 3D"));
        games.add(new Game(R.drawable.dd3, "Call Of Duty Black Ops 3"));
        games.add(new Game(R.drawable.dd4, "DotA 2"));
        games.add(new Game(R.drawable.dd5, "Halo 5"));
        games.add(new Game(R.drawable.dd6, "Left 4 Dead 2"));
        games.add(new Game(R.drawable.dd_1, "Assassin Creed 3"));
        games.add(new Game(R.drawable.dd2, "Avatar 3D"));
        games.add(new Game(R.drawable.dd3, "Call Of Duty Black Ops 3"));
        games.add(new Game(R.drawable.dd4, "DotA 2"));
        games.add(new Game(R.drawable.dd5, "Halo 5"));
        games.add(new Game(R.drawable.dd6, "Left 4 Dead 2"));

    }
}