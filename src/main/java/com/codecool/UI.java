package com.codecool;

import com.jakewharton.fliptables.FlipTable;

public class UI {
    
    private IO io;

    public UI() {
        io = new IO();
    }

    // public static void login() {
    //     String[] headers = {"Welcome to our store!"};
    //     String[][] data = {
    //             {"Please enter your login and password :"}
    //     };
    //     System.out.println(FlipTable.of(headers,data));

   // }

    public static void menuForAdmin(){
        String[] headers = {"Hello Master what you want to do ?"};
        String[][] data = {
            {"1. Creat new product category"},
            {"2. Edit name of the product"},
                {"3. Deactivate product"},
                {"4. Creat new product"},
                {"5. Edit product"},
                {"6. Give a discount"},
                {"7. Status of orders"},
                {"8. See feedback and statistics"}
        };
        System.out.println(FlipTable.of(headers,data));


    }

    public static void menuForUser() {
        String[] headers = {"Hello Customer what you want to do ?"};
        String[][] data = {
                {"1. Add product to basket"},
                {"2. Edit product quantity in my basket"},
                {"3. Remove product from basket"},
                {"4. See your basket"},
                {"5. Place a order"},
                {"6. See your history of orders"},
                {"7. Rate product"}
        };
        System.out.println(FlipTable.of(headers,data));
    }
    public void menuForLoginOrRegister() {
        String[] headers = {"Welcome to BikeShop!"};
        String[][] data ={   
            {"(1) Login"},
            {"(2) Register"}
        };
        System.out.println(FlipTable.of(headers, data));
    }

    public String gatherInput(String message) {
        return io.gatherInput(message);
    }


    
    

}
