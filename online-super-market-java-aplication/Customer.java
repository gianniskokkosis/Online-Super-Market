
import java.util.Scanner;
import java.util.Date;

public class Customer {

    private int customerId;
    private String name;
    private String userame;
    private String password;
    Product p = new Product();
    private static int number = 0;
    static Customer[] customer = new Customer[20];
    int[][] values = new int[20][2];//pimakas pou mpanoun oi agores tou xristi

    Scanner input = new Scanner(System.in);
    Receipt receipt = new Receipt();
    BonusCard b = new BonusCard();

    public Customer(int customerId, String name, String userame, String password) {
        Customer.customer[number] = this;
        number++;
        this.customerId = customerId;
        this.name = name;
        this.userame = userame;
        this.password = password;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getUserame() {
        return userame;
    }

    public String getPassword() {
        return password;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserame(String userame) {
        this.userame = userame;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", name=" + name + ", userame=" + userame + ", password=" + password + '}';
    }

    public void menuCustomer() {
        System.out.println("Welcome *" + getName() + "*");
        System.out.println("**Menu**");
        System.out.println("1. Change password");
        System.out.println("2. Print Products");
        System.out.println("3. Buy Products");
        System.out.print("Make a choice :");
    }

    public void changePassword() {
        boolean changed = false;
        while (changed != true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("**Change Password**");
            System.out.print("Enter the new password :");
            String password1 = scanner.next();
            System.out.print("\nRewrite the same password :");
            String password2 = scanner.next();
            System.out.println();
            if (!(password1.equals(getPassword())) && (password1.equals(password2))) {
                setPassword(password1);
                changed = true;
                System.out.println("Password has been changed!");
            } else {
                System.out.println("Passwords do not match, try again");
            }
        }
        menuCustomer();
    }

    public static Customer check(String username, String password) {
        int i = 0;
        while (Customer.customer[i] != null) {
            if (username.equals(Customer.customer[i].getUserame()) && password.equals(Customer.customer[i].getPassword())) {
                return customer[i];
            }
            i++;
        }
        return null;
    }

    public void printProductsForCustomers() {
        int i = 0;
        while (Product.product[i] != null) {
            System.out.println(Product.product[i]);
            i++;
        }
    }

    public Product checkProduct(int code) {
        int i = 0;
        boolean find = false;
        while (Product.product[i] != null) {
            if (Product.product[i].getProductId() == code) {
                find = true;
                if (Product.product[i].getNumberOfProducts() > 0) {
                    return Product.product[i];
                } else {
                    System.out.println("Product " + Product.product[i].getProductName() + " is not available");
                    break;
                }
            }
            i++;
        }
        if (find == false) {
            System.out.println("Product does not exist, try again");
            System.out.println("Enter Product id:");
            code = input.nextInt();
        }
        return null;
    }

    public Product checkQivenQuantity(int code, int ammount) {
        int i = 0;
        while (Product.product[i] != null) {
            if (Product.product[i].getProductId() == code) {
                if (ammount < Product.product[i].getNumberOfProducts()) {
                    return Product.product[i];
                }
                break;
            }
            i++;
        }
        return null;
    }

    public void buyProducts(RegularCustomer customer) {
        System.out.println("Enter product id : ");
        int id = input.nextInt();
        int[][] valuesOfProducts = null;

        while (id != -1) {
            checkProduct(id);
            System.out.println("Enter quantity :");
            int quantity = input.nextInt();
            Product check = checkQivenQuantity(id, quantity);
            if (check == null) {
                System.out.println("The maximum quantity you can buy is :" + p.getNumberOfProducts());
            } else {
                valuesOfProducts = insertValuesIntoArray(id, quantity);
                int newQuantity = refreshProducts(id, quantity);
                p.setNumberOfProducts(newQuantity);
            }
            System.out.println("Enter product id :");
            id = input.nextInt();
        }
        int[][] arrayOfPurchasedProducts;
        arrayOfPurchasedProducts = compressArray(valuesOfProducts);
        receipt.setPurchasedProd(arrayOfPurchasedProducts);
        double cost = 0.0;
        cost = receipt.calculateTotalCost();
        receipt.setTotalCost(cost);
        Date date = new java.util.Date(System.currentTimeMillis());
        receipt.setDate(date);
        Receipt r = new Receipt(1, customer, date, cost, arrayOfPurchasedProducts);
        r.printReceipt(customer);
    }

    public int[][] insertValuesIntoArray(int code, int amount) {//Methodos pou eisagei ta stoixeia ton agorasmenwn prointwn ston pinaka values[20][2]
        for (int[] value : values) {
            if (value[0] == 0) {
                if (value[1] == 0) {
                    value[0] = code;
                    value[1] = amount;
                    break;
                }
            }
        }
        return values;
    }

    public int[][] compressArray(int[][] a) {//Methodos pou siriknwnei ton pinaka values gia na exei stoixeia oses kai oi agores tou xristi
        int countProducts = 0;
        int compressArray[][];

        for (int[] a1 : a) {
            if (a1[0] != 0 && a1[1] != 0) {
                countProducts++;
            }
        }

        compressArray = new int[countProducts][2];
        for (int j = 0; j < compressArray.length; j++) {
            compressArray[j][0] = a[j][0];
            compressArray[j][1] = a[j][1];
        }
        return compressArray;
    }

    public int refreshProducts(int code, int amount) {
        int i = 0;
        int newQuantity = 0;
        while (Product.product[i] != null) {
            if (Product.product[i].getProductId() == code) {
                int quantity = Product.product[i].getNumberOfProducts();
                newQuantity = quantity - amount;
            }
            i++;
        }
        return newQuantity;
    }

}
