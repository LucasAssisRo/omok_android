/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.cs4330.cs.utep.edu.omok.model;

/**
 *
 * @author Lucas Assis Rodrigues and John Ramirez
 */
public class Board {

    private char boardMatrix[][];
    private int xCor;
    private int yCor;
    private final int xCorArray[];
    private final int yCorArray[];

    /**
     *
     */
    public Board() {
        boardMatrix = new char[10][10];
        xCorArray = new int[5];
        yCorArray = new int[5];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boardMatrix[i][j] = ' ';
            }
        }
    }

    /**
     *
     * @param player The player who's placing the token
     * @param xCor The x coordinate that the token is being placed
     * @param yCor The y coordinate that the token is being placed
     * @return Returns if the player won the game after the token has been
     * placed
     */
    protected boolean placeToken(Player player, int xCor, int yCor) {
        char token = player.isPlayerOne() ? 'B' : 'W';
        boardMatrix[xCor][yCor] = token;
        xCorArray[0] = xCor;
        yCorArray[0] = yCor;
        this.xCor = xCor;
        this.yCor = yCor;
        return checkWinner(token);
    }

    /**
     *
     * @return Returns the board with all the tokens placed in it
     */
    public char[][] getBoardMatrix() {
        return boardMatrix;
    }

    /**
     *
     * @param boardMatrix Sets the matrix that represents the board
     */
    public void setBoardMatrix(char[][] boardMatrix) {
        this.boardMatrix = boardMatrix;
    }

    /**
     *
     * @return Returns the last clicked X coordinate
     */
    public int getxCor() {
        return xCor;
    }

    /**
     *
     * @param xCor Sets the last clicked X coordinate
     */
    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    /**
     *
     * @return Returns the last clicked y coordinate
     */
    public int getyCor() {
        return yCor;
    }

    /**
     *
     * @param yCor Sets the last clicked y coordinate
     */
    public void setyCor(int yCor) {
        this.yCor = yCor;
    }

    private boolean checkWinner(char token) {
        if (checkDiagonal(token) || checkVertical(token) || checkHorizontal(token)) {
            for (int i = 0; i < 5; i++) {
                boardMatrix[xCorArray[i]][yCorArray[i]] = '!';
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean checkHorizontal(char token) {
        int xAux = xCor + 1;
        int connected = 1;
        int i = 1;
        while (xAux < 10) {
            if (boardMatrix[xAux][yCor] != token) {
                break;
            }
            xCorArray[i] = xAux;
            yCorArray[i] = yCor;
            connected++;
            xAux++;
            i++;
            if (connected == 5) {
                return true;
            }
        }
        xAux = xCor - 1;
        while (xAux > -1) {
            if (boardMatrix[xAux][yCor] != token) {
                break;
            }
            xCorArray[i] = xAux;
            yCorArray[i] = yCor;
            connected++;
            xAux--;
            i++;
            if (connected == 5) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertical(char token) {
        int yAux = yCor + 1;
        int connected = 1;
        int i = 1;
        while (yAux < 10) {
            if (boardMatrix[xCor][yAux] != token) {
                break;
            }
            xCorArray[i] = xCor;
            yCorArray[i] = yAux;
            connected++;
            yAux++;
            i++;
            if (connected == 5) {
                return true;
            }
        }
        yAux = yCor - 1;
        while (yAux > -1) {
            if (boardMatrix[xCor][yAux] != token) {
                break;
            }
            xCorArray[i] = xCor;
            yCorArray[i] = yAux;
            connected++;
            yAux--;
            i++;
            if (connected == 5) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(char token) {
        int yAux = yCor + 1;
        int xAux = xCor + 1;
        int connected = 1;
        int i = 1;
        while (yAux < 10 && xAux < 10) {
            if (boardMatrix[xAux][yAux] != token) {
                break;
            }
            xCorArray[i] = xAux;
            yCorArray[i] = yAux;
            yAux++;
            xAux++;
            connected++;
            i++;
            if (connected == 5) {
                return true;
            }
        }
        yAux = yCor - 1;
        xAux = xCor - 1;
        while (yAux > -1 && xAux > -1) {
            if (boardMatrix[xAux][yAux] != token) {
                break;
            }
            xCorArray[i] = xAux;
            yCorArray[i] = yAux;
            yAux--;
            xAux--;
            connected++;
            i++;
            if (connected == 5) {
                return true;
            }
        }
        yAux = yCor + 1;
        xAux = xCor - 1;
        i = 1;
        connected = 1;
        while (yAux < 10 && xAux > -1) {
            if (boardMatrix[xAux][yAux] != token) {
                break;
            }
            xCorArray[i] = xAux;
            yCorArray[i] = yAux;
            yAux++;
            xAux--;
            connected++;
            i++;
            if (connected == 5) {
                return true;
            }
        }
        yAux = yCor - 1;
        xAux = xCor + 1;
        while (yAux > -1 && xAux < 10) {
            if (boardMatrix[xAux][yAux] != token) {
                break;
            }
            xCorArray[i] = xAux;
            yCorArray[i] = yAux;
            yAux--;
            xAux++;
            connected++;
            i++;
            if (connected == 5) {
                return true;
            }
        }
        return false;
    }
}
