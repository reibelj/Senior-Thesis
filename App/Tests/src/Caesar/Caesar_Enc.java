import java.util.*;
import java.io.*;

public class Caesar_Enc {
    // Encrypts text using shift
    public static StringBuffer encrypt(String text, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public static void main(String[] args) {
      // randomly generated
      int random_shiftCount = 17;
      try {
          File input_file = new File("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Tests/bin/file1.txt");
          File enc_file = new File("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Tests/bin/Enc/file1_Caesar_Enc.txt");
          Scanner sc = new Scanner(input_file);
          PrintWriter printer = new PrintWriter(enc_file);
          while(sc.hasNextLine()) {
            String originalString = sc.nextLine();
            String encryptedString = encrypt(originalString, random_shiftCount).toString();
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
