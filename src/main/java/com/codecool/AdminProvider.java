package com.codecool;

import com.codecool.dao.BikeDao;
import com.codecool.models.Admin;
import com.codecool.models.Bike;

import java.util.List;
import java.util.Scanner;

public class AdminProvider {
    Admin admin;
    BikeDao bikeDao = new BikeDao();
    Scanner scan = new Scanner(System.in);

    public AdminProvider(Admin admin) {
        this.admin = admin;
    }

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
        System.out.println("What type is it? ");
        String newType= scan.next();
        System.out.println("What colour it has? ");
        String newColour= scan.next();
        System.out.println("How many bikes You want to add to supplies? ");
        int newAmount= scan.nextInt();
        System.out.println("What will be the cost of new bike? ");
        int newPrice= scan.nextInt();

        bikeDao.createBike( newName, newType, newColour, newAmount, newPrice);

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
            }
    }

    public void printBikesTableForAdmin(){
        List<Bike> bikes = bikeDao.getBikes();
        System.out.println("~~ Our Bikes to sell: ~~");
        for (Bike bike : bikes) {
            System.out.println(bike.getId() + " " + bike.getBrand() + " | " + bike.getType() + " | " + bike.getColor() + " | In stock: " + bike.getInStock() + " | Price: " + bike.getPrice() + " " + bike.getIsAvailable() );
        }
    }
    public void adminsMenu(){
        boolean isRunning = true;
        while (isRunning) {
            UI.menuForAdmin();
            printBikesTableForAdmin();
            System.out.println("Choose option: ");
            switch (scan.nextInt()){
                case 1:
                    //TODO
                case 2:
                    editName();
                    break;
                case 3:
                    setAvailable();
                    break;
                case 4:
                    createProduct();
                    break;
                case 5:
                    editProduct();
                    break;
                case 6:
                    //TODO
                case 7:
                    //TODO
                case 8:
                    //TODO

            }
        }
    }
}
