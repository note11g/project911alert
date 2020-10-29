package com.note11.client_119.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.note11.client_119.R;
import com.note11.client_119.databinding.ActivityMainBinding;
import com.note11.client_119.util.GpsInfo;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    TextView tvLatitude;
    TextView tvLongitude;
    TextView tvDistance;
    Button btn;

    // GPSTracker class
    private GpsInfo gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        tvLatitude = binding.textView1;
        tvLongitude = binding.textView2;
        tvDistance = binding.textView3;
        btn = binding.btnMainLoad;

        btn.setOnClickListener(v -> {
            gps = new GpsInfo(MainActivity.this);

            if (gps.isGetLocation()) {
                double latitude = gps.getLatitude();
                double longitude = gps.getLongitude();
                Location distance = gps.getLocation();
//                    double speed = gps.onLocationChanged();
                tvLatitude.setText(String.valueOf(latitude));
                tvLongitude.setText(String.valueOf(longitude));
                tvDistance.setText(String.valueOf(distance));
            } else
                gps.showSettingAlert();
        }); // end of setOnClickListener
    } // end of onCreate


//    private GpsTracker gpsTracker;
//
//    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
//    private static final int PERMISSIONS_REQUEST_CODE = 100;
//    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//
//        if (!checkLocationServicesStatus()) {
//
//            showDialogForLocationServiceSetting();
//        } else {
//
//            checkRunTimePermission();
//        }
//
//        Button ShowLocationButton = binding.btnMainLoad;
//        ShowLocationButton.setOnClickListener(v -> {
//
//            gpsTracker = new GpsTracker(MainActivity.this);
//
//            double latitude = gpsTracker.getLatitude();
//            double longitude = gpsTracker.getLongitude();
//
//            String address = getCurrentAddress(latitude, longitude);
//            binding.setNowLocation(address);
//
//            Toast.makeText(MainActivity.this, "현재위치 \n위도 " + latitude + "\n경도 " + longitude, Toast.LENGTH_SHORT).show();
//        });
//    }
//        @Override
//        public void onRequestPermissionsResult ( int permsRequestCode,
//        @NonNull String[] permissions,
//        @NonNull int[] grandResults){
//
//            if (permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {
//
//                // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면
//                boolean check_result = true;
//
//                // 모든 퍼미션을 허용했는지 체크합니다.
//                for (int result : grandResults) {
//                    if (result != PackageManager.PERMISSION_GRANTED) {
//                        check_result = false;
//                        break;
//                    }
//                }
//
//
//                if (!check_result) {
//                    // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.
//                    //if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
//                      //      || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])) {
//                        Toast.makeText(MainActivity.this, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_LONG).show();
//                        finish();
//                    } //else Toast.makeText(MainActivity.this, "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ", Toast.LENGTH_LONG).show();
////                }
//
//            }
//        }//fun end
//
//        void checkRunTimePermission () {
//            //런타임 퍼미션 처리
//            // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
//            int hasFineLocationPermission = ContextCompat.checkSelfPermission(MainActivity.this,
//                    Manifest.permission.ACCESS_FINE_LOCATION);
//            int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(MainActivity.this,
//                    Manifest.permission.ACCESS_COARSE_LOCATION);
//
//            if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
//                    hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {
//                // 2. 이미 퍼미션을 가지고 있다면 3. 위치 값을 가져올 수 있음
//
//            } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.
//                // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
//                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, REQUIRED_PERMISSIONS[0])) {
//                    // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
//                    Toast.makeText(MainActivity.this, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
//                    // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
//                    ActivityCompat.requestPermissions(MainActivity.this, REQUIRED_PERMISSIONS,
//                            PERMISSIONS_REQUEST_CODE);
//                } else
//                    ActivityCompat.requestPermissions(MainActivity.this, REQUIRED_PERMISSIONS,
//                            PERMISSIONS_REQUEST_CODE);
//                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
//                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
//            }
//
//        }//fun end
//
//
//        public String getCurrentAddress ( double latitude, double longitude){
//
//            //지오코더... GPS를 주소로 변환
//            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
//            List<Address> addresses;
//
//            try {
//                addresses = geocoder.getFromLocation(latitude, longitude, 7);
//            } catch (IOException ioException) {
//                //네트워크 문제
//                Toast.makeText(this, "지오코더 서비스 사용불가", Toast.LENGTH_LONG).show();
//                return "지오코더 서비스 사용불가";
//            } catch (IllegalArgumentException illegalArgumentException) {
//                Toast.makeText(this, "잘못된 GPS 좌표", Toast.LENGTH_LONG).show();
//                return "잘못된 GPS 좌표";
//            }
//
//
//            if (addresses == null || addresses.size() == 0) {
//                Toast.makeText(this, "주소 미발견", Toast.LENGTH_LONG).show();
//                return "주소 미발견";
//            }
//            Address address = addresses.get(0);
//            return address.getAddressLine(0).toString() + "\n";
//        }//end fun
//
//        //여기부터는 GPS 활성화를 위한 메소드들
//        private void showDialogForLocationServiceSetting () {
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setTitle("위치 서비스 비활성화");
//            builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
//                    + "위치 설정을 수정하실래요?");
//            builder.setCancelable(true);
//            builder.setPositiveButton("설정", (dialog, id) -> {
//                Intent callGPSSettingIntent
//                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
//            });
//            builder.setNegativeButton("취소", (dialog, id) -> dialog.cancel());
//            builder.create().show();
//        }//fun end
//
//
//        @Override
//        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
//            super.onActivityResult(requestCode, resultCode, data);
//            switch (requestCode) {
//                case GPS_ENABLE_REQUEST_CODE:
//                    //사용자가 GPS 활성 시켰는지 검사
//                    if (checkLocationServicesStatus())
//                        if (checkLocationServicesStatus()) {
//                            Log.d("@@@", "onActivityResult : GPS 활성화 되있음");
//                            checkRunTimePermission();
//                            return;
//                        }
//                    break;
//            }
//        }//fun end
//
//        public boolean checkLocationServicesStatus () {
//            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//
//            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
//                    || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//        }//fun end

}