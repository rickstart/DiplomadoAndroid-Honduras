package com.mobintum.moviesearch.fragments;


import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mobintum.moviesearch.R;
import com.mobintum.moviesearch.adapters.MovieRVAdapter;
import com.mobintum.moviesearch.application.App;
import com.mobintum.moviesearch.models.Movie;
import com.mobintum.moviesearch.models.Poster;
import com.mobintum.moviesearch.models.Raiting;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesRVFragment extends Fragment implements Response.ErrorListener, Response.Listener<String> {

    public static final String URL_SEARCH = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=35hg37n2zaybbwf7wncj9vgw";
    private RecyclerView rvMovies;
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieRVAdapter adapter;
    private ProgressDialog pDialog;

    public MoviesRVFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage(getString(R.string.loading));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_rv, container, false);
        rvMovies = (RecyclerView) view.findViewById(R.id.rvMovies);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        adapter = new MovieRVAdapter(movies);
        rvMovies.setLayoutManager(layoutManager);
        rvMovies.setAdapter(adapter);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem menuSearch = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.length()!=0)
                    getMovies(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });


    }

    public void getMovies(String query){
        String buildURL = Uri.parse(URL_SEARCH).buildUpon()
                .appendQueryParameter("q", query)
                .build().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,buildURL,this,this);
        movies.clear();
        adapter.notifyDataSetChanged();
        pDialog.show();
        App.getInstance().getRequestQueue().add(stringRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        pDialog.dismiss();
    }

    @Override
    public void onResponse(String response) {
        Log.e("DEBUG", response);
        pDialog.dismiss();

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonMovies = jsonObject.getJSONArray("movies");
            for( int i=0 ; i<jsonMovies.length() ; i++){
                JSONObject jsonMovie = jsonMovies.getJSONObject(i);
                String title = jsonMovie.getString("title");
                Integer year = jsonMovie.getInt("year");
                String synopsis = jsonMovie.getString("synopsis");
                JSONObject jsonRaitings = jsonMovie.getJSONObject("ratings");
                JSONObject jsonPosters = jsonMovie.getJSONObject("posters");
                Integer criticScore = jsonRaitings.getInt("critics_score");
                Integer audienceScore = jsonRaitings.getInt("audience_score");
                String original = jsonPosters.getString("original");
                String thumbnail = jsonPosters.getString("thumbnail");
                String profile = jsonPosters.getString("profile");
                String detailed = jsonPosters.getString("detailed");

                Raiting raiting = new Raiting(criticScore,audienceScore);
                Poster poster = new Poster(thumbnail,profile,detailed,original);
                Movie movie = new Movie(title,year,raiting,synopsis,poster);
                movies.add(movie);
                adapter.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
