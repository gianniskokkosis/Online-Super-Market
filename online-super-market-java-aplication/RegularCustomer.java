
import java.util.Date;

public class RegularCustomer extends Customer {

    private BonusCard card;

    public RegularCustomer(int customerId, String name, String userame, String password) {
        super(customerId, name, userame, password);
        card = new BonusCard(199);
    }

    public void menuRegularCustomer() {
        System.out.println("**Menu**");
        System.out.println("1. Change password");
        System.out.println("2. Print Bonus Points");
        System.out.println("3. Print Available Products");
        System.out.println("4. Buy Products");
        System.out.println("5. Print Previous Transactions");
        System.out.print("Make a choice :");
    }

    public void printProductsForRegularCustomers() {
        for (Product product : Product.product) {
            if (product != null) {
                if (product.getNumberOfProducts() > 0) {
                    System.out.println(product);
                }
            }
        }
    }

    public void printBonusPoints(String username, String password) {
        Customer customer;
        customer = super.check(username, password);
        final int discountPoints = 200;
        int difference = 0;
        int bonus = 0;
        if (customer instanceof RegularCustomer) {
            if (((RegularCustomer) customer).card.getPoints() >= 200) {
                System.out.println("You have reached 200 points!");
            } else {
                difference = 200 - ((RegularCustomer) customer).card.getPoints();
                System.out.println("You have, " + ((RegularCustomer) customer).card.getPoints() + " you need " + difference + " to get 20% discount");
            }

        }
    }

    public void printPreviousTransactions() {
        Date date = receipt.getDate();
        double cost = receipt.getTotalCost();
        int sum = calculatePreviousTransactions();
        System.out.println("Date of issue : " + date + ", Total cost " + cost + ", Bought items " + sum);
    }

    public int calculatePreviousTransactions() {
        int sum = 0;
        int b[][] = receipt.getPurchasedProd();
        for (int[] b1 : b) {
            sum = sum + b1[1];
        }
        return sum;
    }

    public int calculateBonusPoints() {
        double totalCost = receipt.getTotalCost();
        int bonusPoints = 0;
        int pointCounter = 0;
        while (totalCost != 0.0) {
            totalCost /= 3;
            pointCounter++;
            bonusPoints = card.getPoints() + pointCounter;
        }
        card.setPoints(bonusPoints);
        return pointCounter;
    }
}
