package edu.goit.databaseutil;

import lombok.Builder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private static Database database;
    private static Connection connection;

    @BeforeAll
    public static void setUp() {
        database = Database.getInstance();
        connection = database.getConnection();
    }

    @AfterAll
    public static void shutDown(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getInstanceTest() {
        assertNotNull(database);
        assertEquals(database, Database.getInstance());
    }

    @Test
    void getConnectionTest() {
        assertNotNull(connection);
        try {
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}