package concretes;

import abstracts.ObserverInterface;

public class AnormalDurumTespitBirimi implements ObserverInterface {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
