package com.codecool;

import com.codecool.dao.CategoryDao;
import com.codecool.dao.StatusDao;
import com.codecool.models.Category;
import com.codecool.models.Status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Common {

    public String getDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public String categoryChooser() {
        Scanner scan = new Scanner(System.in);
        CategoryDao categoryDao = new CategoryDao();
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
                }
            }
        } while (chosen <= 0 || chosen> options.size());
        return type;
    }

    public int statusChooser() {
        Scanner scan = new Scanner(System.in);
        StatusDao statusDao = new StatusDao();
        List<Status> options = statusDao.getStatuses();
        System.out.println("Choose bike status from list: ");
        int type = 0;
        int chosen = 0;
        do {
            for (Status status : options) {
                System.out.println(" [" + status.getStatusID() + "] " + status.getOrdStatus());
            }
            chosen = scan.nextInt();
            for (Status status: options) {
                int temp = status.getStatusID();
                if (temp == chosen) {
                    type = status.getStatusID();
                }
            }
        } while (chosen <= 0 || chosen > options.size());
        return type;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
