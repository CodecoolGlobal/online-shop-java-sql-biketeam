package com.codecool.dao;

import com.codecool.models.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao extends Dao {

    public List<Status> getStatuses() {
        List<Status> statuses = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM Status;");
            while (results.next()) {
                int statusID = results.getInt("Status_ID");
                String ordStatus = results.getString("Ord_Status");
                Status newStatus = new Status(statusID, ordStatus);
                statuses.add(newStatus);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statuses;
    }
}