package com.sapphire.carouseldemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    public final static int LOOPS = 1000;
    public static int count = 10; //ViewPager items size
    public static int FIRST_PAGE = 10;
    public CarouselPagerAdapter2 adapter2;
    public ViewPager pager2;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<String> alName;

    /////////////////////
    ArrayList<Integer> alImage;
    private FeatureCoverFlow coverFlow, coverFlow_Video, coverFlow2;
    private CoverFlowAdapter adapter;
    private CoverFlowAdapter_Video coverFlowAdapter_video;
    private ArrayList<Game> ddImages;
    private ArrayList<Game> videosThumnails;

    ////////////
    private int[] menuItemIcon = {R.drawable.dd2, R.drawable.notification, R.drawable.dd3, R.drawable.dd4,
            R.drawable.dd5, R.drawable.profile, R.drawable.dd6, R.drawable.dd_1, R.drawable.dd3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        coverFlow_Video = (FeatureCoverFlow) findViewById(R.id.coverflow_video);
        // coverFlow2 = (FeatureCoverFlow) findViewById(R.id.coverflow2);

        //  pager2 = (ViewPager) findViewById(R.id.myviewpager2);
//pager2.setVisibility(View.GONE);
        settingDummyData();

        adapter = new CoverFlowAdapter(this, ddImages);

        coverFlowAdapter_video = new CoverFlowAdapter_Video(this, videosThumnails);

        coverFlow.setAdapter(adapter);

        coverFlow_Video.setAdapter(coverFlowAdapter_video);
        // coverFlow2.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());

        coverFlow_Video.setOnScrollPositionListener(onScrollListener());
        // coverFlow2.setOnScrollPositionListener(onScrollListener());


        ///////////////////
        //set page margin between pages for viewpager
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = ((metrics.widthPixels / 4) * 2);


        /////////////////
        alName = new ArrayList<>(Arrays.asList("Cheesy...", "Crispy... ", "Fizzy...", "Cool...", "Softy...", "Fruity...", "Fresh...", "Sticky..."));
        alImage = new ArrayList<>(Arrays.asList(R.drawable.dd2, R.drawable.dd3, R.drawable.dd4, R.drawable.dd5, R.drawable.dd6, R.drawable.dd6,
                R.drawable.dd_1, R.drawable.dd6));

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HLVAdapter(MainActivity.this, alName, alImage);
        mRecyclerView.setAdapter(mAdapter);

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

    public void settingDDData(){
        ddImages = new ArrayList<>();
     //

        ddImages.add(new Game(R.drawable.dd_1, "Tulsi Arpan" + " : " + "10K"));
        ddImages.add(new Game(R.drawable.dd2, "Tulsi Arpan" + " : " + "20K"));
        ddImages.add(new Game(R.drawable.dd3, "Tulsi Arpan" + " : " + "30K"));
        ddImages.add(new Game(R.drawable.dd4, "Tulsi Arpan" + " : " + "40K"));
        ddImages.add(new Game(R.drawable.dd5, "Tulsi Arpan" + " : " + "50K"));
        ddImages.add(new Game(R.drawable.dd6, "Tulsi Arpan" + " : " + "60K"));
        ddImages.add(new Game(R.drawable.dd_1, "Tulsi Arpan" + " : " + "70K"));
        ddImages.add(new Game(R.drawable.dd2, "Tulsi Arpan" + " : " + "80K"));
        ddImages.add(new Game(R.drawable.dd3, "Tulsi Arpan" + " : " + "90K"));
        ddImages.add(new Game(R.drawable.dd4, "Tulsi Arpan" + " : " + "100K"));
        ddImages.add(new Game(R.drawable.dd5, "Tulsi Arpan" + " : " + "110K"));
        ddImages.add(new Game(R.drawable.dd6, "Tulsi Arpan" + " : " + "120K"));

    }

    public void settingVideoData(){
        videosThumnails = new ArrayList<>();
        videosThumnails.add(new Game(R.drawable.dd_1, "Tulsi Arpan" + " : " + "10K"));
        videosThumnails.add(new Game(R.drawable.dd2, "Tulsi Arpan" + " : " + "20K"));
        videosThumnails.add(new Game(R.drawable.dd3, "Tulsi Arpan" + " : " + "30K"));
        videosThumnails.add(new Game(R.drawable.dd4, "Tulsi Arpan" + " : " + "40K"));
        videosThumnails.add(new Game(R.drawable.dd5, "Tulsi Arpan" + " : " + "50K"));
    }


    private void settingDummyData() {
        settingDDData();
settingVideoData();


    }
}