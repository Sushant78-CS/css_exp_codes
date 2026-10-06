import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Blowfish {

    // Function to encrypt text
    public static String encrypt(String text, String key) throws Exception {

        SecretKeySpec secretKey =
                new SecretKeySpec(key.getBytes(), "Blowfish");

        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(text.getBytes());

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Function to decrypt text
    public static String decrypt(String encryptedText, String key)
            throws Exception {

        SecretKeySpec secretKey =
                new SecretKeySpec(key.getBytes(), "Blowfish");

        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] encryptedBytes =
                Base64.getDecoder().decode(encryptedText);

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text to be encrypted: ");
        String text = sc.nextLine();

        System.out.print("Enter the secret key: ");
        String key = sc.nextLine();

        // Encryption
        String encryptedText = encrypt(text, key);

        System.out.println("\nEncrypted Text: " + encryptedText);

        // Decryption
        String decryptedText = decrypt(encryptedText, key);

        System.out.println("Decrypted Text: " + decryptedText);

        sc.close();
    }
}