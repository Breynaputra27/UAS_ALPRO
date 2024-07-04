package database;

public class menu {
    private int idMenu;
    private String namaMenu;
    private int harga;
    private int stock;

    // buat set/ngisi
    public menu setidMenu(int idMenu) {
        this.idMenu = idMenu;
        return this;
    }

    public menu setnamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
        return this;
    }

    public menu setharga(int harga) {
        this.harga = harga;
        return this;
    }

    public menu setstock(int stock) {
        this.stock = stock;
        return this;
    }

    // buat manggil data yang di isi
    public int getidMenu() {
        return idMenu;
    }

    public String getnamaMenu() {
        return namaMenu;
    }

    public int getharga() {
        return harga;
    }

    public int getstock() {
        return stock;
    }
}
