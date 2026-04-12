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
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilihan = sc.nextInt();
            sc.nextLine(); // membersihkan buffer setelah membaca input angka

            switch (pilihan) { // struktur kontrol switch-case untuk menangani berbagai pilihan menu yang dipilih oleh pengguna

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
                    // Bubble sort berdasarkan NIM sebelum binary search
                    for (int i = 0; i < peminjamanList.length - 1; i++) {  // perulangan untuk melakukan sorting menggunakan algoritma bubble sort berdasarkan NIM, dimulai dari indeks 0 hingga indeks kedua terakhir dari array peminjamanList
                        for (int j = i + 1; j < peminjamanList.length; j++) { // perulangan nested untuk membandingkan elemen-elemen dalam array peminjamanList, dimulai dari indeks i + 1 hingga akhir array
                            if (peminjamanList[i].mhs.nim.compareTo(peminjamanList[j].mhs.nim) > 0) { 
                                PeminjamanBuku06 temp = peminjamanList[i];
                                peminjamanList[i] = peminjamanList[j];
                                peminjamanList[j] = temp;
                            }
                        }
                    }

                    System.out.print("Masukkan NIM yang dicari: ");
                    String cari = sc.nextLine(); 

                    int left = 0;
                    int right = peminjamanList.length - 1;
                    boolean ketemu = false;

                    // BINARY SEARCH
                    while (left <= right) { // perulangan while untuk melakukan pencarian menggunakan algoritma binary search, dimulai dengan indeks left di awal array dan indeks right di akhir array, 
                                            // dan terus mempersempit rentang pencarian hingga ditemukan atau rentang pencarian habis
                        int mid = (left + right) / 2; // menghitung indeks tengah (mid) dari rentang pencarian saat ini dengan menjumlahkan indeks left dan right, lalu membaginya dengan 2
                        int hasil = peminjamanList[mid].mhs.nim.compareTo(cari); 

                        if (hasil == 0) {
                            System.out.println("\nData ditemukan:"); 
                            peminjamanList[mid].tampilPeminjaman(); // jika hasil perbandingan adalah 0, berarti NIM yang dicari ditemukan pada indeks mid, 
                            // maka menampilkan data peminjaman yang sesuai dengan NIM tersebut dengan memanggil method tampilPeminjaman()
                            //  pada objek PeminjamanBuku06 yang berada di indeks mid dalam array peminjamanList
                            ketemu = true; 
                            break;
                        } else if (hasil < 0) { // jika hasil perbandingan kurang dari 0, berarti NIM yang dicari lebih besar dari NIM pada indeks mid,
                            
                            left = mid + 1; // mempersempit pencarian ke bagian kanan dengan mengubah nilai left menjadi mid + 1
                        } else {
                            right = mid - 1; // jika hasil perbandingan lebih besar dari 0, berarti NIM yang dicari lebih kecil dari NIM pada indeks mid,
                                              // mempersempit pencarian ke bagian kiri dengan mengubah nilai right menjadi mid - 1
                        }
                    }

                    if (!ketemu) { // jika setelah proses pencarian selesai dan variabel ketemu masih bernilai false, berarti NIM yang dicari tidak ditemukan dalam array peminjamanList,
                                     // maka menampilkan pesan "Data tidak ditemukan"
                        System.out.println("Data tidak ditemukan");
                    }
                    break;
            }

        } while (pilihan != 0);
    }
}