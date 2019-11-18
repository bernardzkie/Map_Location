package com.example.mapbox;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineListener;
import com.mapbox.android.core.location.LocationEnginePriority;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.plugins.locationlayer.LocationLayerPlugin;
import com.mapbox.mapboxsdk.plugins.locationlayer.modes.CameraMode;
import com.mapbox.mapboxsdk.plugins.locationlayer.modes.RenderMode;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mapbox extends AppCompatActivity implements OnMapReadyCallback, LocationEngineListener,
        PermissionsListener, MapboxMap.OnMapClickListener {


    private MapView mapView;
    private MapboxMap map;
    private Button startButton;
    private PermissionsManager permissionsManager;
    private LocationEngine locationEngine;
    private LocationLayerPlugin locationLayerPlugin;
    private Location originLocation;
    private Point originPosition;
    private Point destinationPosition;
    private Marker destinationMarker;
    private NavigationMapRoute navigationMapRoute;
    private static final String TAG = "mapbox";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.access_token));
        setContentView(R.layout.activity_mapbox);
        mapView =  findViewById(R.id.mapView);
        startButton = findViewById(R.id.startButton);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


        //dental markers
        //1
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Valderama Dental Clinic");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.60034647164284, 121.00170499089211));
                mapboxMap.addMarker(options);
            }
        });

        //2
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Happy Teeth Dental Clinic");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.60122813727105, 121.00464861427486));
                mapboxMap.addMarker(options);

            }
        });

        //3
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Bright Smile Dental Clinic");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.616989064470221, 120.98369397726924));
                mapboxMap.addMarker(options);
            }
        });

        //4
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Bonifacio Dental Clinic");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.616989064470221, 120.98369397726924));
                mapboxMap.addMarker(options);
            }
        });

        //5
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Dental Wellness");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.609269672982792, 120.99283773588309));
                mapboxMap.addMarker(options);
            }
        });

        //6
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("City Smiles Dental");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.603071713852664, 121.00118255711027));
                mapboxMap.addMarker(options);
            }
        });

        //7
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Gentle Dental Center");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.588842513710683, 121.00158391962088));
                mapboxMap.addMarker(options);
            }
        });

        //8
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Hope Dental Care");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.60163385175201, 120.99285006523132));
                mapboxMap.addMarker(options);
            }
        });

        //9
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Dental House");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.598454359856609, 120.97029852200251));
                mapboxMap.addMarker(options);
            }
        });

        //10
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("City Smiles Dental");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.58904899047906, 120.97764241028528));
                mapboxMap.addMarker(options);
            }
        });

        //11r
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Fulo Dental Hub");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.601444927211094, 121.0042103454656));
                mapboxMap.addMarker(options);
            }
        });

        //12r
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Guerrero Dental");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.601456607326233, 121.00434780867761));
                mapboxMap.addMarker(options);
            }
        });

        //13r
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Simbajon - Olaer Dental CLinic");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.611065983464842, 120.99561005830765));
                mapboxMap.addMarker(options);
            }
        });

        //14r
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("JMorada Dental Clinic and Laboratory");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.60170912352956, 121.00291907787323));
                mapboxMap.addMarker(options);
            }
        });

        //15r
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                MarkerOptions options = new MarkerOptions();
                options.title("Geeee... Smile!");

                IconFactory iconFactory = IconFactory.getInstance(mapbox.this);
                Icon icon = iconFactory.fromResource(R.drawable.marker_icon);
                options.icon(icon);

                options.position(new LatLng(14.601241918976829, 121.0028050839901));
                mapboxMap.addMarker(options);
            }
        });


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                        .origin(originPosition)
                        .destination(destinationPosition)
                        .shouldSimulateRoute(true)
                        .build();
                NavigationLauncher.startNavigation(mapbox.this, options);
            }
        });
    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        map = mapboxMap;
        map.addOnMapClickListener(this);
        enableLocation();

    }

    private void enableLocation() {

        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            initializeLocationEngine();
            initializeLocationLayer();

        }   else {
                permissionsManager = new PermissionsManager(this);
                permissionsManager. requestLocationPermissions(this);
        }
    }


    @SuppressWarnings("MissingPermission")
    private void initializeLocationEngine() {
        locationEngine = new LocationEngineProvider(this).obtainBestLocationEngineAvailable();
        locationEngine.setPriority(LocationEnginePriority.HIGH_ACCURACY);
        locationEngine.activate();

        Location lastLocation = locationEngine.getLastLocation();
        if (lastLocation != null) {
            originLocation = lastLocation;
            setCameraPosition(lastLocation);
        }   else {
                locationEngine.addLocationEngineListener(this);
        }

    }

    @SuppressWarnings("MissingPermission")
    private void initializeLocationLayer(){

        locationLayerPlugin = new LocationLayerPlugin(mapView, map, locationEngine);
        locationLayerPlugin.setLocationLayerEnabled(true);
        locationLayerPlugin.setCameraMode(CameraMode.TRACKING);
        locationLayerPlugin.setRenderMode(RenderMode.NORMAL);

    }

    private void setCameraPosition(Location location) {
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),
                location.getLongitude()), 13.0));

    }

    @Override
    public void onMapClick(@NonNull LatLng point) {

        if (destinationMarker !=null) {
            map.removeMarker(destinationMarker);
        }

        destinationMarker = map.addMarker(new MarkerOptions().position(point));

        destinationPosition = Point.fromLngLat(point.getLongitude(), point.getLatitude());
        originPosition = Point.fromLngLat(originLocation.getLongitude(), originLocation.getLatitude());
        getRoute(originPosition, destinationPosition);

        startButton.setEnabled(true);
        startButton.setBackgroundResource(R.color.md_grey_200);
    }

    private void getRoute(Point origin, Point destination) {
        NavigationRoute.builder()
                .accessToken(Mapbox.getAccessToken())
                .origin(origin)
                .destination(destination)
                .build()
                .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        if (response.body() == null) {
                            Log.e(TAG, "No Route Found check right user");
                            return;
                        }   else if (response.body().routes().size() == 0) {
                            Log.e(TAG, "No Routes Found");
                            return;
                        }


                        DirectionsRoute currentRoute = response.body().routes().get(0);

                        if (navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        }   else {
                                navigationMapRoute = new NavigationMapRoute(null, mapView, map);
                        }

                        navigationMapRoute.addRoute(currentRoute);
                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {

                        Log.e(TAG, "ERROR:" + t.getMessage());
                    }
                });
    }


    @Override
    @SuppressWarnings("MissingPermission")
    public void onConnected() {
    locationEngine.requestLocationUpdates();

    }

    @Override
    public void onLocationChanged(Location location) {
    if (location !=null) {
        originLocation = location;
        setCameraPosition(location);
    }

    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {

        if (granted) {
            enableLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @SuppressWarnings("MissingPermission")
    @Override
    protected void onStart() {
        super.onStart();
        if (locationEngine !=null) {
            locationEngine.removeLocationUpdates();
        }
        if (locationLayerPlugin != null) {
            locationLayerPlugin.onStart();
        }
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (locationEngine !=null) {
            locationEngine.removeLocationUpdates();
        }
        if (locationLayerPlugin !=null) {
            locationLayerPlugin.onStop();
        }
        mapView.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);


    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (locationEngine !=null) {
            locationEngine.deactivate();
        }
        mapView.onDestroy();

    }




}
