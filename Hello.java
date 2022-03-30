import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;

public class Hello {
    public static void main(MysqlxDatatypes.Scalar.String[] args) throws SQLException {
//        

        insert(new Customer(1, "Ion_x", "Glanetasu", "Ion", "074444444", "Str Independ",
                "Bucuresti", "625400", "Romania"));




    }

    public static void insert(Customer customer) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `customers` (`id`, `username`, `last_name`, `first_name`, `phone`, `address`, `city`, `postalCode`, `country`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        psw.setInt(1, customer.getID());
        psw.setString(2, customer.getUsername());
        psw.setString(3, customer.getLast_name());
        psw.setString(4, customer.getFirst_name());
        psw.setString(5, customer.getPhone());
        psw.setString(6, customer.getAddress());
        psw.setString(7, customer.getCity());
        psw.setString(8, customer.getPostalCode());
        psw.setString(9, customer.getCountry());
        psw.execute();
    }

    public static void delete(Customer customer) throws SQLException {

        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("DELETE FROM 'customers' WHERE id = ?");

        psw.setInt(1, customer.getID());
        psw.execute();

    }
    public static void getAll(Customer customer) throws SQLException {

        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("SELECT * FROM 'customers'");
        psw.execute();

    }

    public static void getById(Customer customer) throws SQLException {

        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("SELECT * FROM 'customers' WHERE id = ?");
        psw.setInt(1, customer.getID());
        psw.execute();

    }
    public static void Update(int id, String oldValue, String newValue) throws SQLException {

        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        String msg = "UPDATE customers SET " + oldValue + "="+newValue+ " WHERE id = " + id;
        PreparedStatement psw = connection.prepareStatement(msg);
        psw.execute();

    }

    public static void newOrder(Order order) throws  SQLException {

        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `Orders' ('id', 'customer_id', 'status', 'order') VALUES (?, ?, ?, ?);");

        psw.setInt(1, order.getID());
        psw.setInt(2, order.getCustomer_ID());
        psw.setString(3, order.getStatus());
        psw.setString(4, order.getOrder());

        psw.execute();


    }
    public static void customerOrders(Customer customer) throws  SQLException {

        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("SELECT * FROM Orders where customer_id = ?");

        psw.setInt(1, customer.getID());


        psw.execute();


    }
     public static void updateOrder(Order order) throws  SQLException {

            String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(connectionUrl, username, password);

            PreparedStatement psw = connection.prepareStatement("UPDATE Orders SET status = ? WHERE id = ?");

            psw.setString(1, order.getStatus());
            psw.setInt(2, order.getID());


            psw.execute();
        }
        public static void updateStock(Order order) throws  SQLException {

            String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(connectionUrl, username, password);

            PreparedStatement psw = connection.prepareStatement("UPDATE Orders SET Comment = ? WHERE id = ?");

            psw.setString(1, order.getOrder());
            psw.setInt(2, order.getID());


            psw.execute();
        }


}
