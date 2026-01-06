import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main implements iEv, iHonap, iNap{

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
            valasztas = Integer.parseInt(menuEllenorzo(be, "Választás: "));

            switch (valasztas) {
                case 1:
                    for (Szerzodes sz : szerzodesek) System.out.println(sz);
                    break;

                case 2:
                    fajlbaIras(szerzodesek);
                    System.out.println("Szerződés felvéve!");
                    break;

                case 3:
                    System.out.print("Törlendő azonosító: ");
                    int id = be.nextInt();
                    if (torles(szerzodesek, id)) {
                        fajlFrissites(szerzodesek);
                        System.out.println("A " + id + ". azonosítójú szerződés adatai törölve!");
                    } else {
                        System.out.println("Nincs ilyen azonosító!");
                    }
                    break;

                case 4:
                    System.out.print("Keresett azonosító: ");
                    int keres = be.nextInt();
                    System.out.println(keresAzon(keres, szerzodesek));
                    break;

                case 5:
                    System.out.println(legolcsobbBerletiDij(szerzodesek));
                    break;

                case 6:
                    System.out.println(legnagyobbNm(szerzodesek));
                    break;

                case 7:
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

        } catch (Exception e) {
            System.out.println("Hiba üzenet: " + e);
        }
    }

    public static void fajlbaIras(ArrayList<Szerzodes> szerzodesek) {
        Scanner be = new Scanner(System.in);
        ArrayList<String> adatok = new ArrayList<>();





        adatok.add(bekerSzam(be, "Bérlő ID: "));
        adatok.add(bekerNev(be, "Bérlő neve: "));
        adatok.add(String.valueOf(bekerDatum(be, "Bérlő születési dátuma: ")));
        adatok.add(bekerSzam(be, "Apartmanok száma: "));

        adatok.add(bekerSzam(be, "Bérbeadó ID: "));
        adatok.add(bekerNev(be,"Bérbeadó neve: "));
        adatok.add(String.valueOf(bekerDatum(be, "Bérbeadó születési dátuma: ")));
        adatok.add(bekerSzam(be, "Kiadott lakások száma: "));




        adatok.add(bekerUjCim(be, szerzodesek, "Apartmann címe: "));

        adatok.add(bekerSzam(be, "Bérleti díj: "));
        adatok.add(bekerSzam(be, "Bérleti idő (hónapban): "));
        adatok.add(bekerSzam(be, "Kaució: "));
        adatok.add(bekerSzam(be, "Négyzetméter: "));

        int id;
        while (true) {
            id = Integer.parseInt(bekerSzam(be, "Azonosító: "));
            if (azonositoFoglalt(id, szerzodesek)) {
                System.out.println("Ez az azonosító már foglalt! Adj meg egy újat.");
            } else {
                break;
            }
        }
        adatok.add(String.valueOf(id));

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

    public static boolean torles(ArrayList<Szerzodes> szerzodesek, int id) {
        for (Szerzodes sz : szerzodesek) {
            if (sz.getAzon() == id) {
                szerzodesek.remove(sz);
                return true;
            }
        }
        return false;
    }

    public static void fajlFrissites(ArrayList<Szerzodes> szerzodesek) {
        try (FileWriter fw = new FileWriter("szerzodesek.txt", false)) {
            for (Szerzodes sz : szerzodesek) fw.write(sz.fajlbaIras());
        } catch (IOException e) { throw new RuntimeException(e); }
    }

    public static Object keresAzon(int id, ArrayList<Szerzodes> szerzodesek) {
        for (Szerzodes sz : szerzodesek)
            if (sz.getAzon() == id) return sz;
        return "Nincs ilyen azonosító!";
    }
    public static Object legolcsobbBerletiDij(ArrayList<Szerzodes> szerzodesek) {
        if (szerzodesek.isEmpty()) {
            return "A lista üres!";
        } else {
            System.out.println("Legolcsóbb:");
            return Collections.min(szerzodesek, Comparator.comparingInt(Szerzodes::getBerletiDij));
        }

    }

    public static Object legnagyobbNm(ArrayList<Szerzodes> szerzodesek) {
        if (szerzodesek.isEmpty()) {
            return "A lista üres!";
        } else {
            System.out.println("Legnagyobb négyzetméter:");
            return Collections.max(szerzodesek, Comparator.comparingInt(Szerzodes::getNm));
        }

    }

    public static Object legkisebbNm(ArrayList<Szerzodes> szerzodesek) {
        if (szerzodesek.isEmpty()) {
            return "A lista üres!";
        } else {
            System.out.println("Legkisebb négyzetméter:");
            return Collections.min(szerzodesek, Comparator.comparingInt(Szerzodes::getNm));
        }

    }

    public static String bekerNemUres(Scanner be, String uzenet) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(uzenet);
            input = be.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Nem lehet ezt a mezőt üresen hagyni!");
            }
        }

        return input;
    }

    public static String bekerSzam(Scanner be, String uzenet) {
        while (true) {
            String input = bekerNemUres(be, uzenet);

            try {
                int szam = Integer.parseInt(input);

                if (input.matches("\\d+") && Integer.parseInt(input) > 0) {
                    return input;
                } else {
                    System.out.println("Hibás adat! Csak számot adjon meg.");
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Hibás adat! Csak az int tartományon belüli számot adjon meg!");
            }


        }
    }

    public static String menuEllenorzo(Scanner be, String uzenet) {
        while (true) {
            System.out.print(uzenet);
            String input = be.nextLine().trim();

            if (input.matches("\\d")) {
                int szam = Integer.parseInt(input);
                if (szam >= 0 && szam <= 7) {
                    return input;
                }
            }

            System.out.println("Hibás választás! 0 és 7 közötti számot adj meg.");
        }
    }

    public static String bekerNev(Scanner be, String uzenet) {
        while (true) {
            String input = bekerNemUres(be, uzenet);
            String[] szavak = input.split(" ");

            if (szavak.length < 2) {
                System.out.println("Hibás név! Legalább két szóból kell állnia.");
                continue;
            }

            boolean helyes = true;
            for (String szo : szavak) {
                if (szo.isEmpty() || !Character.isUpperCase(szo.charAt(0))) {
                    helyes = false;
                    break;
                }
            }

            if (!helyes) {
                System.out.println("Hibás név! Minden szónak nagybetűvel kell kezdődnie.");
                continue;
            }

            return input;
        }
    }

    public static boolean azonositoFoglalt(int id, ArrayList<Szerzodes> szerzodesek) {
        for (Szerzodes sz : szerzodesek) {
            if (sz.getAzon() == id) return true;
        }
        return false;
    }

    public static LocalDate bekerDatum(Scanner be, String uzenet) {
        while (true) {
            System.out.print(uzenet);
            String input = be.nextLine();

            if (input.length() != 10 || input.charAt(4) != '-' || input.charAt(7) != '-') {
                System.out.println("Hibás formátum! Helyes formátum: yyyy-MM-dd");
                continue;
            }

            try {
                int ev = Integer.parseInt(input.substring(0, 4));
                int honap = Integer.parseInt(input.substring(5, 7));
                int nap = Integer.parseInt(input.substring(8, 10));

                if (ev < iEv.MIN || ev > iEv.MAX) {
                    System.out.println("Hibás év! Érvényes év: " + iEv.MIN + "-" + iEv.MAX);
                    continue;
                }

                if (honap < iHonap.MIN || honap > iHonap.MAX) {
                    System.out.println("Hibás hónap! Érvényes hónap: 1-12");
                    continue;
                }

                if (nap < iNap.MIN || nap > iNap.MAX) {
                    System.out.println("Hibás nap! Érvényes nap: 1-31");
                    continue;
                }

                LocalDate datum = LocalDate.parse(input);
                return datum;

            } catch (NumberFormatException e) {
                System.out.println("Hiba! Csak számokat adjon meg.");
            } catch (DateTimeParseException e) {
                System.out.println("Érvénytelen dátum!");
            }
        }

    }

    public static String bekerUjCim(Scanner be,ArrayList<Szerzodes> szerzodesek, String uzenet) {
        while (true) {
            String ujCim = bekerNemUres(be, uzenet);
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
                return ujCim;
            }
        }
    }
}