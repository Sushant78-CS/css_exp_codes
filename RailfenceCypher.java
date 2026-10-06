import java.util.Scanner;

public class RailfenceCypher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Rail Fence Cipher =====");

        System.out.print("Enter the message: ");
        String message = sc.nextLine();

        System.out.print("Enter the number of rails: ");
        int rails = sc.nextInt();

        if (rails <= 1) {
            System.out.println("\nEncrypted Message: " + message);
            System.out.println("Decrypted Message: " + message);
            sc.close();
            return;
        }

        int cycleLength = 2 * (rails - 1);
        int paddingCount = 0;

        StringBuilder paddedMessage = new StringBuilder(message);

        while (paddedMessage.length() % cycleLength != 0) {
            paddedMessage.append('Z');
            paddingCount++;
        }

        String encryptedMessage = encrypt(
            paddedMessage.toString(),
            rails
        );

        String decryptedMessage = decrypt(
            encryptedMessage,
            rails,
            paddingCount
        );

        System.out.println("\n===== Result =====");

        System.out.println("Original Message : " + message);
        System.out.println("Encrypted Message : " + encryptedMessage);
        System.out.println("Decrypted Message : " + decryptedMessage);

        sc.close();
    }

    public static String encrypt(String text, int rails) {

        if (rails <= 1) {
            return text;
        }

        StringBuilder[] rail = new StringBuilder[rails];

        for (int i = 0; i < rails; i++) {
            rail[i] = new StringBuilder();
        }

        int row = 0;
        boolean movingDown = false;

        for (int i = 0; i < text.length(); i++) {

            rail[row].append(text.charAt(i));

            if (row == 0 || row == rails - 1) {
                movingDown = !movingDown;
            }

            row += movingDown ? 1 : -1;
        }

        StringBuilder encryptedText = new StringBuilder();

        for (StringBuilder currentRail : rail) {
            encryptedText.append(currentRail);
        }

        return encryptedText.toString();
    }

    public static String decrypt(
        String cipherText,
        int rails,
        int paddingCount
    ) {

        int length = cipherText.length();

        char[][] matrix = new char[rails][length];

        int row = 0;
        boolean movingDown = false;

        for (int column = 0; column < length; column++) {

            matrix[row][column] = '*';

            if (row == 0 || row == rails - 1) {
                movingDown = !movingDown;
            }

            row += movingDown ? 1 : -1;
        }

        int index = 0;

        for (int i = 0; i < rails; i++) {

            for (int j = 0; j < length; j++) {

                if (matrix[i][j] == '*' && index < length) {
                    matrix[i][j] = cipherText.charAt(index++);
                }
            }
        }

        StringBuilder decryptedText = new StringBuilder();

        row = 0;
        movingDown = false;

        for (int column = 0; column < length; column++) {

            decryptedText.append(matrix[row][column]);

            if (row == 0 || row == rails - 1) {
                movingDown = !movingDown;
            }

            row += movingDown ? 1 : -1;
        }

        return decryptedText.substring(
            0,
            decryptedText.length() - paddingCount
        );
    }
}