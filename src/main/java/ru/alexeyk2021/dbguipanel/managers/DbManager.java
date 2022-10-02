package ru.alexeyk2021.dbguipanel.managers;

import java.sql.*;


public class DbManager {
    private final String dbUrl = "194.87.239.99";
    private final String dbUser = "alexey";
    private final String dbPassword = "Alexey2002";
    private final String DbName = "test_mirea_db";
    private static DbManager instance;

    private DbManager() {
    }

    public static DbManager getInstance() {
        if (instance == null) {
            instance = new DbManager();
        }
        return instance;
    }

//    public void connect() throws SQLException {


//            ResultSet resultSet = statement.executeQuery("SELECT * FROM client;");
//            ArrayList<Client> clients = new ArrayList<>();
//            while (resultSet.next()) {
//                clients.add(new Client(resultSet));
//            }
//            for (Client client : clients) {
//                System.out.println(client.toString());
//            }


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

//        } catch (SQLException e) {
//            // handle any errors
//            System.out.println("SQLException: " + e.getMessage());
//            System.out.println("SQLState: " + e.getSQLState());
//            System.out.println("VendorError: " + e.getErrorCode());
//        } catch (Exception e) {
//            System.out.println("EXCEPTION " + e.getMessage());
//        }
//        }
//    }

//    public ArrayList<ClientPersonalInfo> getAllClientsData() {
//        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + url + "/" + DbName + "?user=" + user + "&password=" + password)) {
//            Statement statement = conn.createStatement();
//
//            statement.executeUpdate("USE test_mirea_db;");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM personal_info;");
//            System.out.println(resultSet.toString());
//            ArrayList<ClientPersonalInfo> personalInfos = new ArrayList<>();
//            while (resultSet.next()) {
//                personalInfos.add(
//                        new ClientPersonalInfo(
//                                clientId, resultSet.getString("full_name"),
//                                resultSet.getString("passport_data"),
//                                resultSet.getString("login"),
//                                resultSet.getString("password")
//                        )
//                );
//            }
//            return personalInfos;
//        } catch (SQLException e) {
//            // handle any errors
//            System.out.println("SQLException: " + e.getMessage());
//            System.out.println("SQLState: " + e.getSQLState());
//            System.out.println("VendorError: " + e.getErrorCode());
//        } catch (Exception e) {
//            System.out.println("EXCEPTION " + e.getMessage());
//        }
//        return null;
//    }

    public int approveEnter(String login, String password, boolean isAdmin) {
        String selectCmd = "";
        if (isAdmin) selectCmd = "SELECT employee_id, password FROM employee WHERE login = ? ;";
        else selectCmd = "SELECT client_id, password FROM personal_info WHERE login = ? ;";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + dbUrl + "/" + DbName + "?user=" + dbUser + "&password=" + dbPassword)) {
            PreparedStatement statement = conn.prepareStatement(selectCmd);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String passwd = resultSet.getString("password");
                if (passwd.equals(password))
                    return userId;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

}
