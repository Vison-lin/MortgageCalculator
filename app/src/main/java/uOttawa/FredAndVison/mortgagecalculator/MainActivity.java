package uOttawa.FredAndVison.mortgagecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton settingPageBtn;
    private TextView appHead;
    private EditText principalAmount;
    private EditText interestRate;
    private EditText amortizationPeriod;
    private Button calculateBtn;
    private LinearLayout summaryInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.settingPageBtn = findViewById(R.id.settingPageBtn);
        this.appHead = findViewById(R.id.appHead);
        this.principalAmount = findViewById(R.id.principalAmount);
        this.interestRate = findViewById(R.id.interestRate);
        this.amortizationPeriod = findViewById(R.id.amortizationPeriod);
        this.calculateBtn = findViewById(R.id.calculateBtn);
        this.summaryInfo = findViewById(R.id.summaryInfo);
    }
}
