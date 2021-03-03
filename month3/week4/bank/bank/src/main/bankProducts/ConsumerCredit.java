package main.bankProducts;

public class ConsumerCredit extends Credit {
    public ConsumerCredit(int productPeriod, double stock) {
        super(productPeriod, stock);
    }

    @Override
    public double getAnnualInterestPercent() {
        return 10.0;
    }

    @Override
    public BankProductType getType() {
        return BankProductType.CREDIT;
    }
}
