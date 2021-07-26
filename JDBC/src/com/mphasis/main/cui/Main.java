package com.mphasis.main.cui;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
     static Logger logger;
    static {
        logger = Logger.getLogger(Main.class.getName());
    }
    public static void main(String[] args) {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin://localhost:1521:ORCL","hr","12345678");
            connection.setAutoCommit(false);
           logger.log(Level.INFO,"Connected");
           preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?)");
           preparedStatement.setString(1,"anil");
           preparedStatement.setString(2,"pass");
           preparedStatement.setString(3,"A");
           int row = preparedStatement.executeUpdate();
           connection.commit();
           if (row>0){
               logger.log(Level.INFO,"Table updated");
           }

            //Systemt).out.println("Connected");
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally{
            try {
               // if(resultSet != null && !resultSet.isClosed())
                //    resultSet.close();
                if(preparedStatement != null && !preparedStatement.isClosed())
                    preparedStatement.close();
                if(connection != null && !connection.isClosed())
                    connection.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
