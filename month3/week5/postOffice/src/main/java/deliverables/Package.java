package deliverables;

import persons.Citizen;

public class Package extends Delivery {
    private final int length;
    private final int width;
    private final int height;
    private final boolean isFragile;

    public Package(Citizen sender,
                   Citizen receiver,
                   int length,
                   int width,
                   int height,
                   boolean isFragile) {
        super(sender, receiver);
        this.length = length;
        this.height = height;
        this.width = width;
        this.isFragile = isFragile;
    }

    @Override
    double getTax() {
        int tax = 2;
        if (isAbnormal()) {
            tax += ((tax * 50) / 100);
        }
        if (isFragile) {
            tax += ((tax * 50) / 100);
        }
        return tax;
    }

    @Override
    public DeliveryType getType() {
        return DeliveryType.PACKAGE;
    }

    @Override
    public int getDeliveryTime() {
        return 2000;
    }

    private boolean isAbnormal() {
        return width > 60 || height > 60 || length > 60;
    }
}
