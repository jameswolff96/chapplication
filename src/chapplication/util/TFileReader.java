package chapplication.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author timothy.chandler
 * @date Sep 16, 2013
 */
public class TFileReader {
    private String loc;
    public TFileReader(String loc){
        this.loc=loc;
    }
    public ArrayList readFile() throws FileNotFoundException{
        FileInputStream fis=new FileInputStream(loc);
        ArrayList<String> buffer=new ArrayList<>();
        try(Scanner scanner = new Scanner(fis)) {
            while(scanner.hasNext()){
                buffer.add(scanner.nextLine());
            }
        }
        return buffer;
    }
}
