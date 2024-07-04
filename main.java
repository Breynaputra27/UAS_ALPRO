import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import database.menu;
import database.Struk;
import database.customer;
import backend.periogi;

class main {
    public static void main(String[] args) {
        int pilih = 0;
        boolean lanjut = true;
        periogi control = new periogi();
        menu menus = new menu();
        control.inputMenu();
        Scanner input = new Scanner(System.in);
        System.out.println("================KEDAI KOPI TEU BISAEUN================");
        System.out.println("Hai selamat datang di aplikasi kami");
        System.out.println();

        System.out.println("================Main Menu Customer================");
        control.daftarCustomer();
        while (lanjut) {
            System.out.print("1 untuk lihat menu | 2 untuk pesan | 3 Untuk pembayaran | 4 untuk keluar: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    control.lihatMenu();
                    break;
                case 2:
                    control.lihatMenu();
                    control.Pemesanan();
                    break;
                case 3:
                    control.Pembayaran();
                    break;
                case 4:
                    lanjut = false;
                    break;
                default:
                    System.out.println("mohon untuk mengisi nomor yang sudah tertera!!!");
                    break;
            }
        }
        System.out.println();
        System.out.println("Sampai jumpa lagi");

    }

}