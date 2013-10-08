package chapplication.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class TFileWriter {
    private static String fileName;
    public TFileWriter(String name){
        fileName=name;
    }
    public void write(String s){
        Writer out = null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
        }
       BufferedWriter writer=new BufferedWriter(out);
        try {
            try {
                writer.write(s);
                writer.newLine();
            } catch (IOException e) {
            }
        }
        finally {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
    }
    public void write(ArrayList<String> strings){
        Writer out = null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
        }
        BufferedWriter writer=new BufferedWriter(out);
        try{
            for(String s:strings){
                try {
                    writer.write(s);
                    writer.newLine();
                } catch (IOException e) {
                }
            }
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
    }
    public void write(String[] strings){
        Writer out = null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
        }
        BufferedWriter writer=new BufferedWriter(out);
        try{
            for(String s:strings){
                try {
                    writer.write(s);
                    writer.newLine();
                } catch (IOException e) {
                }
            }
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
    }
}
