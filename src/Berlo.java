public class Berlo {
    private int azonosito;
    private String nev;
    private String szulEv;
    private int bereltApartman;

    public Berlo(int azonosito, String nev, String szulEv, int bereltApartman) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.szulEv = szulEv;
        this.bereltApartman = bereltApartman;
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
                "-azonosító: " + azonosito +
                "\n-név: " + nev +
                "\n-születési év: " + szulEv +
                "\n-bérelt apartmanok száma: " + bereltApartman;
    }


}
