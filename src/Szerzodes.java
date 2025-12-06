public class Szerzodes {

    private Berlo berloAdatai;
    private BerbeAdo berbeAdoAdatai;
    private String cim;
    private int azon;
    private int berletiDij;
    private int kaukcioOsszeg;
    private int berletiIdo;
    private int nm;

    public Szerzodes(Berlo berloAdatai, BerbeAdo berbeAdoAdatai, String cim,
                     int berletiDij, int berletiIdo, int kaukcioOsszeg, int nm, int azon) {

        setBerloAdatai(berloAdatai);
        setBerbeAdoAdatai(berbeAdoAdatai);
        setCim(cim);
        setBerletiDij(berletiDij);
        setBerletiIdo(berletiIdo);
        setKaukcioOsszeg(kaukcioOsszeg);
        setNm(nm);
        setAzon(azon);
    }

    public Berlo getBerloAdatai() { return berloAdatai; }
    public void setBerloAdatai(Berlo berloAdatai) { this.berloAdatai = berloAdatai; }

    public BerbeAdo getBerbeAdoAdatai() { return berbeAdoAdatai; }
    public void setBerbeAdoAdatai(BerbeAdo berbeAdoAdatai) { this.berbeAdoAdatai = berbeAdoAdatai; }

    public String getCim() { return cim; }
    public void setCim(String cim) { this.cim = cim; }

    public int getBerletiDij() { return berletiDij; }
    public void setBerletiDij(int berletiDij) { this.berletiDij = berletiDij; }

    public int getKaukcioOsszeg() { return kaukcioOsszeg; }
    public void setKaukcioOsszeg(int kaukcioOsszeg) { this.kaukcioOsszeg = kaukcioOsszeg; }

    public int getBerletiIdo() { return berletiIdo; }
    public void setBerletiIdo(int berletiIdo) { this.berletiIdo = berletiIdo; }

    public int getAzon() { return azon; }
    public void setAzon(int azon) { this.azon = azon; }

    public int getNm() { return nm; }
    public void setNm(int nm) { this.nm = nm; }

    public int getNegyzetMeter() { return nm; }

    @Override
    public String toString() {
        return "\n------------------------------\nSzerződés:" +
                "\n" + berloAdatai +
                "\n\n" + berbeAdoAdatai +
                "\n\n- Cím: " + cim +
                "\n- Bérleti díj: " + berletiDij +
                "\n- Bérleti idő: " + berletiIdo +
                "\n- Négyzetméter: " + nm +
                "\n- Kaukció: " + kaukcioOsszeg +
                "\n- Azonosító: " + azon +
                "\n------------------------------\n";
    }

    public String fajlbaIras() {
        return berloAdatai.fajlbaIras() + "," +
                berbeAdoAdatai.fajlbaIras() + "," +
                cim + "," +
                berletiDij + "," +
                berletiIdo + "," +
                nm + "," +
                kaukcioOsszeg + "," +
                azon + "\n";
    }
}


