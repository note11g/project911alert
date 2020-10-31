package com.note11.client_119.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.note11.client_119.R;
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import org.w3c.dom.Document;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "l7xxaede1cbc3d2e43569b3e4d9abfb76430" );

        TMapData tmapdata = new TMapData();

        TMapPoint startpoint = new TMapPoint(37.570841, 126.985302);
        TMapPoint endpoint = new TMapPoint(37.570841, 126.985302);

        tmapdata.findPathDataAll(startpoint, endpoint, doc -> {
            //doc가 Document타입의 xml 문서임.
            //거기서 distance값이 존재할 것 같음.
            //잘 빼보시길(아마 xml파서 써야할 것 같음.)
            //TODO doc에서 총 거리 가져오기
            
        });


    }
}