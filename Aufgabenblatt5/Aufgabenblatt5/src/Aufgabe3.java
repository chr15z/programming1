/*
    Aufgabe 3) Zweidimensionale Arrays und CodeDraw - Bildverarbeitung "Finding Waldo"
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.Image;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Aufgabe3 {

    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        return imgArray;
    }

    //detect waldo by template matching
    private static void detectWaldo(CodeDraw myDrawObj, Image img, Image template) {
        int imgArray [][] = convertImg2Array(img);
        int imgTemplate [][] = convertImg2Array(template);
        int SAD;
        int minSAD = 99999;
        int waldoX;
        int waldoY;
        for (int j = 0; j <= imgArray.length - imgTemplate.length; j++) { //704-39 = 665
            for (int i = 0; i <= imgArray[0].length - imgTemplate[0].length; i++) { //1120-25 = 1095
                SAD = getSAD(imgArray, imgTemplate, i, j);
                if (SAD < minSAD) {
                    minSAD = SAD;
                    waldoX = i;
                    waldoY = j;

                    myDrawObj.setLineWidth(6);
                    myDrawObj.setColor(Palette.BLACK);
                    myDrawObj.drawImage(0,0,img);
                    myDrawObj.drawRectangle(waldoX,waldoY,template.getWidth(), template.getHeight());
                    myDrawObj.show(300);
                }
            }
        }
    }

    private static int getSAD(int[][] workArray, int[][] filterArray, int width, int height){
        int SAD = 0;

        for (int i = 0; i < filterArray.length; i++) {
            for (int j = 0; j < filterArray[0].length; j++) {
                SAD += Math.abs(filterArray[i][j] - workArray[i+height][j+width]);
            }
        }

        return SAD;
    }

    public static void main(String[] args) {

        //waldo1
        //String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/6NcsuQdriPbHcKN/download"; //waldo1.png
        //String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/AwlmIBqj2V1qGV7/download"; //template1.png

        //waldo2
        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/922nyXVsBkMKz6K/download"; //waldo2.png
        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/tqTFXxF2BkeKnhm/download"; //template2.png

        //waldo3
        //String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/DR2u4Xf5muAZsWo/download"; //waldo3.png
        //String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/xEMZlbdHJ4ZfLfz/download"; //template3.png

        // open image file
        Image img = Image.fromUrl(linkWaldo);

        // open template image file
        Image template = Image.fromUrl(linkTemplate);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //cd.drawImage(0,0,template);
        //draw image
        cd.drawImage(0, 0, img);
        cd.show();

        //detect Waldo given in 'template' and show result in image 'img'
        detectWaldo(cd, img, template);
    }
}
