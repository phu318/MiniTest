package utils;

import model.IParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static <T> void writeFile(List<T> data, String fileName){
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (T e: data) {
                bufferedWriter.write(e +"\n");
            }
        }catch (Exception e){

        }finally {
            try{
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
    public static boolean checkFileExit(String fileName){
        File file = new  File(fileName);
        return file.exists();

    }
    public static <T> List<T> readFile(String fileName, Class<T> classz ){
        List<T> data = new ArrayList<>();
        try {
            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    Object obj = classz.newInstance();
                    IParser iParser = (IParser) obj;
                    iParser.parse(line);
                    data.add((T) obj);
                } catch (InstantiationException | IllegalAccessException  e) {

                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
         
            e.printStackTrace();
        }
        return data;
    }

}
