package concretes;

import abstracts.KullaniciInterface;
import abstracts.SubjectInterface;

public class Kullanici implements KullaniciInterface {

    private String userName;
    private String password;
    private String accessLevel;
    SubjectInterface publisher;

    private Kullanici(KullaniciBuilder builder){
        this.userName = builder.userName;
        this.password = builder.password;
        this.accessLevel = builder.accessLevel;
        this.publisher = builder.publisher;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public SubjectInterface getPublisher() {
        return publisher;
    }

    public void setPublisher(SubjectInterface publisher) {
        this.publisher = publisher;
    }

    public static class KullaniciBuilder {
        private String userName;
        private String password;
        private String accessLevel;
        SubjectInterface publisher;

        public KullaniciBuilder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public KullaniciBuilder accessLevel(String accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        public KullaniciBuilder publisher(SubjectInterface publisher) {
            this.publisher = publisher;
            return this;
        }

        public Kullanici build() {
            return new Kullanici(this);
        }
    }
}
