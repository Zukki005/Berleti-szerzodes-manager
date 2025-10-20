public class BerbeAdo {
    private int azonosito;
    private String nev;
    private String szulEv;
    private int kiadottApartmann;

    public BerbeAdo(int azonosito, String nev, String szulEv, int kiadottApartmann) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.szulEv = szulEv;
        this.kiadottApartmann = kiadottApartmann;
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

    public int getKiadottApartmann() {
        return kiadottApartmann;
    }

    public void setKiadottApartmann(int kiadottApartmann) {
        this.kiadottApartmann = kiadottApartmann;
    }

    @Override
    public String toString() {
        return "Bérbeadó adatai: \n" +
                "-azonosító: " + azonosito +
                "\n-név: " + nev +
                "\n-születési év: " + szulEv +
                "\n-kiadott apartmanok száma: " + kiadottApartmann;
    }




}
