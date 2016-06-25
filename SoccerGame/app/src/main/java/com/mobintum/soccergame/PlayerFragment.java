package com.mobintum.soccergame;


import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends Fragment {

    private static final String ARG_PARAM_NAME = "paramName";
    private static final String ARG_PARAM_COLOR = "paramColor";

    private String name;
    private int color;

    private TextView txtName;
    private ImageView imgTShirt;

    public static PlayerFragment newInstance(String name, int color){
        PlayerFragment fragment = new PlayerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_NAME,name);
        args.putInt(ARG_PARAM_COLOR,color);
        fragment.setArguments(args);
        return fragment;
    }

    public PlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            this.name = getArguments().getString(ARG_PARAM_NAME);
            this.color = getArguments().getInt(ARG_PARAM_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);

        return view;
    }

}
