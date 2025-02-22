package com.kodilla.jdbc;

import com.kodilla.DbManager;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DbManagerTestSuite {

    @Test
    void testConnection() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }
    @Test
    void testSelectUsers() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + ", " + resultSet.getString("FIRSTNAME")
                    + ", " + resultSet.getString("LASTNAME"));
            counter++;
        }
        resultSet.close();
        statement.close();
        assertEquals(17, counter);
    }
    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER
                FROM USERS U JOIN POSTS P ON P.USER_ID = U.ID
                GROUP BY P.USER_ID
                HAVING COUNT(*) > 1;
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FIRSTNAME")+ ", " +
                    resultSet.getString("LASTNAME") + ", " + resultSet.getInt("POSTS_NUMBER"));
            counter++;
        }
        resultSet.close();
        statement.close();
        assertEquals(1, counter);
    }
}
