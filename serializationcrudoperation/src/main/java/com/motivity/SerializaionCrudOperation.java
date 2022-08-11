package com.motivity;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SerializaionCrudOperation {
    private static Connection con;

    private static String str="C:\\Users\\Sandeep\\Desktop\\New folder\\sample.txt";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/motivity","root","root");
        if(con==null){
            System.out.println("connection not established");
        }
        else{
            System.out.println("connection established");
        }
        return con;
    }
    public static List<Student> getElements(Connection con) throws SQLException
    {
        List<Student>li=new ArrayList<>();
        Student student;
        PreparedStatement ps =con.prepareStatement("select *from student");
        ResultSet rs =ps.executeQuery();
        while(rs.next())
        {
            student =new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setBranch(rs.getString(3));
            student.setGender(rs.getString(4));
            student.setPassword(rs.getString(5));
            li.add(student);
        }
        return li;
    }
    public static Student selectElementById(int id) throws SQLException, IOException, ClassNotFoundException
    {
        Student student=null;
        List<Student> list=objectRetriving();
        for (Student student1 : list)
        {
            if( id==student1.getId()){
                return student=student1;
            }

        }
        return student;
    }
    public static String deleteElementById(int id,Connection con) throws SQLException, IOException
    {
        String result;
        PreparedStatement ps=con.prepareStatement("delete from student where id =?");
        ps.setInt(1,id);
        int a=ps.executeUpdate();
        if(a==1){
            result="delete successful";
            objectStateTransfer();
        }
        else {
            result="not deleted";
        }
        return result;
    }
    public static String insertStudent(int id,String name,String branch,String gender,String passowrd,Connection con) throws SQLException, IOException
    {
        String result;
        PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?)");
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setString(3,branch);
        ps.setString(4,gender);
        ps.setString(5,passowrd);
        int a=ps.executeUpdate();
        if(a==1) {
            result="inserted successful";
            objectStateTransfer();
        }
        else{
            result="not inserted";
        }
        return result;

    }
    public static String updateName(String name,String updatename,Connection con) throws SQLException, IOException {
        String result;
        PreparedStatement ps=con.prepareStatement("update student set name=? where name=?");
        ps.setString(1,updatename);
        ps.setString(2,name);
        int a=ps.executeUpdate();
        if(a==1){
            result="update successful";
            objectStateTransfer();
        }
        else {
            result="not updated";
        }
        return result;
    }
    public static void objectStateTransfer() throws SQLException, IOException {
        List<Student> li=getElements(con);
        FileOutputStream fileOutputStream=new FileOutputStream(str);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(li);
        System.out.println("object entered into file");
    }
    public static List<Student> objectRetriving() throws SQLException, IOException, ClassNotFoundException {
        objectStateTransfer();
        File file=new File(str);
        List<Student> list=new ArrayList<>();
        if(file.length()==0){
            System.out.println("file is empty");
        }
        else {
            FileInputStream fileInputStream = new FileInputStream(str);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List) objectInputStream.readObject();
            System.out.println("object readed from the file");
        }
        return list;
    }
    public static void showAll() throws SQLException, IOException, ClassNotFoundException {
        List<Student> list=objectRetriving();
        for (Student student:list){
            System.out.println(student);
        }
    }
}
