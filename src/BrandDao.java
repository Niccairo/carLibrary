import java.sql.*;

public class BrandDao {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/car_library" ;
    private final static String USER = "root";
    private final static String PASS  = "Totti10totti";

    public void createTable() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String tableQuery = ""
                + "CREATE TABLE brand ( "
                + "brand_id int NOT NULL AUTO_INCREMENT,"
                + "name varchar(255),"
                + "nationality varchar(255),"
                + "year_of_birth int,"
                +"PRIMARY KEY (brand_id) );" ;

        statement.executeUpdate(tableQuery);
        connection.close();
        System.out.println("Table Brand created");
    }

    public Integer insertBrand(Brand brand) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String brand1 = ""
                + "INSERT INTO brand"
                + "(name,nationality,year_of_birth)"
                +"VALUES ( '" + brand. getName() + "' , '" + brand.getNationality()+ "' , '" + brand.getYearOfBirth()+ "'); ";

        PreparedStatement ps = connection.prepareStatement(brand1,Statement.RETURN_GENERATED_KEYS);
        ps.execute();
        ResultSet rs = ps.getGeneratedKeys();
        Integer generatedKey = 0;
        if(rs.next()){
            generatedKey = rs.getInt(1);
        }
        connection.close();
        System.out.println("Table populated");
        return generatedKey;
    }

    public void printAllBrand() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String printQuery = "SELECT * FROM brand;";
        ResultSet rs = statement.executeQuery(printQuery);
        while(rs.next()){
            System.out.println("Name" + rs.getString("name"));
            System.out.println("Nationality" + rs.getString("nationality"));
            System.out.println("Year Of Birth" + rs.getString("year_of_birth"));
        }
        connection.close();
    }

    public void updateBrand(Brand brand, Integer brandId) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String updateQuery = ""
                + "UPDATE brand"
                + "SET name = '" + brand.getName() + "' , nationality = '" + brand.getNationality() + "' , year_of_birth = '" + brand.getYearOfBirth() + "' "
                + "WHERE brand_id = '" + brandId+ "'; ";

        statement.executeUpdate(updateQuery);
        connection.close();
        System.out.println("Brand updated");
    }

    public void deleteBrand(Integer brandId) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String deleteQuery = ""
                +"DELETE FROM brand"
                +"WHERE brand_id = '" + brandId + "' ; " ;

        statement.executeUpdate(deleteQuery);
        connection.close();
        System.out.println("Brand delated");
    }

    public void deleteAllBrand() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();

        String deleteQuery = "TRUNCATE brand;";

        statement.executeUpdate(deleteQuery);
        connection.close();
        System.out.println("Table cleaned completely");
    }
}