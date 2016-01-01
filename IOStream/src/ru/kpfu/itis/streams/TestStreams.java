package ru.kpfu.itis.streams;

import ru.kpfu.itis.orders.Customer;
import java.io.*;
import java.util.Date;

/**
 * @author Gataullin Kamil
 * 16.08.2014 22:30:47
 */
public class TestStreams {

    public static void main(String[] args) {

        try {
//            testDataIO();

//            testTextIO();

            testObjectsIO();

//            testFiles();

//            testDoc();

//            testWriteInEnd1();

//            testWriteInEnd2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testDataIO() throws IOException {
        // Объявляя таким образом потоки записи в блоке try они будут закрыты сами автоматически
        try (FileOutputStream fout = new FileOutputStream("./testData.dat");      // Запись байтовых массивов
             DataOutputStream dout = new DataOutputStream(fout)) {                // Запись в примитивных типах данных
            dout.writeBoolean(true);
            dout.writeDouble(Math.PI);
            dout.writeLong(System.currentTimeMillis());
        }

        // Объявляя таким образом потоки чтения в блоке try они будут закрыты сами автоматически
        try (FileInputStream fin = new FileInputStream("./testData.dat");         // Чтение байтовых массивов
             DataInputStream din = new DataInputStream(fin)) {                    // Чтение в примитивных типах данных
            boolean b = din.readBoolean();
            System.out.println(b);
            double d = din.readDouble();
            System.out.println(d);
            long l = din.readLong();
            System.out.println(l);
        }
    }

    private static void testTextIO() throws IOException {
        try (FileOutputStream fin = new FileOutputStream("./testText.txt");
             PrintWriter pw = new PrintWriter(fin)) {                // Поток записи для текстовых файлов
            pw.write("Welcome\n");
            pw.write("Все люди делятся на 10 категорий - те, кто понимает двоичную систему счисления, и остальные.");
        }

        try (FileReader fr = new FileReader("./testText.txt");
             BufferedReader br = new BufferedReader(fr)) {           // Поток чтения для текстовых файлов по строчкам
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void testObjectsIO() throws IOException, ClassNotFoundException {
        try (FileOutputStream fout = new FileOutputStream("./testObjects.dat");
             ObjectOutputStream out = new ObjectOutputStream(fout)) {        // Поток для записи (сериализации) объектов
            out.writeObject(new Date());
            out.writeObject(new Customer(1L, "Customer 1"));
        }

        try (FileInputStream fin = new FileInputStream("./testObjects.dat");
             ObjectInputStream oin = new ObjectInputStream(fin)) {           // Поток для чтения (сериализации) объектов
            Date date = (Date) oin.readObject();
            System.out.println(date);
            Customer customer = (Customer) oin.readObject();
            System.out.println(customer.getName());
            while (true) {
                try {
                    Object o = oin.readObject();
                    System.out.println(o);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("END OF FILE");
        }
    }

    private static void testFiles() throws IOException {
        File file = new File("./");
        boolean exists = file.exists();
        System.out.println(exists);
        if (!exists) {           // Если объект не существует
            file.mkdirs();       // то создать его (директорию)
        }
        boolean isDir = file.isDirectory();       // Если этот файл является директорией (папкой), то true, иначе false, т.е. файл
        System.out.println(isDir);
        if (isDir) {
            File[] files = file.listFiles();      // Получаем список поддиректорий (папок и файлов)
            for (File child : files) {
                System.out.println(child.getCanonicalPath());  // Получаем их адреса и выводим их на экран
            }
        }
    }

    private static void testDoc() throws IOException {
        //Создаём объект файла
        File flt = new File("document.doc");
        //Объект, позволяющий осуществить запись в файл
        FileWriter wrt = new FileWriter(flt);
        CharSequence cq = "welcome to future";
        wrt.append(cq);
        wrt.append("\nnew line");
        //Собственно здесь и происходит сама запись в файл
        wrt.flush();
        System.out.println("Output is generated in a file document.doc");

        flt = new File("dz-labs.txt");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(flt)));
        out.print("Welcome to DZ-Labs");
        out.println(" line 1");
        out.print("line 2");
        out.flush();
        System.out.println("Output is generated in a file dz-labs.txt");

        flt = new File("another_text_file");
        flt.createNewFile();
        System.out.println("An unknown extension file another_text_file is created");
    }

    private static void testWriteInEnd1() {
        try {
            FileWriter sw = new FileWriter("./testText.txt", true);
            sw.write("Add this text to the end of datafile by FileWriter" + "\n");
            sw.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static void testWriteInEnd2() {
        PrintStream out = null;
        try {
            out = new PrintStream(
                    new BufferedOutputStream(
                            new FileOutputStream("./testText.txt")));
            out.println("Add this text to the end of datafile by FileOutputStream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}