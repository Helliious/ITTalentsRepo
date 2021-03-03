package main.bankProducts;

import main.constants.Constants;
import main.util.Randomizator;

public abstract class Credit extends BankProduct {
    Credit(int productPeriod, double stock) {
        super(Constants.CREDIT_NAMES[Randomizator.randomNumRange(
                0,
                Constants.CREDIT_NAMES.length
                )],
                productPeriod,
                stock
        );
    }

    public void giveAnnualPayment() {
        reduceMoney(getAnnualPayment());
    }
}
