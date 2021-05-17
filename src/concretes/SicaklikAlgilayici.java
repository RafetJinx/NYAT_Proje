package concretes;

import abstracts.SicaklikAlgilayiciInterface;

import java.util.Random;

public class SicaklikAlgilayici extends Sogutucu implements SicaklikAlgilayiciInterface {

    Random random = new Random();

    private int sicaklik;

    @Override
    public void sicaklikOku() {
        sicaklik = random.nextInt(80);
    }

    @Override
    public int sicaklikDegeriGonder() {
        return sicaklik;
    }
}
