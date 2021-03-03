package main.bankProducts;

public class ShortDeposit extends Deposit {
    public ShortDeposit(double stock) {
        super(3, stock);
    }

    @Override
    public double getAnnualInterestPercent() {
        return 3.0;
    }

    @Override
    public BankProductType getType() {
        return BankProductType.DEPOSIT;
    }
}
