/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.cs4330.cs.utep.edu.omok.model;

/**
 * @author Lucas Assis Rodrigues and John Ramirez
 */
public class ConnectFiveGame {

    private Player[] players;
    private Board board;
    private boolean playerOneTurn;
    private boolean gameStarted;

    /**
     *
     */
    public ConnectFiveGame() {
        players = new Player[2];
        players[0] = new Player(true);
        players[0].setName("Player 1");
        players[1] = new Player(false);
        players[1].setName("Player 2");
        playerOneTurn = true;
        gameStarted = false;
        board = new Board();
    }

    /**
     * Creates a new board - Sets the turn as black - Starts the game
     */
    public void startNewGame(String nameOne, String nameTwo) {
        setPlayersNames(nameOne, nameTwo);
        board = new Board();
        gameStarted = true;
        playerOneTurn = true;
    }

    /**
     * @param xCor The x coordinate that the token is being placed
     * @param yCor The y coordinate that the token is being placed
     * @return Returns if the player won the game after the token has been
     * placed
     */
    public boolean placeToken(int xCor, int yCor) {
        boolean winState = false;
        if (checkValidPosition(xCor,yCor)) {
            Player player;
            if (playerOneTurn) {
                player = players[0];
            } else {
                player = players[1];
            }
            playerOneTurn = !playerOneTurn;
            winState = board.placeToken(player, xCor, yCor);
            gameStarted = !winState;
        }
        return winState;
    }

    public boolean checkValidPosition(int xCor, int yCor) {
        return board.getBoardMatrix()[xCor][yCor] == ' ';
    }

    public String getPlayerName() {
        if (!playerOneTurn) {
            return players[0].getName();
        } else {
            return players[1].getName();
        }
    }

    public void setPlayersNames(String nameOne, String nameTwo) {
        players[0].setName(nameOne);
        players[1].setName(nameTwo);
    }

    /**
     * @return Returns an array with booth players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * @param players Sets an array with booth players
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * @return Returns the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board Sets the board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return Returns if is the players one turn
     */
    public boolean isPlayerOneTurn() {
        return playerOneTurn;
    }

    /**
     * @param playerOneTurn Sets if it is players one turn
     */
    public void setPlayerOneTurn(boolean playerOneTurn) {
        this.playerOneTurn = playerOneTurn;
    }

    /**
     * @return Returns if the game started
     */
    public boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * @param gameStarted Sets if the game started
     */
    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

}
