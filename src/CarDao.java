import java.sql.*;

public class CarDao {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/car_library" ;
    private final static String USER = "root";
    private final static String PASS  = "Totti10totti";

    public void createTable() throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();
        String createTable = ""
                + "CREATE TABLE car ("
                + "car_id int NOT NULL AUTO_INCREMENT,"
                + "brand_id int,"
                + "model varchar(255), "
                + "color varchar(255),"
                + "year_of_production int,"
                + "price double,"
                + "PRIMARY KEY (car_id),"
                + "KEY car_FK (brand_id),"
                + "CONSTRAINT car_FK FOREIGN KEY (brand_id) REFERENCES brand (brand_id) )" ;

        statement.executeUpdate(createTable);
        connection.close();
        System.out.println("Table created");
    }
    public void insertCar(Car car) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();
        String insertQuery = ""
                + "INSERT INTO car"
                + "(brand_id,model,color,year_of_production,price)"
                + "VALUES ( '" + car.getBrand_id() + "','" + car.getModel() + "','" + car.getColor() + "', '" + car.getYearOdProduction() + "' , '" + car.getPrice() + "' )" ;

        statement.executeUpdate(insertQuery);
        connection.close();
        System.out.println("Table populated");
    }
    public void printAllCar() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String printQuery = "SELECT * FROM car;";
        ResultSet rs = statement.executeQuery(printQuery);
        while(rs.next()){
            System.out.println("Model = " + rs.getString("model"));
            System.out.println("Color = " + rs.getString("color"));
            System.out.println("Year of production = " + rs.getString("year_of_production"));
            System.out.println("Price = " + rs.getString("price"));
            System.out.println("Brand ID = " + rs.getString("brand_id"));
        }
        connection.close();
    }
    public void updateCar(Car car, Integer carId) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();
        String updateQuery = ""
                + "UPDATE car"
                + "SET model = '" + car.getModel() + "' , color = '" + car.getColor() + "' , year_of_production = '" + car.getYearOdProduction() + "' , price = '" + car.getPrice() + "' "
                + "WHERE car_id = '" + carId+ "';";
        statement.executeUpdate(updateQuery);
        connection.close();
        System.out.println("Table updated");
    }

    public void deleteCar(Integer carId) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();
        String deleteQuery = "DELETE FROM car"
                + "WHERE car_id = '" + carId +"'; ";
        statement.executeUpdate(deleteQuery);
        connection.close();
        System.out.println("Car deleted");
    }
    public void deleteallCar() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();
        String deleteQuery = "TRUNCATE car;";
        statement.executeUpdate(deleteQuery);
        connection.close();
        System.out.println("Table cleaned completely");
    }
}