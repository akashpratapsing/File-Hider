package org.example.views;


import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.services.GenrateOTP;
import org.example.services.SendOTPService;
import org.example.services.UserService;


import java.sql.SQLException;
import java.util.Scanner;
import java.util.SortedMap;

public class Welcome {

    public void welcomeScreen(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to The App\nPress To Perform following operations\n");
        System.out.println("1. To Login");
        System.out.println("2. To SingUp");
        System.out.println("0. To Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();


        switch (choice){

            case 1 -> login();
            case 2 -> signUp();
            case 0 -> System.exit(0);
            default -> System.out.println("You've made Invalid choice");

        }

    }

    private void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.nextLine();
        System.out.println("Enter email : ");
        String email = sc.nextLine();

        String genOTP = GenrateOTP.getOTP();
        SendOTPService.sendOTP(email, genOTP);

        System.out.println("Enter OTP : ");
        String otp = sc.nextLine();

        if (otp.equals(genOTP)){
            User user = new User(name, email);
            int response = UserService.saveUser(user);

            switch (response){
                case 0 -> System.out.println("User already exist");
                case 1 -> System.out.println("User Registered ");
            }
        }else {
            System.out.println("Wrong OTP");
        }


    }

    private void login() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email");
        String email = sc.nextLine();

        try {
            if (UserDAO.isUserExist(email)){
                String genOTP = GenrateOTP.getOTP();
                SendOTPService.sendOTP(email, genOTP);

                System.out.println("Enter OTP : ");
                String otp = sc.nextLine();

                if (otp.equals(genOTP)){
                    new UserView(email).home();
                }else {
                    System.out.println("Wrong OTP");
                }
            }else {
                System.out.println("User not found ");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}