package editor.services;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;


/**
 * Created by godex_000 on 23.07.2014.
 */
public class security {
    private static void main(String[] args) {
        try {
            String key = "squirrel123";

            FileInputStream fis = new FileInputStream("original.txt");
            FileOutputStream fos = new FileOutputStream("encrypted.txt");
            encrypt_file(key, fis, fos);

            FileInputStream fis2 = new FileInputStream("encrypted.txt");
            FileOutputStream fos2 = new FileOutputStream("decrypted.txt");
            decrypt_file(key, fis2, fos2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Шифрувати файл
     *
     * @param key ключ шифрування
     * @param is  вхідний файл
     * @param os  вихідний файл
     * @throws Throwable
     */
    public static void encrypt_file(String key, InputStream is, OutputStream os)
            throws Throwable {
        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
    }

    public static void decrypt_file(String key, InputStream is, OutputStream os)
            throws Throwable {
        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
    }

    public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os)
            throws Throwable {
        String salt = "masterkey";
        salt = salt + key;
        byte[] KeyData = salt.getBytes();
        SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        if (mode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, KS);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            doCopy(cis, os);
        } else if (mode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, KS);
            CipherOutputStream cos = new CipherOutputStream(os, cipher);
            doCopy(is, cos);
        }
    }

    public static void doCopy(InputStream is, OutputStream os)
            throws IOException {
        byte[] bytes = new byte[64];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            os.write(bytes, 0, numBytes);
        }
        os.flush();
        os.close();
        is.close();
    }
}
