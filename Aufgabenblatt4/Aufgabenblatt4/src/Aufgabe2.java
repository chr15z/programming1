/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        //1a)
        int arrA[] = {6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
        printArray(arrA, "#");

        //1b)
        int arrB[] = new int[12];
        int num = 6;
        for (int i = 0; i < arrB.length - 1; i++) {
            if (num%9==0) arrB[i] = 0;
            else arrB[i] = num;
            num+=6;
        }
        printArray(arrB, " ");

        //1c)
        int arrC[] = {7, 3, 2, 7, 6, 7, 7, 8, 9, 5};

        int count7 = 0;
        for (int i = 0; i < arrC.length; i++) {
            if(arrC[i]==7){
                count7++;
            }
        }

        int newArrC[] = new int[arrC.length + count7];

        int i = 0;
        int j = 0;
        while(i < newArrC.length){
            newArrC[i] = arrC[i-j];
            if(newArrC[i]== 7){
                newArrC[i+1] = -1;
                i++;
                j++;
            }
            i++;
        }
        printArray(arrC, " ");
        printArray(newArrC, " ");

        //1d)
        int arrD[] = new int[11];
        for (int k = 0; k < 11; k++) {
            arrD[k] = k+1;
        }

        System.out.print("for-Schrleife: ");
        for (int l = 0; l < arrD.length-1; l++) {
            System.out.print(arrD[10-l] + ", ");
        }
        System.out.println(arrD[0] + "\n");


        System.out.print("while-Schrleife: ");
        int m = arrD.length-1;
        while (m > 0){
            System.out.print(arrD[m]+", ");
            m--;
        }
        System.out.println(arrD[0] + "\n");

    }

    private static void printArray(int[] workArray, String s) {
        for (int i = 0; i < workArray.length-1; i++) {
            System.out.print(workArray[i] + s);
        }
        System.out.println(workArray[workArray.length-1]);
    }
}

