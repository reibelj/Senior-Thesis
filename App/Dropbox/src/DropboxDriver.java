/*
    Code written by Professor. Mohan using the Dropbox Developer API Library.
    This class provides the methods such as storing data into dropbox, displaying the
    files and folders in the dropbox location for displaying the data stored in dropbox,
    and download files from dropbox to local machine.

*/


import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.WriteMode;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.files.DownloadErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.FileMetadata;

import java.util.Date;
import java.io.*;




import java.io.IOException;

public class DropboxDriver {
    public void listFilesandFolders(String path, DbxClientV2 client) throws DbxException, IOException{
        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder(path);
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }
            if (!result.getHasMore()) {
                break;
            }
            result = client.files().listFolderContinue(result.getCursor());
        }

    }

    public void listFilesandFoldersRecursive(String path, DbxClientV2 client) throws DbxException, IOException{
        while(true){
            ListFolderResult result = client.files().listFolderBuilder(path)
            .withRecursive(true)
            .start();


            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }
            if(result.getHasMore()){
                result = client.files().listFolderContinue(result.getCursor());
            } else {
                break; //no more entries to process
            }
        }
    }

    public void uploadFile(String filePath, String dropboxPath, DbxClientV2 client){
         // Upload "test.txt" to Dropbox
        try (InputStream in = new FileInputStream(filePath)) {
            FileMetadata metadata = client.files().uploadBuilder(dropboxPath)
                .uploadAndFinish(in);
        } catch(IOException ex){
            System.out.println(ex.toString());
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }

    public void downloadFile(String path, String downloadFileName, DbxClientV2 client){
        try {
            DbxDownloader<FileMetadata> downloader = client.files().download(path);
            FileOutputStream out = new FileOutputStream(downloadFileName);
            downloader.download(out);
            out.close();
        } catch(DownloadErrorException ex1){
            System.out.println(ex1.getMessage());
        } catch (DbxException ex2) {
            System.out.println(ex2.getMessage());
        } catch(IOException ex3){
            System.out.println(ex3.toString());
        } catch(Exception ex4){
            System.out.println(ex4.toString());
        }
    }


    public static void main(String args[]) throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("en_US");
        DbxClientV2 client = new DbxClientV2(config, args[0]);
        String filePath = "/home/jon/Desktop/cs600-610/Senior-Thesis/App/Dropbox/Hello2.txt";
        String dropboxDownloadPath = "/Test/HelloWorld.txt";
        String downloadFileName = "HelloWorld.txt";
        String dropboxUploadPath = "/Test/Hello2.txt";

        DropboxDriver obj = new DropboxDriver();

        obj.downloadFile(dropboxDownloadPath, downloadFileName, client);
        obj.uploadFile(filePath, dropboxUploadPath, client);
        //obj.listFilesandFoldersRecursive("", client);
        //obj.listFilesandFoldersRecursive("/teaching/CMPSC112", client);

    }
}
