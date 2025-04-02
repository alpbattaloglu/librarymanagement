/**
 * Kitap sınıfı
 * Kitabın başlık, yazar, ISBN ve ödünç alma durumu gibi özelliklerini tutar
 */
public class Book {
    // Kitap özellikleri
    private String title;
    private String author;
    private String isbn;
    private boolean borrowed;
    private String borrowedBy;

    // Değerlendirme formu 8: Kitap oluşturma metodu
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowed = false;
    }

    // Kitap özelliklerini getiren metodlar
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    // Değerlendirme formu 9: Kitabı ödünç alma metodu
    public void borrowBook(String borrower) {
        this.borrowed = true;
        this.borrowedBy = borrower;
    }

    // Değerlendirme formu 10: Kitabı iade etme metodu
    public void returnBook() {
        this.borrowed = false;
        this.borrowedBy = null;
    }

    // Değerlendirme formu 11: Kitap bilgilerini gösterme metodu
    @Override
    public String toString() {
        return "Kitap: " + title + " | Yazar: " + author + " | ISBN: " + isbn + 
               (borrowed ? " | Ödünç Alan: " + borrowedBy : " | Durum: Kütüphanede");
    }
} 