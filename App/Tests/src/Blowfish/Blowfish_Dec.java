import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Blowfish_Dec {
	public static void main(String[] args) throws Exception {

    // Token value from encrypted file
		String token = "rUeOutxhmL";

    // reading the salt
		FileInputStream saltFis = new FileInputStream("salt.enc");
		byte[] salt = new byte[8];
		saltFis.read(salt);
		saltFis.close();

		// reading the iv
		FileInputStream ivFis = new FileInputStream("iv.enc");
		byte[] iv = new byte[8];
		ivFis.read(iv);
		ivFis.close();

    // Generating instance of Algorithm / Cipher
		SecretKeyFactory factory = SecretKeyFactory
				.getInstance("PBKDF2WithHmacSHA1");
		KeySpec keySpec = new PBEKeySpec(token.toCharArray(), salt, 65536,
				256);
		SecretKey tmp = factory.generateSecret(keySpec);
		SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "Blowfish");

		// file decryption
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
		FileInputStream fis = new FileInputStream("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Tests/bin/Enc/file1_BF.des");
		FileOutputStream fos = new FileOutputStream("/home/jon/Desktop/cs600-610/Senior-Thesis/App/Tests/bin/Dec/file1_BF_Dec.txt");
		byte[] in = new byte[64];
		int read;
		while ((read = fis.read(in)) != -1) {
			byte[] output = cipher.update(in, 0, read);
			if (output != null)
				fos.write(output);
		}

		byte[] output = cipher.doFinal();
		if (output != null)
			fos.write(output);
		fis.close();
		fos.flush();
		fos.close();
		System.out.println("File Decrypted.");
	}
}
