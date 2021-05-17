package concretes;

import abstracts.EyleyiciInterface;

public class Eyleyici extends Sogutucu implements EyleyiciInterface {

    @Override
    public void sogutucuAc() {
        System.out.println("Sogutucu acildi.");
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sogutucu kapatildi.");
    }
}
