/*
    Aufgabe 2) Zweidimensionale Arrays - Sortieren und Filtern
*/
public class Aufgabe2 {

    private static double[][] genCircleFilter(int n, double radius) {
        double[][] out = new double[n][n];
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double pos = Math.sqrt(Math.pow(mid - i, 2) + Math.pow(mid - j, 2));
                if (radius > pos) out[i][j] = 1.00;
            }
        }
        return out;
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {
        double[][] out = new double[workArray.length][workArray[0].length];
        if (workArray.length < filterArray.length) return out;

        for (int j = 0; j <= workArray.length - filterArray.length; j++) {
            for (int i = 0; i <= workArray[0].length - filterArray[0].length; i++) {
                out[1+j][1+i] = getKreuz(workArray, filterArray, i, j);
            }
        }

        return out;
    }


    private static int getSAD(double[][] workArray, double[][] filterArray, int width, int height){
        int SAD = 0;

        for (int i = 0; i < filterArray.length; i++) {
            for (int j = 0; j < filterArray.length; j++) {
                SAD += Math.abs(filterArray[i][j] - workArray[i+height][j+width]);
            }
        }

        return SAD;
    }
    private static int getKreuz(double[][] workArray, double[][] filterArray, int width, int height){
        int cross = 0;

        for (int i = 0; i < filterArray.length; i++) {
            for (int j = 0; j < filterArray.length; j++) {
                cross += filterArray[i][j] * workArray[i+height][j+width];
            }
        }

        return cross;
    }

    private static void print(double[][] workArray) {
        if (workArray != null) {
            for (int y = 0; y < workArray.length; y++) {
                for (int x = 0; x < workArray[y].length; x++) {
                    System.out.printf("%.2f", workArray[y][x]);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] myResultArray;

        double[][] myFilter1 = genCircleFilter(3, 1.2);
        System.out.println("Output -> myFilter1 (genCircleFilter mit size = 3 und radius = 1.2):");
        print(myFilter1);

        double[][] myFilter2 = genCircleFilter(7, 2.5);
        System.out.println("Output -> myFilter2 (genCircleFilter mit size = 7 und radius = 2.5):");
        print(myFilter2);

        double[][] myArray1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 2, 2, 2, 0}, {0, 3, 3, 3, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray1:");
        print(myArray1);

        myResultArray = applyFilter(myArray1, myFilter1);
        System.out.println("Output -> myFilter1 applied to myArray1:");
        print(myResultArray);

        myResultArray = applyFilter(myArray1, myFilter2);
        System.out.println("Output -> myFilter2 applied to myArray1:");
        print(myResultArray);

        //Beispiel aus Aufgabenblatt
        double[][] myArray3 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        double[][] myFilter3 = {{1, 0, 0}, {1, 2, 0}, {0, 0, 3}};
        System.out.println("Output -> myArray3:");
        print(myArray3);
        System.out.println("Output -> myFilter3:");
        print(myFilter3);
        myResultArray = applyFilter(myArray3, myFilter3);
        System.out.println("Output -> myFilter3 applied to myArray3:");
        print(myResultArray);

        double[][] myArray4 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 2, 3, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray4:");
        print(myArray4);
        //TODO: Erstellen Sie den Filter aus dem Aufgabenblatt, wenden Sie ihn auf myArray4 an und geben Sie das Ergebnis mittels print() aus
    }


}
