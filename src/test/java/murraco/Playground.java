package murraco;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class Playground {

  @Test
  public void shouldSortArrayOneElement_dynamicVersion() {
    for (TestUtils.SorterWrapper sorter : TestUtils.buildSorters()) {
      String[] array = {"A"};
      String[] copy = array.clone();
      sorter.sort(copy);
      assertEquals("Sorter " + sorter.getSorterName() + " should be the same", array, copy);
    }

    Integer[] mergeArray = new Integer[]{1};
    MergeSort.mergeSort(mergeArray);
    assertEquals(new Integer[]{1}, mergeArray);
  }

  @Test
  public void shouldThrowNullArray_dynamicVersion() {
    for (TestUtils.SorterWrapper sorter : TestUtils.buildSorters()) {
      String message = "Sorter " + sorter.getSorterName() + " should throw exception";
      Assert.assertThrows(message, Exception.class, () -> sorter.sort(null));
    }

    Assert.assertThrows(Exception.class, () -> MergeSort.mergeSort(null));
  }

  @Test
  public void shouldSortEmptyArray_dynamicVersion() {
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
  public void x_test() {
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

}
