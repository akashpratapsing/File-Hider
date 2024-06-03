package org.example.views;



import org.example.dao.DataDAO;
import org.example.model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView
{

    private String email;
    public UserView(String email) {
        this.email = email;
    }

    public void home(){

        do {
            System.out.println("Welcome : " + this.email);
            System.out.println("Press 1 to show Hidden file");
            System.out.println("Press 2 to Hide a file");
            System.out.println("Press 3 to unhide file");
            System.out.println("Press 0 to EXIT");

            Scanner sc = new Scanner(System.in);
            int ch = Integer.parseInt(sc.nextLine());

            switch (ch)
            {
                case 1 -> {
                    try {
                        List<Data> files = DataDAO.getAllFiles(this.email);
                        System.out.println("ID - File Name");
                        for (Data file : files){
                            System.out.println(file.getId() + " - " + file.getFileName());
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> {
                    System.out.println("Enter The File Path : ");
                    String fPath = sc.nextLine();
                    File f = new File(fPath);
                    Data file = new Data(0,f.getName(), fPath, this.email);
                    try {
                        DataDAO.fileHide(file);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    List<Data> files = null;
                    try {
                        files = DataDAO.getAllFiles(this.email);

                        System.out.println("ID - File Name");
                        for (Data file : files){
                            System.out.println(file.getId() + " - " + file.getFileName());
                        }
                        System.out.println("Enter the file id to unhide : ");
                        int id = Integer.parseInt(sc.nextLine());
                        boolean isValidId = false;

                        for (Data file : files){
                            if (file.getId() == id){
                                isValidId = true;
                                break;
                            }
                        }
                        if (isValidId){
                            DataDAO.unHide(id);
                        }else {
                            System.out.println("Wrong ID");
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                case 0 -> System.exit(0);
            }

        }while (true);
    }
}