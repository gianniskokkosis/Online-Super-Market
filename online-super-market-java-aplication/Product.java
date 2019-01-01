
public class Product {

    private int productId;
    private String productName;
    private double productPrice;
    private int numberOfProducts;

    static int number = 0;
    static Product[] product = new Product[20];

    public Product(int productId, String productName, double productPrice, int numberOfProducts) {
        Product.product[number] = this;
        number++;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.numberOfProducts = numberOfProducts;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", numberOfProducts=" + numberOfProducts + '}';
    }

}
