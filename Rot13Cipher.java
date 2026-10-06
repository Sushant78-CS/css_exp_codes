import java.util.Scanner;

public class Rot13Cipher {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text to be encrypted: ");
        String textToEncrypt = sc.nextLine();

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < textToEncrypt.length(); i++) {
            char ch = textToEncrypt.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (((ch - 'A' + 13) % 26) + 'A');
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) (((ch - 'a' + 13) % 26) + 'a');
            }

            encryptedText.append(ch);
        }

        System.out.println("encrypted text: " + encryptedText);
        System.out.println();

        System.out.print("enter the text to be decrypted: ");
        String textToDecrypt = sc.nextLine();

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < textToDecrypt.length(); i++) {
            char ch = textToDecrypt.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (((ch - 'A' + 13) % 26) + 'A');
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) (((ch - 'a' + 13) % 26) + 'a');
            }

            decryptedText.append(ch);
        }

        System.out.println("decrypted text: " + decryptedText);

        sc.close();
    }
}