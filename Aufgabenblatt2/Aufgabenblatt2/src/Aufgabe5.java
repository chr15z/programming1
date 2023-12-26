import codedraw.CodeDraw;
import codedraw.Palette;
import java.awt.*;

/*
    Aufgabe 5) Designaufgabe
*/
public class Aufgabe5 {

    static CodeDraw myCode = new CodeDraw(500,500);
    static Color colour = Palette.randomColor();

    public static void main(String[] args) {
        drawBackground();

        myCode.setColor(Palette.GREEN);
        myCode.fillCircle(myCode.getWidth()/4,myCode.getHeight()/4, 50);
        myCode.fillCircle(myCode.getWidth()*3/4,myCode.getHeight()/4, 50);

        drawLines(Palette.GREEN.brighter());

        myCode.setColor(Palette.BLACK);
        myCode.fillCircle(myCode.getWidth()/4,myCode.getHeight()/4, 10);
        myCode.fillCircle(myCode.getWidth()*3/4,myCode.getHeight()/4, 10);

        drawSmile(colour, smile());
        myCode.show();
    }
    public static void drawBackground(){
        myCode.setColor(Palette.LIGHT_GRAY);
        myCode.fillRectangle(0,0, myCode.getWidth(), myCode.getHeight());
        for (int i = 0; i < myCode.getWidth(); i++) {
            if(Math.random()>0.9){
                myCode.setColor(Palette.LIGHT_SKY_BLUE.darker());
            }else{
                myCode.setColor(Palette.LIGHT_SKY_BLUE);
            }
            if(Math.random()>0.5){
                myCode.drawLine(0,i, myCode.getWidth(), myCode.getHeight()-i);
            }
            else {
                myCode.drawLine(i,0, myCode.getWidth()-i, myCode.getHeight());
            }
        }
    }

    public static void drawSmile(Color colour, boolean smile){
        double y1 = myCode.getHeight()/3+myCode.getHeight()/3*Math.random();
        double y2 = myCode.getHeight()/3+myCode.getHeight()/3*Math.random();
        myCode.setLineWidth(8);
        myCode.setColor(colour);
        if(smile) myCode.drawCurve(10,y1,50,400,myCode.getWidth()-10,y2);
        else myCode.drawCurve(10,y1,50,200,myCode.getWidth()-10,y2);
    }

    public static void drawLines(Color colour){
        myCode.setColor(colour);
        myCode.setLineWidth(1);
        double b = myCode.getWidth()/4;
        for (int i = 0; i < 100; i++) {
            myCode.drawLine(b,b,b+70*Math.random()-35, b+70*Math.random()-35);
        }
        for (int i = 0; i < 100; i++) {
            myCode.drawLine(b*3,b,b*3+70*Math.random()-35, b+70*Math.random()-35);
        }
    }

    public static boolean smile(){
        if(Math.random()<0.5){
            return false;
        }else return true;
    }
}
