package com.mobintum.mapfoursquare.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobintum.mapfoursquare.R;
import com.mobintum.mapfoursquare.models.LocationVenue;
import com.mobintum.mapfoursquare.models.Venue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, Response.Listener<String>, Response.ErrorListener {

    public static final String URL_FOURSQUARE = "https://api.foursquare.com/v2/venues/search?";
    private GoogleMap googleMap;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        getChildFragmentManager().executePendingTransactions();
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        this.googleMap = googleMap;
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }else {
            googleMap.setMyLocationEnabled(true);
            googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    Location location = googleMap.getMyLocation();
                    getPlaces("Sushi", new LatLng(location.getLatitude(),location.getLongitude()));
                    return false;
                }
            });
        }


    }

    public void getPlaces(String query, LatLng latLng){
        String buildURL = Uri.parse(URL_FOURSQUARE).buildUpon()
                .appendQueryParameter("client_id", "KFBD1D243LNTYSNNUWJ1X3ZD4V5JXJ04IB0OEDV11JR1OROX")
                .appendQueryParameter("client_secret", "DMTPETRTOC3BRZEK2VIWZV3A1MPIHV4XO2IHMNH4Q4MM5YNQ")
                .appendQueryParameter("v", "20130815")
                .appendQueryParameter("ll",latLng.latitude+","+latLng.longitude )
                .appendQueryParameter("query", query).build().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,buildURL,this,this);
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }

    @Override
    public void onResponse(String response) {

        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONObject jsonResponseR = jsonResponse.getJSONObject("response");
            JSONArray arrayVenues = jsonResponseR.getJSONArray("venues");
            for(int i=0; i<arrayVenues.length(); i++){
                JSONObject jsonVenue = arrayVenues.getJSONObject(i);
                String name = jsonVenue.getString("name");
                JSONObject jsonLocation = jsonVenue.getJSONObject("location");
                Double latitude = jsonLocation.getDouble("lat");
                Double longitude = jsonLocation.getDouble("lng");
                LocationVenue locationVenue = new LocationVenue(latitude,longitude);
                Venue venue = new Venue(name,locationVenue);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(new LatLng(locationVenue.getLatitude(),locationVenue.getLongitude()));
                markerOptions.title(venue.getName());
                googleMap.addMarker(markerOptions);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
