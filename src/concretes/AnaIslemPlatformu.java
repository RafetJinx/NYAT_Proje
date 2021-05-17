package concretes;

import abstracts.AnaIslemPlatformuInterface;

public class AnaIslemPlatformu extends Sogutucu implements AnaIslemPlatformuInterface {

    private boolean sogutucuDurumu = false;

    public AnaIslemPlatformu() {
    }

    public boolean isSogutucuDurumu() {
        return sogutucuDurumu;
    }

    public void setSogutucuDurumu(boolean sogutucuDurumu) {
        this.sogutucuDurumu = sogutucuDurumu;
    }

    @Override
    public void sicaklikDegeriGoster(int sicaklik) {
        System.out.println("Sicaklik degeri: " + sicaklik);
    }

    @Override
    public boolean sogutucuAcikMi() {
        if(sogutucuDurumu == true){
            return true;
        }
        return false;
    }

    @Override
    public boolean sogutucuKapaliMi() {
        if(sogutucuDurumu == true){
            return true;
        }
        return false;
    }

    @Override
    public void sogutucuZatenAcikMesajGonder() {
        System.out.println("Sogutucu zaten acik.");
    }

    @Override
    public void sogutucuZatenKapaliMesajGonder() {
        System.out.println("Sogutucu zaten kapali");
    }
}
