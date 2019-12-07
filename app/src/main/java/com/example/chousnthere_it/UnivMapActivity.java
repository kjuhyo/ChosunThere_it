package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.model.Marker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;


public class UnivMapActivity extends AppCompatActivity implements MapView.MapViewEventListener, MapView.POIItemEventListener, MapView.CurrentLocationEventListener {

    //마커 위치
    private static final MapPoint Univ_IT = MapPoint.mapPointWithGeoCoord(35.140072, 126.934250); //IT융합대학
    private static final MapPoint Univ_humanity = MapPoint.mapPointWithGeoCoord(35.141788, 126.935005); //인문과학대학
    private static final MapPoint Univ_natural = MapPoint.mapPointWithGeoCoord(35.139584, 126.928337); //자연과학대학
    private static final MapPoint Univ_law = MapPoint.mapPointWithGeoCoord(35.139206, 126.935326); //법학대학
    private static final MapPoint Univ_cucoss = MapPoint.mapPointWithGeoCoord(35.146328, 126.934288); //사회과학대학
    private static final MapPoint Univ_cob = MapPoint.mapPointWithGeoCoord(35.139645, 126.935745); //경상대학
    private static final MapPoint Univ_engni1 = MapPoint.mapPointWithGeoCoord(35.141808, 126.925529); //공과대학 1공학관
    private static final MapPoint Univ_engni2 = MapPoint.mapPointWithGeoCoord(35.138622, 126.933456); //공과대학 2공학관
    private static final MapPoint Univ_edu = MapPoint.mapPointWithGeoCoord(35.145691, 126.934425); //사범대학
    private static final MapPoint Univ_global = MapPoint.mapPointWithGeoCoord(35.143852, 126.934479); //외국어대학
    private static final MapPoint Univ_dpe = MapPoint.mapPointWithGeoCoord(35.140507, 126.927528); //체육대학
    private static final MapPoint Univ_medi = MapPoint.mapPointWithGeoCoord(35.140446, 126.929565); //의과대학
    private static final MapPoint Univ_denti = MapPoint.mapPointWithGeoCoord(35.144196, 126.927269); //치과대학
    private static final MapPoint Univ_pharmacy = MapPoint.mapPointWithGeoCoord(35.141720, 126.926674); //약학대학
    private static final MapPoint Univ_art = MapPoint.mapPointWithGeoCoord(35.144127, 126.930473); //미술대학
    private static final MapPoint Univ_libedu = MapPoint.mapPointWithGeoCoord(35.142403, 126.934814); //기초교육대학
    private static final MapPoint Univ_heal = MapPoint.mapPointWithGeoCoord(35.139633, 126.934280); //보건과학대학
    private static final MapPoint Univ_future = MapPoint.mapPointWithGeoCoord(35.142048, 126.934875); //미래사회융합대학
    private static final MapPoint library = MapPoint.mapPointWithGeoCoord(35.141872, 126.932495); //중앙도서관
    private static final MapPoint sunrise = MapPoint.mapPointWithGeoCoord(35.140846, 126.933022); //해오름관
    private static final MapPoint mainbuild = MapPoint.mapPointWithGeoCoord(35.142742, 126.934708); //본관
    //마커 위치 끝

    private MapView mMapView; //맵 뷰 띄워줌
    private MapPOIItem marker; //기본 마커

    //현재 위치 받기 위함
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION};

    // fab_marker 클릭 여부
    private boolean fClick = false;


    //상단 메뉴
    private static final int MENU_MAP_TYPE = Menu.FIRST + 1;

    private static final String LOG_TAG = "UnivMapActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univ_map);

        //gps FAB 누르면 현재 위치 + 나침반
        FloatingActionButton fab_gps = (FloatingActionButton) findViewById(R.id.fab_gps);
        fab_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 누르면 현재 위치 이벤트 발생
               mMapView.setCurrentLocationEventListener(UnivMapActivity.this);

                if (!checkLocationServicesStatus()) { // 허용 안함

                    showDialogForLocationServiceSetting();
                }else { // 허용

                    checkRunTimePermission();
                }
            }
        });

        //marker FAB 누르면 트래킹 해제, 마커 모여있는 위치로
        FloatingActionButton fab_marker = (FloatingActionButton) findViewById(R.id.fab_marker);
        fab_marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMapView.setCurrentLocationEventListener(UnivMapActivity.this);
                MapPoint.GeoCoordinate gc = mMapView.getMapCenterPoint().getMapPointGeoCoord(); //현재 보고 있는 화면의 중심점
                double latitude = gc.latitude; //위도, x
                double longitude = gc.longitude; //경도, y

                if(latitude!=35.141018 && longitude!=126.931709) {
                    mMapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff); //트래킹 해제, 중심점으로 돌아오기
                    mMapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(35.141018, 126.931709), 2, true);

                } else {
                    Toast.makeText(UnivMapActivity.this, "이미 적용 중입니다.", Toast.LENGTH_LONG).show();
                }
            }
        });

        mMapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mMapView);

        // 지도 들어왔을 때 처음 중심점
        mMapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(35.141018, 126.931709), 2, true);

        // 이벤트 리스너
        mMapView.setMapViewEventListener(this);
        mMapView.setPOIItemEventListener(this);

        for(int i = 0; i<20; i++ ) {
            createDefaultMarker(i);
        }
        showAll();
}
    //상단바 메뉴 생성
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_MAP_TYPE, Menu.NONE, "지도 종류");

        return true;
    }

    //메뉴 선택
    public boolean onOptionsItemSelected(MenuItem item) {

        final int itemId = item.getItemId();

        switch (itemId) {
            case MENU_MAP_TYPE: {

                String[] mapTypeMenuItems = { "일반 지도", "위성 지도", "복합 지도"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("지도 종류");
                dialog.setItems(mapTypeMenuItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controlMapTile(which);
                    }
                });
                dialog.show();

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    //트래킹 모드 해제
    protected void onDestroy() {
        super.onDestroy();
        mMapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff);
//        mMapView.setShowCurrentLocationMarker(false);
        fClick = true;
    }

    //지도 타일 컨트롤
    private void controlMapTile(int which) {
        switch (which) {
            case 0: // 일반 지도
            {
                mMapView.setMapType(MapView.MapType.Standard);
            }
            break;
            case 1: // 위성 지도
            {
                mMapView.setMapType(MapView.MapType.Satellite);
            }
            break;
            case 2: // 복합 지도
            {
                mMapView.setMapType(MapView.MapType.Hybrid);
            }
            break;
        }
    }

    private void createDefaultMarker(int i) {
        int num = i;
        String[] building = new String[]{
                "IT융합대학","인문과학대학","자연과학대학","법과대학","사회과학대학","경상대학",
                "공과대학 제 1공학관","공과대학 제 2공학관","사범대학","외국어대학","체육대학",
                "의과대학","치과대학","약학대학","미술대학","기초교육대학","보건과학대학",
                "미래사회융합대학","중앙도서관","해오름관","본관"};

            marker = new MapPOIItem();
            marker.setItemName(building[num]);
            marker.setTag(num);
        for(int j = 0; j<21; j++) {
            if(num==0) {
                marker.setMapPoint(Univ_IT);
            } else if(num == 1) {
                marker.setMapPoint(Univ_humanity);
            } else if(num == 2) {
                marker.setMapPoint(Univ_natural);
            } else if(num == 3) {
                marker.setMapPoint(Univ_law);
            } else if(num == 4) {
                marker.setMapPoint(Univ_cucoss);
            } else if(num == 5) {
                marker.setMapPoint(Univ_cob);
            } else if(num == 6) {
                marker.setMapPoint(Univ_engni1);
            } else if(num == 7) {
                marker.setMapPoint(Univ_engni2);
            } else if(num == 8) {
                marker.setMapPoint(Univ_edu);
            } else if(num == 9) {
                marker.setMapPoint(Univ_global);
            } else if(num == 10) {
                marker.setMapPoint(Univ_dpe);
            } else if(num == 11) {
                marker.setMapPoint(Univ_medi);
            } else if(num == 12) {
                marker.setMapPoint(Univ_denti);
            } else if(num == 13) {
                marker.setMapPoint(Univ_pharmacy);
            } else if(num == 14) {
                marker.setMapPoint(Univ_art);
            } else if(num == 15) {
                marker.setMapPoint(Univ_libedu);
            } else if(num == 16) {
                marker.setMapPoint(Univ_heal);
            } else if(num == 17) {
                marker.setMapPoint(Univ_future);
            } else if(num == 18) {
                marker.setMapPoint(library);
            } else if(num == 19) {
                marker.setMapPoint(sunrise);
            } else if(num == 20) {
                marker.setMapPoint(mainbuild);
            }
                marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
                marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

                mMapView.addPOIItem(marker);

        }
    }

    // 마커 모두 보여줌
    private void showAll() {
        int padding = 20;
        float minZoomLevel = 2;
        float maxZoomLevel = 8;
        MapPointBounds bounds = new MapPointBounds(Univ_IT, Univ_natural);
        mMapView.moveCamera(CameraUpdateFactory.newMapPointBounds(bounds, padding, minZoomLevel, maxZoomLevel));
    }

    //ActivityCompat.requestPermissions를 사용한 퍼미션 요청의 결과를 리턴받는 메소드
    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {

        if ( permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면

            boolean check_result = true;


            // 모든 퍼미션을 허용했는지 체크합니다.

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }


            if ( check_result ) {
                Log.d("@@@", "start");
                //위치 값을 가져올 수 있음
                mMapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
            }
            else {
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {

                    Toast.makeText(UnivMapActivity.this, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_LONG).show();
                    finish();


                }else {

                    Toast.makeText(UnivMapActivity.this, "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ", Toast.LENGTH_LONG).show();

                }
            }

        }
    }
    // 1) gps FAB 누르고 위치 정보 제공 허용시
    void checkRunTimePermission(){

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(UnivMapActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION);


        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED ) {

            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)


            // 3.  위치 값을 가져올 수 있음
            mMapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);


        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.

            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(UnivMapActivity.this, REQUIRED_PERMISSIONS[0])) {

                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(UnivMapActivity.this, "이 기능을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
                // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(UnivMapActivity.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);


            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(UnivMapActivity.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }

        }

    }



    //여기부터는 GPS 활성화를 위한 메소드들
    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(UnivMapActivity.this);
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정에서 허용을 눌러주세요.");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case GPS_ENABLE_REQUEST_CODE:

                //사용자가 GPS 활성 시켰는지 검사
                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {

                        Log.d("@@@", "onActivityResult : GPS 활성화 돼 있음");
                        checkRunTimePermission();
                        return;
                    }
                }

                break;
        }
    }


    // 위치서비스 허용 유무 확인
    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }
    public void onMapViewInitialized(MapView mapView) {

    }
    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }
    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }

    // 현재 장소로 포인트 갱신
    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {
        MapPoint.GeoCoordinate mapPointGeo = mapPoint.getMapPointGeoCoord();
        Log.i(LOG_TAG, String.format("MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)", mapPointGeo.latitude, mapPointGeo.longitude, v));
    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }
}
