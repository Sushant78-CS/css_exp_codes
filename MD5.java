import java.security.MessageDigest;
import java.util.Scanner;

public class MD5 {

    // Function to generate MD5 hash
    public static String getHash(String input) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] hashBytes = md.digest(input.getBytes());

            // Convert bytes to hexadecimal
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {

                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1)
                    hexString.append('0');

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String message = sc.nextLine();

        // Generate original MD5 hash
        String md5Hash = getHash(message);

        System.out.println("\n--- Hash Value ---");
        System.out.println("MD5 Hash : " + md5Hash);

        // Verify message
        System.out.print("\nEnter message again for verification: ");
        String verifyMessage = sc.nextLine();

        String verifyHash = getHash(verifyMessage);

        System.out.println("\nVerification MD5 Hash : " + verifyHash);

        // Verify integrity
        if (md5Hash.equals(verifyHash)) {
            System.out.println("Data Integrity Verified (No Change)");
        } else {
            System.out.println("Data Integrity Compromised (Data Modified)");
        }

        sc.close();
    }
} 