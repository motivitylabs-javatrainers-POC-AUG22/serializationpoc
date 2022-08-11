package com.motivity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Connection con;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
         con=SerializaionCrudOperation.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.insert 2.deletebyid 3.updatebyname  4.selectbyid 5.showall");
        System.out.println("enter your choice");
        int choice = sc.nextInt();
        while (choice < 6 && choice != 0) {

            switch (choice) {
                case 1: {
                    System.out.println("enter id");
                    int id = sc.nextInt();
                    System.out.println("enter name");
                    String name = sc.next();
                    System.out.println("enter branch");
                    String branch = sc.next();
                    System.out.println("enter gender");
                    String gender = sc.next();
                    System.out.println(SerializaionCrudOperation.insertStudent(id, name, branch, gender, con));
                    System.out.println("1.insert 2.deletebyid 3.updatebyname 4selectbyid 5.showall");
                    System.out.println("enter your choice");
                    choice = sc.nextInt();
                    break;
                }
                case 2: {
                    System.out.println("enter you are deleted id");
                    int deleteId = sc.nextInt();
                    System.out.println(SerializaionCrudOperation.deleteElementById(deleteId, con));
                    System.out.println("1.insert 2.deletebyid 3.updatebyname 4.selectbyid 5.showall");
                    System.out.println("enter your choice");
                    choice = sc.nextInt();
                    break;
                }
                case 3: {
                    System.out.println("enter which name to be updated");
                    String selectname = sc.next();
                    System.out.println("enter update name");
                    String updatename = sc.next();
                    System.out.println(SerializaionCrudOperation.updateName(selectname, updatename, con));
                    System.out.println("1.insert 2.deletebyid 3.updatebyname 4.selectbyid 5.showall");
                    System.out.println("enter your choice");
                    choice = sc.nextInt();
                    break;
                }
                case 4: {
                    System.out.println("enter search id");
                    int searchId = sc.nextInt();
                    System.out.println(SerializaionCrudOperation.selectElementById(searchId));
                    System.out.println("1.insert 2.deletebyid 3.updatebyname 4.selectbyid 5.showall");
                    System.out.println("enter your choice");
                    choice = sc.nextInt();
                    break;
                }
                case 5: {
                    SerializaionCrudOperation.showAll();
                    System.out.println("1.insert 2.deletebyid 3.updatebyname 4.selectbyid 5.showall");
                    System.out.println("enter your choice");
                    choice = sc.nextInt();
                    break;

                }
            }
        }
    }
}
