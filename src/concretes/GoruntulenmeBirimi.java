package concretes;

import abstracts.ObserverInterface;

public class GoruntulenmeBirimi implements ObserverInterface {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
