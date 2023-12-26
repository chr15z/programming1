/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    //Es gibt 4 for Schleifen, die nacheinander ausgeführt werden
    //Es ist eine grafische Ausgabe die ein Muster ausgibt (5 Zeilen pro for Schleife)
    //

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    //
    //jeweils 2 for Schleifen und die erste und letzte der Ausgabezeile machen das gleiche -> Methoden erstellen
    //Dadurch wird die main Methode übersichtlicher


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");

        //********************************************************
        int n = 28;
        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        printLine(n);
        spaghetti1(n);
        spaghetti2(n);
        spaghetti1(n);
        spaghetti2(n);
        printLine(n);
    }

    public static void printLine(int n){
        System.out.print("#");
        for (int i = 1; i <= n; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }

    public static void spaghetti1(int n){
        for (int i = 1; i < n/2+1; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");

            for (int j = 1; j <= (n - 2 * i); j++)
            {System.out.print("*");
            }
            System.out.print("/");

            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();

        }
    }

    public static void spaghetti2(int n){
        for (int i = 1; i < n/2+1; i++) {

            for (int j = 1; j <= (n/2-i+1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("*");
            }

            System.out.print("\\");
            for (int j = 1; j <= (n/2-i+1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }
}
