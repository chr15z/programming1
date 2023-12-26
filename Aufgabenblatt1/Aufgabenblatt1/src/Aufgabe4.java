/*
    Aufgabe 4) CodeDraw Bibliothek
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe4 {

    public static void main(String[] args) {

        CodeDraw myDrawObj = new CodeDraw(400, 400);

        myDrawObj.setLineWidth(2);

        myDrawObj.setColor(Palette.PINK);
        myDrawObj.fillCircle(100,100,50);
        myDrawObj.drawCircle(100,100,100);

        myDrawObj.setColor(Palette.YELLOW);
        myDrawObj.fillRectangle(50,250,100,100);
        myDrawObj.setColor(Palette.BLUE);
        myDrawObj.drawLine(50,250,150,350);
        myDrawObj.drawLine(50,350,150,250);

        myDrawObj.setColor(Palette.GREEN);
        for(int i = 200; i < 600; i+=40){
            myDrawObj.drawLine(200,0,i,400);
        }

        myDrawObj.setColor(Palette.RED);
        myDrawObj.fillEllipse(350,50, 15,50);
        myDrawObj.fillEllipse(350,50, 50,15);

        myDrawObj.show();
    }
}
