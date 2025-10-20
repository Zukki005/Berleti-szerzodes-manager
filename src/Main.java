public class Main {
    public static void main(String[] args) {
        BerbeAdo berbeAdo = new BerbeAdo(1, "Tamás", "2000-02-02", 5);

        System.out.println(berbeAdo.toString());

        Berlo berlo = new Berlo(2, "Lajos", "2001-06-08", 3);

        System.out.println("\n" + berlo.toString());
    }
}