import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Szerzodes> szerzodesek = new ArrayList<>();
        toltes(szerzodesek);

        Scanner be = new Scanner(System.in);
        int valasztas;

        do {
            System.out.println("\n====== Szerződéskezelő Menü ======");
            System.out.println("1 - Összes szerződés listázása");
            System.out.println("2 - Új szerződés felvétele");
            System.out.println("3 - Szerződés törlése");
            System.out.println("4 - Keresés a szerződési azonosító alapján");
            System.out.println("5 - Legolcsóbb bérleti díj");
            System.out.println("6 - Legnagyobb négyzetméter");
            System.out.println("7 - Legkisebb négyzetméter");
            System.out.println("0 - Kilépés");
            System.out.print("Választás: ");
            valasztas = be.nextInt();
            be.nextLine();

            switch (valasztas) {
                case 1:
                    for (Szerzodes sz : szerzodesek) System.out.println(sz);
                    break;

                case 2:
                    fajlbaIras(szerzodesek);
                    break;

                case 3:
                    System.out.print("Törlendő azonosító: ");
                    int id = be.nextInt();
                    torles(szerzodesek, id);
                    fajlFrissites(szerzodesek);
                    System.out.println("A "+id+" azonosítójú adatai törölve!");
                    break;

                case 4:
                    System.out.print("Keresett azonosító: ");
                    int keres = be.nextInt();
                    System.out.println(keresAzon(keres, szerzodesek));
                    break;

                case 5:
                    System.out.println("Legolcsóbb:");
                    System.out.println(legolcsobbBerletiDij(szerzodesek));
                    break;

                case 6:
                    System.out.println("Legnagyobb négyzetméter:");
                    System.out.println(legnagyobbNm(szerzodesek));
                    break;

                case 7:
                    System.out.println("Legkisebb négyzetméter:");
                    System.out.println(legkisebbNm(szerzodesek));
                    break;
            }

        } while (valasztas != 0);
    }

    public static void toltes(ArrayList<Szerzodes> szerzodesek) {
        try (BufferedReader br = new BufferedReader(new FileReader("szerzodesek.txt"))) {
            String sor;

            while ((sor = br.readLine()) != null) {

                StringTokenizer st1 = new StringTokenizer(sor, ",");
                String berloadat = st1.nextToken();
                String berbeadoadat = st1.nextToken();

                StringTokenizer st2 = new StringTokenizer(berloadat, "/");
                Berlo berlo = new Berlo(
                        Integer.parseInt(st2.nextToken()),
                        st2.nextToken(),
                        st2.nextToken(),
                        Integer.parseInt(st2.nextToken())
                );

                StringTokenizer st3 = new StringTokenizer(berbeadoadat, "/");
                BerbeAdo berbeAdo = new BerbeAdo(
                        Integer.parseInt(st3.nextToken()),
                        st3.nextToken(),
                        st3.nextToken(),
                        Integer.parseInt(st3.nextToken())
                );

                Szerzodes sz = new Szerzodes(
                        berlo,
                        berbeAdo,
                        st1.nextToken(),
                        Integer.parseInt(st1.nextToken()),
                        Integer.parseInt(st1.nextToken()),
                        Integer.parseInt(st1.nextToken()),
                        Integer.parseInt(st1.nextToken()),
                        Integer.parseInt(st1.nextToken())
                );

                szerzodesek.add(sz);
            }

        } catch (Exception ignored) {}
    }

    public static void fajlbaIras(ArrayList<Szerzodes> szerzodesek) {
        Scanner be = new Scanner(System.in);
        ArrayList<String> adatok = new ArrayList<>();

        System.out.println("Bérlő ID:"); adatok.add(be.nextLine());
        System.out.println("Bérlő neve:"); adatok.add(be.nextLine());
        System.out.println("Bérlő szül. éve:"); adatok.add(be.nextLine());
        System.out.println("Apartmanok száma:"); adatok.add(be.nextLine());

        System.out.println("Bérbeadó ID:"); adatok.add(be.nextLine());
        System.out.println("Bérbeadó neve:"); adatok.add(be.nextLine());
        System.out.println("Bérbeadó szül. éve:"); adatok.add(be.nextLine());
        System.out.println("Kiadott lakások száma:"); adatok.add(be.nextLine());


        String ujCim;
        while (true) {
            System.out.println("Cím:");
            ujCim = be.nextLine();
            boolean foglalt = false;
            for (Szerzodes sz : szerzodesek) {
                if (sz.getCim().equalsIgnoreCase(ujCim)) {
                    foglalt = true;
                    break;
                }
            }
            if (foglalt) {
                System.out.println("Ezen a címen már lefoglalták az apartmant! Adj meg egy új címet!");
            } else {
                break;
            }
        }

        adatok.add(ujCim);


        System.out.println("Bérleti díj:"); adatok.add(be.nextLine());
        System.out.println("Bérleti idő:"); adatok.add(be.nextLine());
        System.out.println("Kaukció:"); adatok.add(be.nextLine());
        System.out.println("Négyzetméter:"); adatok.add(be.nextLine());
        System.out.println("Azonosító:"); adatok.add(be.nextLine());

        Berlo b = new Berlo(Integer.parseInt(adatok.get(0)), adatok.get(1), adatok.get(2), Integer.parseInt(adatok.get(3)));
        BerbeAdo ba = new BerbeAdo(Integer.parseInt(adatok.get(4)), adatok.get(5), adatok.get(6), Integer.parseInt(adatok.get(7)));

        Szerzodes sz = new Szerzodes(b, ba,
                adatok.get(8), Integer.parseInt(adatok.get(9)),
                Integer.parseInt(adatok.get(10)), Integer.parseInt(adatok.get(11)),
                Integer.parseInt(adatok.get(12)), Integer.parseInt(adatok.get(13)));

        szerzodesek.add(sz);

        try (FileWriter fw = new FileWriter("szerzodesek.txt", true)) {
            fw.write(sz.fajlbaIras());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void torles(ArrayList<Szerzodes> szerzodesek, int id) {
        szerzodesek.removeIf(sz -> sz.getAzon() == id);
    }

    public static void fajlFrissites(ArrayList<Szerzodes> szerzodesek) {
        try (FileWriter fw = new FileWriter("szerzodesek.txt", false)) {
            for (Szerzodes sz : szerzodesek) fw.write(sz.fajlbaIras());
        } catch (IOException e) { throw new RuntimeException(e); }
    }

    public static Szerzodes keresAzon(int id, ArrayList<Szerzodes> szerzodesek) {
        for (Szerzodes sz : szerzodesek)
            if (sz.getAzon() == id) return sz;
        return null;
    }
    public static Szerzodes legolcsobbBerletiDij(ArrayList<Szerzodes> szerzodesek) {
        return Collections.min(szerzodesek, Comparator.comparingInt(Szerzodes::getBerletiDij));
    }

    public static Szerzodes legnagyobbNm(ArrayList<Szerzodes> szerzodesek) {
        return Collections.max(szerzodesek, Comparator.comparingInt(Szerzodes::getNm));
    }

    public static Szerzodes legkisebbNm(ArrayList<Szerzodes> szerzodesek) {
        return Collections.min(szerzodesek, Comparator.comparingInt(Szerzodes::getNm));
    }
}
