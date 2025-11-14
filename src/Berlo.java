public class Berlo {
    private int azonosito, bereltApartman;
    private String nev, szulEv;

    public Berlo(int azonosito, String nev, String szulEv, int bereltApartmann) {
        this.setAzonosito(azonosito);
        this.setNev(nev);
        this.setSzulEv(szulEv);
        this.setBereltApartman(bereltApartmann);
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

    public int getBereltApartman() {
        return bereltApartman;
    }

    public void setBereltApartman(int bereltApartman) {
        this.bereltApartman = bereltApartman;
    }

    @Override
    public String toString() {
        return "Bérlő adatai: \n" +
                "-azonosító: " + this.getAzonosito() +
                "\n-név: " + this.getNev()+
                "\n-születési év: " + this.getSzulEv() +
                "\n-bérelt apartmanok száma: " + this.getBereltApartman();
    }

    public String fajlbaIras() {
        return azonosito + "/" + nev + "/" + szulEv + "/" + bereltApartman;
    }

}
