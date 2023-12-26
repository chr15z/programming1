/*
    Aufgabe 1) Zweidimensionale Arrays und Methoden - Vier Gewinnt
*/

import codedraw.*;

import java.util.Arrays;

//import java.util.Arrays;

public class Aufgabe1 {

    private static int[][] genGameBoard(int row, int col) {
        return new int[row][col];
    }

    private static void drawGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        for (int row = 0; row < currentGameBoard.length; row++) { //=7
            for (int col = 0; col < currentGameBoard[row].length; col++) { //=6
                myDrawObj.setColor(Palette.BLUE);
                myDrawObj.fillRectangle(col * oneSquareSize, row * oneSquareSize, oneSquareSize, oneSquareSize);
                drawCircles(myDrawObj, row, col, oneSquareSize, currentGameBoard);
            }
        }
        //currentGameBoard in console
        for (int[] ints : currentGameBoard) {
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static void drawCircles(CodeDraw myDrawObj, int row, int col, int oneSquareSize, int[][] currentGameBoard) {
        myDrawObj.setColor(Palette.DARK_GRAY);
        if (currentGameBoard[row][col] == 1) myDrawObj.setColor(Palette.RED);
        if (currentGameBoard[row][col] == 2) myDrawObj.setColor(Palette.YELLOW);
        myDrawObj.fillCircle(col * oneSquareSize + oneSquareSize / 2.0, row * oneSquareSize + oneSquareSize / 2.0, oneSquareSize / 3.0);
    }

    private static boolean isMovePossible(int[][] currentGameBoard, int col) {
        return currentGameBoard[0][col] == 0;
    }

    private static void makeMove(int[][] currentGameBoard, int player, int col) {
        for (int i = currentGameBoard.length - 1; i >= 0; i--) {
            if (currentGameBoard[i][col] == 0) {
                currentGameBoard[i][col] = player;
                return;
            }
        }
    }

    private static boolean existsWinner(int[][] currentGameBoard, int player) {
        for (int[] ints : currentGameBoard) { //vertikal
            for (int j = 0; j < ints.length - 3; j++) {
                if (ints[j] == player && ints[j + 1] == player &&
                        ints[j + 2] == player && ints[j + 3] == player) return true;
            }
        }
        for (int i = 0; i < currentGameBoard.length - 3; i++) { //horizontal
            for (int j = 0; j < currentGameBoard[i].length; j++) {
                if (currentGameBoard[i][j] == player && currentGameBoard[i + 1][j] == player &&
                        currentGameBoard[i + 2][j] == player && currentGameBoard[i + 3][j] == player) return true;
            }
        }

        for (int i = 0; i < currentGameBoard.length - 3; i++) { //links oben nach rechts unten
            for (int j = 0; j < currentGameBoard[i].length - 3; j++) {
                if (currentGameBoard[i][j] == player && currentGameBoard[i + 1][j + 1] == player &&
                        currentGameBoard[i + 2][j + 2] == player && currentGameBoard[i + 3][j + 3] == player)
                    return true;
            }
        }

        for (int i = currentGameBoard.length - 1; i >= 3; i--) { //links unten nach rechts oben
            for (int j = 0; j < currentGameBoard[0].length - 3; j++) { //7 - 3 = 4
                if (currentGameBoard[i][j] == player && currentGameBoard[i - 1][j + 1] == player &&
                        currentGameBoard[i - 2][j + 2] == player && currentGameBoard[i - 3][j + 3] == player)
                    return true;
            }
        }

        return false;
    }

    private static void boardFull(CodeDraw myDrawObj, int[][] fullGameBoard, int oneSquareSize){
        if (fullGameBoard[fullGameBoard.length - 1][0] != 0){
            for (int i = fullGameBoard.length - 1; i > 0; i--) { //jede Zeile eins nach unten verschieben
                for (int j = 0; j < fullGameBoard[i].length; j++) {
                    fullGameBoard[i][j] = fullGameBoard[i-1][j];
                }
            }
            Arrays.fill(fullGameBoard[0], 0); //die erste Zeile wird zu 0en


            long end = System.currentTimeMillis() + 1000;
            while (System.currentTimeMillis() < end) {
                drawGameBoard(myDrawObj, fullGameBoard, oneSquareSize);
                myDrawObj.show();
            }
            boardFull(myDrawObj, fullGameBoard, oneSquareSize);
        }
        else{
            long end = System.currentTimeMillis() + 3000;
            while (System.currentTimeMillis() < end) {
                myDrawObj.setColor(Palette.WHITE);
                myDrawObj.drawText(myDrawObj.getWidth() / 2.0, myDrawObj.getHeight() / 2.0, "Try Again!");
                myDrawObj.show();
            }


        }
    }

    public static void main(String[] args) {

        // canvas settings
        int rowsGameBoard = 6;
        int colsGameBoard = 7;
        int oneSquareSize = 50;
        int width = oneSquareSize * colsGameBoard;
        int height = oneSquareSize * rowsGameBoard;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        // game variables
        int[][] myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
        int player = 1;
        int fieldsUsed = 0;
        boolean gameActive = true;

        // set font for text
        TextFormat font = new TextFormat();
        font.setFontSize(28);
        font.setFontName("Arial");
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);
        myDrawObj.setTextFormat(font);

        // initial draw of the game board
        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

        // game play starts
        System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
        while (!myDrawObj.isClosed() && gameActive) {
            if (myEventSC.hasKeyPressEvent()) {
                if (myEventSC.nextKeyPressEvent().getChar() == 'q') {
                    gameActive = false;
                }
            }
            else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                //int mouseY = currentClick.getY();
                // TODO: Implementieren Sie hier die fehlende Spiellogik

                boolean change = false;
                if (isMovePossible(myGameBoard, mouseX / oneSquareSize)) {
                    makeMove(myGameBoard, player, mouseX / oneSquareSize);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    change = true;
                    fieldsUsed++;

                    if (existsWinner(myGameBoard, player)) {
                        long end = System.currentTimeMillis() + 3000;
                        while (System.currentTimeMillis() < end) {
                            myDrawObj.setColor(Palette.WHITE);
                            myDrawObj.drawText(myDrawObj.getWidth() / 2.0, myDrawObj.getHeight() / 2.0, "Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " wins!");
                            myDrawObj.show();
                            System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " wins!");
                        }
                        fieldsUsed = 0;
                        myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                        myDrawObj.drawText(myDrawObj.getWidth() / 2.0, myDrawObj.getHeight() / 2.0, "Next Round!");
                    }
                }
                else if (fieldsUsed < colsGameBoard * rowsGameBoard) { //column full
                    myDrawObj.setColor(Palette.WHITE);
                    myDrawObj.drawText(myDrawObj.getWidth() / 2.0, myDrawObj.getHeight() / 2.0, "Column already full!");

                }
                else { //board full
                    fieldsUsed = 0;
                    long end = System.currentTimeMillis() + 3000;
                    while (System.currentTimeMillis() < end) {
                        myDrawObj.setColor(Palette.WHITE);
                        myDrawObj.drawText(myDrawObj.getWidth() / 2.0, myDrawObj.getHeight() / 2.0, "Board full!");
                        myDrawObj.show();
                    }
                    boardFull(myDrawObj, myGameBoard, oneSquareSize);
                }


                if (change) { //Spielertausch (nur wenn isMovePossible)
                    if (player == 1) player = 2;
                    else player = 1;
                }


            }
            else {
                myEventSC.nextEvent();
            }
            myDrawObj.show();
        }
        myDrawObj.close();
    }
}


