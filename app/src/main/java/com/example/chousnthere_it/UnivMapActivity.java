package com.example.chousnthere_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapView;

public class UnivMapActivity extends FragmentActivity implements MapView.MapViewEventListener,MapView.POIItemEventListener {

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

    //상단 메뉴
    private static final int MENU_MAP_TYPE = Menu.FIRST + 1;

    private static final String LOG_TAG = "UnivMapActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univ_map);

        mMapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mMapView);

        mMapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(35.14, 126.93), 2, true);

        // 마커 사용 위함
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

    public void onMapViewInitialized(MapView mapView) {

    }

    private void showAll() {
        int padding = 20;
        float minZoomLevel = 2;
        float maxZoomLevel = 8;
        MapPointBounds bounds = new MapPointBounds(Univ_IT, Univ_natural);
        mMapView.moveCamera(CameraUpdateFactory.newMapPointBounds(bounds, padding, minZoomLevel, maxZoomLevel));
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
}
