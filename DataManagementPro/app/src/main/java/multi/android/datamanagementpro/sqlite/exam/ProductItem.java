package multi.android.datamanagementpro.sqlite.exam;

public class ProductItem {
    private String id;
    private String name;
    private String price;
    private String su;
    private String totPrice;

    public ProductItem(String id, String name, String totPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.su = su;
        this.totPrice = totPrice;
    }

    @Override
    public String toString() {
        return  id + ", " +
                name + ", " +
                totPrice;
    }
}
