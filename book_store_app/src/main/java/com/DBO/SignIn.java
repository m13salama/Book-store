package com.DBO;

import java.sql.*;

public class SignIn {
    private Connection connection;
    public static int userID;
    public SignIn() {
        connection = DBConnection.createConnection();
    }

    public Boolean run(String email,String password){
        try {
            String str = "Select userId, password from USER_INFORMATION where email = " + "\"" + email + "\"";
            PreparedStatement sql = connection.prepareStatement(str);
            ResultSet resultSet = sql.executeQuery();
            String passw = "";
            while (resultSet.next()){
                passw = resultSet.getString("password");
                userID = resultSet.getInt("userId");
            }
            if(password.equals(passw)){
                return true;
            }
            return false;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
