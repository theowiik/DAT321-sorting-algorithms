package murraco;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class BetterTestSuite {

  @Test
  public void oneElementShouldBeSorted() {
    String[] original = {"A"};

    String[] bubbleArray = original.clone();
    BubbleSort.bubbleSort(bubbleArray);
    assertEquals(original, bubbleArray);

    String[] heapArray = original.clone();
    Heapsort.heapSort(heapArray);
    assertEquals(original, heapArray);

    String[] selectionArray = original.clone();
    SelectionSort.selectionSort(selectionArray);
    assertEquals(original, selectionArray);

    String[] quickArray = original.clone();
    Quicksort.quickSort(quickArray);
    assertEquals(original, quickArray);

    String[] insertionArray = original.clone();
    InsertionSort.insertionSort(insertionArray);
    assertEquals(original, insertionArray);

    // Custom

    Integer[] mergeArray = new Integer[]{1};
    MergeSort.mergeSort(mergeArray);
    assertEquals(new Integer[]{1}, mergeArray);
  }

  @Test
  public void shouldSortEmptyArray_v1() {
    for (TestUtils.SorterWrapper sorter : TestUtils.buildSorters()) {
      String[] array = {};
      sorter.sort(array);
      assertEquals(0, array.length);
    }
  }

  private interface Performer {
    void perform();
  }

  @Test
  public void x() {
    Performer p = new Performer() {
      @Override
      public void perform() {
        String[] array = {};
        // Sort
        assertEquals(0, array.length);
      }
    };
  }

  private void perform(Performer performer) {

  }

  @Test
  public void shouldThrowNullArray() {
    Assert.assertThrows(Exception.class, () -> BubbleSort.bubbleSort(null));
    Assert.assertThrows(Exception.class, () -> Heapsort.heapSort(null));
    Assert.assertThrows(Exception.class, () -> MergeSort.mergeSort(null));
    Assert.assertThrows(Exception.class, () -> SelectionSort.selectionSort(null));
    Assert.assertThrows(Exception.class, () -> Quicksort.quickSort(null));
    Assert.assertThrows(Exception.class, () -> InsertionSort.insertionSort(null));
  }


}
