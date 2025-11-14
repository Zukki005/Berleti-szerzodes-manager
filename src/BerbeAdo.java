public class BerbeAdo {
    private int azonosito, kiadottApartman;
    private String nev, szulEv;

    public BerbeAdo(int azonosito, String nev, String szulEv, int kiadottApartman) {
        this.setAzonosito(azonosito);
        this.setNev(nev);
        this.setSzulEv(szulEv);
        this.setKiadottApartman(kiadottApartman);
    }

    public int getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(int azonosito) {
        this.azonosito = azonosito;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzulEv() {
        return szulEv;
    }

    public void setSzulEv(String szulEv) {
        this.szulEv = szulEv;
    }

    public int getKiadottApartman() {
        return kiadottApartman;
    }

    public void setKiadottApartman(int kiadottApartman) {
        this.kiadottApartman = kiadottApartman;
    }

    @Override
    public String toString() {
        return "Bérbeadó adatai: \n" +
                "-azonosító: " + this.getAzonosito() +
                "\n-név: " + this.getNev() +
                "\n-születési év: " + this.getSzulEv() +
                "\n-kiadott apartmanok száma: " + this.getKiadottApartman();
    }

    public String fajlbaIras() {
        return azonosito + "/" + nev + "/" + szulEv + "/" + kiadottApartman;
    }


}
