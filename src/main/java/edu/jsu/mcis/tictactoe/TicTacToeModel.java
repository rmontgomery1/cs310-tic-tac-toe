package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] grid; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
        /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        grid = new Mark[width][width];

        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                grid[i][j]= Mark.EMPTY;
             }
        }
        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
            if ((isValidSquare (row, col))&& (!isSquareMarked (row, col)&& xTurn)){
         grid [row][col]=Mark.X;
         xTurn=false;
         
         return true;
        }
            else if ((isValidSquare (row, col))&& (!isSquareMarked (row, col)&& !xTurn)){
         grid [row][col]=Mark.O;
         xTurn=true;
        
         return true;
        }
         else{
             return false;
        }
        
    }
       
    
	
    private boolean isValidSquare(int row, int col) {

        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
         if ((row< width)&&(row>=0)&& (col<width)&&(col>=0)&&(!isSquareMarked(row,col))){
            return true;
        }
        else {
            return false;
        }
    }
        
    
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        if (grid[row][col].equals(Mark.X)){
            
            return true;
        }
        else if (grid[row][col].equals(Mark.O)){
            
            return true;
        }
        else{
            return false;
        }
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
        
        return grid[row][col];
        
    }
                
    
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */

        // INSERT YOUR CODE HERE
    
        if (isMarkWin(Mark.X) == true){
            return Result.X;
        } 
        else if (isMarkWin(Mark.O) == true){
            return Result.O;
        } 
        else if (isTie() == true) {
            return Result.TIE;
        } 
        else {
            return Result.NONE;
        }

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
{
        int count=0;
        for(int r=0; r<width;++r){
            for(int c=0; c<width;++c){
                if (grid[r][c]==mark){
                    count++;
                }
                if (count == width){
                    return true;
                }
            }
            count=0;
        }
        for(int c=0; c<width;++c){
            for(int r=0; r<width;++r){
                if (grid[r][c]==mark){
                    count++;                 
                }
                if (count == width){
                    return true;
                } 
            }
            count=0;
        }
        for (int i=0; i<width; ++i){
            if (grid[i][i]==mark){
                count++;               
            }
            //else{
             //   count=0;
            //}
            if (count ==width){
                return true;
            }
            
        }
        count = 0;
        for (int j=0; j<width; ++j){
            if( grid [j][width-1-j]==mark){
                count++;              
            }
           /* else{
                count=0;
            }*/
            if (count==width){
                return true;
            }
        }
        count = 0;
      
     return false;
    }

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE

        for (int r=0; r<width;++r){
            for (int c=0; c<width;c++){
                if ((!isSquareMarked(r,c))||(isMarkWin(Mark.X)||(isMarkWin(Mark.O)))){
                    return false;
                }
            }
        }
        
        return true;
        
    }
        

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
       
        for (int i=0 ;i<getWidth(); i++){
            output.append(i+1);
        }
        output.append("/n");

        for (int i=0 ;i<getWidth(); i++){
            output.append(i+1);
            for (int j=0;j<getWidth(); j++){
                output.append(Mark.EMPTY);
            }
            output.append("/n");
        }

        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
        
        return output.toString();
        
    }
    
}
