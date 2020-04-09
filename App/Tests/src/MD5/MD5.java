import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class MD5 {
    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Driver code
    public static void main(String args[]) throws NoSuchAlgorithmException {
      try {
          File input = new File("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Tests/bin/file1.txt");
          File output = new File("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Tests/bin/Enc/file1_MD5.txt");
            Scanner sc = new Scanner(input);
            PrintWriter printer = new PrintWriter(output);
            while(sc.hasNextLine()) {
              String originalString = sc.nextLine();
              String encryptedString = getMd5(originalString);
              printer.write(encryptedString);
              printer.flush();
            }
            printer.close();


      }
      catch(FileNotFoundException e) {
          System.err.println("File not found. Please scan in new file.");
       }
  }
}
