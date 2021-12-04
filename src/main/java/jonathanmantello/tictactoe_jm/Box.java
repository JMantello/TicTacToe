/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jonathanmantello.tictactoe_jm;

/**
 *
 * @author jonat
 */
public class Box {
    private BOX_STATE state;

    public Box() {
        state = BOX_STATE.EMPTY;
    }

    public void mark(BOX_STATE newState){
        state = newState;
    }
    
    public BOX_STATE getState() {
        return state;
    }

    @Override
    public String toString() {
        if(state == BOX_STATE.EMPTY) {
            return "";
        }
        return state.name();
    }
}
