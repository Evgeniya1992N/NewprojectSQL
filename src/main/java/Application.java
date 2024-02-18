import java.sql.*;
public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "Mydog2021Till";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM books")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfBook = resultSet.getInt("book_id");
                System.out.println("ID книги: " + idOfBook);

                String titleOfBook = resultSet.getString("title");
                int authorOfBook = resultSet.getInt("author_id");
                int amountOfBook = resultSet.getInt("amount");

                System.out.println("Название: " + titleOfBook);
                System.out.println("ID автора: " + authorOfBook);
                System.out.println("Количество: " + amountOfBook);
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
            // Исключение для обработки возможных ошибок при подключении
        }
    }
}
