package minggu8;

public class Buku06 {
    String KodeBuku;
    String Judul;
    String tahunTerbit;

// konstruktor berparameter untuk mengisi data buku
    public Buku06(String KodeBuku, String Judul, String tahunTerbit) {
        this.KodeBuku = KodeBuku;
        this.Judul = Judul;
        this.tahunTerbit = tahunTerbit;
    }
    void tampilBuku() {
        System.out.println("Kode Buku : " + KodeBuku + " | " + "Judul : " + Judul + " | " + "Tahun Terbit : " + tahunTerbit);
    }
}

