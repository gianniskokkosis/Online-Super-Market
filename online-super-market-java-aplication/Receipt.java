
import java.util.Date;

public class Receipt {

    private int receiptId;
    private RegularCustomer customer;
    private Date date;
    private double totalCost;
    private int[][] purchasedProd;
    public RegularCustomer cust = null;
    static Receipt[] receipt = new Receipt[20];
    BonusCard b = new BonusCard();

    public Receipt(int receiptId, RegularCustomer customer, Date date, double totalCost, int[][] purchasedProd) {
        this.receiptId = receiptId;
        this.customer = customer;
        this.date = date;
        this.totalCost = totalCost;
        this.purchasedProd = purchasedProd;
    }

    public Receipt() {
        this.cust = getCustomer();
    }

    public int getReceiptId() {
        return receiptId;
    }

    public RegularCustomer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int[][] getPurchasedProd() {
        return purchasedProd;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public void setCustomer(RegularCustomer customer) {
        this.customer = customer;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setPurchasedProd(int[][] purchasedProd) {
        this.purchasedProd = purchasedProd;
    }

    public void printReceipt(RegularCustomer customer) {
        System.out.println("Receipt#" + getReceiptId() + "#");
        System.out.println("Date of issue: " + getDate());
        for (int[] purchasedProd1 : purchasedProd) {
            double cost = 0.0;
            int j = 0;
            while (Product.product[j] != null) {
                if (Product.product[j].getProductId() == purchasedProd1[0]) {
                    System.out.println("|" + Product.product[j].getProductName() + "     " + Product.product[j].getProductPrice() + "|");
                    cost = Product.product[j].getProductPrice() * purchasedProd1[1] + cost;
                    System.out.println("|" + "x" + purchasedProd1[1] + "     " + cost + "|");
                    break;
                }
                j++;
            }
        }
        if (getCustomer() == null) {
            System.out.println("|" + "Cost : " + getTotalCost() + "|");
            System.out.println("Total Cost : " + getTotalCost());
        } else {
            System.out.println("Today you have earned " + customer.calculateBonusPoints() + " points and you reached 200 points! You get 20% discount.");
            int a = b.getPoints() - 200;//Edw kanonika kanw thn aferaish twn pontwn gia na vrw to ipoloipo tous... Parola auta den mou vgazei to ipoloipo kai mou vgazei panta 0.
            if (a < 0) {
                a = 0;
            }
            System.out.println("You have now " + a + " points.");
            double total = getTotalCost() - getTotalCost() * 0.2;
            setTotalCost(total);
            System.out.println("Total Cost : " + getTotalCost());
        }

    }

    public double calculateTotalCost() {
        double total = 0.0;
        for (int[] purchasedProd1 : purchasedProd) {
            int j = 0;
            while (Product.product[j] != null) {
                if (Product.product[j].getProductId() == purchasedProd1[0]) {
                    total = total + Product.product[j].getProductPrice() * purchasedProd1[1];
                }
                j++;
            }
        }
        return total;
    }

}
