package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.Struk;
import database.menu;
import database.customer;
import database.fixedStruk;
import java.util.Scanner;

public class periogi {
    Scanner input = new Scanner(System.in);
    HashMap<Integer, menu> menus = new HashMap<Integer, menu>();
    ArrayList<Struk> objekStruk = new ArrayList<Struk>();
    ArrayList<customer> objekcustomer = new ArrayList<customer>();
    ArrayList<fixedStruk> fStruk = new ArrayList<fixedStruk>();
    HashMap<Integer, customer> customers = new HashMap<Integer, customer>();

    Struk oStruk = new Struk();
    customer ocustomer = new customer();

    public void inputMenu() {
        menu menu1 = new menu();
        menu menu2 = new menu();
        menu menu3 = new menu();
        menu menu4 = new menu();
        menu1.setidMenu(1).setnamaMenu("v60").setharga(25000).setstock(100);
        menu2.setidMenu(2).setnamaMenu("Japanese").setharga(25000).setstock(100);
        menu3.setidMenu(3).setnamaMenu("Americano").setharga(15000).setstock(100);
        menu4.setidMenu(4).setnamaMenu("Vietnam Drip").setharga(15000).setstock(100);
        menus.put(menu1.getidMenu(), menu1);
        menus.put(menu2.getidMenu(), menu2);
        menus.put(menu3.getidMenu(), menu3);
        menus.put(menu4.getidMenu(), menu4);
    }

    public void daftarCustomer() {
        String name;
        int id = 0;
        System.out.println("Sebelum menggunakan program kami silahkan isi data diri terlebih dahulu");
        System.out.print("Masukan Nama anda : ");
        name = input.nextLine();
        System.out.println();
        id++;
        ocustomer.setIdcustomer(id);
        ocustomer.setNamacustomer(name);
        customers.put(id, ocustomer);
    }

    public void penampilDatacustomer() {
        System.out.println("================Keterangan Data Anda================");
        for (Map.Entry<Integer, customer> k : customers.entrySet()) {
            int key = k.getKey();
            customer valuecustomer = k.getValue();
            System.out.print("Kode spesial anda adalah : " + key);
            System.out.println();
            System.out.print("Nama yang anda input adalah : " + valuecustomer.getNamacustomer());
            System.out.println();
            System.out.println("Mohon Untuk Selalu Mengingat kode special anda!!!");
            System.out.println();
        }
    }

    public void lihatMenu() {
        System.out.println();
        System.out.println("================Daftar Menu Kopi================");
        for (Map.Entry<Integer, menu> k : menus.entrySet()) {
            int key = k.getKey();
            menu valuemenu = k.getValue();
            System.out.println("");
            if (valuemenu.getstock() >= 0) {
                System.out.println("Kode Menu           : " + key);
                System.out.println("Nama Menu           : " + valuemenu.getnamaMenu());
                System.out.println("Harga Menu          : " + valuemenu.getharga());
                System.out.println("Stock Yang Tersisa  : " + valuemenu.getstock());
            } else {
                System.out.println("menu ini sedang kosong");
            }
        }
        System.out.println();
    }

    public menu getMenu(int idMenu) {
        return menus.get(idMenu);
    }

    public customer getCustomer(int idCustomer) {
        return customers.get(idCustomer);
    }

    public void Pemesanan() {
        int choice = 0;
        int idIncrement = 0, jml, no, skode;
        do {

            System.out.print("Masukan nomor menu yang akan di pesan     : ");
            no = input.nextInt();
            System.out.print("Masukan jumlah pesanan menu tersebut      : ");
            jml = input.nextInt();
            System.out.print("Ingin pesan lagi? (1=ya 2=tidak)          : ");
            choice = input.nextInt();
            System.out.println();
            idIncrement += 1;

            menu tmenu = getMenu(no);
            Struk setruk = new Struk();
            setruk.setidStruk(idIncrement);
            setruk.setMenu(tmenu);
            setruk.setHargasatuan(tmenu.getharga());
            setruk.setJumlah(jml);
            setruk.sethargaTotal(tmenu.getharga() * jml);
            menus.put(no, tmenu.setstock(tmenu.getstock() - jml));
            objekStruk.add(setruk);

        } while (choice == 1);
        struk(objekStruk);
        ArrayList<Struk> setruk = objekStruk;
        fixedStruk fixpisan = new fixedStruk();
        fixpisan.setDetilPenjualans(setruk);
        fixpisan.setidStruk(fStruk.size() + 1);
        fixpisan.setCustomer(customers.get(1));
        fixpisan.sethargaTotal(HitungTotalPesanan(setruk));

        fStruk.add(fixpisan);

        System.out.println("Total Yang Harus di Bayar Adalah : " + HitungTotalPesanan(setruk));
        System.out.println();
    }

    public void struk(ArrayList<Struk> objekStruk) {
        System.out.println("================Struk Pembayaran================");
        for (Struk s : objekStruk) {
            System.out.println("Menu Yang Dipilih : " + s.getMenu().getnamaMenu());
            System.out.println("Jumlah pesanan      : " + s.getJumlah());
            System.out.println("Total Harga Jual    : " + s.gethargaTotal());
            System.out.println();
        }

        System.out.println();
    }

    public int HitungTotalPesanan(ArrayList<Struk> objekStruk) {
        int total = 0;
        int ftotal = 0;
        for (Struk s : objekStruk) {
            total += s.gethargaTotal();
            ftotal = total * s.getJumlah();
        }
        return total;
    }

    public void Pembayaran() {
        int total = 0, uang, kembalian;
        for (fixedStruk i : fStruk) {
            System.out.println("================Menu Pembayaran================");
            System.out.println();
            System.out.println("Nomor Pesanan : " + i.getidStruk());
            System.out.println("Nama Customer : " + i.getCustomer().getNamacustomer());
            ArrayList<Struk> detilstruk = i.getStruks();
            struk(detilstruk);
            System.out.println("Anda Dikenakan Biaya sebesar : Rp." + i.gethargaTotal());
            System.out.println();
        }
        for (Struk s : objekStruk) {
            total += s.gethargaTotal();
        }
        System.out.println();

        System.out.print("Masukan nominal yang telah di tentukan : ");
        uang = input.nextInt();
        System.out.println();
        if (uang > total) {
            kembalian = uang - total;
            System.out.println();
            System.out.println("Uang anda lebih, kembalian anda : Rp." + kembalian);
            System.out.println("Terimakasih");
        } else if (uang == total) {
            System.out.println();
            System.out.println("Uang anda pas terimakasih");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("uang anda kurang");
            System.out.println();
        }
    }
}
