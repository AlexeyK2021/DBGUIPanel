package ru.alexeyk2021.dbguipanel.managers;

import java.sql.*;


public class DbManager {
    private final String url = "194.87.239.99";
    private final String user = "alexey";
    private final String password = "Alexey2002";
    private final String DbName = "mireaDB";
    private static DbManager instance;

    private DbManager() {
    }

    public static DbManager getInstance() {
        if (instance == null) {
            instance = new DbManager();
        }
        return instance;
    }

    public void connect() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + url + "/" + DbName + "?user=" + user + "&password=" + password)) {
            Statement statement = conn.createStatement();


            ResultSet resultSet = statement.executeQuery("SELECT * FROM test");


//List<User> users=new ArrayList<User>();
//
//while(rs.next()) {
//   User user = new User();
//   user.setUserId(rs.getString("UserId"));
//   user.setFName(rs.getString("FirstName"));
//  ...
//  ...
//  ...
//
//
//  users.add(user);
//}

        } catch (SQLException e) {
            // handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        System.out.println("Connected");
    }
}
