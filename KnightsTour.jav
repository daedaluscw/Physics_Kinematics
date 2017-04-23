
public class KnightsTour {
	
	private int moveCounter = 0;
	private final int BOARDMAX = 8;
	private final int BOARDMIN = 0;
	private final int MAXMOVES = 63;
	int highest = 0;
	
	private int[][] board = new int[BOARDMAX][BOARDMAX];
	private int[][] bannedBoard = new int[BOARDMAX][BOARDMAX];
	
	

	KnightsTour()
	{
		this.initialBoard();
		
	}
	
	
	
	public void solveKnight()
	{
		if (this.solveKnightsTour(0, 0, 0))
		{
			this.displayBoard();
			System.out.println("Final Board");
		}
		else
		{
			System.out.println("ERROR ERROR");
		}
	}
	
	private boolean solveKnightsTour( int X, int Y, int index)
	{
		
		if ( index != 0 )
		{
			
			if ( board[X][Y] != 0)
			{
				return false;
				
			}
		}
		
		//if ( index == 0)
		//{
			//board[0][0] = 0;
		//}
		
		board[X][Y] = moveCounter;
		moveCounter = moveCounter+1;
		if ( index ==  MAXMOVES)
		{
			this.displayBoard();
			return true;
		}
		if ( highest < moveCounter) { highest = moveCounter;}
		System.out.println("Move: " + moveCounter + " Highest: " + highest);
		
		
		
		if (tryLocation((X + 2), (Y + 1)) && solveKnightsTour( ( X + 2), ( Y + 1), index+1))
		{
			return true;
		}
		
		if (tryLocation((X + 1), (Y + 2)) && solveKnightsTour( ( X + 1), ( Y + 2), index+1))
		{
			return true;
		}
		
		if (tryLocation((X - 1), (Y + 2)) && solveKnightsTour( ( X - 1), ( Y + 2), index+1))
		{
			return true;
		}
		
		if (tryLocation((X - 2), (Y + 1)) && solveKnightsTour( ( X - 2), ( Y + 1), index+1))
		{
			return true;
		}
		
		if (tryLocation((X - 2), (Y - 1)) && solveKnightsTour( ( X - 2), ( Y - 1), index+1))
		{
			return true;
		}
		
		if (tryLocation((X - 1), (Y - 2)) && solveKnightsTour( ( X - 1), ( Y - 2), index+1))
		{
			return true;
		}
		
		if (tryLocation((X + 1), (Y - 2)) && solveKnightsTour( ( X + 1), ( Y - 2), index+1))
		{
			return true;
		}
		
		if (tryLocation((X + 2), (Y - 1)) && solveKnightsTour( ( X + 2), ( Y - 1), index+1))
		{
			return true;
		}
		
		board[X][Y] = 0;
		moveCounter--;
		return false;

		
		
	}
	
	/*
	private void moveBack( int X, int Y)
	{
		int newX = 0;
		int newY = 0;
		
		board[X][Y] = 0;  //Reset the current location
		
		//look for the previous location
		for ( int i = 0; i < BOARDMAX; i++)
		{
			for ( int j = 0; j < BOARDMAX; j++)
			{
				if ( board[i][j] == (moveCounter - 1))
				{
					newX = i;
					newY = j;
					
				}
			}
			
		}
		moveCounter--;
		this.solveKnightsTour(newX, newY);
		//Re-start our search from the previous location
	}
	*/
	/*
	private boolean tryPosition1( int X, int Y)
	{
		int moveX = X + 1;
		int moveY = Y + 2;
		if ( (moveX < BOARDMAX) && ( moveX >= BOARDMIN))
		{
			if ( (moveY < BOARDMAX) && ( moveY >= BOARDMIN))
			{
				if ( (board[moveX][moveY] == 0) && (bannedBoard[moveX][moveY] != moveCounter))
				{
					
					//moveCounter++;
					return true;
					
				}
			}
		}
		return false;
	}
	
	private boolean tryPosition2( int X, int Y)
	{
		int moveX = X + 2;
		int moveY = Y + 1;
		if ( (moveX < BOARDMAX) && ( moveX >= BOARDMIN))
		{
			if ( (moveY < BOARDMAX) && ( moveY >= BOARDMIN))
			{
				if ( (board[moveX][moveY] == 0) && (bannedBoard[moveX][moveY] != moveCounter))
				{
					return true;
					
				}
			}
		}
		return false;
	}
	
	private boolean tryPosition3 ( int X, int Y)
	{
		int moveX = X + 2;
		int moveY = Y - 1;
		if ( (moveX < BOARDMAX) && ( moveX >= BOARDMIN))
		{
			if ( (moveY < BOARDMAX) && ( moveY >= BOARDMIN))
			{
				if ( (board[moveX][moveY] == 0) && (bannedBoard[moveX][moveY] != moveCounter))
				{
					return true;
					
				}
			}
		}
		return false;
	}
	
	private boolean tryPosition4( int X, int Y)
	{
		int moveX = X + 1;
		int moveY = Y - 2;
		if ( (moveX < BOARDMAX) && ( moveX >= BOARDMIN))
		{
			if ( (moveY < BOARDMAX) && ( moveY >= BOARDMIN))
			{
				if ( (board[moveX][moveY] == 0) && (bannedBoard[moveX][moveY] != moveCounter))
				{
					return true;
					
				}
			}
		}
		return false;
	}
	
	private boolean tryPosition5 ( int X, int Y)
	{
		int moveX = X - 1;
		int moveY = Y - 2;
		if ( (moveX < BOARDMAX) && ( moveX >= BOARDMIN))
		{
			if ( (moveY < BOARDMAX) && ( moveY >= BOARDMIN))
			{
				if ( (board[moveX][moveY] == 0) && (bannedBoard[moveX][moveY] != moveCounter))
				{
					return true;
					
				}
			}
		}
		return false;
	}
	
	private boolean tryPosition6( int X, int Y)
	{
		int moveX = X - 2;
		int moveY = Y - 1;
		if ( (moveX < BOARDMAX) && ( moveX >= BOARDMIN))
		{
			if ( (moveY < BOARDMAX) && ( moveY >= BOARDMIN))
			{
				if ( (board[moveX][moveY] == 0) && (bannedBoard[moveX][moveY] != moveCounter))
				{
					return true;
					
				}
			}
		}
		return false;
	}
	
	private boolean tryPosition7 ( int X, int Y)
	{
		int moveX = X - 2;
		int moveY = Y + 1;
		if ( (moveX < BOARDMAX) && ( moveX >= BOARDMIN))
		{
			if ( (moveY < BOARDMAX) && ( moveY >= BOARDMIN))
			{
				if ( (board[moveX][moveY] == 0) && (bannedBoard[moveX][moveY] != moveCounter))
				{
					return true;
					
				}
			}
		}
		return false;
	}
	
	private boolean tryPosition8 ( int X, int Y)
	{
		int moveX = X - 1;
		int moveY = Y + 2;
		if ( (moveX < BOARDMAX) && ( moveX >= BOARDMIN))
		{
			if ( (moveY < BOARDMAX) && ( moveY >= BOARDMIN))
			{
				if ( (board[moveX][moveY] == 0) && (bannedBoard[moveX][moveY] != moveCounter))
				{
					
					return true;
					
				}
			}
		}
		return false;
	}

*/
	private boolean tryLocation( int X, int Y)
	{
		if ( ( X < BOARDMAX ) && ( X >= BOARDMIN) && ( Y < BOARDMAX) && ( Y >= BOARDMIN))
		{
			return true;
		}
		return false;
	}
	
	
	public void displayBoard()
	{
		for ( int i = 0; i < BOARDMAX; i++)
		{
			for ( int j = 0; j < BOARDMAX; j++)
			{
				if ( board[i][j] < 10)
				{
					System.out.print("0" + board[i][j] + " ");
				}
				else
				{
					System.out.print(board[i][j] + " ");
				}
				//System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void initialBoard()
	{
		for ( int i = 0; i < 8; i++)
		{
			for ( int a = 0; a < 8; a++)
			{
				board[i][a] = 0;
				bannedBoard[i][a] = 0;
			}
		}
		board[0][0] = 1;
		moveCounter++;
	}
	
//	private void initialBoardDefinedLocation( int X, int Y)
//	{
//		for ( int i = 0; i < 8; i++)
//		{
//			for ( int a = 0; a < 5; a++)
//			{
//				board[i][a] = 0;
//				bannedBoard[i][a] = 0;
//			}
//		}
//		board[X][Y] = 1;
//		moveCounter++;
//	}

}
