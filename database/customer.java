package database;

public class customer {
    int idCustomer;
    String namaCustomer;

    public customer setIdcustomer(int idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

    public customer setNamacustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
        return this;
    }

    public String getNamacustomer() {
        return namaCustomer;
    }

    public int getIdcustomer() {
        return idCustomer;
    }
}
