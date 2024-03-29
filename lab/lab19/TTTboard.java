import java.io.*;

public class TTTboard {
	/*
	 * Tasks:
	 * 1. Add methods to the TTTBoard class that test two ways to hash Tic-tac-toe boards.
	 * 
	 * a. In one, you should convert the board to a String and then use the String 
	 * hashCode function. 
	 * 
	 * b. In the other, you should interpret the Tic-tac-toe board as a nine-digit base 3
	 * numeral and return the corresponding integer as the hash value. Compare the 
	 * performance of these two implementations (There is a hint about this one on 
	 * the next page.)
	 */

    private char[ ][ ] myBoard;

    // Initialize a blank Tic-tac-toe board.
    public TTTboard ( ) {
        myBoard = new char[3][3];
	for (int r=0; r<3; r++) {
	    for (int c=0; c<3; c++) {
		setCell (r, c, BLANK);
	    }
	}
    }
    
    // Initialize a Tic-tac-toe board from the given value
    // by interpreting the value in base 3 and representing
    // a 0 as a blank, a 1 as an X, and a 2 as an O.
    public TTTboard (int base3) {
	myBoard = new char[3][3];
	for (int r=0; r<3; r++) {
	    for (int c=0; c<3; c++) {
		int digit = base3 % 3;
		switch (digit) {
		case 0:
		    setCell (r, c, BLANK); 
		    break;
		case 1: 
		    setCell (r, c, 'X'); 
		    break;
		case 2:
		    setCell (r, c, 'O'); 
		    break;
		}
		base3 = base3/3;
	    }
        }
    }
	
    private void setCell (int r, int c, char value) {
	myBoard[r][c] = value;
    }
	
    private char cell (int r, int c) {
	return myBoard[r][c];
    }
    
    public int hashCode ( ) {
	// YOU REPLACE THE BODY OF THIS METHOD.
    	// 1. Hashes the String version of the board.
    	//return myBoard.toString().hashCode();
    	return this.toBase3();
    }

    public String toString() {
    	/*
    	 * Main difficulties encountered:
    	 * 1. STRINGS ARE IMMUTABLE!!
    	 * I was stuck because I was wondering why s.concat() didn't print out
    	 * anything. It was because it was returning a string, and not mutating String s
    	 * itself.
    	 * To get around this, you need to reassign the result of s.concat() to s again.
    	 * This is how I got to build up the immutable string.
    	 */
    	String s = new String();
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
				if (cell (r, c) == BLANK) {
				    s = s.concat("-");
				} else {
				    s = s.concat(Character.toString(cell(r, c)));
				}
            }
        }
		return s;
    }
    
    public int toBase3() {
    	String s = this.toString();
    	s = s.replace('-', '0');
    	s = s.replace('X', '1');
    	s = s.replace('O', '2');
    	return Integer.parseInt(s);
    }
    
    private static final char BLANK = ' ';
    
    // Handle a player's move.
    // If player1isMoving, the move is 'x', otherwise it's 'o'.
    // If the chosen move isn't blank, print an error message
    // and don't do anything.
    public void makeMove (boolean player1isMoving, int row, int col) {
        if (cell (row, col) != BLANK) {
            System.err.println ("Can't move to " + row + "," + col
                + "; move already made.");
        } else if (player1isMoving) {
            setCell (row, col, 'X');
        } else {
            setCell (row, col, 'O');
        }
		if (wins (row, col)) {
			System.out.println ("win");
		}
    }
    
    // Determine if the move just made was a winner, that is,
    // created three in a row of whoever moved.
    public boolean wins (int row, int col) {
        switch (row) {
        case 0:
            switch (col) {
            case 0: return allMatch (0, 1, 2) || allMatch (0, 3, 6) || allMatch (0, 4, 8);
            case 1: return allMatch (0, 1, 2) || allMatch (1, 4, 7);
            case 2: return allMatch (0, 1, 2) || allMatch (2, 5, 8) || allMatch (2, 4, 6);
            }
        case 1:
            switch (col) {
            case 0: return allMatch (3, 4, 5) || allMatch (0, 3, 6);
            case 1: return allMatch (3, 4, 5) || allMatch (1, 4, 7)
                || allMatch (0, 4, 8) || allMatch (2, 4, 6);
            case 2: return allMatch (3, 4, 5) || allMatch (2, 5, 8);
            }
        case 2:
            switch (col) {
            case 0: return allMatch (6, 7, 8) || allMatch (0, 3, 6) || allMatch (2, 4, 6);
            case 1: return allMatch (6, 7, 8) || allMatch (1, 4, 7);
            case 2: return allMatch (6, 7, 8) || allMatch (2, 5, 8) || allMatch (0, 4, 8);
            }
        }
	return false;
    }
        
    // a, b, and c represent the internal coordinates of the elements
    // of a row, column, or diagonal of the board, at least one of which
    // is nonblank.  Return true if they all match.
    private boolean allMatch (int a, int b, int c) {
	int rowa = a/3;
	int cola = a%3;
	int rowb = b/3;
	int colb = b%3;
	int rowc = c/3;
	int colc = c%3;
	return cell (rowa, cola) == cell (rowb, colb)
		&& cell (rowb, colb) == cell (rowc, colc);
    }
    
    public void print ( ) {
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
		if (cell (r, c) == BLANK) {
		    System.out.print ("-");
		} else {
		    System.out.print (cell (r, c));
		}
            }
            System.out.println ("");
        }
	System.out.println ("");
    }
	
    public static void main (String [ ] args) {
	TTTboard board = new TTTboard ( );
	board.print ( );
	board.makeMove (true, 1, 1);
	board.print ( );
	board.makeMove (false, 0, 0);
	board.print ( );
	board.makeMove (true, 0, 2);
	board.print ( );
	/*
	// tie game
	board.makeMove (false, 2, 0);
	board.print ( );
	board.makeMove (true, 1, 0);
	board.print ( );
	board.makeMove (false, 1, 2);
	board.print ( );
	board.makeMove (true, 0, 1);
	board.print ( );
	board.makeMove (false, 2, 1);
	board.print ( );
	board.makeMove (true, 2, 2);
	board.print ( );
	*/ 
	// end of tie game
	// x wins
	board.makeMove (false, 2, 1);
	board.print ( );
	board.makeMove (true, 2, 0);
	board.print ( );
	// end of x wins
	//System.out.println(board.toString());
	System.out.println(board.toBase3());
    }
}
