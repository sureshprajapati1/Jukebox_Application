package DAOimplClasses;

import DAOInterfaces.UserInterface;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserImpl implements UserInterface {
    Scanner sc=new Scanner(System.in);


    @Override
    public  boolean createAccount() {
        boolean flag=false;
        System.out.println("enter ur name");
        String name =sc.next();
        System.out.println("enter ur password");
        String password= sc.next();
        System.out.println("enter ur mobile number");
        String mobileNo=sc.next();
        Connection con= DBCConnection.getCon();
        PreparedStatement pstmt=null;
        try{
            String query="insert into user(user_name,password,mobile_no) values(?,?,?)";
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            pstmt.setString(3,mobileNo);
            pstmt.executeUpdate();
            flag =true;

        }
catch (Exception e){
    System.out.println(e);
}
        finally {
            con=null;
        }

        return flag;
    }



    @Override
    public boolean login(String userName,String password) {
        boolean flag=false;

       Connection con=DBCConnection.getCon();
       try {
           PreparedStatement pspt = con.prepareStatement("select user_name,password from user where 'user_name' =? and 'password'=? ");
           pspt.setString(1, userName);
           pspt.setString(2, password);
           boolean resul = pspt.execute();

           if (resul) {
               System.out.println("login successfully");
               flag = true;
           } else{
               System.out.println("credentials do not match");
               System.exit(0);
           }


       }
catch (Exception e){
    System.out.println(e);
}

        return flag;
    }
}
