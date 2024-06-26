package ru.alexeyk2021.dbguipanel.managers;

import ru.alexeyk2021.dbguipanel.models.*;

import java.sql.*;
import java.util.ArrayList;


public class DbManager {
    private final String dbUrl = "194.87.239.99";
    private final String dbUser = "alexey";
    private final String dbPassword = "Alexey2002";
    private final String DbName = "mireaDB";
    private static DbManager instance;

    private final String connectionString;

    private DbManager() {
        connectionString = "jdbc:mysql://" + dbUrl + "/" + DbName + "?user=" + dbUser + "&password=" + dbPassword;
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

    public Client approveEnter(String login, String password) {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement statement = conn.prepareStatement("call approveEnter(?, ?);");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            return findByPhoneNumber(resultSet.getString(1));

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
        return null;
    }

    public ArrayList<String> findByPartNumber(String phone_number) {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement statement = conn.prepareStatement("call getLikeNumbersList(?);");
            statement.setString(1, phone_number + "%");
            ResultSet numbers = statement.executeQuery();

            ArrayList<String> numberList = new ArrayList<>();
            while (numbers.next()) {
                numberList.add(numbers.getString("phone_number"));
            }
            return numberList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Client findByPhoneNumber(String phone_number) {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement statement = conn.prepareStatement("call selectClientByNumber(?);");
            statement.setString(1, phone_number);
            ResultSet user = statement.executeQuery();
            user.next(); ///????
            Client client = new Client(user);

            statement = conn.prepareStatement("call selectTariffByNumber(?);");
            statement.setString(1, phone_number);
            ResultSet client_tariff = statement.executeQuery();

            client_tariff.next();///????
            client.setTariff(new Tariff(client_tariff));

            statement = conn.prepareStatement("call selectAddServicesByNumber(?);");
            statement.setString(1, phone_number);
            ResultSet addServices = statement.executeQuery();
            ArrayList<AddService> adds = new ArrayList<>();

            while (addServices.next()) {
                adds.add(new AddService(addServices));
            }
            client.setAddServiceList(adds);

            statement = conn.prepareStatement("call selectReportsByNumber(?);");
            statement.setString(1, phone_number);
            ResultSet reports = statement.executeQuery();

            ArrayList<Report> reps = new ArrayList<>();
            while (reports.next()) {
                Report report = new Report(reports);
                report.setCategory(new Category(reports));
                reps.add(report);
            }
            client.setReportList(reps);

            return client;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
