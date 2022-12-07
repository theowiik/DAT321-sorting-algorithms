package murraco;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public final class BetterTestSuite {

  @Test
  public void oneElement() {
    String[] original = {"A"};
    String[] shouldBeSorted = original.clone();
    BubbleSort.bubbleSort(shouldBeSorted);

    assertEquals(original, shouldBeSorted);
  }

  @Test
  public void nully_overkill() {
    Iterable<SorterWrapper> sorters = buildSorters();

    for (SorterWrapper sorter : sorters) {
      // sorter.sort(null);
      // Assert.assertThrows("Sorter: ", Exception.class, () -> sorter.sort(null));
    }

    Assert.assertThrows(Exception.class, () -> BubbleSort.bubbleSort(null));
  }

  @Test
  public void nully_normal() {
    Assert.assertThrows(Exception.class, () -> BubbleSort.bubbleSort(null));
    Assert.assertThrows(Exception.class, () -> Heapsort.heapSort(null));
    Assert.assertThrows(Exception.class, () -> MergeSort.mergeSort(null));
    Assert.assertThrows(Exception.class, () -> SelectionSort.selectionSort(null));
    Assert.assertThrows(Exception.class, () -> Quicksort.quickSort(null));
    Assert.assertThrows(Exception.class, () -> InsertionSort.insertionSort(null));
  }

  private interface SorterWrapper {
    <T extends Comparable<T>> void sort(T[] t);
  }

  private Iterable<SorterWrapper> buildSorters() {
    SorterWrapper bubble = BubbleSort::bubbleSort;
    SorterWrapper heap = Heapsort::heapSort;
    SorterWrapper insertion = new SorterWrapper() {
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

    SorterWrapper selection = SelectionSort::selectionSort;

    SorterWrapper quick = new SorterWrapper() {
      @Override
      public <T extends Comparable<T>> void sort(T[] t) {
        Quicksort.quickSort(t);
      }
    };

    SorterWrapper[] wrappers = new SorterWrapper[]{bubble, heap, insertion, selection, quick};
    return Arrays.asList(wrappers);
  }
}
