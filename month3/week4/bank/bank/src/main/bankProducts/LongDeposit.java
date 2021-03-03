package main.bankProducts;

public class LongDeposit extends Deposit {
    public LongDeposit(double stock) {
        super(12, stock);
    }

    @Override
    public double getAnnualInterestPercent() {
        return 5.0;
    }

    @Override
    public BankProductType getType() {
        return BankProductType.DEPOSIT;
    }
}
