/*
    Aufgabe 1) Schleifen - geometrische Formen und Muster (optische Täuschung)
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe1 {

    public static void main(String[] args) {

        int ws = 400;
        CodeDraw myDraw = new CodeDraw(ws,ws);
        double r = 400.0/60;
        double x = r*2;        //X-Koordinate
        double y = r*2;        //Y-Koordinate

        for(int j = 1; j < 16; j++){                      //nächste Spalte
            for (int i = 0; i < 15; i++) {                //befüllt Zeile
                myDraw.setColor(Palette.BLACK);
                myDraw.fillCircle(x + 4 * r * i, y, r);
                myDraw.setColor(Palette.GRAY);
                myDraw.setLineWidth(3);
                myDraw.drawCircle(x + 4 * r * i, y, r);
            }
            y += 4 * r;
        }

        x = 0.25 * ws + r;
        y = 0.25 * ws + r;
        myDraw.setColor(Palette.LIGHT_GRAY);
        myDraw.fillRectangle(x, y, 0.5 * ws - 2 * r, 0.5 * ws - 2 * r);
        myDraw.setLineWidth(1);
        myDraw.setColor(Palette.BLACK);
        myDraw.drawRectangle(x, y, 0.5 * ws - 2 * r, 0.5 * ws - 2 * r);
        System.out.println(x + " " + y);

        y = ws/4 + 2*r;
        for(int j = 1; j < 8; j++){                      //nächste Spalte
            for (int i = 0; i < 7; i++) {
                myDraw.drawRectangle(ws/4+2*r + 4*r*i, y, 2*r, 2*r);
            }
            y+= 4 * r;
        }
        myDraw.show();

    }
}
