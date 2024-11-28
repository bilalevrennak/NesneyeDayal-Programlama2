
import java.util.ArrayList;
import java.util.List;

// BaseEntity Class (Base Class)
abstract class BaseEntity {
    int id;
    String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void BilgiGoster();
}

// IKayit Interface
interface IKayit {
    void kayitEkle();
}

// Musteri Class (Customer Class)
class Musteri extends BaseEntity implements IKayit {
    public Musteri(int id, String name) {
        super(id, name);
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Müşteri ID: " + id + ", Adı: " + name);
    }

    @Override
    public void kayitEkle() {
        System.out.println(name + " sisteme eklendi.");
    }
}

// Film Class
class Film extends BaseEntity {
    String tur;
    int sure; // dakika cinsinden

    public Film(int id, String name, String tur, int sure) {
        super(id, name);
        this.tur = tur;
        this.sure = sure;
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Film ID: " + id + ", Adı: " + name + ", Türü: " + tur + ", Süresi: " + sure + " dakika");
    }
}

// Salon Class
class Salon extends BaseEntity {
    Film film;
    List<Musteri> musteriler = new ArrayList<>();

    public Salon(int id, String name, Film film) {
        super(id, name);
        this.film = film;
    }

    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
        System.out.println(musteri.name + " " + name + " salonuna eklendi.");
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Salon ID: " + id + ", Adı: " + name + ", Gösterimdeki Film: " + film.name);
        System.out.println("Kayıtlı Müşteriler:");
        for (Musteri musteri : musteriler) {
            System.out.println(" - " + musteri.name);
        }
    }
}

// Main Class
public class SinemaSistemi {
    public static void main(String[] args) {
        // Film Tanımlama
        Film film1 = new Film(1, "Inception", "Bilim Kurgu", 148);
        Film film2 = new Film(2, "Titanic", "Romantik", 195);

        // Salon Tanımlama
        Salon salon1 = new Salon(1, "Salon 1", film1);
        Salon salon2 = new Salon(2, "Salon 2", film2);

        // Müşteri Tanımlama
        Musteri musteri1 = new Musteri(1, "Ali Yılmaz");
        Musteri musteri2 = new Musteri(2, "Ayşe Demir");

        // Müşteri Ekleme
        salon1.musteriEkle(musteri1);
        salon2.musteriEkle(musteri2);

        // Bilgi Gösterme
        film1.BilgiGoster();
        film2.BilgiGoster();

        salon1.BilgiGoster();
        salon2.BilgiGoster();

        musteri1.BilgiGoster();
        musteri2.BilgiGoster();
    }
}
