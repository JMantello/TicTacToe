/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jonathanmantello.tictactoe_jm;

/**
 *
 * @author jonat
 */
public class Game {
    // Fields
    private Box[][] gameboard;
    private BOX_STATE marker;
    private String winner;
    int movesRemaining;

    // Constructor
    public Game() {
        initGame();
    }
    
    // Methods
    private void initGame() {
        setGameboardToEmpty();
        marker = BOX_STATE.X;
        winner = null;
        movesRemaining = 9;
    }
    
    private void setGameboardToEmpty() {
        gameboard = new Box[3][3];
        for(int i = 0; i < gameboard.length; i++) {
            for(int j = 0; j < gameboard[i].length; j++) {
                gameboard[i][j] = new Box();
            }
        }
    }

    public void markBoard(int row, int column) {
        Box clickedBox = gameboard[row][column];

        if(clickedBox.getState() == BOX_STATE.EMPTY) {
            clickedBox.mark(marker);
            switchMarker();
            movesRemaining--;
        }
    }
    
    private void switchMarker() {
        if(marker.equals(BOX_STATE.O))
            marker = BOX_STATE.X;
        else
            marker = BOX_STATE.O;
    }
    
    private Boolean isWinner() {
        checkForWin(BOX_STATE.X);
        checkForWin(BOX_STATE.O);
        if(winner != null){
            return true;
        }
        return false;
    }
    
    private void checkForWin(BOX_STATE boxState) {
        // Horizontal win
        for(int i = 0; i < gameboard.length; i++) { // For each row
            if(gameboard[i][0].getState().equals(boxState) &&
               gameboard[i][1].getState().equals(boxState) &&
               gameboard[i][2].getState().equals(boxState)) {
                winner = boxState.name();
            }
        }
        
        // Vertical win
        for(int i = 0; i < gameboard.length; i++) {
            if(gameboard[0][i].getState().equals(boxState) && 
               gameboard[1][i].getState().equals(boxState) && 
               gameboard[2][i].getState().equals(boxState)) {
                winner = boxState.name();
            }
        }
        
        // Diagonal win
        if(gameboard[0][0].getState().equals(boxState) &&
           gameboard[1][1].getState().equals(boxState) &&
           gameboard[2][2].getState().equals(boxState)) {
            winner = boxState.name();
        }
        
        if(gameboard[2][0].getState().equals(boxState) && 
           gameboard[1][1].getState().equals(boxState) &&
           gameboard[0][2].getState().equals(boxState)) {
            winner = boxState.name();
        }
        
    }
    
    public Box[][] getGameboard() {
        Box[][] gameboardCopy = new Box[3][3];
        for(int i = 0; i < gameboard.length; i++) {
            for(int j = 0; j < gameboard[i].length; j++) {
                gameboardCopy[i][j] = gameboard[i][j];
            }
        }
        return gameboardCopy;
    }
    
    public Boolean isFinished() {
        return isWinner() || movesRemaining == 0;
    }
    
    public String getOutcome() {
        if(isWinner())
            return "Winner is " + winner + "!";
        else
            return "Draw";
        
    }

    public String getWinner(){
        return winner;
    }

}
