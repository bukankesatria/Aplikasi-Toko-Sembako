/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectuas;
import java.util.Scanner; 

public class ProjectUAS {
    // Menggunakan Static Agar Lebih Rapi
    static String Barang[] = new String[30];
    static int Harga[] = new int[30];
    static int jumlahBarang = 9;
    
    // Menggunakan Array dan Methods
    static void iniSembako() {
        Barang[0] = " Beras        "; Harga[0] = 15000;
        Barang[1] = " Gula         "; Harga[1] = 8000;
        Barang[2] = " Minyak Goreng"; Harga[2] = 20000;
        Barang[3] = " Sirup        "; Harga[3] = 15000;
        Barang[4] = " Mie Instan   "; Harga[4] = 16000;
        Barang[5] = " Air Mineral  "; Harga[5] = 45000;
        Barang[6] = " Tepung Terigu"; Harga[6] = 16000;
        Barang[7] = " Kopi         "; Harga[7] = 13000;
        Barang[8] = " Teh          "; Harga[8] = 6000;
    }
   
    static int pilihBarang = 0, pilihcari = 0, idx = 0, total = 0, bayar = 0;
    static String beliBarang[] = new String[30];
    static int beliharga[] = new int[30];
    static int pcs[] = new int[30];
    static int subtotal[] = new int[30];

    //Mengurutkan Barang sesuai Abjad (Sorting)
    static void sort(String[] Barang, int[] harga) {
        for (int i = 0; i < jumlahBarang; i++) {
            for (int j = 0; j < jumlahBarang - 1; j++) {
                if (Barang[j].compareToIgnoreCase(Barang[j + 1]) > 0) {
                    String temp = Barang[j];
                    Barang[j] = Barang[j + 1];
                    Barang[j + 1] = temp;
                    int h = harga[j];
                    harga[j] = harga[j + 1];
                    harga[j + 1] = h;
                }
            }
        }
    }
    
    static void displayBarang(String[] Barang, int[] harga) {
        System.out.println("\nDaftar Barang : ");
        sort(Barang, Harga);
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.print((i + 1) + ". " + Barang[i] + "   " );
            System.out.println(Harga[i]);
        }
    } 
    
    //Mencari Barang (Searching)
    static String[][] mCari(String[] Barang, int harga[], String cari) {
        String[][] hasil = new String[30][2];
        for (int i = 0; i < jumlahBarang; i++) {
            if (Barang[i].contains(cari)) {
                hasil[idx][0] = Barang[i];
                hasil[idx][1] = String.valueOf(harga[i]);
                idx++;
            }
        }
        return hasil;
    }
    
    
    static String[] bestseller(String[] Barang2, int[] Harga2, int pcs2[]) {
        String[] best = new String[30];
        Barang2 = beliBarang;
        Harga2 = beliharga;
        pcs2 = pcs;
        for (int i = 0; i < jumlahBarang - 1; i++) {
            for (int j = i + 1; j < jumlahBarang; j++) {
                if (pcs2 [i] < pcs2 [j]) {
                    int temp = pcs2[j];
                    pcs2[j] = pcs2[i];
                    pcs2[i] = temp;                  
                    String m = Barang2[j];
                    Barang2[j] = Barang2[i];
                    Barang2[i] = m;
                    int h = Harga2[j];
                    Harga2[j] = Harga2[i];
                    Harga2[i] = h;
                }
            }
        }
        idx = 0;
        System.out.println("Barang Terlaris");
        System.out.println("-------------------------------------");
        System.out.println("No\t Barang\t\tJumlah");      
        for (int i = 0; i < jumlahBarang; i++) {
            if (beliBarang[i] != null) {
                System.out.println((idx + 1) + "\t" + Barang2[i] + "\t" + pcs2[i]);
                idx++;
            }
        }
        return best;
    }
    
    // Program Utama
    public static void main(String[] args) {
        iniSembako();
        Scanner sc = new Scanner (System.in);
        int user = 0, userBarang = 0, pilih = 0;
        boolean pesanlagi = true;
        System.out.println("=========================================");
        System.out.println("||<=>APLIKASI TOKO SEMBAKO RESTU IBU<=>||");
        System.out.println("=========================================");
        do {
            System.out.println("\nPilihan Pengguna");
            System.out.println("1. Kasir");
            System.out.println("2. Admin");
            System.out.println("3. Owner");
            System.out.println("4. Keluar");
            System.out.print("Pilih Anda Ingin Sebagai Apa\t  : ");
            user = sc.nextInt();
            switch (user) {
                
                // Pilihan Menu Kasir
                case 1 :
                    System.out.println("\n======================================");
                    System.out.println("||        ANDA SEKARANG KASIR       ||");
                    System.out.println("======================================");
                    
                    do {
                        System.out.println("\nPilihan Menu Kasir");
                        System.out.println("1. Transaksi Pembelian");
                        System.out.println("2. Keluar");
                        System.out.print("Pilih Menu \t\t\t  : ");
                        userBarang = sc.nextInt();
                        
                        switch (userBarang) {
                            case 1 :
                                total = 0;                                   
                                    while (pesanlagi) {
                                        System.out.println("======================================");
                                        System.out.println("\nTransaksi Pembelian");
                                        System.out.println("1. Daftar Barang");
                                        System.out.println("2. Cari Barang");
                                        System.out.print("Pilih Menu \t\t\t  : ");
                                        pilih = sc.nextInt();
                                        if (pilih == 1) {
                                            System.out.println("======================================");
                                            displayBarang(Barang, Harga);
                                            System.out.print("\nPilih Menu \t\t\t  : ");
                                            pilihBarang = sc.nextInt();
                                            System.out.print("Jumlah pcs \t\t\t  : ");
                                            pcs[idx] = sc.nextInt();
                                            beliBarang[idx] = Barang[(pilihBarang-1)];
                                            beliharga[idx]= Harga[(pilihBarang-1)];
                                            subtotal[idx] = pcs[idx] * beliharga[idx];
                                            idx++;
                                        }
                                        else if (pilih == 2) {
                                            System.out.print("Cari \t\t\t\t  : ");
                                            String cariBarang = sc.next();
                                            String[][] hasilCari = mCari(Barang, Harga, cariBarang);
                                            System.out.println("--------------------------------------");
                                            System.out.println("Hasil Pencarian");
                                            for (int i = 0; i < hasilCari.length ; i++) {
                                                if (hasilCari[i][0] != null) {
                                                    System.out.println((i) + ".\t" + hasilCari[i][0] + "\t" + Integer.parseInt(hasilCari[i][1]));
                                                }
                                            }
                                            System.out.print("Pilih Barang \t\t\t  : ");
                                            pilihcari = sc.nextInt();
                                            System.out.print("Jumlah pcs \t\t\t  : ");
                                            pcs[idx] = sc.nextInt();
                                            beliBarang[idx] = hasilCari[pilihcari][0];
                                            beliharga[idx] = Integer.parseInt(hasilCari[pilihcari][1]);
                                            subtotal[idx] = pcs[idx] * beliharga[idx];
                                            idx++;
                                        } 

                                        System.out.println("\nApakah Anda Ingin Memesan Lagi?");
                                        System.out.print("Tekan 1 Jika Ya atau 2 Jika Tidak : ");
                                        int pesan = sc.nextInt();
                                        if(pesan ==1){
                                            pesanlagi = true;
                                        }
                                        else if(pesan!=1){
                                            break;
                                        }
                                        idx++;
                                    }
                                    System.out.println("\nDaftar Pembelian");
                                    System.out.println("--------------------------------------");
                                    System.out.println("No   Barang       Harga\tJumlah\tSubtotal");
                                    for (int i = 0; i <= idx; i++) {
                                        if (beliBarang[i] != null) {
                                            System.out.print((i+1) + "   " + beliBarang[i]);
                                            System.out.print(beliharga[i]);
                                            System.out.print("\t" + pcs[i]);
                                            System.out.println("\t" + subtotal[i]);
                                            total = total + subtotal[i];
                                            idx++;
                                        }
                                    }
                                    idx++;
                                    System.out.println("-------------------------------------");
                                    System.out.println("Total \t\t\t\t" + total);
                                    System.out.print("Bayar \t\t\t\t");
                                    bayar = sc.nextInt();
                                    System.out.println("Kembali \t\t\t" + (bayar - total));
                                    System.out.println("-------------------------------------");
                                break;
                            default :                              
                                System.out.println("=====================================");
                                System.out.println("||      ANDA BUKAN LAGI KASIR      ||");
                                System.out.println("=====================================");
                                break;
                        } 
                    } while(userBarang != 2);
                    break;
                    
                // Pilihan Menu Admin
                case 2 :
                    System.out.println("\n=====================================");
                    System.out.println("||       ANDA SEKARANG ADMIN       ||");
                    System.out.println("=====================================");
                    
                    do {
                        System.out.println("\nBarang Admin");
                        System.out.println("1. Daftar Barang");
                        System.out.println("2. Tambah Barang");
                        System.out.println("3. Ubah Barang");
                        System.out.println("4. Hapus Barang");
                        System.out.println("5. Keluar");
                        System.out.print("Pilih Menu \t\t\t  : ");
                        userBarang = sc.nextInt();                       
                        System.out.println("=====================================");
                        
                        switch (userBarang) {
                            case 1 :
                                displayBarang(Barang, Harga);
                                break;
                            case 2 : 
                                System.out.println("\nTambah Barang");
                                System.out.println("=====================================");
                                System.out.print("Nama Barang \t\t\t  : ");
                                Barang[jumlahBarang] = sc.next();
                                System.out.print("Harga Barang \t\t\t  : ");
                                Harga[jumlahBarang] = sc.nextInt();
                                System.out.println("Penambahan Berhasil...");
                                jumlahBarang++;
                                break;
                            case 3  :
                                displayBarang(Barang, Harga);
                                System.out.println("Ubah Barang");
                                System.out.println("=====================================");          
                                System.out.print("Nomor Barang \t\t\t : ");
                                int nomorBarang = sc.nextInt();
                                System.out.print("Nama Barang \t\t\t : ");
                                Barang[nomorBarang - 1] = sc.next();
                                System.out.print("Harga Barang \t\t\t : ");
                                Harga[nomorBarang - 1] = sc.nextInt();
                                break;
                            case 4 : 
                                displayBarang(Barang, Harga);
                                System.out.println("Hapus Barang");
                                System.out.println("=====================================");
                                System.out.print("Nama Barang \t\t\t: ");
                                String nama = sc.next();
                                boolean ketemu = false;
                                int idk = -1;
                                for (int i = 0; i < jumlahBarang; i++) {
                                    if (Barang[i].compareToIgnoreCase(nama) == 0) {
                                        ketemu = true;
                                        idk = i;
                                        break;
                                    }
                                }
                                if (ketemu==false) {
                                    System.out.println("Barang Tidak Ada!");
                                }
                                else{
                                    for (int i = idk; i < jumlahBarang - 1; i++) {
                                        Barang[i] = Barang[i + 1];
                                        Harga[i] = Harga[i + 1];  
                                    }
                                    System.out.println("Penghapusan Sukses..");
                                    jumlahBarang--;
                                }
                                break;
                            default :
                                System.out.println("=====================================");
                                System.out.println("||   ANDA KELUAR DARI MENU ADMIN   ||");
                                System.out.println("=====================================");
                                break;                               
                        }                      
                    } while(userBarang != 5);                  
                    break;
                    
                // Pilihan Menu Owner
                case 3 :
                    System.out.println("\n=====================================");
                    System.out.println("||       ANDA SEKARANG OWNER       ||");
                    System.out.println("=====================================");
                    
                    do {
                        System.out.println("\nBarang Owner");
                        System.out.println("1. Laporan Pemasukan");
                        System.out.println("2. Best Seller Barang");
                        System.out.println("3. Keluar");
                        System.out.print("Pilih Menu \t\t\t  : ");
                        userBarang = sc.nextInt();
                        System.out.println("=====================================");
                        
                        switch (userBarang) {
                            case 1 :
                                total = 0;
                                System.out.println("Laporan Pemasukan");
                                System.out.println("-------------------------------------");
                                System.out.println("No  Barang\t Harga   Jumlah  Subtotal");
                                for (int i = 0; i <= idx; i++) {
                                    if (beliBarang[i] != null) {
                                        System.out.print((i+1) + "  " + beliBarang[i]);
                                        System.out.print(beliharga[i]);
                                        System.out.print("   " + pcs[i]);
                                        System.out.println("       " + subtotal[i]);
                                        total = total + subtotal[i];
                                        idx++;
                                    }
                                }
                                System.out.println("-------------------------------------");
                                System.out.println("Total Pemasukan \t\t" + " " +total);
                                break;
                            case 2 :
                                bestseller(Barang, Harga, pcs);
                                break;
                            default :
                                System.out.println("=====================================");
                                System.out.println("||   ANDA KELUAR DARI MENU OWNER   ||");
                                System.out.println("=====================================");
                                break;
                        }                       
                    } while (userBarang != 3);
                    break;
                    
                default :
                    System.out.println("=====================================");
                    System.out.println("||  <=>   ANDA TELAH KELUAR   <=>  ||");
                    System.out.println("=====================================");                
                    break;
            }
        } while(user != 4);
    } 
}
