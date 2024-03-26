package io.gitlab.tomatsch87;

import java.util.Arrays;

public class HeapSort implements StringSort{

  //Implementierung einer Heapsort-Variante, welche Strings "in-place" und lexikografisch aufsteigend sortiert
  public void sort(String[] a){
    buildMaxHeap(a);
    //Durchlaufe das Array a von rechts nach links bis auf das letzte Element
    for(int i = a.length-1; i > 0; --i){
      //Tausche das Maximum in den sortierten Bereich am Ende des Arrays
      swap(a, 0, i);
      //Stelle die Max-Heap-Eigenschaft für den Bereich von Index 0 bis Index i-1 wieder her
      maxHeapify(a, 0, i-1);
    }
  }

  //Für alle Felder die keine Blätter des Heaps sind, wird die Max-Heap-Eigenschaft sichergestellt
  public void buildMaxHeap(String[] a){
    for(int i = a.length/2; i >= 0; --i) maxHeapify(a, i, a.length-1);
  }

  //Stelle für den Bereich von Index i bis Index heapsize im Array a die Max-Heap-Eigenschaft sicher
  public void maxHeapify(String[] a, int i, int heapsize){
    /*Das erste Element im Array a hat den Index 0 und wir können nicht mit 2*i und 2*i+1 die Kindknoten erfragen
      deswegen bilden wir das Inkrement von i und gleichen dies bei Feldzugriffen mit a[i-1] bzw. a[k-1] wieder aus
      Dementsprechend müssen wir auch die übergebene Größe des Heaps inkrementieren*/
    i++;
    heapsize++;
    //Solange der Index i einen linken Kindknoten im Heap hat
    while(2*i<=heapsize){
      //Die Variable k setzen wird auf den linken Kindknoten
      int k = 2*i;
      //Wenn i auch einen rechten Kindknoten im Heap hat, vergleichen wir beide Kindknoten von i
      //Ist der rechte Kindknoten lexikografisch größer als der Linke, setzten wir k auf den rechten Kindknoten
      if(k+1<=heapsize && a[k-1].compareTo(a[k])<0) k++;
      //Wir vergleichen i lexikografisch mit dem größeren Kindknoten und tauschen beide, wenn der Kindknoten größer ist,
      //dann setzen wir Index i auf den Kindknoten und sickern weiter durch den Heap
      if(a[i-1].compareTo(a[k-1])<0){
        swap(a, i-1, k-1);
        i = k;
      }
      //Wenn kein Kindknoten von i lexikografisch größer ist als i selbst ist die Heap-Eigenschaft erfüllt
      else break;
    }
  }

  public static void main(String[] args){
    //HeapSort-Objekt für den Aufruf von sort() auf String-Arrays
    HeapSort hs = new HeapSort();

    /*Einfacher Unit-Test der Methode sort() auf korrekte Funktionalität über das Terminal
      Weitere J-Unit Testcases sind in der Datei HeapSortTest.java zu finden*/
    System.out.println("Einfache Unit-Test der Methode sort meiner Heapsortvariante aus Aufgabe 1: "+"\n");
    String[] a = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
    String[] b = {"Eifersucht", "ist", "eine", "Leidenschaft", "die", "mit", "Eifer", "sucht", "was", "Leiden", "schafft"};
    String[] c = {"Ich", "bin", "ein", "Teil", "von", "jener", "Kraft", "Die", "stets", "das", "Böse", "will", "und", "stets", "das", "Gute", "schafft"};

    //Ausgabe der String-Arrays a, b und c vor der Sortierung
    System.out.println("Eingabearray A: ");
    System.out.print("[");
    for(int i=0; i<a.length; i++) System.out.print(" "+a[i]+", ");
    System.out.println("]"+"\n\n"+"Eingabearray B:");
    System.out.print("[");
    for(int i=0; i<b.length; i++) System.out.print(" "+b[i]+", ");
    System.out.println("]"+"\n\n"+"Eingabearray C: ");
    System.out.print("[");
    for(int i=0; i<c.length; i++) System.out.print(" "+c[i]+", ");
    System.out.println("]"+"\n");

    //Erstelle Kopien der Arrays a, b und c
    String[] x = new String[a.length];
    String[] y = new String[b.length];
    String[] z = new String[c.length];
    System.arraycopy(a, 0, x, 0, a.length);
    System.arraycopy(b, 0, y, 0, b.length);
    System.arraycopy(c, 0, z, 0, c.length);

    //Sortiere a, b und c mit unserer Heapsortvariante sort() aus der Klasse HeapSort
    hs.sort(a);
    hs.sort(b);
    hs.sort(c);

    //Sortiere x, y und z mittels der in der Klasse Arrays enthaltenen Methode sort() für Objekte
    Arrays.sort(x);
    Arrays.sort(y);
    Arrays.sort(z);

    //Ausgabe der sortierten String-Arrays im Terminal
    System.out.println("\nErgebnis der Heapsortvariante für A: ");
    System.out.print("[");
    for(int i=0; i<a.length; i++) System.out.print(" "+a[i]+", ");
    System.out.println("]"+"\n"+"Korrektes Ergebnis für A: ");
    System.out.print("[");
    for(int i=0; i<x.length; i++) System.out.print(" "+x[i]+", ");
    System.out.println("]"+"\n\n"+"Ergebnis der Heapsortvariante für B: ");
    System.out.print("[");
    for(int i=0; i<b.length; i++) System.out.print(" "+b[i]+", ");
    System.out.println("]"+"\n"+"Korrektes Ergebnis für B: ");
    System.out.print("[");
    for(int i=0; i<y.length; i++) System.out.print(" "+y[i]+", ");
    System.out.println("]"+"\n\n"+"Ergebnis der Heapsortvariante für C: ");
    System.out.print("[");
    for(int i=0; i<c.length; i++) System.out.print(" "+c[i]+", ");
    System.out.println("]"+"\n"+"Korrektes Ergebnis für C: ");
    System.out.print("[");
    for(int i=0; i<z.length; i++) System.out.print(" "+z[i]+", ");
    System.out.println("]"+"\n\n");

    /*Einfache Unit-Tests auf dem Terminal für die Methode genRandomString()
      Diese ist als Default-Methode in StringSort.java implementiert*/
    System.out.println("Aufruf der Methode genRandomString aus Aufgabe 2: "+"\n");
    System.out.println(hs.genRandomString(16)+"\n");
    System.out.println(hs.genRandomString(32)+"\n");
    System.out.println(hs.genRandomString(128)+"\n\n");

    //Laufzeittests mit Arrays von verschiedener Größe, die zufällige 16-stellige Strings enthalten
    System.out.println("Aufruf der Methode runtimeTest, welche für Aufgabe 3 entwickelt wurde: "+"\n");
    hs.runtimeTest(16);
  }
}