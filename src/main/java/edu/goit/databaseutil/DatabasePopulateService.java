package edu.goit.databaseutil;

import edu.goit.util.FileSQLReader;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {

        DatabaseInitService.main(new String[0]);

        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(FileSQLReader.readFromFile("src/main/java/edu/goit/sql/populate_db.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(new DatabaseQueryService().findMaxSalaryWorker());
        System.out.println(new DatabaseQueryService().findLongestProject());
        System.out.println(new DatabaseQueryService().findMaxProjectClient());
        System.out.println(new DatabaseQueryService().findYoungestOldestWorker());
        System.out.println(new DatabaseQueryService().printProjectPrice());

    }


}
