package App.Interface;
// Import packages, API drivers, and corresponding functions
import java.io.*;
import java.util.*;

import DPE.*;

public class Interface{

  public static void main(String[] args) {

    System.out.println("Welcome message");
    System.out.println();

    // Initalize scanner for user input
    Scanner scan = new Scanner(System.in);

    // Specifies users choice of platform stores if for later use
    System.out.println("Do you utilize (Dropbox) or (Google Drive) for your storage?");
    String platform = scan.nextLine();
    System.out.println();

    // Specifies users goal uploading / downloading files
    System.out.println("Do you want to (upload) a file or (download) a file?");
    String goal = scan.nextLine();
    System.out.println();

    if (goal.equals("upload")){
      System.out.println("Listing all available files for uploading:");
      File inputfolder = new File("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Input");
        File[] listOfFiles = inputfolder.listFiles();

      for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
          System.out.println("File " + listOfFiles[i].getName());
        }
      }

      System.out.println();
      System.out.println("Please choose the file you wish to upload by entering its name and extension.");
      String file = scan.nextLine();
      // store users choice as a parameter

      System.out.println();
      System.out.println("Do you wish to encrypt your file before uploading?");
      String enc = scan.nextLine();

        if(enc.equals("yes")){
          //AES_Encrypt encrypt = new AES_Encrypt();
          // Call AES_Enc on the users chosen file and provide the token

          // Then call upload of intended platform
          // logic for DB upload w/ encryption
          // logic for GD upload w/ encryption
          // success message and break
        } else if(enc.equals("no")){
          // Call upload of intended platform
          // logic for DB upload
          // logic for GD upload
          // success message and break
        }
  }
}
}
