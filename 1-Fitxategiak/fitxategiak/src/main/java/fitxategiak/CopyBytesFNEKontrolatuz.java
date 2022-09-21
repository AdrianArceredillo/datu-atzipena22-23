package fitxategiak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesFNEKontrolatuz {
    public static void main(String[] args) throws IOException {
        
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("gegerg.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
            
        } 
        
        catch (FileNotFoundException e1) {  
            // e1.printStackTrace();  
            System.out.println("Ez da fitxategia aurkitu. ");            
        } 
        catch (IOException ioe) {
            ioe.printStackTrace();
        } 
        finally {
            
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}
