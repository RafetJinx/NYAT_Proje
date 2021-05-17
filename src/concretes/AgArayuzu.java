package concretes;

import abstracts.AgArayuzuInterface;
import abstracts.ObserverInterface;

import java.util.Scanner;

public class AgArayuzu extends Sogutucu implements AgArayuzuInterface {
    AnaIslemPlatformu anaIslemPlatformu = new AnaIslemPlatformu();
    Eyleyici eyleyici = new Eyleyici();
    SicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici();    

    Scanner scanner = new Scanner(System.in);

    ObserverInterface goruntulenmeBirimi = new GoruntulenmeBirimi();
    ObserverInterface anormalDurumTespitBirimi = new AnormalDurumTespitBirimi();

    @Override
    public void agArayuzu() {
        boolean control = true;
        int islem;
        String islemler = "1. Sogutucuyu Ac\n"
        					+ "2. Sogutucuyu Kapat\n"
        					+ "3. Sicakligi Goruntule\n"
        					+ "4. Cikis yap";

        while(control){
            System.out.println(islemler);
            System.out.print("Isleminiz: ");
            islem = scanner.nextInt();
            scanner.nextLine();
            
            switch (islem) {
                case 1:
                	if(anaIslemPlatformu.sogutucuAcikMi()){
                        anaIslemPlatformu.sogutucuZatenAcikMesajGonder();
                    } else {
                        anaIslemPlatformu.setSogutucuDurumu(true);
                        eyleyici.sogutucuAc();
                    }
                    break;
                case 2:
                	if(anaIslemPlatformu.sogutucuKapaliMi()){
                        anaIslemPlatformu.setSogutucuDurumu(false);
                        eyleyici.sogutucuKapat();
                    } else {
                        anaIslemPlatformu.sogutucuZatenKapaliMesajGonder();
                    }
                    break;
                case 3:
                	sicaklikAlgilayici.sicaklikOku();
                    anaIslemPlatformu.sicaklikDegeriGoster(sicaklikAlgilayici.sicaklikDegeriGonder());
                    goruntulenmeBirimi.update("\"Goruntulenme\" birimine sicaklik bilgisinin goruntulendigi gonderildi.");
                    if(sicaklikAlgilayici.sicaklikDegeriGonder() > 60) {
                    	anormalDurumTespitBirimi.update("\"Anormal Durum Tespiti\" birimine yuksek sicakliga ulasildigi bilgisi gonderildi.");
                    }
                    break;
                case 4:
                    System.out.println("Cikis yapiliyor...");
                    control = false;
                    break;
                default:
                    System.out.println("Gecerli bir islem giriniz.");
            }
        }
    }

	public ObserverInterface getGoruntulenmeBirimi() {
		return goruntulenmeBirimi;
	}

	public ObserverInterface getAnormalDurumTespitBirimi() {
		return anormalDurumTespitBirimi;
	}
}
