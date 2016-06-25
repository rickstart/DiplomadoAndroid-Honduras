package com.mobintum.soccergame;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FieldActivity extends AppCompatActivity implements PlayerFragment.CallbacksFragment {
    private FragmentManager dtOsman;
    private TextView txtTeamOne, txtTeamTwo, txtScoreOne, txtScoreTwo;
    private int scoreOne, scoreTwo;
    private int times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        txtTeamOne = (TextView) findViewById(R.id.txtTeamOne);
        txtTeamTwo = (TextView) findViewById(R.id.txtTeamTwo);
        txtScoreOne = (TextView) findViewById(R.id.txtScoreOne);
        txtScoreTwo = (TextView) findViewById(R.id.txtScoreTwo);

        PlayerFragment player1 = PlayerFragment.newInstance("Miguel",R.color.blue_motagua);
        PlayerFragment player2 = PlayerFragment.newInstance("Mario",R.color.blue_motagua);
        PlayerFragment player3 = PlayerFragment.newInstance("Maurin",R.color.blue_motagua);
        PlayerFragment player4 = PlayerFragment.newInstance("Ivan",R.color.white);
        PlayerFragment player5 = PlayerFragment.newInstance("Eduardo",R.color.white);
        PlayerFragment player6 = PlayerFragment.newInstance("Olvin",R.color.white);

        dtOsman = getSupportFragmentManager();
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
    protected void onStart() {
        super.onStart();
        startGame();

    }


    private void startGame(){
        txtTeamOne.setText("Motagua");
        txtTeamTwo.setText("Olimpia");
        scoreOne =0;
        scoreTwo =0;
        times=0;
        txtScoreTwo.setText(Integer.toString(scoreTwo));
        txtScoreOne.setText(Integer.toString(scoreOne));
        deleteBall();
        dtOsman.executePendingTransactions();
        PlayerFragment fragment = (PlayerFragment) dtOsman.getFragments().get(PlayerFragment.getRandomPosition(0,6));
        fragment.showBall(true);
    }

    private void deleteBall(){
        for(Fragment fragment:dtOsman.getFragments()){
            PlayerFragment playerFragment = (PlayerFragment) fragment;
            playerFragment.showBall(false);
        }
    }
    @Override
    public void pass(int position) {
        times++;
        deleteBall();
        PlayerFragment playerFragment = (PlayerFragment) dtOsman.getFragments().get(position);
        playerFragment.showBall(true);

        switch (position){
            case 0:
                if(PlayerFragment.getRandomPosition(0,4)==1){
                    scoreTwo++;
                    txtScoreTwo.setText(Integer.toString(scoreTwo));
                }
                break;
            case 5:
                if(PlayerFragment.getRandomPosition(0,4)==1){
                    scoreOne++;
                    txtScoreOne.setText(Integer.toString(scoreOne));
                }
                break;
        }

        if(times == 20){
            if(scoreOne == scoreTwo)
                Toast.makeText(getApplicationContext(), "End Draw", Toast.LENGTH_SHORT).show();
            if(scoreOne<scoreTwo)
                Toast.makeText(getApplicationContext(), "Wiiiiinnn Olimpia", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "Wiiiiinnn Motagua", Toast.LENGTH_SHORT).show();

            startGame();
        }


    }
}
