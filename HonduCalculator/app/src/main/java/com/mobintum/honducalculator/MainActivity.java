package com.mobintum.honducalculator;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private Button btnAC, btnSign, btnPercent, btnDivision, btnMultiply;
    private Button btnSubstraction, btnPlus, btnEqual, btnDot;
    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    private Boolean flagOper = false;
    private Double oper1 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnSign = (Button) findViewById(R.id.btnSign);
        btnPercent = (Button) findViewById(R.id.btnPercent);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnSubstraction = (Button) findViewById(R.id.btnSubstraction);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);

        btnAC.setOnClickListener(this);
        btnSign.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnSubstraction.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
    }


    private void setOper(){
        Double number = Double.parseDouble(txtResult.getText().toString());
        if(number != 0.0 && oper1 == 0.0){
            oper1 = number;
        }else if( oper1!=0.0 && flagOper ){
            oper1 = oper1 + number;
            txtResult.setText(oper1+"");
        }
    }
    @Override
    public void onClick(View v) {
        Button btnTemp = (Button) v;
        String strBtn = btnTemp.getText().toString();
        Double number = 0.0;
        switch (v.getId()){
            case R.id.btnPlus:
                setOper();
                break;
            default:
                number = Double.parseDouble(txtResult.getText().toString());
                if((number != 0.0 && flagOper) ||txtResult.getText().toString().equals("0.") ){
                    if(strBtn.equals(".")){
                        String strResult = txtResult.getText().toString();
                        if(!strResult.contains(".")){
                            txtResult.append(strBtn);
                        }
                    }else{
                        txtResult.append(strBtn);
                    }
                }else {
                    if(strBtn.equals(".")){
                        txtResult.setText("0"+strBtn);
                    }else {
                        txtResult.setText(strBtn);
                    }
                    flagOper = true;
                }
                break;

        }

    }
}
