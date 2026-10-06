import java.util.Scanner;

public class DiffieHellman {

    // Function to compute (base^exp) % mod
    public static long power(long base, long exp, long mod) {

        long result = 1;
        base = base % mod;

        while (exp > 0) {

            if (exp % 2 == 1)
                result = (result * base) % mod;

            exp = exp >> 1;
            base = (base * base) % mod;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Public values
        System.out.print("Enter prime number (p): ");
        long p = sc.nextLong();

        System.out.print("Enter primitive root (g): ");
        long g = sc.nextLong();

        // Private keys
        System.out.print("Enter private key of User A: ");
        long a = sc.nextLong();

        System.out.print("Enter private key of User B: ");
        long b = sc.nextLong();

        // Compute public keys
        long A = power(g, a, p); // g^a mod p
        long B = power(g, b, p); // g^b mod p

        // Compute shared secret keys
        long keyA = power(B, a, p); // (g^b)^a mod p
        long keyB = power(A, b, p); // (g^a)^b mod p

        System.out.println("\n--- Results ---");

        System.out.println("Public key of A: " + A);
        System.out.println("Public key of B: " + B);

        System.out.println("Secret key computed by A: " + keyA);
        System.out.println("Secret key computed by B: " + keyB);

        if (keyA == keyB) {
            System.out.println("Key Exchange Successful!");
        } else {
            System.out.println("Key Exchange Failed!");
        }

        sc.close();
    }
}