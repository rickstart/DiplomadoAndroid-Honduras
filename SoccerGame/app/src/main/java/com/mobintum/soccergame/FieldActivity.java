package com.mobintum.soccergame;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FieldActivity extends AppCompatActivity implements PlayerFragment.CallbacksFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);
        PlayerFragment player1 = PlayerFragment.newInstance("Miguel",R.color.blue_motagua);
        PlayerFragment player2 = PlayerFragment.newInstance("Mario",R.color.blue_motagua);
        PlayerFragment player3 = PlayerFragment.newInstance("Maurin",R.color.blue_motagua);
        PlayerFragment player4 = PlayerFragment.newInstance("Ivan",R.color.white);
        PlayerFragment player5 = PlayerFragment.newInstance("Eduardo",R.color.white);
        PlayerFragment player6 = PlayerFragment.newInstance("Olvin",R.color.white);
        FragmentManager dtOsman = getSupportFragmentManager();
        FragmentTransaction ft = dtOsman.beginTransaction();
        ft.add(R.id.goalKeeperSpace1,player1,"Miguel");
        ft.add(R.id.player1,player2,"Mario");
        ft.add(R.id.player2,player3,"Maurin");
        ft.add(R.id.player3,player4,"Ivan");
        ft.add(R.id.player4,player5,"Eduardo");
        ft.add(R.id.goalKeeperSpace2,player6,"Olvin");
        ft.commit();




    }

    @Override
    public void pass() {

    }
}
