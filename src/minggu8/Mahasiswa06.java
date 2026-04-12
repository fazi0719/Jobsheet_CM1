package minggu8;

public class Mahasiswa06 {
    String nim;
    String nama;
    String Prodi;

    // konsturktor berparameter untuk mengisi data mahasiswa
    public Mahasiswa06 (String nim, String nama, String Prodi) {
        this.nim = nim;
        this.nama = nama;
        this.Prodi = Prodi;
    }
    // method untuk menampilkan data mahasiswa
    void tampilMahasiswa() {
        System.out.println("NIM : " + nim + " | " + "Nama : " + nama + " | " + "Prodi : " + Prodi);
    }
}
