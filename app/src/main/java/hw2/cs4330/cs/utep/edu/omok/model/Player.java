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
public class Player {


    private String name;
    private boolean playerOne;

    /**
     *
     * @param one Flag that indicates if the player one or two
     */
    public Player(boolean one) {
        playerOne = one;
    }


    /**
     *
     * @return Returns the players name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Sets the players name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Returns if is player one
     */
    public boolean isPlayerOne() {
        return playerOne;
    }

    /**
     *
     * @param playerOne Sets if is player one
     */
    public void setPlayerOne(boolean playerOne) {
        this.playerOne = playerOne;
    }

}
