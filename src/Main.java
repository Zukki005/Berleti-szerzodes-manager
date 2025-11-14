import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        ArrayList<Szerzodes> szerzodesek = new ArrayList<>();
        BerbeAdo berbeAdo = new BerbeAdo(1, "Tamás", "2000-02-02", 5);

        Berlo berlo = new Berlo(2, "Lajos", "2001-06-08", 3);


        Szerzodes szerzodes = new Szerzodes(berlo, berbeAdo, "Tatabánya Gál István ltp. 707", 90000, 12, 10000);


        try {
            File f = new File("szerzodesek.txt");
            if (f.createNewFile()) {
                System.out.println("Sikeres létrehozás: " + f.getName());
            } else
                System.out.println("A fájl már létezik!");
        } catch (IOException e) {
            System.out.println("Hiba történt!");
        }

        try {
            FileWriter fw = new FileWriter("szerzodesek.txt", true);
            fw.write(szerzodes.fajlbaIras());
            fw.close();
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl írása során!");
            throw new RuntimeException(e);
        }
        toltes(szerzodesek);
        for (int i = 0; i < szerzodesek.size(); i++) {
            System.out.println(szerzodesek.get(i));
        }

    }

    public static void toltes(ArrayList<Szerzodes> szerzodesek) {
        try {
            ArrayList<Berlo> berlok = new ArrayList<>();
            ArrayList<BerbeAdo> berbeAdok = new ArrayList<>();
            ArrayList<String> sorok = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("szerzodesek.txt"));
            String sor = br.readLine();
            br.close();
            sorok.add(sor);
            for (int i = 0; i < sorok.size(); i++) {
                StringTokenizer st1 = new StringTokenizer(sor, ",");
                String berloadat = st1.nextToken();
                String berbeadoadat = st1.nextToken();
                StringTokenizer st2 = new StringTokenizer(berloadat, "/");
                Berlo berlo = new Berlo(Integer.parseInt(st2.nextToken()),st2.nextToken(),st2.nextToken(),Integer.parseInt(st2.nextToken()));
                StringTokenizer st3 = new StringTokenizer(berbeadoadat, "/");
                BerbeAdo berbeAdo = new BerbeAdo(Integer.parseInt(st3.nextToken()),st3.nextToken(),st3.nextToken(),Integer.parseInt(st3.nextToken()));
                Szerzodes szerzodes = new Szerzodes(berlo,berbeAdo,st1.nextToken(),Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()));
                szerzodesek.add(szerzodes);
            }

        } catch (IOException e) {
            System.out.println("Hiba történt a fájl olvasása során!");
            throw new RuntimeException(e);
        }
    }

}