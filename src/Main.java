import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        ArrayList<Szerzodes> szerzodesek = new ArrayList<>();

        try {
            File f = new File("szerzodesek.txt");
            if (f.createNewFile()) {
                System.out.println("Sikeres létrehozás: " + f.getName());
            } else
                System.out.println("A fájl már létezik!");
        } catch (IOException e) {
            System.out.println("Hiba történt!");
        }

        toltes(szerzodesek);
        fajlbaIras(szerzodesek);

        for (int i = 0; i < szerzodesek.size(); i++) {
            System.out.println(szerzodesek);
        }


        //switch ()


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
                Szerzodes szerzodes = new Szerzodes(berlo,berbeAdo,st1.nextToken(),Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()));
                szerzodesek.add(szerzodes);
            }
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl olvasása során!");
            throw new RuntimeException(e);
        }
    }

    public  static void fajlbaIras(ArrayList<Szerzodes> szerzodesek){
        ArrayList<String> adatok = new ArrayList<>();
        Scanner be = new Scanner(System.in);
        System.out.println("Bérlő adatai:");
        System.out.println("Bérlő azonosítója: ");
        adatok.add(be.nextLine());
        System.out.println("Berlő Neve: ");
        adatok.add(be.nextLine());
        System.out.println("Bérlő születési éve: ");
        adatok.add(be.nextLine());
        System.out.println("Bérlő bérelt apartmanok száma: ");
        adatok.add(be.nextLine());

        System.out.println("Bérbeadó adatai:");
        System.out.println("Bérbeadó azonosítója: ");
        adatok.add(be.nextLine());
        System.out.println("Bérbeadó Neve: ");
        adatok.add(be.nextLine());
        System.out.println("Bérbeadó születésiéve: ");
        adatok.add(be.nextLine());
        System.out.println("Bérbeadó kiadott apartmanok száma: ");
        adatok.add(be.nextLine());

        System.out.println("Szerzodes adatai: ");
        System.out.println("Apartman címe: ");
        adatok.add(be.nextLine());
        System.out.println("Bérletidíj: ");
        adatok.add(be.nextLine());
        System.out.println("Bérleti idő (hónapban): ");
        adatok.add(be.nextLine());
        System.out.println("Kaukció összege: ");
        adatok.add(be.nextLine());
        System.out.println("Lakás négyzetmétere: ");
        adatok.add(be.nextLine());
        System.out.println("Szerződés azonosítója:");
        adatok.add(be.nextLine());
        Berlo berlo = new Berlo(Integer.parseInt(adatok.get(0)),adatok.get(1),adatok.get(2),Integer.parseInt(adatok.get(3)));
        BerbeAdo berbeAdo = new BerbeAdo(Integer.parseInt(adatok.get(4)),adatok.get(5),adatok.get(6),Integer.parseInt(adatok.get(7)));
        Szerzodes szerzodes = new Szerzodes(berlo,berbeAdo,adatok.get(8),Integer.parseInt(adatok.get(9)),Integer.parseInt(adatok.get(10)),Integer.parseInt(adatok.get(11)),Integer.parseInt(adatok.get(12)), Integer.parseInt(adatok.get(13)));
        try {
            FileWriter fw = new FileWriter("szerzodesek.txt", true);
            fw.write(szerzodes.fajlbaIras());
            fw.close();
        } catch (IOException e) {
            System.out.println("Hiba történt a fájl írása során!");
            throw new RuntimeException(e);
        }
        toltes(szerzodesek);
    }
    public static void torles(ArrayList<Szerzodes> szerzodesek, int szerzodesAzonosito){
        toltes(szerzodesek);
        for (int i = 0; i < szerzodesek.size(); i++) {
            if (szerzodesek.get(i).getAzon() == szerzodesAzonosito){
                szerzodesek.remove(szerzodesek.get(i));
            }
        }
    }

        public static void fajlTorles() throws IOException {
            FileWriter fw = new FileWriter("szerzodesek.txt", false);
            fw.write("");
            fw.close();
        }

    public static void fajlFrissites(ArrayList<Szerzodes> szerzodesek){
        try {
            fajlTorles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < szerzodesek.size(); i++) {
            try {
                FileWriter fw = new FileWriter("szerzodesek.txt", true);
                fw.write(szerzodesek.get(i).toString());
                fw.close();
            } catch (IOException e) {
                System.out.println("Hiba történt a fájl írása során!");
                throw new RuntimeException(e);
            }
        }

    }
}