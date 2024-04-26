import java.util.Scanner;

abstract class AlatMusik {
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

    // Metode abstrak tambahInfo
    public abstract void tambahInfo();

    public void tambahInfo(String deskripsi) {
        System.out.println("Deskripsi: " + deskripsi);
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Harga: Rp" + (int) harga;
    }
}

class AlatTiup extends AlatMusik {
    public AlatTiup(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public void tambahInfo() {
        System.out.println("Jenis: Tiup");
    }
}

class AlatPetik extends AlatMusik {
    public AlatPetik(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public void tambahInfo() {
        System.out.println("Jenis: Petik");
    }
}

public class Djaya {
    static final int MAX_ALAT_MUSIK = 100; // Maksimum jumlah alat musik yang dapat disimpan
    static AlatMusik[] daftarAlatMusik = new AlatMusik[MAX_ALAT_MUSIK];
    static int jumlahAlatMusik = 0; // Jumlah alat musik yang saat ini disimpan
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
        if (jumlahAlatMusik < MAX_ALAT_MUSIK) {
            System.out.println("Jenis alat musik:");
            System.out.println("1. Alat Tiup");
            System.out.println("2. Alat Petik");
            System.out.print("Pilih jenis alat musik (1-2): ");
            int jenis = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Masukkan nama alat musik: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan harga alat musik: ");
            double harga = scanner.nextDouble();

            if (jenis == 1) {
                AlatTiup alatTiup = new AlatTiup(nama, harga);
                daftarAlatMusik[jumlahAlatMusik++] = alatTiup;
            } else if (jenis == 2) {
                AlatPetik alatPetik = new AlatPetik(nama, harga);
                daftarAlatMusik[jumlahAlatMusik++] = alatPetik;
            }

            System.out.println("Alat musik berhasil ditambahkan.");
        } else {
            System.out.println("Maaf, sudah mencapai batas maksimal jumlah alat musik yang dapat disimpan.");
        }
    }

    static void lihatDaftarAlatMusik() {
        System.out.println("=== Daftar Alat Musik ===");
        if (jumlahAlatMusik == 0) {
            System.out.println("Tidak ada alat musik dalam daftar.");
        } else {
            for (int i = 0; i < jumlahAlatMusik; i++) {
                AlatMusik alatMusik = daftarAlatMusik[i];
                System.out.println((i + 1) + ". " + alatMusik.toString());
                alatMusik.tambahInfo();
            }
        }
    }

    static void updateAlatMusik() {
        lihatDaftarAlatMusik();

        if (jumlahAlatMusik > 0) {
            System.out.print("Pilih nomor alat musik yang akan diupdate: ");
            int nomor = scanner.nextInt();
            scanner.nextLine();

            if (nomor >= 1 && nomor <= jumlahAlatMusik) {
                AlatMusik alatMusik = daftarAlatMusik[nomor - 1];
                System.out.print("Masukkan nama baru: ");
                String namaBaru = scanner.nextLine();
                System.out.print("Masukkan harga baru: ");
                double hargaBaru = scanner.nextDouble();

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

        if (jumlahAlatMusik > 0) {
            System.out.print("Pilih nomor alat musik yang akan dihapus: ");
            int nomor = scanner.nextInt();
            scanner.nextLine();

            if (nomor >= 1 && nomor <= jumlahAlatMusik) {
                for (int i = nomor - 1; i < jumlahAlatMusik - 1; i++) {
                    daftarAlatMusik[i] = daftarAlatMusik[i + 1];
                }
                jumlahAlatMusik--;

                System.out.println("Alat musik berhasil dihapus.");
            } else {
                System.out.println("Nomor alat musik tidak valid.");
            }
        }
    }
}
