package minggu8;

// class PeminjamanBuku06 untuk mengelola data peminjaman buku
public class PeminjamanBuku06 {
    Mahasiswa06 mhs;
    Buku06 buku;
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;

// konstruktor berparameter untuk mengisi data peminjaman buku
public PeminjamanBuku06(Mahasiswa06 mhs, Buku06 buku, int lamaPinjam) {
    this.mhs = mhs;
    this.buku = buku;
    this.lamaPinjam = lamaPinjam;   
    // saat obejek dibuat, langsung menghitung denda
    hitungDenda();
}

// algoritma perhitungan
// method untuk menghitung jumlah hari keterlambatan dan denda yang harus dibayar
void hitungDenda() {
    if (lamaPinjam > 5) {  // jika lama pinjam lebih dari 5 hari, maka terjadi keterlambatan
        terlambat = lamaPinjam - batasPinjam; //    menghitung jumlah hari keterlambatan
        denda = terlambat * 2000; // menghitung jumlah denda yang harus dibayar, dengan asumsi denda per hari adalah 2000
    } else { // jika lama pinjam tidak lebih dari 5 hari, maka tidak terjadi keterlambatan dan denda yang harus dibayar adalah 0
        terlambat = 0;
        denda = 0;
    }
}
// method untuk menampilkan data peminjaman buku
void tampilPeminjaman() {
    System.out.println("Nama peminjam buku: " + mhs.nama + " | judul buku: " + buku.Judul + 
    " | lama pinjam: " + lamaPinjam + " | hari keterlambatan: " + terlambat + " | denda Rp: " + denda);
   
}
}
