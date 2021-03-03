package main.bankProducts;

import main.constants.Constants;
import main.util.Randomizator;

public abstract class Deposit extends BankProduct {
    Deposit(int productPeriod, double stock) {
        super(Constants.DEPOSIT_NAMES[Randomizator.randomNumRange(
                0,
                Constants.DEPOSIT_NAMES.length
                )],
                productPeriod,
                stock
        );
    }
}
