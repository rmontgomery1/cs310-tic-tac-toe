package edu.jsu.mcis;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this,width);
        
    }



    public String getMarkAsString(int row, int col) {       
        return (model.getMark(row, col).toString());       
    }
   
    public TicTacToeView getView() {       
        return view;       
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() instanceof JButton) {
            
            String button = ((JButton) event.getSource()).getName();
            int row = Integer.parseInt(button.substring(6,7));
            int col = Integer.parseInt(button.substring(7));
            
            if(model.makeMark(row, col)) {

                view.updateSquares();
                if(model.getResult().toString()=="X"){
                    view.showResult("X");
                    view.disableSquares();

                }
                else if(model.getResult().toString()=="O"){
                    view.showResult("O");
                    view.disableSquares();

                }
                else if(model.getResult().toString()=="TIE"){
                    view.showResult("TIE");
                    view.disableSquares();
                }
                else{
                    view.clearResult();

                }





            }


              
        }
    }

}
