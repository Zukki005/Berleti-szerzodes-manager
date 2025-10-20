import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
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

    }
}