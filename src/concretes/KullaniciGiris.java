package concretes;

import abstracts.KullaniciGirisInterface;
import abstracts.ObserverInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class KullaniciGiris implements KullaniciGirisInterface {
	ObserverInterface veritabaniBirimi = new VeritabaniBirimi();
	
	Scanner scanner = new Scanner(System.in);

	ArrayList<String> userNames = new ArrayList<>();
	ArrayList<String> passwords = new ArrayList<>();
	ArrayList<String> accessLevels = new ArrayList<>();
	ArrayList<String> publishers = new ArrayList<>();

	String userName = null;
	String password = null;
	String accessLevel = null;
	String publisher = null;

	int rightOfEntry = 3;

	KullaniciGiris() {
		String query;
		DataBase.connect();
		query = "select * from users";

		ResultSet resultSet = DataBase.list(query);

		try {
			while (resultSet.next()) {
				userName = resultSet.getString("userName");
				password = resultSet.getString("password");
				accessLevel = resultSet.getString("accessLevel");
				publisher = resultSet.getString("publisher");

				userNames.add(userName);
				passwords.add(password);
				accessLevels.add(accessLevel);
				publishers.add(publisher);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getRightOfEntry() {
		return rightOfEntry;
	}

	public void setRightOfEntry(int rightOfEntry) {
		this.rightOfEntry = rightOfEntry;
	}

	@Override
    public boolean Login(Kullanici kullanici) {
		 
        while(rightOfEntry > 0) {
            System.out.print("Kullanici Adi: ");
            kullanici.setUserName(scanner.nextLine());
            System.out.print("Sifre: " );
            kullanici.setPassword(scanner.nextLine());
            
            for(int i = 0; i < userNames.size(); i++) {
                if(kullanici.getUserName().equals(userNames.get(i)) & kullanici.getPassword().equals(passwords.get(i))) {
                    System.out.println("Giris Basarili.");
                    veritabaniBirimi.update("\"Veritabani\" birimine erisim saglanarak giris yapildi.");
                    return true;
                }
            }
            rightOfEntry--;
            System.out.println("Giris Basarisiz. Kalan giris hakki sayiniz: " + rightOfEntry);
        }
        
        if(rightOfEntry == 0) {
        	System.out.println("Giris hakkiniz kalmadigi icin sogutucu sisteminden cikis yapiliyor...");
        }
        return false;
    }
}
