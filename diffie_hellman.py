# Diffie-Hellman Key Exchange Algorithm

# Publicly agreed values
p = int(input("Enter a prime number (p): "))
g = int(input("Enter a primitive root (g): "))

# Private keys
a = int(input("Enter Alice's private key: "))
b = int(input("Enter Bob's private key: "))

# Public keys
A = (g ** a) % p
B = (g ** b) % p

print("\nAlice's Public Key =", A)
print("Bob's Public Key =", B)

# Shared secret keys
key_alice = (B ** a) % p
key_bob = (A ** b) % p

print("\nSecret Key computed by Alice =", key_alice)
print("Secret Key computed by Bob =", key_bob)

if key_alice == key_bob:
    print("Shared Secret Key Established Successfully!")
else:
    print("Key Exchange Failed!")