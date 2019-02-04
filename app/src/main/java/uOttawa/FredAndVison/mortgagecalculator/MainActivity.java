package uOttawa.FredAndVison.mortgagecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout rootFrame;
    private ImageButton settingPageBtn;
    private TextView appHead;
    private LinearLayout settingPage;
    private EditText userName;
    private TextView currencySign;
    private TextView dollar;
    private TextView euro;
    private TextView pound;
    private TextView biweekly;
    private TextView weekly;
    private TextView monthly;
    private EditText principalAmount;
    private EditText interestRate;
    private EditText amortizationPeriod;
    private Button confirm;
    private Button calculateBtn;
    private LinearLayout summaryInfo;
    private TextView result;
    private boolean isAppHeadVisible;
    private ObjectDto objectDto;
    private boolean isUserNameSetted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.rootFrame = findViewById(R.id.rootFrame);
        this.settingPageBtn = findViewById(R.id.settingPageBtn);
        this.appHead = findViewById(R.id.appHead);
        this.settingPage = findViewById(R.id.settingPage);
        this.userName = findViewById(R.id.userName);
        this.currencySign = findViewById(R.id.currencySign);
        this.dollar = findViewById(R.id.dollar);
        this.euro = findViewById(R.id.euro);
        this.pound = findViewById(R.id.pound);
        this.biweekly = findViewById(R.id.biweekly);
        this.weekly = findViewById(R.id.weekly);
        this.monthly = findViewById(R.id.monthly);
        this.principalAmount = findViewById(R.id.principalAmount);
        this.interestRate = findViewById(R.id.interestRate);
        this.amortizationPeriod = findViewById(R.id.amortizationPeriod);
        this.confirm = findViewById(R.id.confirm);
        this.calculateBtn = findViewById(R.id.calculateBtn);
        this.summaryInfo = findViewById(R.id.summaryInfo);
        this.summaryInfo.setVisibility(View.INVISIBLE);
        this.result = findViewById(R.id.result);
        this.isAppHeadVisible = true;
        this.settingPage.setVisibility(View.INVISIBLE);
        objectDto = new ObjectDto();
        registerSettingPageBtn();
        registerCurrencySelectionBtns();
        registerPaymentFrequencyBtns();
        registerCalculateBtn();
    }

    private void registerPaymentFrequencyBtns() {
        biweekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectDto.setPaymentFrequency(PaymentFrequency.Biweekly);
                Toast.makeText(getApplicationContext(), "Changed the payment frequency to bi-weekly", Toast.LENGTH_SHORT).show();
            }
        });
        weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectDto.setPaymentFrequency(PaymentFrequency.Weekly);
                Toast.makeText(getApplicationContext(), "Changed the payment frequency to weekly", Toast.LENGTH_SHORT).show();
            }
        });
        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectDto.setPaymentFrequency(PaymentFrequency.Monthly);
                Toast.makeText(getApplicationContext(), "Changed the payment frequency to monthly", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registerSettingPageBtn() {
        this.settingPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAppHeadVisible) {
                    appHead.setVisibility(View.INVISIBLE);
                    settingPage.setVisibility(View.VISIBLE);
                    isAppHeadVisible = false;
                } else {
                    appHead.setVisibility(View.VISIBLE);
                    settingPage.setVisibility(View.INVISIBLE);
                    isAppHeadVisible = true;
                }
            }
        });
    }

    private void registerCurrencySelectionBtns() {
        registerDollar();
        registerEuro();
        registerPound();
        registerSettingConfirmBtn();
        registerForClosingSettingWhileClickingAnywhereOutsideFoSetting();
    }

    private void registerDollar() {
        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectDto.setSelectedCurrencyType(CurrencyType.DOLLAR);
                Toast.makeText(getApplicationContext(), "Changed the currency to Dollar", Toast.LENGTH_SHORT).show();
                currencySign.setText("$");
            }
        });
    }

    private void registerEuro() {
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectDto.setSelectedCurrencyType(CurrencyType.EURO);
                Toast.makeText(getApplicationContext(), "Changed the currency to Euro", Toast.LENGTH_SHORT).show();
                currencySign.setText("€");
            }
        });
    }

    private void registerPound() {
        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectDto.setSelectedCurrencyType(CurrencyType.POUND);
                Toast.makeText(getApplicationContext(), "Changed the currency to Pound", Toast.LENGTH_SHORT).show();
                currencySign.setText("£");
            }
        });
    }

    private void registerSettingConfirmBtn() {
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mUserName = userName.getText().toString();
                if (mUserName.length() < 1) {
                    userName.setError("Please enter your name here :)");
                    isUserNameSetted = false;
                } else {
                    isUserNameSetted = true;
                    objectDto.setUserName(mUserName);
                    appHead.setVisibility(View.VISIBLE);
                    settingPage.setVisibility(View.INVISIBLE);
                    isAppHeadVisible = true;
                    Toast.makeText(getApplicationContext(), "Setting saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerCalculateBtn() {
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean hasError = false;

                appHead.setVisibility(View.VISIBLE);
                settingPage.setVisibility(View.INVISIBLE);
                isAppHeadVisible = true;

                try {
                    double amount = Double.valueOf(principalAmount.getText().toString());
                    objectDto.setPrincipleAmount(amount);
                } catch (NumberFormatException e) {
                    principalAmount.setError("Please enter a number for principle amount");
                    hasError = true;
                }

                try {
                    double interest = Double.valueOf(interestRate.getText().toString());
                    objectDto.setInterestRate(interest);
                } catch (NumberFormatException e) {
                    interestRate.setError("Please enter a number for interest rate");
                    hasError = true;
                }

                try {
                    double period = Integer.valueOf(amortizationPeriod.getText().toString());
                    objectDto.setPeriod(period);
                } catch (NumberFormatException e) {
                    amortizationPeriod.setError("Please enter a number for amortization period");
                    hasError = true;
                }

                if (userName.getText().toString().length() < 1) {
                    appHead.setVisibility(View.INVISIBLE);
                    settingPage.setVisibility(View.VISIBLE);
                    isAppHeadVisible = false;
                    hasError = true;
                    userName.setError("Please enter your name here :)");
                }

                if (hasError || !isUserNameSetted) {
                    summaryInfo.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "You entered invalid input. Please check all the fields in red", Toast.LENGTH_SHORT).show();
                } else {
                    calculateAndDisplay();
                    summaryInfo.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void registerForClosingSettingWhileClickingAnywhereOutsideFoSetting() {
        rootFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appHead.setVisibility(View.VISIBLE);
                settingPage.setVisibility(View.INVISIBLE);
                isAppHeadVisible = true;
                if (!isAppHeadVisible) {
                    Toast.makeText(getApplicationContext(), "Setting unsaved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void calculateAndDisplay() {
        String currency;
        if (objectDto.getSelectedCurrencyType() == CurrencyType.DOLLAR) {
            currency = "$";
        } else if (objectDto.getSelectedCurrencyType() == CurrencyType.EURO) {
            currency = "€";
        } else if (objectDto.getSelectedCurrencyType() == CurrencyType.POUND) {
            currency = "£";
        } else {
            throw new IllegalStateException();
        }
        String display = userName.getText().toString() + ", you should make " + objectDto.getPaymentFrequency() + " payments for: " + currency + " " + 10000;
        result.setText(display);
    }

}
