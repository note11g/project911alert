package com.note11.client_119.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.note11.client_119.Define;
import com.note11.client_119.R;
import com.note11.client_119.Thread_Distance;
import com.note11.client_119.databinding.ActivityMainBinding;
import com.note11.client_119.util.GpsInfo;
import com.skt.Tmap.TMapView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    Thread_Distance cThread_Distance;


    private LocationManager mLM;
    private static final int GPS_ENABLE_REQUEST_CODE = 5000;
    private static final int PERMISSIONS_REQUEST_CODE = 4000;
    private DatabaseReference mPostReference;
    private final String[] REQUIRED_PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
    };



    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            double longitude = location.getLongitude(); //경도
            double latitude = location.getLatitude();   //위도

//            Define.ins().plongitude = longitude;
//            Define.ins().platitude = latitude;
//            cThread_Distance.start();
            Toast.makeText(MainActivity.this, (int)(longitude*1000000)%100+"", Toast.LENGTH_SHORT).show();

            //여기서 firebase 가져오기
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };

    // GPSTracker class
    private GpsInfo gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        cThread_Distance = new Thread_Distance(this);

        binding.btnMainLoad.setOnClickListener(v->startGPSService());
//        TMapView tmapview = new TMapView(this);
//        tmapview.setSKTMapApiKey("l7xxaede1cbc3d2e43569b3e4d9abfb76430");

        if (!locationStatus()) dialogWhenOffLocationService();
        else {
            if (!checkPermission()) {
                startActivity(new Intent(MainActivity.this, getPermissionActivity.class));
                finish();
            }
        }

    }


    private void startGPSService() {
        mLM = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            mLM.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    2000, 2, mLocationListener);
        } catch (Exception e) {
            Toast.makeText(this, "위치 권한이 허용되지 않았습니다.", Toast.LENGTH_SHORT).show();
            mLM.removeUpdates(mLocationListener);//자원해제
        }
    }

    public boolean locationStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private boolean checkPermission() {
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
                REQUIRED_PERMISSIONS[0]);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
                    REQUIRED_PERMISSIONS[1]);

        if (hasFineLocationPermission != PackageManager.PERMISSION_GRANTED)
            return false;
        else
            return true;
    }


    private void dialogWhenOffLocationService() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("위치를 켜주세요.")
                .setCancelable(true)
                .setMessage("위치 서비스가 꺼져있습니다. 위치 서비스를 아래 버튼을 눌러 활성화해주세요.")
                .setPositiveButton("설정하러가기", (dialog, id) -> {
                    Intent callGPSSettingIntent
                            = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
                }).setNegativeButton("취소", (dialog, id) -> dialog.cancel())
                .create()
                .show();
    }

//    private void getDataOnRTDB(Context context){
//        mPostReference = FirebaseDatabase.getInstance().getReference("/list/");
//
//
//        mPostReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                for(DataSnapshot messageData : snapshot.getChildren()){
//                    //Map<String, Object> a = (Map<String, Object>) messageData.getValue();
//
////                    Toast.makeText(context, a.get("longitude")+","+a.get("latitude"), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//
//    }

}