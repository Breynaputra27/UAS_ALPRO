package database;

public class Struk {
    private int idStruk;
    private int hargaTotal;
    private int hargasatuan;
    private int jumlah;
    private menu Menu;

    // buat set/ngisi
    public Struk setidStruk(int idStruk) {
        this.idStruk = idStruk;
        return this;
    }

    public void setMenu(menu Menu) {
        this.Menu = Menu;
    }

    public Struk setHargasatuan(int hargasatuan) {
        this.hargasatuan = hargasatuan;
        return this;
    }

    public Struk sethargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
        return this;
    }

    public Struk setJumlah(int jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    // buat manggil data yang di isi
    public int getidStruk() {
        return idStruk;
    }

    public int gethargaTotal() {
        return hargaTotal;
    }

    public int getHargasatuan() {
        return hargasatuan;
    }

    public menu getMenu() {
        return this.Menu;
    }

    public int getJumlah() {
        return jumlah;
    }
}
