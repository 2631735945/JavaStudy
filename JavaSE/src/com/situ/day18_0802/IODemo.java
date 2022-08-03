package com.situ.day18_0802;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.security.Signature;
import java.util.Arrays;

public class IODemo {

    @Test
    public void testFileReader() {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("io.txt");
            int ch = fileReader.read();
            System.out.println((char) ch);//a
            int ch1 = fileReader.read();
            System.out.println((char) ch1);//b
            int ch2 = fileReader.read();
            System.out.println((char) ch2);//c
            int ch3 = fileReader.read();
            System.out.println((char) ch3);//d
            int ch4 = fileReader.read();
            System.out.println(ch4);//-1

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReader2() {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("io.txt");
            int ch = -1;
            while ((ch = fileReader.read()) != -1) {
                System.out.println((char) ch);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReader3() {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("io.txt");
            char[] buffer = new char[20];
            int length = -1;
            // 将字符读入数组。在某个输入可用、发生 I/O 错误或者已到达流的末尾前，
            // 此方法一直阻塞。读取的字符数，如果已到达流的末尾，则返回 -1
            while ((length = fileReader.read(buffer)) != -1) {
                System.out.println(length);
                System.out.println(Arrays.toString(buffer));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//     Signature  签名
    }

    @Test
    public void testFileReaderWriter() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("io.txt");
            fileWriter = new FileWriter("io_back.txt");
            char[] buffer = new char[20];
            int length = -1;
            while ((length = fileReader.read(buffer)) != -1) {
                System.out.println(length);
                System.out.println(Arrays.toString(buffer));
                // 读出多少就写多少，最后一次读取的数据可能不够buffer数组长度的数据
                fileWriter.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 文本文件复制使用字符流、字节流都可以，但是读取里面的某部分内容用字符流
    // 图片、视频这种文件复制使用字节流
    @Test
    public void testInputOutputStream() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("a.png");
            outputStream = new FileOutputStream("a_back.png");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = inputStream.read(buffer)) != -1) {
                // System.out.println(Arrays.toString(buffer));
                outputStream.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // json、xml
    @Test
    //序列化
    public void testObjectOutputStream() {
        Student student = new Student();
        student.setId(2);
        student.setName("zhangsan");
        student.setAge(23);

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("student");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testObjectInputStream() {

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("student");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace()




            ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
