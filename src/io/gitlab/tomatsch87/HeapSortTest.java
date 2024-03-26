package io.gitlab.tomatsch87;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

/*Junit-Testcases für Implementierung der Heapsort-Variante
  einfache Testcases mit Ausgabe auf dem Terminal sind in der Main-Methode von HeapSort.java zu finden*/
public class HeapSortTest{
  private static void isSorted(String[] a){
    //Erstelle eine Kopie b des Arrays a
    String[] b = new String[a.length];
    System.arraycopy(a, 0, b, 0, a.length);

    //Sortiere a mit unserer Heapsortvariante sort() aus der Klasse HeapSort
    HeapSort hs = new HeapSort();
    hs.sort(a);

    //Sortiere b mittels der in der Klasse Arrays enthaltenen Methode sort() für Objekte
    Arrays.sort(b);
    assertTrue(Arrays.equals(a, b));
  }
  
  @Test
  public void testHeapSort1(){
    String[] a = {};
    isSorted(a);
  }

  @Test
  public void testHeapSort2(){
    String[] a = {""};
    isSorted(a);
  }

  @Test
  public void testHeapSort3(){
    String[] a = {"Welt","Hallo"};
    isSorted(a);
  }

  @Test
  public void testHeapSort4(){
    String[] a = {"5", "4", "3", "2", "1"};
    isSorted(a);
  }

  @Test
  public void testHeapSort5(){
    String[] a = {"1", "4", "2", "3", "5"};
    isSorted(a);
  }

  @Test
  public void testHeapSort6(){
    String[] a = {"5", "6", "7", "8", "1", "2", "4", "3", "0"};
    isSorted(a);
  }

  @Test
  public void testHeapSort7(){
    String[] a = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
    isSorted(a);
  }

  @Test
  public void testHeapSort8(){
    String[] a = {"Eifersucht", "ist", "eine", "Leidenschaft", "die", "mit", "Eifer", "sucht", "was", "Leiden", "schafft"};
    isSorted(a);
  }

  @Test
  public void testHeapSort9(){
    String[] a = {"Ich", "bin", "ein", "Teil", "von", "jener", "Kraft", "Die", "stets", "das", "Böse", "will", "und", "stets", "das", "Gute", "schafft"};
    isSorted(a);
  }

  @Test
  public void testHeapSort10(){
    HeapSort hs = new HeapSort();
    String[] a = hs.createRandomStringArray(100,16);
    isSorted(a);
  }
}