package murraco;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class CustomClass implements Comparable<CustomClass> {
  private String toBeHashed;

  public CustomClass(String hashMe) {
    this.toBeHashed = hashMe;
  }

  @Override
  public int compareTo(CustomClass custom) {
    return hash(this.toBeHashed).compareTo(hash(custom.toBeHashed));
  }

  /**
   * Hash a string
   */
  public static String hash(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(input.getBytes());
      byte[] digest = md.digest();
      return String.format("%064x", new java.math.BigInteger(1, digest));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
