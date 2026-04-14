package minggu8;
import java.util.Scanner; // fungsi untuk mengimpor kelas Scanner dari paket java.util, 
                         // yang digunakan untuk membaca input dari pengguna
public class MainPeminjaman06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
      // Array statis yang menyimpan data mahasiswa menggunakan array of object
        Mahasiswa06[] mhsList ={ // membuat array of object untuk menyimpan data mahasiswa
                                // mhsList adalah array yang menyimpan objek-objek Mahasiswa06 
            new Mahasiswa06("22001", "Andi", "Teknik Informatika"), // membuat objek Mahasiswa06 dengan data NIM, nama, dan prodi, 
                                                                                    // lalu menyimpannya dalam array mhsList
            new Mahasiswa06("22002", "Budi", "Teknik Informatika"),
            new Mahasiswa06("22003", "Citra", "Sistem Informasi Bisnis")
        };
     // Array statis yang menyimpan data buku menggunakan array of object
        Buku06[] bukuList = { // membuat array of object untuk menyimpan data buku
            new Buku06("BK001", "Algoritma", "2020"), 
            new Buku06("BK002", "Basis Data", "2019"),
            new Buku06("BK003", "Pemrograman ", "2021"),
            new Buku06("BK004", "Fisika ", "2024")
        };
    // Array statis yang menyimpan data peminjaman buku menggunakan array of object
        PeminjamanBuku06[] peminjamanList = {
            new PeminjamanBuku06(mhsList[0], bukuList[0], 7),
            new PeminjamanBuku06(mhsList[1], bukuList[1], 3),
            new PeminjamanBuku06(mhsList[2], bukuList[2], 10),
            new PeminjamanBuku06(mhsList[2], bukuList[3], 6),
            new PeminjamanBuku06(mhsList[0], bukuList[1], 4)
        };
    
        int pilihan; // variabel untuk menyimpan pilihan menu yang dipilih oleh pengguna
        do { // perulangan do-while untuk menampilkan menu dan memproses pilihan pengguna hingga pengguna memilih untuk keluar (pilihan 0)
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Tampilkan Denda");
            System.out.println("5. Urutkan Berdasarkan Denda");
            System.out.println("6. Cari Berdasarkan NIM");
            System.out.println("7. Tampilkan Data Peminjaman Terlambat");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilihan = sc.nextInt();
            sc.nextLine(); // membersihkan buffer setelah membaca input angka

            switch (pilihan) { // struktur kontrol switch-case untuk menangani berbagai pilihan menu yang dipilih oleh pengguna

            // Menu 1 digunakan untuk menampilkan seluruh data mahasiswa menggunakan for-each.”
                case 1:
                    System.out.println("\n=== DATA MAHASISWA ===");
                    for (Mahasiswa06 m : mhsList) { // perulangan for-each untuk menampilkan data mahasiswa yang tersimpan dalam array mhsList
                        m.tampilMahasiswa(); // memanggil method tampilMahasiswa() untuk menampilkan data mahasiswa pada setiap objek Mahasiswa06 dalam array mhsList
                    }
                    break; // perintah break untuk keluar dari struktur switch setelah mengeksekusi case yang sesuai dengan pilihan pengguna

                case 2:
                    System.out.println("\n=== DATA BUKU ===");
                    for (Buku06 b : bukuList) {
                        b.tampilBuku();
                    }
                    break;

                
                case 3:
                    System.out.println("\n=== DATA PEMINJAMAN ===");
                    for (PeminjamanBuku06 p : peminjamanList) {
                        p.tampilPeminjaman();
                    }
                    break;

                case 4:
                    System.out.println("\n=== DATA DENDA ===");
                    for (PeminjamanBuku06 p : peminjamanList) {
                        p.hitungDenda();
                        p.tampilPeminjaman();
                    }
                    break;

                case 5:
                    // INSERTION SORT descending berdasarkan denda
                    for (int i = 1; i < peminjamanList.length; i++) { // perulangan untuk melakukan sorting menggunakan algoritma insertion sort,
                                                                      //  dimulai dari indeks 1 hingga akhir array peminjamanList
                        PeminjamanBuku06 temp = peminjamanList[i]; // menyimpan elemen saat ini (peminjamanList[i]) dalam variabel sementara temp untuk digunakan dalam proses penyisipan
                        int j = i; 

                        while (j > 0 && peminjamanList[j - 1].denda < temp.denda) { // perulangan while untuk memindahkan elemen-elemen yang memiliki denda lebih kecil dari temp ke posisi yang lebih tinggi dalam array, 
                                                                                 // sehingga elemen dengan denda terbesar akan berada di awal array setelah proses selesai
                            peminjamanList[j] = peminjamanList[j - 1]; 
                            j--;
                        }

                        peminjamanList[j] = temp;
                    }

                    System.out.println("\n=== HASIL SORTING DENDA ===");
                    for (PeminjamanBuku06 p : peminjamanList) { // perulangan for-each untuk menampilkan data peminjaman yang telah diurutkan berdasarkan denda,
                                                                 // dengan memanggil method tampilPeminjaman() untuk setiap objek PeminjamanBuku06 dalam array peminjamanList
                        p.tampilPeminjaman(); // memanggil method
                    }
                    break;

                case 6:
                    // Menu 6 digunakan untuk mencari data peminjaman berdasarkan NIM menggunakan sequential search.
                 System.out.print("Masukkan NIM yang dicari: ");
                    String cari = sc.nextLine();

                     boolean ketemu = false;

                 System.out.println("\n=== HASIL PENCARIAN ===");
    
                 for (PeminjamanBuku06 p : peminjamanList) { // program akan mengecek semua array satu persatu
                   if (p.mhs.nim.equals(cari)) { // utk mencari NIM jika lebih dari 1 maka akan menampilkan semua data yang memiliki NIM tersebut
                   p.tampilPeminjaman();
                     ketemu = true;
                    }
                }
                    if (!ketemu) {
                System.out.println("Data tidak ditemukan");
                }
                break;

                // tugas modifikasi
                case 7:
                System.out.println("\n=== DATA PEMINJAMAN TERLAMBAT ===");

                boolean adaTerlambat = false;
                for (PeminjamanBuku06 p : peminjamanList) {
                    if (p.terlambat > 0) { // hanya tampil yang terlambat
                         p.tampilPeminjaman();
                            adaTerlambat = true;
                         }
                }

                    if (!adaTerlambat) {
                    System.out.println("Tidak ada data peminjaman yang terlambat");
                }
                break;
        }
    } while (pilihan != 0);
    }
}
