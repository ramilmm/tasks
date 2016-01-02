package com.fujitsu.fs.javalab.fcsv.cli;

import com.fujitsu.fs.javalab.fcsv.parser.CSVParser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FCSV {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path;
        File file;
        while (true){
            path = sc.next();
            file = new File(path);
            if (!file.exists()){
                System.out.println("Тестового файла не существует или путь указан неверно!");
            }else if(!file.isFile()){
                System.out.println("Путь указан неверно!Укажите путь до файла!");
            }else  if(!file.canRead()){
                System.out.println("Недостаточно прав для чтения файла!");
            }else break;
        }

        CSVParser parser = null;
        try {
            parser = new CSVParser(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка в создании объекта CSV Parser");
        }
        String[] row;
        try {
            while ((row = parser.nextRow()) != null) {
                for (String cell : row) {
                    System.out.format("%-40s",cell);
                }
                System.out.print("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
