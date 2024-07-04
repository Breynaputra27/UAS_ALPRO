package database;

import java.util.ArrayList;

public class fixedStruk extends Struk {
    private int fidStruk;
    private String fnamaCustomer;
    private customer customers;
    private int fhargaTotal;
    private int fjumlah;
    private menu fMenu;
    private ArrayList<Struk> objekStruk;

    // buat set/ngisi
    public fixedStruk setidStruk(int fidStruk) {
        this.fidStruk = fidStruk;
        return this;
    }

    public void setMenu() {
        this.fMenu = fMenu;
    }

    public fixedStruk setnamaCustomer(String fnamaCustomer) {
        this.fnamaCustomer = fnamaCustomer;
        return this;
    }

    public fixedStruk sethargaTotal(int fhargaTotal) {
        this.fhargaTotal = fhargaTotal;
        return this;
    }

    public fixedStruk setJumlah(int fjumlah) {
        this.fjumlah = fjumlah;
        return this;
    }

    // buat manggil data yang di isi
    public int getidStruk() {
        return fidStruk;
    }

    public String getnamaCustomer() {
        return fnamaCustomer;
    }

    public int gethargaTotal() {
        return fhargaTotal;
    }

    public menu getMenu() {
        return this.fMenu;
    }

    public int getJumlah() {
        return fjumlah;
    }

    public fixedStruk setDetilPenjualans(ArrayList<Struk> objekStruk) {
        this.objekStruk = objekStruk;
        return this;
    }

    public ArrayList<Struk> getStruks() {
        return objekStruk;
    }

    public fixedStruk setCustomer(customer customers) {
        this.customers = customers;
        return this;
    }

    public customer getCustomer() {
        return customers;
    }
}
