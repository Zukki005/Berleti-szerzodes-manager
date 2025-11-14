public class Szerzodes {
    private Berlo berloAdatai;
    private BerbeAdo berbeAdoAdatai;
    private String cim;
    private int berletiDij;
    private int berletiIdo;
    private int kaukcioOsszeg;

    public Szerzodes(Berlo berloAdatai, BerbeAdo berbeAdoAdatai, String cim, int berletiDij, int berletiIdo, int kaukcioOsszeg) {
        this.berloAdatai = berloAdatai;
        this.berbeAdoAdatai = berbeAdoAdatai;
        this.cim = cim;
        this.berletiDij = berletiDij;
        this.berletiIdo = berletiIdo;
        this.kaukcioOsszeg = kaukcioOsszeg;
    }

    public int getKaukcioOsszeg() {
        return kaukcioOsszeg;
    }

    public void setKaukcioOsszeg(int kaukcioOsszeg) {
        this.kaukcioOsszeg = kaukcioOsszeg;
    }

    public int getBerletiIdo() {
        return berletiIdo;
    }

    public void setBerletiIdo(int berletiIdo) {
        this.berletiIdo = berletiIdo;
    }

    public int getBerletiDij() {
        return berletiDij;
    }

    public void setBerletiDij(int berletiDij) {
        this.berletiDij = berletiDij;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public BerbeAdo getBerbeAdoAdatai() {
        return berbeAdoAdatai;
    }

    public void setBerbeAdoAdatai(BerbeAdo berbeAdoAdatai) {
        this.berbeAdoAdatai = berbeAdoAdatai;
    }

    public Berlo getBerloAdatai() {
        return berloAdatai;
    }

    public void setBerloAdatai(Berlo berloAdatai) {
        this.berloAdatai = berloAdatai;
    }

    @Override
    public String toString() {
        return "Szerződés: " +
                "\n\n" + berloAdatai.toString() +
                "\n\n" + berbeAdoAdatai.toString() +
                "\n\nSzerződés adatai:\n-cím: " + cim +
                "\n-bérleti díj: " + berletiDij +
                "\n-bérleti idő: " + berletiIdo +
                "\n-kaukció összege: " + kaukcioOsszeg + "\n";
    }

    public String fajlbaIras() {
        return berloAdatai.fajlbaIras() + "," + berbeAdoAdatai.fajlbaIras() + "," + cim + "," + berletiDij + "," + berletiIdo + "," + kaukcioOsszeg + "\n";
    }
}
