/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19oknavlad;

import entity.Customer;
import entity.History;
import entity.Product;
import tools.manager.CustomerManager;
import tools.manager.HistoryManager;
import tools.manager.ProductManager;
import tools.saver.CustomerSaver;
import tools.saver.HistorySaver;
import tools.saver.ProductSaver;

import java.util.Scanner;

class App {
    private Product[] products = new Product[10];
    private Customer[] customers = new Customer[10];
    private History[] histories = new History[10];
    private ProductManager productManager = new ProductManager();
    private CustomerManager customerManager = new CustomerManager();
    private HistoryManager historyManager = new HistoryManager();
    private ProductSaver productSaver = new ProductSaver();
    private CustomerSaver customerSaver = new CustomerSaver();
    private HistorySaver historySaver = new HistorySaver();

    public App() {
        products = ProductSaver.loadProducts();
    }

    public void run() {
        System.out.println("Магазин окон");
        System.out.println();
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Выберите программу: ");
            System.out.println();
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить окна");
            System.out.println("2. Список окон");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Купить товар");
            System.out.print("Выберите задачу: ");
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println();
                    System.out.println("0. Выйти из магазина");
                    System.out.println();
                    System.out.println("|Конец программы|");
                    repeat = false;
                    break;
                case "1":
                    System.out.println();
                    System.out.println("1. Добавить окна");

                    Product product = ProductManager.createProduct();
                    productManager.addProductToArray(product, products);
                    ProductSaver.saveProducts(products);

                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("2. Список окон");

                    productManager.printListProducts(products);

                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    System.out.println("3. Добавить покупателя");

                    Customer customer = customerManager.createCustomer();
                    customerManager.addCustomerToArray(customer, customers);
                    customerSaver.saveReaders(customers);

                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    System.out.println("4. Список покупателей");
                    System.out.println();

                    customerManager.printListCustomers(customers);

                    break;
                case "5":
                    System.out.println();
                    System.out.println("5. Купить окна");

                    History history = historyManager.takeOnProduct(products, customers);
                    historyManager.addHistoryToArray(history,histories);
                    historySaver.saveHistories(histories);

                    System.out.println();
                    break;
            }
        } while(repeat);
    }
}

