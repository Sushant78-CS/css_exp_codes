import java.util.Scanner;

public class AtbashCipher {

    public static String encryptDecrypt(String text) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {

                if (Character.isUpperCase(ch)) {

                    char newChar = (char) ('Z' - (ch - 'A'));
                    result.append(newChar);

                } else {

                    char newChar = (char) ('z' - (ch - 'a'));
                    result.append(newChar);
                }

            } else {

                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(
            System.lineSeparator() != null ? System.in : null
        );

        if (scanner == null)
            return;

        System.out.println("enter the text to be encrypted :");
        String textToEncrypt = scanner.nextLine();

        String encryptedText = encryptDecrypt(textToEncrypt);
        System.out.println(encryptedText);

        System.out.println("enter the text to be decrypted :");
        String textToDecrypt = scanner.nextLine();

        String decryptedText = encryptDecrypt(textToDecrypt);
        System.out.println(decryptedText);

        scanner.close();
    }
}