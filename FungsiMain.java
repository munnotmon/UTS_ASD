import java.util.Scanner;
public class FungsiMain {
    static Mahasiswa[] daftarMahasiswa = {
        new Mahasiswa("22001", "Ali Rahman", "Informatika"),
        new Mahasiswa("22002", "Budi Santoso", "Informatika"),
        new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis")
    };

    static MataKuliah[] daftarMataKuliah = {
        new MataKuliah("MK001", "Struktur Data", 3),
        new MataKuliah("MK002", "Basis Data", 3),
        new MataKuliah("MK003", "Desain Web", 3)
    };

    static Penilaian[] daftarPenilaian = {
        new Penilaian(daftarMahasiswa[0], daftarMataKuliah[0], 80, 85, 90),
        new Penilaian(daftarMahasiswa[0], daftarMataKuliah[1], 60, 75, 70),
        new Penilaian(daftarMahasiswa[1], daftarMataKuliah[0], 75, 70, 80),
        new Penilaian(daftarMahasiswa[2], daftarMataKuliah[1], 85, 90, 95),
        new Penilaian(daftarMahasiswa[2], daftarMataKuliah[2], 80, 90, 65)
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n==== MENU SISTEM AKADEMIK ====");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    tampilDaftarMahasiswa();
                    break;
                case 2:
                    tampilDaftarMataKuliah();
                    break;
                case 3:
                    tampilSemuaPenilaian();
                    break;
                case 4:
                    sortingPenilaian();
                    break;
                case 5:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String cari = input.next();
                    cariMahasiswa(cari);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    public static void tampilDaftarMahasiswa() {
        for (Mahasiswa mhs : daftarMahasiswa) {
            mhs.tampilMahasiswa();
            System.out.println("----------------------------------------------------------------------");
        }
    }

    public static void tampilDaftarMataKuliah() {
        for (MataKuliah mk : daftarMataKuliah) {
            mk.tampilMataKuliah();
            System.out.println("----------------------------------------------------------------------");
        }
    }

    public static void tampilSemuaPenilaian() {
        for (Penilaian p : daftarPenilaian) {
            p.hitungNilaiAkhir();
            p.tampilPenilaian();
            System.out.println("----------------------------------------------------------------------");
        }
    }

    public static void sortingPenilaian() {
        for (int i = 0; i < daftarPenilaian.length - 1; i++) {
            for (int j = 0; j < daftarPenilaian.length - i - 1; j++) {
                if (daftarPenilaian[j].nilaiAkhir < daftarPenilaian[j + 1].nilaiAkhir) {
                    Penilaian temp = daftarPenilaian[j];
                    daftarPenilaian[j] = daftarPenilaian[j + 1];
                    daftarPenilaian[j + 1] = temp;
                }
            }
        }

        System.out.println("\n=== Mahasiswa Berdasarkan Nilai Akhir (Tertinggi ke Terendah) ===");
        for (Penilaian p : daftarPenilaian) {
            p.hitungNilaiAkhir();
            p.tampilPenilaian();
            System.out.println("----------------------------------------------------------------------");
        }
    }

    public static void cariMahasiswa(String cariNim) {
        boolean ditemukan = false;

        for (Penilaian p : daftarPenilaian) {
            if (p.mahasiswa.nim.equalsIgnoreCase(cariNim)) {
                p.hitungNilaiAkhir();
                p.tampilPenilaian();
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + cariNim + " tidak ditemukan.");
        }
    }
}