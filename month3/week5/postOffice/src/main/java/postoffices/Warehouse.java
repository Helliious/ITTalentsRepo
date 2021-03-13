package postoffices;

import deliverables.Delivery;
import deliverables.DeliveryType;
import deliverables.Letter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Warehouse {
    private final ConcurrentHashMap<DeliveryType, List<Delivery>> deliveries;
    private final int postmenCount;

    Warehouse(int postmenCount) {
        deliveries = new ConcurrentHashMap<>();
        this.postmenCount = postmenCount;
    }

    public void addLetters(List<Letter> letters) {
        if (!deliveries.containsKey(DeliveryType.LETTER)) {
            deliveries.put(DeliveryType.LETTER, new LinkedList<>());
        }
        assert letters != null;
        deliveries.get(DeliveryType.LETTER).addAll(letters);
    }

    public synchronized void addDelivery(Delivery delivery) {
        if (!deliveries.containsKey(delivery.getType())) {
            deliveries.put(delivery.getType(), new LinkedList<>());
        }
        deliveries.get(delivery.getType()).add(delivery);
    }

    public List<Delivery> getDelivery() {
        int deliverySize = getDeliveriesCount() / postmenCount;
        LinkedList<Delivery> delivery = new LinkedList<>();
        for (int i = 0; i < deliverySize; i++) {
            if (deliveries.isEmpty()) {
                break;
            }
            if (new Random().nextBoolean()) {
                if (!deliveries.get(DeliveryType.PACKAGE).isEmpty()) {
                    delivery.add(deliveries.get(DeliveryType.PACKAGE).remove(0));
                }
            } else {
                if (!deliveries.get(DeliveryType.LETTER).isEmpty()) {
                    delivery.add(deliveries.get(DeliveryType.LETTER).remove(0));
                }
            }
        }
        return delivery;
    }

    public synchronized void showStock() {
        for (Map.Entry<DeliveryType, List<Delivery>> d : deliveries.entrySet()) {
            for (Delivery delivery : d.getValue()) {
                delivery.showDelivery();
            }
        }
    }

    public int getDeliveriesCount() {
        int deliveriesCount = 0;
        for (Map.Entry<DeliveryType, List<Delivery>> d : deliveries.entrySet()) {
            deliveriesCount += d.getValue().size();
        }
        return deliveriesCount;
    }
}
