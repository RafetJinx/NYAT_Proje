package concretes;

import abstracts.ObserverInterface;

public class VeritabaniBirimi implements ObserverInterface {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
