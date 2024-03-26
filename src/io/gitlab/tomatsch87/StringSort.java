package io.gitlab.tomatsch87;

import java.security.SecureRandom;

//Interface für String-basiertes Sortieren
public interface StringSort{
  //Abstrakte Methode sort(String[] a) ist von implementierenden Klassen zu überschreiben
  public void sort(String[] a);

  //Default-Methode zum Vertauschen von zwei Positionen in einem String-Array
  default void swap(String[] a, int pos1, int pos2){
		String tmp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = tmp;
	}

  //Default-Methode die zufällige Strings einer gegebenen Länge liefert
  default String genRandomString(int len){
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,.-;:_#+*ß?=()[]{}/&%$§!";
    SecureRandom rand = new SecureRandom();
    StringBuilder build = new StringBuilder(len);
    for (int i = 0; i<len; i++){
      int randomCharPos = rand.nextInt(chars.length());
      char randomCar = chars.charAt(randomCharPos);
      build.append(randomCar);
    }
    return build.toString();
  }

  //Default-Methode die ein Array mit der Größe n erzeugt und zufällige Strings mit der Länge max hineinschreibt
  default String[] createRandomStringArray(int n, int max){
    String a[] = new String[n];
    for (int i = 0; i < n; i++) a[i] = genRandomString(max);
    return a;
  }

  /*Default-Methode für die Laufzeittests der Sort-Methode, wobei der Parameter max die Länge der zufälligen Strings
   ist und wird weiter an createRandomStringArray übergeben*/
  default void runtimeTest(int max){
    int length[] = {100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000, 1000000, 2000000, 4000000, 8000000};
    for(int n:length){
      String a[] = createRandomStringArray(n, max);
      //Zeitmessung
      long start = System.nanoTime();
      sort(a);
      long end = System.nanoTime();
      long microseconds = (end-start)/1000;
      //Ausgabe der Zeitmessung
      System.out.format("Sortierzeit für N = %7d : ", a.length);
      //Umrechnung zu Sekunden und Millisekunden: 1 Microsekunde = 1*10^6 Sekunden, 1 Microsekunde = 1*10^3 Millisekunden
      System.out.format("%4d Sekunden, %02d Millisekunden\n", microseconds/1000000, ((microseconds/1000)%1000)/10);
    }
  }
}