package murraco;

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

      }
    };

//    SorterWrapper merge = new SorterWrapper() {
//      @Override
//      public <T extends Comparable<T>> void sort(T[] t) {
//        MergeSort.mergeSort(t);
//      }
//    };

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

}
