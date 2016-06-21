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
    private Double oper1=0.0;
    private Boolean flagOper = false;
    private final static int SUM=1;
    private final static int MULTIPLY=2;
    private final static int DIVISION=3;
    private final static int SUBSTRACTION=4;
    private final static int PERCENT=5;
    private int typeOper;

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


    public String formatResult(Double result){
        String strResult = Double.toString(result);
        String number[] = strResult.split("\\.");

        if(number[1].equals("0")){
            return number[0];
        }else{
            return strResult;
        }

    }

    public Double operation(int typeOper, double oper1, double oper2){
        Double result = 0.0;
        switch (typeOper){
            case SUM:
                result = oper1 + oper2;
                break;
            case SUBSTRACTION:
                result = oper1 - oper2;
                break;
            case MULTIPLY:
                result = oper1 * oper2;
                break;
            case DIVISION:
                result = oper1 / oper2;
                break;
        }
        return result;
    }

    public void setOper(){
        Double number = Double.parseDouble(txtResult.getText().toString());
        if(number!=0.0 && oper1==0.0){
            oper1 = number;
        }else if(oper1!=0.0 && flagOper){
            oper1 = operation(typeOper, oper1, number);
            txtResult.setText(formatResult(oper1));
        }
        flagOper = false;
    }
    @Override
    public void onClick(View v) {
        Double number = 0.0;

        switch (v.getId()) {

            case R.id.btnSubstraction:
                setOper();
                typeOper = SUBSTRACTION;
                break;

            case R.id.btnPlus:
                setOper();
                typeOper = SUM;
                break;
            case R.id.btnDivision:
                setOper();
                typeOper = DIVISION;
                break;
            case R.id.btnMultiply:
                setOper();
                typeOper = MULTIPLY;
                break;
            case R.id.btnAC:
                txtResult.setText("0");
                oper1 = 0.0;
                flagOper = false;
                break;

            case R.id.btnEqual:
                if(oper1!=0.0 && flagOper){
                    number = Double.parseDouble(txtResult.getText().toString());
                    oper1 = operation(typeOper, oper1, number);
                    txtResult.setText(formatResult(oper1));
                    flagOper = false;
                }

                break;

            case R.id.btnPercent:
                number = Double.parseDouble(txtResult.getText().toString());
                if(number!=0.0) {
                    txtResult.setText(formatResult(number/100));
                }
                break;

            case R.id.btnSign:
                String result = txtResult.getText().toString();
                if(!result.equals("0")){
                    if(result.contains("-")){
                        result =result.substring(1,result.length());
                    }else {
                        result="-"+result;
                    }
                    txtResult.setText(result);
                }

                break;
            default:
                Button btnTemp = (Button) v;
                String text = btnTemp.getText().toString();
                number = Double.parseDouble(txtResult.getText().toString());

                if(flagOper || txtResult.getText().toString().equals("0.")) {
                    if(text.equals(".")){
                        String strResult = txtResult.getText().toString();
                        if(!strResult.contains("."))
                            txtResult.append(text);
                    }else {
                        txtResult.append(text);
                    }
                }else {
                    if(text.equals(".")){
                        txtResult.setText("0"+text);
                    }else {
                        txtResult.setText(text);
                    }
                    flagOper = true;
                }
                break;

        }

    }
}
