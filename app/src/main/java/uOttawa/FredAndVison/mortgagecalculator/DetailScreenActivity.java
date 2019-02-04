package uOttawa.FredAndVison.mortgagecalculator;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailScreenActivity extends AppCompatActivity {

    private TextView inputP;
    private TextView inputR;
    private TextView inputN;
    private TextView result;

    private ObjectDto infor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_screen);
        inputP = findViewById(R.id.inputP);
        inputR = findViewById(R.id.inputR);
        inputN = findViewById(R.id.inputN);
        result = findViewById(R.id.result);
        infor = (ObjectDto) getIntent().getSerializableExtra("Infor");
        setup();









    }


    public void setup(){
       int day = 0;
       String period = "";
       if(infor.getPaymentFrequency()==PaymentFrequency.Biweekly){
           day = 12*4*2;
           period = " Bi-weekly ";
       }else if(infor.getPaymentFrequency() ==PaymentFrequency.Monthly){
           day = 12;
           period = " Monthly ";
       }else if(infor.getPaymentFrequency()== PaymentFrequency.Weekly){
           day = 12*4;
           period = " Weekly ";
       }


        inputP.setText("P = "+infor.getPrincipleAmount());
        inputR.setText("r = "+(infor.getInterestRate()/day)+"\r\n"+"(You use"+period+"interest rate, so result: "+infor.getInterestRate()+" / "+day+" = "+(infor.getInterestRate()/day)+" )");
        inputN.setText("n = "+day*infor.getPeriod()+"\r\n"+"("+day+" months * "+infor.getPeriod() +" years "+" = "+day*infor.getPeriod()+" )");
        result.setText("Finally, M = "+infor.getResult());







    }


}
