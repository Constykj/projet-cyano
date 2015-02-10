/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP USER
 */
public class DAOUtilitaire {

    public static PreparedStatement initialisationRequetePreparee(Connection connection,
            String sql, boolean returnGeneratedKey, Object... objects) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                returnGeneratedKey ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        for (int i = 0; i < objects.length; i++) {
            preparedStatement.setObject(i + 1, objects[i]);
        }
        return preparedStatement;
    }

    public static void fermetureSilencieuse(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Echec a la fermeture du resultSet : " + e.getMessage());
            }
        }
    }

    public static void fermetureSilencieuse(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Echec a la fermeture de la connection : " + e.getMessage());
            }
        }
    }

    public static void fermetureSilencieuse(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Echec a la fermeture du statement : " + e.getMessage());
            }
        }
    }

    public static void fermetureSilencieuse(PreparedStatement prepareStatement) {
        if (prepareStatement != null) {
            try {
                prepareStatement.close();
            } catch (SQLException e) {
                System.out.println("Echec a la fermeture du prepareStatement : " + e.getMessage());
            }
        }
    }

    public static void fermetureSilencieuse(Statement statement, Connection connection) {
        fermetureSilencieuse(statement);
        fermetureSilencieuse(connection);
    }

    public static void fermetureSilencieuse(ResultSet resultSet, Statement statement, Connection connection) {
        
        fermetureSilencieuse(statement);
        fermetureSilencieuse(resultSet);
        fermetureSilencieuse(connection);
    }

}
