public class DemoLogin {

    private static final String DB_PASSWORD = "admin123";
    private static final String API_KEY = "demo-api-key-12345";

    public static void main(String[] args) {
        System.out.println("Connecting with password: " + DB_PASSWORD);
        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        while (result.next()) {
            System.out.println(result.getString("username"));
        }
    }

}
