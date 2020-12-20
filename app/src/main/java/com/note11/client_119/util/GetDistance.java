package com.note11.client_119.util;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

public class GetDistance {

    public static Long getDistanceForMe(Context context,  GpsModel nowPoint){
        Location NOW = new Location("point A");
        NOW.setLatitude(nowPoint.getLatitude());
        NOW.setLongitude(nowPoint.getLongitude());
        Location B = new Location("point B");
        B.setLatitude(GpsCache.getGps(context).getLatitude());
        B.setLongitude(GpsCache.getGps(context).getLongitude());

        double distance = NOW.distanceTo(B);

//        Toast.makeText(context, Math.round(distance)+"m", Toast.LENGTH_SHORT).show();
        return Math.round(distance);
        //        TMapView tMapView = new TMapView(context);
//        tMapView.setSKTMapApiKey( "l7xxaede1cbc3d2e43569b3e4d9abfb76430" );
//
//        TMapPoint tMapPointStart = new TMapPoint(GpsCache.getGps(context).getLatitude(),GpsCache.getGps(context).getLongitude());
//        TMapPoint tMapPointNow = new TMapPoint(nowPoint.getLatitude(), nowPoint.getLongitude());
//
//        Log.d("start", GpsCache.getGps(context).getLatitude()+","+GpsCache.getGps(context).getLongitude());
//        Log.d("now", nowPoint.getLatitude()+","+nowPoint.getLongitude());
//
//        try {
//            TMapPolyLine tMapPolyLine = new TMapData().findPathData(tMapPointStart, tMapPointNow);
//            tMapPolyLine.setLineColor(Color.BLUE);
//            tMapPolyLine.setLineWidth(2);
//            double Distance = tMapPolyLine.getDistance();
//            Toast.makeText(context, Math.round(Distance)+"m", Toast.LENGTH_SHORT).show();
//        }catch(Exception e){
//            Toast.makeText(context, "실패", Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//        }
    }
}
