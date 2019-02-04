package uOttawa.FredAndVison.mortgagecalculator;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailScreenActivity extends AppCompatActivity {

    private TextView inputP;
    private TextView inputR;
    private TextView inputN;
    private TextView result;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_screen);
        inputP = findViewById(R.id.inputP);
        inputR = findViewById(R.id.inputR);
        inputN = findViewById(R.id.inputN);
        result = findViewById(R.id.result);
        setup();









    }


    public void setup(){
        inputP.setText("P = "+100000);
        inputR.setText("r = "+0.005+"\r\n"+"(You use"+" monthly "+"interest rate, so result: "+0.06+" / "+12+" = "+0.005+" )");
        inputN.setText("n = "+180+"\r\n"+"("+12+" months * "+15 +" years "+" = "+180+" )");
        result.setText("Finally, M = "+1);







    }


}
