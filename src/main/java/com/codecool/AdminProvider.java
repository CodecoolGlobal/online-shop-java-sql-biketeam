package com.codecool;

import com.codecool.dao.BikeDao;
import com.codecool.dao.CategoryDao;
import com.codecool.dao.OrderDao;
import com.codecool.models.Admin;
import com.codecool.models.Category;
import com.codecool.models.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminProvider {
    Admin admin;
    BikeDao bikeDao = new BikeDao();
    CategoryDao categoryDao = new CategoryDao();
    Scanner scan = new Scanner(System.in);


    public AdminProvider(Admin admin) {
        this.admin = admin;
    }

    public void editName(){
        System.out.println("Which brand's name do You want to change? ");
        String oldName = scan.next();
        System.out.println(String.format("Provide new name for %s brand", oldName));
        String newName = scan.next();
        bikeDao.changeBrand(oldName, newName);
    }

    public void changePrice(){
        System.out.println("Which brand's price do You want to change? ");
        String brand = scan.next();
        System.out.println(String.format("Provide new price for %s brand", brand));
        int newPrice = scan.nextInt();
        bikeDao.changePrice(brand, newPrice);
    }

    public void setAvailable(){
        System.out.println("Which brand do You want to set Available or Not Available ");
        String brand = scan.next();
        System.out.println("Set to: [1] Available" +
                "\n        [2] Not Available");
        switch(scan.nextInt()) {
            case 1:
                bikeDao.setActive(brand, true);
                break;
            case 2:
                bikeDao.setActive(brand, false);
                break;
        }
    }

    public void createProduct(){
        System.out.println("Provide brand's name of new bike product: ");
        String newName= scan.next();
        Common common = new Common();
        String type = common.categoryChooser();
        System.out.println("What colour it has? ");
        String newColour= scan.next();
        System.out.println("How many bikes You want to add to supplies? ");
        int newAmount= scan.nextInt();
        System.out.println("What will be the cost of new bike? ");
        int newPrice= scan.nextInt();

        bikeDao.createBike( newName, type, newColour, newAmount, newPrice);

    }

    public void deleteBrand(){
        System.out.println("Which brand do You want to delete? ");
        String brand = scan.next();
        bikeDao.deleteBikes(brand);
    }

    public void updateAmount(){
        System.out.println("Which brand do you want to change amount of bikes? ");
        String brand = scan.next();
        System.out.println("Choose option: [1] Add bikes" +
                        "\n                [2] Remove bikes");
        int chosenOption = scan.nextInt();
        System.out.println("How many bikes do You want to add/remove?");
        int amount = scan.nextInt();
        switch(chosenOption) {
            case 1:
                bikeDao.updateAmountBike(brand, amount);
                break;
            case 2:
                bikeDao.updateAmountBike(brand, -amount);
                break;
        }
    }

        public void editProduct(){
            System.out.println("What do You want to change?" +
                    "\n    [1] Edit name" +
                    "\n    [2] Update amount of bikes" +
                    "\n    [3] Change price");
            switch (scan.nextInt()){
                case 1:
                    editName();
                    break;
                case 2:
                    updateAmount();
                    break;
                case 3:
                    changePrice();
                    break;
            }
    }

        public void createCategory(){
            System.out.println("You are creating new category, there are already this bike types in database: ");
            List<Category> categories = categoryDao.getCategories();
            for (Category category : categories){
                System.out.println(category.getCategory());
            }
            System.out.println("Provide new category: ");
            categoryDao.createCategory(scan.next());
        }

//    public void printBikesTableForAdmin(){
//        List<Bike> bikes = bikeDao.getBikes();
//        System.out.println("~~ Our Bikes to sell: ~~");
//        for (Bike bike : bikes) {
//            System.out.println(bike.getId() + " " + bike.getBrand() + " | " + bike.getType() + " | " + bike.getColor() + " | In stock: " + bike.getInStock() + " | Price: " + bike.getPrice() + " | " + bike.getIsAvailable() );
//        }
//    }

    public void showOrders(){
        OrderDao orders = new OrderDao();
        List<Order> ord = orders.getOrders();
        for (Order o: ord){
            System.out.println(o.getOrderId() +".  |Bike ID: " + o.getBikeId()+ " |Customer ID: " + o.getCustomerId() +" |Order status: " + o.getStatus());
        }
    }

    public void changeStatus(){
        OrderDao orders = new OrderDao();
        List<Order> ord = orders.getOrders();
        Common common = new Common();
        int chosenOne = 0;
        do{
        System.out.println("Which order You want to change status? ");
        chosenOne = scan.nextInt();
        } while (chosenOne <= 0 || chosenOne > ord.size());
        int stat = common.statusChooser();
        orders.changeStatus(stat, chosenOne);
    }


    public void adminsMenu() throws SQLException {
        Common common = new Common();
        boolean isRunning = true;
        while (isRunning) {
            UI.menuForAdmin();
            System.out.println("Choose option: ");
            switch (scan.nextInt()){
                case 1:
                    createCategory();
                    break;
                case 2:
                    UI ui = new UI();
                    ui.displayBikes();
                    editName();
                    break;
                case 3:
                    UI ui2 = new UI();
                    ui2.displayBikes();
                    setAvailable();
                    break;
                case 4:
                    deleteBrand();
                    break;
                case 5:
                    createProduct();
                    break;
                case 6:
                    UI ui3 = new UI();
                    ui3.displayBikes();
                    editProduct();
                    break;
                case 7:
                    showOrders();
                    break;
                case 8:
                    showOrders();
                    changeStatus();
                    break;
                case 0:
                    isRunning = false;
            }
        }
    }
}
