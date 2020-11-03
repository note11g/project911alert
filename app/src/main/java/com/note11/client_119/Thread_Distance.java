package com.note11.client_119;

import android.graphics.Color;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

public class Thread_Distance extends Thread{

    AppCompatActivity aThread_Distance;
    Handler handler;
    TMapPoint tMapPointStart;
    TMapPoint tMapPointEnd;
    TMapView tMapView;

    public Thread_Distance(AppCompatActivity appCompatActivity){
        aThread_Distance = appCompatActivity;
        tMapView = new TMapView(aThread_Distance);
        tMapView.setSKTMapApiKey( "l7xxaede1cbc3d2e43569b3e4d9abfb76430" );
        handler = new Handler();
        tMapPointStart = new TMapPoint(37.5178656,126.857308);//37.5427117,126.9313434
        tMapPointEnd = new TMapPoint(Define.ins().platitude, Define.ins().plongitude);
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("들어옴");
            TMapPolyLine tMapPolyLine = new TMapData().findPathData(tMapPointStart, tMapPointEnd);
            tMapPolyLine.setLineColor(Color.BLUE);
            tMapPolyLine.setLineWidth(2);
            double Distance = tMapPolyLine.getDistance();
            System.out.println("distance : " + Math.round(Distance)/1000);
            Define.ins().get_distance = Math.round(Distance);
            Toast.makeText(aThread_Distance, ""+Define.ins().get_distance, Toast.LENGTH_SHORT).show();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
