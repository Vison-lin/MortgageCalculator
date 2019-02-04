package uOttawa.FredAndVison.mortgagecalculator;

public class ObjectDto {

    private String userName;

    private double principleAmount;

    private PaymentFrequency paymentFrequency = PaymentFrequency.Monthly;

    private double interestRate;

    private double period;

    private CurrencyType selectedCurrencyType = CurrencyType.DOLLAR;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(double principleAmount) {
        this.principleAmount = principleAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public CurrencyType getSelectedCurrencyType() {
        return selectedCurrencyType;
    }

    public void setSelectedCurrencyType(CurrencyType selectedCurrencyType) {
        this.selectedCurrencyType = selectedCurrencyType;
    }

    public PaymentFrequency getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(PaymentFrequency paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }
}
