package com.codecool;

import com.codecool.dao.BikeDao;
import com.codecool.dao.CategoryDao;
import com.codecool.models.Admin;
import com.codecool.models.Category;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminProvider {
    Admin admin;
    BikeDao bikeDao = new BikeDao();
    CategoryDao categoryDao = new CategoryDao();
    Scanner scan = new Scanner(System.in);
    UI print = new UI();

    public AdminProvider(Admin admin) {
        this.admin = admin;
    }

    public AdminProvider() { }

    public void editName(){
        System.out.println("Which brand's name do You want to change? ");
        String oldName = scan.next();
        System.out.println(String.format("Provide new name for &s brand", oldName));
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
        String type = categoryChooser();
        System.out.println("What colour it has? ");
        String newColour= scan.next();
        System.out.println("How many bikes You want to add to supplies? ");
        int newAmount= scan.nextInt();
        System.out.println("What will be the cost of new bike? ");
        int newPrice= scan.nextInt();

        bikeDao.createBike( newName, type, newColour, newAmount, newPrice);

    }

    private String categoryChooser() {
        List<Category> options = categoryDao.getCategories();
        System.out.println("Choose bike category from list: ");
        String type = null;
        int chosen = 0;
        do {
            for (Category category : options) {
                System.out.println("[" + category.getID() + "]" + category.getCategory());
            }
            chosen = scan.nextInt();
            for (Category category : options) {
                int temp = category.getID();
                if (temp == chosen) {
                    type = category.getCategory();
                } else {

                }
            }
        } while (chosen <= 0 || chosen> options.size());
        return type;
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

    public void adminsMenu() throws SQLException {
        boolean isRunning = true;
        while (isRunning) {
            print.menuForAdmin();
            print.displayBikes();
            System.out.println("Choose option: ");
            switch (scan.nextInt()){
                case 1:
                    createCategory();
                    break;
                case 2:
                    editName();
                    break;
                case 3:
                    setAvailable();
                    break;
                case 4:
                    deleteBrand();
                    break;
                case 5:
                    createProduct();
                    break;
                case 6:
                    editProduct();
                    break;
                case 7:
                    //TODO
                case 8:
                    //TODO
                case 9:
                    //TODO

            }
        }
    }
}
