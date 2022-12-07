package murraco;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class BetterTestSuite {

  @Test
  public void shouldThrowNullArray() {
    Assert.assertThrows(Exception.class, () -> BubbleSort.bubbleSort(null));
    Assert.assertThrows(Exception.class, () -> Heapsort.heapSort(null));
    Assert.assertThrows(Exception.class, () -> MergeSort.mergeSort(null));
    Assert.assertThrows(Exception.class, () -> SelectionSort.selectionSort(null));
    Assert.assertThrows(Exception.class, () -> Quicksort.quickSort(null));
    Assert.assertThrows(Exception.class, () -> InsertionSort.insertionSort(null));
  }

  @Test
  public void shouldSortEmptyArray() {
    String[] original = {};

    String[] bubbleArray = original.clone();
    BubbleSort.bubbleSort(bubbleArray);
    assertEquals(0, bubbleArray.length);

    String[] heapArray = original.clone();
    Heapsort.heapSort(heapArray);
    assertEquals(0, heapArray.length);

    String[] selectionArray = original.clone();
    SelectionSort.selectionSort(selectionArray);
    assertEquals(0, selectionArray.length);

    String[] quickArray = original.clone();
    Quicksort.quickSort(quickArray);
    assertEquals(0, quickArray.length);

    String[] insertionArray = original.clone();
    InsertionSort.insertionSort(insertionArray);
    assertEquals(0, insertionArray.length);

    Integer[] mergeArray = new Integer[]{};
    MergeSort.mergeSort(mergeArray);
    assertEquals(0, mergeArray.length);
  }

  @Test
  public void shouldSortArrayOneElement() {
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

    Integer[] mergeArray = new Integer[]{1};
    MergeSort.mergeSort(mergeArray);
    assertEquals(new Integer[]{1}, mergeArray);
  }

  @Test
  public void shouldSortStringArrayWithMultipleElements() {
    String[] original = {"C", "J", "A", "F", "I", "E", "H", "D", "B", "G"};
    String[] correctSort = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    String[] bubbleArray = original.clone();
    BubbleSort.bubbleSort(bubbleArray);
    assertEquals(correctSort, bubbleArray);

    String[] heapArray = original.clone();
    Heapsort.heapSort(heapArray);
    assertEquals(correctSort, heapArray);

    String[] selectionArray = original.clone();
    SelectionSort.selectionSort(selectionArray);
    assertEquals(correctSort, selectionArray);

    String[] quickArray = original.clone();
    Quicksort.quickSort(quickArray);
    assertEquals(correctSort, quickArray);

    String[] insertionArray = original.clone();
    InsertionSort.insertionSort(insertionArray);
    assertEquals(correctSort, insertionArray);

    Integer[] mergeArray = new Integer[]{2, 5, 7, 6, 1, 3, 4, 10, 9, 8};
    MergeSort.mergeSort(mergeArray);
    assertEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, mergeArray);
  }

  @Test
  public void shouldSortIntegerArrayWithMultipleElements() {
    Integer[] original = new Integer[]{2, 5, 7, 6, 1, 3, 4, 10, 9, 8};
    Integer[] correctSort = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Integer[] bubbleArray = original.clone();
    BubbleSort.bubbleSort(bubbleArray);
    assertEquals(correctSort, bubbleArray);

    Integer[] heapArray = original.clone();
    Heapsort.heapSort(heapArray);
    assertEquals(correctSort, heapArray);

    Integer[] selectionArray = original.clone();
    SelectionSort.selectionSort(selectionArray);
    assertEquals(correctSort, selectionArray);

    Integer[] quickArray = original.clone();
    Quicksort.quickSort(quickArray);
    assertEquals(correctSort, quickArray);

    Integer[] insertionArray = original.clone();
    InsertionSort.insertionSort(insertionArray);
    assertEquals(correctSort, insertionArray);

    Integer[] mergeArray = original.clone();
    MergeSort.mergeSort(mergeArray);
    assertEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, mergeArray);
  }

  @Test
  public void shouldSortArrayWithDuplicates() {
    String[] original = {"C", "X", "B", "E", "A", "K", "A"};
    String[] sorted = {"A", "A", "B", "C", "E", "K", "X"};

    String[] bubbleArray = original.clone();
    BubbleSort.bubbleSort(bubbleArray);
    assertEquals(sorted, bubbleArray);

    String[] heapArray = original.clone();
    Heapsort.heapSort(heapArray);
    assertEquals(sorted, heapArray);

    String[] selectionArray = original.clone();
    SelectionSort.selectionSort(selectionArray);
    assertEquals(sorted, selectionArray);

    String[] quickArray = original.clone();
    Quicksort.quickSort(quickArray);
    assertEquals(sorted, quickArray);

    String[] insertionArray = original.clone();
    InsertionSort.insertionSort(insertionArray);
    assertEquals(sorted, insertionArray);

    Integer[] mergeArray = new Integer[]{6, 3, 5, 1, 3, 5};
    MergeSort.mergeSort(mergeArray);
    assertEquals(new Integer[]{1, 3, 3, 5, 5, 6}, mergeArray);
  }

  @Test
  public void shouldThrowArrayContainsNull() {
    String[] original = {"C", "X", "B", "E", "A", "K", null};
    Assert.assertThrows(Exception.class, () -> BubbleSort.bubbleSort(original));
    Assert.assertThrows(Exception.class, () -> Heapsort.heapSort(original));
    Assert.assertThrows(Exception.class, () -> SelectionSort.selectionSort(original));
    Assert.assertThrows(Exception.class, () -> Quicksort.quickSort(original));
    Assert.assertThrows(Exception.class, () -> InsertionSort.insertionSort(original));

    Integer[] mergeArray = new Integer[]{6, 3, 5, 1, 3, 5, null};
    Assert.assertThrows(Exception.class, () -> MergeSort.mergeSort(mergeArray));
  }
}
