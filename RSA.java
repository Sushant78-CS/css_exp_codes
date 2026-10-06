import java.util.Scanner;

public class RSA {

    // Function to calculate GCD
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    // Function to calculate modular inverse
    public static int modInverse(int e, int phi) {

        for (int d = 1; d < phi; d++) {

            if ((d * e) % phi == 1)
                return d;
        }

        return -1;
    }

    // Function for modular exponentiation
    public static long power(long base, long exp, long mod) {

        long result = 1;
        base = base % mod;

        while (exp > 0) {

            if (exp % 2 == 1)
                result = (result * base) % mod;

            exp = exp / 2;
            base = (base * base) % mod;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Input prime numbers
        System.out.print("Enter prime number p: ");
        int p = sc.nextInt();

        System.out.print("Enter prime number q: ");
        int q = sc.nextInt();

        // Step 2: Calculate n and phi
        int n = p * q;
        int phi = (p - 1) * (q - 1);

        // Step 3: Choose e (public key)
        int e;

        for (e = 2; e < phi; e++) {

            if (gcd(e, phi) == 1)
                break;
        }

        // Step 4: Calculate d (private key)
        int d = modInverse(e, phi);

        System.out.println("\nPublic Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");

        // Step 5: Input message (number form)
        System.out.print("\nEnter message (number < n): ");
        int message = sc.nextInt();

        // Step 6: Encryption
        long cipher = power(message, e, n);

        // Step 7: Decryption
        long decrypted = power(cipher, d, n);

        System.out.println("\nEncrypted Message: " + cipher);
        System.out.println("Decrypted Message: " + decrypted);

        sc.close();
    }
}