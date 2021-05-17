package concretes;

import abstracts.AgArayuzuInterface;
import abstracts.KullaniciGirisInterface;
import abstracts.KullaniciInterface;
import abstracts.ObserverInterface;

public class Main {
    public static void main(String[] args) {
    	
    	ObserverInterface goruntulenmeBirimi = new GoruntulenmeBirimi();
    	ObserverInterface veritabaniBirimi = new VeritabaniBirimi();
    	ObserverInterface anormalDurumTespitBirimi = new AnormalDurumTespitBirimi();

    	Publisher publisher = new Publisher();
    	
    	publisher.attach(goruntulenmeBirimi);
    	publisher.attach(veritabaniBirimi);
    	publisher.attach(anormalDurumTespitBirimi);
    	
    	
    	KullaniciInterface kullanici = new Kullanici.KullaniciBuilder("", "").build();
    	KullaniciGirisInterface kullaniciGiris = new KullaniciGiris();
    	
    	if(kullaniciGiris.Login((Kullanici) kullanici) == true) {
    		AgArayuzuInterface agArayuzu = new AgArayuzu();
    		agArayuzu.agArayuzu();
    	}
    	
    	
    }
}
