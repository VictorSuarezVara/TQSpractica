package ProjecteProblemas;

public class Game {

	Board b = new Board();
	Keyboard k = new Keyboard();

	void setBoard(Board board) {
		b=board;
	}

	void setKeyboard(Keyboard keyboard) {
		k=keyboard;
	}
	
	/*
	public static void main(String[] args) {
		Board b = new Board();
	}
	*/
	
	public void gameStart(int i)
	{
		/*
		b.setBoard(i);
		b.generateRandomMines();
		b.calculateValue();
		b.drawBoard(); //Introduce bandera o abre mina
		while(!b.gameOver() && !b.loseGame())
		{
			
		}
		*/
		
	}
	
	public void playSquare()
	{
		
	}
	
	public void initializeBoard(int difficult)
	{
		b.setBoard(difficult);
	}
	
	

}
