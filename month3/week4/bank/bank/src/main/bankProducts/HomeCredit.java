package main.bankProducts;

public class HomeCredit extends Credit {
    public HomeCredit(int productPeriod, double stock) {
        super(productPeriod, stock);
    }

    @Override
    public double getAnnualInterestPercent() {
        return 6.0;
    }

    @Override
    public BankProductType getType() {
        return BankProductType.CREDIT;
    }
}
