//KOKKOSIS IOANNIS A.M. 8160190
//PAPATHANASIOU DIMITRIOS A.M. 8170206

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        generate();
        Customer c1;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("-- DMST SUPERMARKET --");
            System.out.println("Log in to continue.");
            System.out.print("username : ");
            String username = input.nextLine();
            System.out.print("\npassword : ");
            String password = input.nextLine();
            System.out.println();
            int id = 0;
            c1 = Customer.check(username, password);
            int choice;
            if (c1 instanceof RegularCustomer) {
                RegularCustomer r1 = (RegularCustomer) c1;
                do {
                    r1.menuRegularCustomer();
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            r1.changePassword();
                            break;
                        case 2:
                            r1.printBonusPoints(username, password);
                            break;
                        case 3:
                            r1.printProductsForRegularCustomers();
                            break;
                        case 4:
                            r1.buyProducts(r1);
                            break;
                        case 5:
                            r1.printPreviousTransactions();
                            break;
                        default:
                            break;
                    }
                } while (choice != 0);
            } else if (c1 instanceof Customer) {

                do {
                    final RegularCustomer cust = null;
                    c1.menuCustomer();
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            c1.changePassword();
                            break;
                        case 2:
                            c1.printProductsForCustomers();
                            break;
                        case 3:
                            c1.buyProducts(cust);
                            break;
                        default:
                            break;
                    }
                } while (choice != 0);
            }
        } while (c1 == null);

    }

    public static void generate() {
        Customer customer1 = new Customer(1, "Giannis Kokkosis", "gkokkosis", "john98");
        Customer customer2 = new Customer(3, "Aggeliki Tserpe", "agts", "aek");
        RegularCustomer customer3 = new RegularCustomer(3, "Dimitris Papathanasiou", "dimipapa", "pao");
        Product product1 = new Product(1, "Vodka", 25.6, 0);
        Product product2 = new Product(2, "Cheese", 13.2, 300);
        Product product3 = new Product(3, "Baycon", 4.04, 150);
        Product product4 = new Product(4, "Prada Luna Rosa", 80.0, 40);
        Product product5 = new Product(5, "Milk", 1.2, 1000);
        Product product6 = new Product(6, "Wine", 22.6, 250);
        Product product7 = new Product(7, "Beer barel 3L", 30.0, 100);
        Product product8 = new Product(8, "Tost bread", 1.0, 2000);
        Product product9 = new Product(9, "Johnnie Walker Golden Label", 120.0, 50);
        Product product10 = new Product(10, "Coca cola zero", 0.9, 900);
        Receipt receipt = new Receipt();
    }
}
