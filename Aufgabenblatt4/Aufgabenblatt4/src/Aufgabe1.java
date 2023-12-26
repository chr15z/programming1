/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);

    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1: Das i muss größer werden, weil ein array r kein value für negative Zahlen (r[-1]) besitzt
    //
    //Frage 2: Die Methode ist vom Typ void, deswegen hat sie keinen Rückgabewert. Sie besitzt jedoch eine Ausgabe (sout).
    //
    //Frage 3: Das Copyarray verweist auf die gleiche Adresse, wie das originale. Deswegen werden die Werte verändert
    //
    //Frage 4:  Das filledArray der Main wurde nie angepasst. In der Methode fillArrayWithNewContent wurde eine neue
    //          Array-Variable initialisiert und alle Werte wurden einzeln kopiert
    //
}
//Zusatzfragen
//  1.  Integer.
//  2.  Nein. Am Anfang ist das Array Leer (kein Inhalt). Wenn man es initialisieren möchte, muss man die Werte an dem
//      entsprechenden Index initialisieren.
//  3.  Man kann ein neues Array mit der gewünschten Länge erstellen und die Werte kopieren + die neuen Werte einfügen
//  4.  Entweder eine for-Schleife, System.arrayCopie() oder Object.clone().
//  5.  Ja.
//  6.  Es werden die Objekte/Adressen verglichen und nicht der Inhalt. Also macht es nur in wenigen besonderen Fällen
//      Sinn.