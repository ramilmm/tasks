package ru.kpfu.itis.jdbc;


import java.io.IOException;
import java.sql.SQLException;

public class TestClass {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        NoteBookWithDB nb = new NoteBookWithDB();
        nb.CreateTable();
        //nb.add(125,"Timur","+79124215329","Lox");
        //nb.add(156,"Dima","+79678531299","Toje lox");
        //nb.add(67,"Ramil","+79177777777","Krasavchik");
        //nb.getAll();
        //nb.deleteByName("Timur");
        //nb.deleteByName("Dima");
        //nb.deleteByName("Ramil");
        //nb.getByFIO("Timur");
        nb.updateById(new Note("RamilEdited","+79241249512","asdas"));
        System.out.println();
        nb.getAll();
        System.out.println();
        //nb.getFirst();
    }
}
