package murraco;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class TestUtils {

  public interface SorterWrapper {
    String getSorterName();

    <T extends Comparable<T>> void sort(T[] t);
  }

  public static Iterable<SorterWrapper> buildSorters() {
    SorterWrapper bubble = new SorterWrapper() {
      @Override
      public String getSorterName() {
        return "Bubble";
      }

      @Override
      public <T extends Comparable<T>> void sort(T[] t) {
        BubbleSort.bubbleSort(t);
      }
    };

    SorterWrapper heap = new SorterWrapper() {
      @Override
      public String getSorterName() {
        return "Heap";
      }

      @Override
      public <T extends Comparable<T>> void sort(T[] t) {
        Heapsort.heapSort(t);
      }
    };

    SorterWrapper insertion = new SorterWrapper() {
      @Override
      public String getSorterName() {
        return "Insertion";
      }

      @Override
      public <T extends Comparable<T>> void sort(T[] t) {
        InsertionSort.insertionSort(t);
      }
    };

    SorterWrapper selection = new SorterWrapper() {
      @Override
      public String getSorterName() {
        return "Selection";
      }

      @Override
      public <T extends Comparable<T>> void sort(T[] t) {
        SelectionSort.selectionSort(t);
      }
    };

    SorterWrapper quick = new SorterWrapper() {
      @Override
      public String getSorterName() {
        return "Quick";
      }

      @Override
      public <T extends Comparable<T>> void sort(T[] t) {
        Quicksort.quickSort(t);
      }
    };

    SorterWrapper[] wrappers = new SorterWrapper[]{bubble, heap, insertion, selection, quick};
    return Arrays.asList(wrappers);
  }

  public static final class CustomClass implements Comparable<CustomClass> {
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
}
