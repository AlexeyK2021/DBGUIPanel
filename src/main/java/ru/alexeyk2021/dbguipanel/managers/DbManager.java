package ru.alexeyk2021.dbguipanel.managers;

import ru.alexeyk2021.dbguipanel.models.AddService;
import ru.alexeyk2021.dbguipanel.models.Client;
import ru.alexeyk2021.dbguipanel.models.Tariff;

import java.sql.*;
import java.util.ArrayList;


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

    public int approveEnter(String login, String password) {
        String selectCmd = "SELECT client_id, password FROM personal_info WHERE login = ? ORDER BY client_id LIMIT 1;";

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

    public Client findByPhoneNumber(String phone_number) {
        String selectClientCmd = "SELECT client_id, balance, phone_number, account_state " +
                "FROM client WHERE phone_number = ? ORDER BY client_id LIMIT 1;";
        String selectTariffCmd = "SELECT * FROM tariff WHERE tariff_id = (SELECT tariff_id FROM client WHERE phone_number = ?);";
        String selectAddServices = "SELECT * FROM add_service WHERE add_service_id IN (" +
                "    SELECT add_service FROM client_add_service WHERE client_id = (" +
                "        SELECT client_id FROM client WHERE phone_number = ?));";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://" + dbUrl + "/" + DbName + "?user=" + dbUser + "&password=" + dbPassword)) {
            PreparedStatement statement = conn.prepareStatement(selectClientCmd);
            statement.setString(1, phone_number);
            ResultSet user = statement.executeQuery();
            user.next();
            Client client = new Client(user);

            statement = conn.prepareStatement(selectTariffCmd);
            statement.setString(1, phone_number);
            ResultSet client_tariff = statement.executeQuery();
            client_tariff.next();

            client.setTariff(new Tariff(client_tariff));

            statement = conn.prepareStatement(selectAddServices);
            statement.setString(1, phone_number);

            ResultSet addServices = statement.executeQuery();
            ArrayList<AddService> adds = new ArrayList<>();

            while (addServices.next()) {
                adds.add(new AddService(addServices));
            }

            client.setAddServiceList(adds);
            return client;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
