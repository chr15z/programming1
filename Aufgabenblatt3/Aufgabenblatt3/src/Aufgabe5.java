/*
    Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe5 {
    static int countRecursiveCalls = 0;
    static int countSmallCircles = 0;
    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        countRecursiveCalls++;
        if(r>2){
            if(r==4) countSmallCircles++;
            drawCirclePatternRecursively(myDrawObj,x+r,y+r,r/2);
            drawCirclePatternRecursively(myDrawObj,x-r,y+r,r/2);
            drawCirclePatternRecursively(myDrawObj,x+r,y-r,r/2);
            drawCirclePatternRecursively(myDrawObj,x-r,y-r,r/2);

            myDrawObj.setColor(Palette.ORANGE);
            myDrawObj.fillCircle(x,y,r);
            myDrawObj.setColor(Palette.RED);
            myDrawObj.drawCircle(x,y,r);
        }
    }

    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {
        int r = 4;
        while (r<=maxRadius){
           drawCircles(myDrawObj, r);
            r *= 2;
        }
    }

    public static void drawCircles(CodeDraw myDrawObj, int maxRadius){
        for(int j = 0; j < myDrawObj.getHeight()/maxRadius; j++)
        {
            for (int i = 0; i < myDrawObj.getHeight()/maxRadius; i++) {
                myDrawObj.setColor(Palette.PURPLE);
                myDrawObj.fillCircle(maxRadius*2+maxRadius*i*4, 2*maxRadius+4*maxRadius*j, maxRadius);
                myDrawObj.setColor(Palette.RED);
                myDrawObj.drawCircle(maxRadius*2+maxRadius*i*4, 2*maxRadius+4*maxRadius*j, maxRadius);
            }
        }
    }

    public static void main(String[] args) {
        CodeDraw myDrawObjR = new CodeDraw(512,512);
        CodeDraw myDrawObjI = new CodeDraw(512,512);
        drawCirclePatternRecursively(myDrawObjR, 256, 256, 128);
        drawCirclePatternIteratively(myDrawObjI, 128);
        myDrawObjR.show();
        myDrawObjI.show();
        System.out.println(countRecursiveCalls);
        System.out.println(countSmallCircles);
        //Frage 3: Man muss den Kreis rechts oben immer weglassen (Zeile 17 löschen)
    }
}


