import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kütüphane Yönetim Sistemi
 * Kitapların eklenmesi, listelenmesi, aranması, ödünç alınması ve iade edilmesi işlemlerini yönetir
 */
public class LibraryManagementSystem {
    // Kütüphanedeki tüm kitapları tutan liste
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Değerlendirme formu 1: Ana menü ve program döngüsü
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Kütüphane Sistemi ===");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Kitap Ara");
            System.out.println("4. Ödünç Al");
            System.out.println("5. İade Et");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            // Değerlendirme formu 2: Menü seçeneklerine göre işlem yapma
            if (secim == 1) {
                kitapEkle();
            } else if (secim == 2) {
                kitaplariListele();
            } else if (secim == 3) {
                kitapAra();
            } else if (secim == 4) {
                oduncAl();
            } else if (secim == 5) {
                iadeEt();
            } else if (secim == 6) {
                System.out.println("Program sonlandı.");
                break;
            }
        }
        scanner.close();
    }

    // Değerlendirme formu 3: Yeni kitap ekleme metodu
    private static void kitapEkle() {
        System.out.print("Başlık: ");
        String baslik = scanner.nextLine();
        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        books.add(new Book(baslik, yazar, isbn));
        System.out.println("Kitap eklendi!");
    }

    // Değerlendirme formu 4: Tüm kitapları listeleme metodu
    private static void kitaplariListele() {
        if (books.isEmpty()) {
            System.out.println("Kitap yok!");
            return;
        }
        for (Book kitap : books) {
            System.out.println(kitap);
        }
    }

    // Değerlendirme formu 5: Kitap arama metodu
    private static void kitapAra() {
        System.out.print("Kitap adı veya ISBN: ");
        String aranan = scanner.nextLine();
        
        for (Book kitap : books) {
            if (kitap.getTitle().toLowerCase().contains(aranan.toLowerCase()) || 
                kitap.getIsbn().contains(aranan)) {
                System.out.println(kitap);
            }
        }
    }

    // Değerlendirme formu 6: Kitap ödünç alma metodu
    private static void oduncAl() {
        System.out.print("Kitap adı veya ISBN: ");
        String kitapAdi = scanner.nextLine();
        
        for (Book kitap : books) {
            if (kitap.getTitle().toLowerCase().contains(kitapAdi.toLowerCase()) || 
                kitap.getIsbn().contains(kitapAdi)) {
                if (kitap.isBorrowed()) {
                    System.out.println("Kitap zaten ödünç alınmış!");
                    return;
                }
                System.out.print("Adınız: ");
                kitap.borrowBook(scanner.nextLine());
                System.out.println("Kitap ödünç alındı!");
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
    }

    // Değerlendirme formu 7: Kitap iade etme metodu
    private static void iadeEt() {
        System.out.print("Kitap adı veya ISBN: ");
        String kitapAdi = scanner.nextLine();
        
        for (Book kitap : books) {
            if (kitap.getTitle().toLowerCase().contains(kitapAdi.toLowerCase()) || 
                kitap.getIsbn().contains(kitapAdi)) {
                if (!kitap.isBorrowed()) {
                    System.out.println("Kitap zaten kütüphanede!");
                    return;
                }
                kitap.returnBook();
                System.out.println("Kitap iade edildi!");
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
    }
} 