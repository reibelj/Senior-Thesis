import java.util.*;
import java.io.*;

public class Caesar_Dec {

    // Decrypts cipher using shift
    public static StringBuffer decrypt(String cipher, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public static void main(String[] args) {
      // randomly generated
      int key_value = 17;
      try {
          File enc_file = new File("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Tests/bin/Enc/file1_Caesar_Enc.txt");
          File dec_file = new File("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Tests/bin/Dec/file1_Caesar_Dec.txt");
          Scanner sc = new Scanner(enc_file);
          PrintWriter printer = new PrintWriter(dec_file);
          while(sc.hasNextLine()) {
            String encryptedString = sc.nextLine();
            String decryptedString = decrypt(encryptedString, 26 - key_value).toString();
            printer.write(decryptedString);
            printer.flush();
          }
          printer.close();
      }
      catch(FileNotFoundException e) {
          System.err.println("File not found. Please scan in new file.");
       }
    }
}
