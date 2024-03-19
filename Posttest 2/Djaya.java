import java.util.ArrayList;
import java.util.Scanner;

class AlatMusik {
    private String nama;
    private double harga;

    public AlatMusik(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

public class Djaya {
    static ArrayList<AlatMusik> daftarAlatMusik = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("=== Toko Alat Musik ===");
            System.out.println("1. Tambah Alat Musik");
            System.out.println("2. Lihat Daftar Alat Musik");
            System.out.println("3. Update Alat Musik");
            System.out.println("4. Hapus Alat Musik");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahAlatMusik();
                    break;
                case 2:
                    lihatDaftarAlatMusik();
                    break;
                case 3:
                    updateAlatMusik();
                    break;
                case 4:
                    hapusAlatMusik();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia. Silakan pilih menu 1-5.");
            }

        } while (pilihan != 5);
    }

    static void tambahAlatMusik() {
        System.out.print("Masukkan nama alat musik: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga alat musik: ");
        double harga = scanner.nextDouble();

        AlatMusik alatMusik = new AlatMusik(nama, harga);
        daftarAlatMusik.add(alatMusik);

        System.out.println("Alat musik berhasil ditambahkan.");
    }

    static void lihatDaftarAlatMusik() {
        System.out.println("=== Daftar Alat Musik ===");
        if (daftarAlatMusik.isEmpty()) {
            System.out.println("Tidak ada alat musik dalam daftar.");
        } else {
            for (int i = 0; i < daftarAlatMusik.size(); i++) {
                AlatMusik alatMusik = daftarAlatMusik.get(i);
                System.out.println((i + 1) + ". " + alatMusik.getNama() + " - Rp" + (int) alatMusik.getHarga());
            }
        }
    }

    static void updateAlatMusik() {
        lihatDaftarAlatMusik();

        if (!daftarAlatMusik.isEmpty()) {
            System.out.print("Pilih nomor alat musik yang akan diupdate: ");
            int nomor = scanner.nextInt();
            scanner.nextLine();

            if (nomor >= 1 && nomor <= daftarAlatMusik.size()) {
                System.out.print("Masukkan nama baru: ");
                String namaBaru = scanner.nextLine();
                System.out.print("Masukkan harga baru: ");
                double hargaBaru = scanner.nextDouble();

                AlatMusik alatMusik = daftarAlatMusik.get(nomor - 1);
                alatMusik.setNama(namaBaru);
                alatMusik.setHarga(hargaBaru);

                System.out.println("Alat musik berhasil diupdate.");
            } else {
                System.out.println("Nomor alat musik tidak valid.");
            }
        }
    }

    static void hapusAlatMusik() {
        lihatDaftarAlatMusik();

        if (!daftarAlatMusik.isEmpty()) {
            System.out.print("Pilih nomor alat musik yang akan dihapus: ");
            int nomor = scanner.nextInt();
            scanner.nextLine();

            if (nomor >= 1 && nomor <= daftarAlatMusik.size()) {
                AlatMusik alatMusik = daftarAlatMusik.remove(nomor - 1);
                System.out.println("Alat musik '" + alatMusik.getNama() + "' berhasil dihapus.");
            } else {
                System.out.println("Nomor alat musik tidak valid.");
            }
        }
    }
}
