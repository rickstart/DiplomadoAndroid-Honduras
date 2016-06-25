package com.mobintum.soccergame;


import android.content.Context;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;


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
    private ImageView imgBall;

    private CallbacksFragment mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (CallbacksFragment) context;
    }

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
        txtName = (TextView) view.findViewById(R.id.txtName);
        imgTShirt = (ImageView) view.findViewById(R.id.imgTShirt);
        imgBall = (ImageView) view.findViewById(R.id.imgBall);
        txtName.setText(name);
        imgTShirt.setColorFilter(getActivity().getResources().getColor(color));
        imgBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mListener.pass(getRandomPosition(0,6));
            }
        });
        return view;
    }

    public void showBall(boolean show){
        if(show)
            imgBall.setVisibility(View.VISIBLE);
        else
            imgBall.setVisibility(View.GONE);

    }

    public static int getRandomPosition(int a, int b){
        Random r = new Random();
        int result = r.nextInt(b-a) + a;
        return result;
    }

    public interface CallbacksFragment{
        public void pass(int position);
    }

}
