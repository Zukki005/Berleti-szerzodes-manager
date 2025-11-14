public class Szerzodes {
    private Berlo berloAdatai;
    private BerbeAdo berbeAdoAdatai;
    private String cim;
    private int berletiDij, kaukcioOsszeg, berletiIdo, nm;

    public Szerzodes(Berlo berloAdatai, BerbeAdo berbeAdoAdatai, String cim, int berletiDij, int berletiIdo, int kaukcioOsszeg, int nm) {
        this.setBerloAdatai(berloAdatai);
        this.setBerbeAdoAdatai(berbeAdoAdatai);
        this.setCim(cim);
        this.setBerletiDij(berletiDij);
        this.setBerletiIdo(berletiIdo);
        this.setKaukcioOsszeg(kaukcioOsszeg);
        this.setNm(nm);
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

    public int getNm() {return nm;}

    public void setNm(int nm) {this.nm = nm;}

    @Override
    public String toString() {
        return "Szerződés: " +
                "\n\n" + berloAdatai.toString() +
                "\n\n" + berbeAdoAdatai.toString() +
                "\n\nSzerződés adatai:\n-cím: " + this.getCim() +
                "\n-bérleti díj: " + this.getBerletiDij() +
                "\n-bérleti idő: " + this.getBerletiIdo() +
                "\n-négyzetméter: " + this.getNm() +
                "\n-kaukció összege: " + this.getKaukcioOsszeg() + "\n";
    }

    public String fajlbaIras() {
        return berloAdatai.fajlbaIras() + "," + berbeAdoAdatai.fajlbaIras() + "," + cim + "," + berletiDij + "," + berletiIdo + "," + nm + "," + kaukcioOsszeg + "\n";
    }
}
