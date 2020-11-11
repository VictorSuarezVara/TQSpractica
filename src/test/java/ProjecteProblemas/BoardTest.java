package ProjecteProblemas;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class BoardTest {

	/*
	@Test
	public void testBoard() {
		fail("Not yet implemented");
	}
	*/

	//Prueba
	@Test
	public void testSetBoard() {
		int test_1=10;
		int test_2=16;
		int test_3=20;
		int test_4=1;
		
		Square[][] squares;
		squares = new Square[10][10];
		boolean check = true;
		Board b = new Board();
		
		b.setBoard(1);
		
		
		assertEquals(test_1, b.size);
		
		
		//Check si se ha inizializado bien (todas las casillas = 0)
			for(int i =0 ; i<test_1;i++) {
				for(int j =0 ; j<test_1;j++) {
					squares[i][j] = new Square();
				}
			}
			
			int i=0;
			int j=0;
			while(check && i < test_1)
			{
				while(check && j < test_1)
				{
					if (squares[i][j].value != b.squares[i][j].value)
						check=false;
					j++;
				}
				j=0;
				i++;
			}
			//Comprobamos que las matrices se han inicializado correctamente
			assertTrue(check);
		
		Square[][] squares_2;
		squares_2 = new Square[test_2][test_2];
		Board b_2 = new Board();
		check = true;
		b_2.setBoard(2);
		i=0;
	    j=0;	
		//Check si se ha inizializado bien (dificultad 2)
			for( i =0 ; i<test_2;i++) {
				for( j =0 ; j<test_2;j++) {
					squares_2[i][j] = new Square();
				}
			}
			 i=0;
			 j=0;
			while(check && i < test_2)
			{
				while(check && j < test_2)
				{
					if (squares_2[i][j].value != b_2.squares[i][j].value)
						check=false;
					j++;
				}
				j=0;
				i++;
			}
			//Comprobamos que las matrices se han inicializado correctamente
			assertTrue(check);
			
		Square[][] squares_3;
		squares_3 = new Square[test_3][test_3];
		Board b_3 = new Board();
		check = true;
		b_3.setBoard(3);
		i=0;
	    j=0;	
		//Check si se ha inizializado bien (dificultad 2)
			for( i =0 ; i<test_3;i++) {
				for( j =0 ; j<test_3;j++) {
					squares_3[i][j] = new Square();
				}
			}
			i=0;
			j=0;
			while(check && i < test_3)
			{
				while(check && j < test_3)
				{
					if (squares_3[i][j].value != b_3.squares[i][j].value)
						check=false;
					j++;
				}
				j=0;
				i++;
			}
			//Comprobamos que las matrices se han inicializado correctamente
			assertTrue(check);
			
			
		//Pasamos por el Default
			Board b_4 = new Board();
			b_4.setBoard(4);
			
			assertEquals(0,b_4.size);
		
	}

	@Test
	public void testRestartBoard() {
		Board b = new Board();
		
		
		
		
	}

	
	@Test
	public void testGenerateRandomMines() {
		//Veremos si se ha puesto alguna bomba, con el check
		boolean check=false;
		int test_1=10;
		Board board_1 = new Board();
		board_1.setBoard(1);
		board_1.generateRandomMines();
		
		int i=0;
		int j=0;
		while(!check && i < test_1)
		{
			while(!check && j < test_1)
			{
				if (board_1.squares[i][j].bomb)
					check=true;
				j++;
			}
			j=0;
			i++;
		}
		
		assertTrue(check);
		
		board_1.drawBoard();
	}
	
	@Test
	public void testOpenSquare()
	{
		//Test para verificar si el m�todo cambia el valor de un Square
		boolean check=false;
		int test_1=10;
		Board board_1 = new Board();
		board_1.setBoard(1);
		board_1.openSquare(0, 0);
		
		check=board_1.squares[0][0].open;
		
		assertTrue(check);
		
		//Como el Test anterior pero provando el nuevo dise�o del c�digo 
		boolean check_2=false;
		int test_2=10;
		Board board_2 = new Board();
		board_2.setBoard(2);
		
		assertTrue(board_2.openSquare(1, 1));
		
		//Ahora probamos que no se puede volver abrir una casilla abierta
		assertFalse(board_2.openSquare(1, 1));
		
		
	}
	
	@Test
	public void testCalculateValue()
	{
		int test_1=10;
		Board board_mock_1 = new Board();
		board_mock_1.setBoard(1);
		
		//Primera fila de bombas
		board_mock_1.squares[0][0].makeBomb();
		board_mock_1.squares[0][2].makeBomb();
		board_mock_1.squares[0][3].makeBomb();
		board_mock_1.squares[0][4].makeBomb();
		board_mock_1.squares[0][5].makeBomb();
			//Valor de las casillas
		board_mock_1.squares[0][1].value="2";
			board_mock_1.squares[0][6].value="1";
			board_mock_1.squares[1][0].value="1";
			board_mock_1.squares[1][1].value="2";
			board_mock_1.squares[1][2].value="2";
			board_mock_1.squares[1][3].value="3";
			board_mock_1.squares[1][4].value="3";
			board_mock_1.squares[1][5].value="2";
			board_mock_1.squares[1][6].value="1";
			
		//Segunda fila de minas
			board_mock_1.squares[3][7].makeBomb();
			//Valor de las casillas
			board_mock_1.squares[2][6].value="1";
			board_mock_1.squares[2][7].value="1";
			board_mock_1.squares[2][8].value="1";
			board_mock_1.squares[3][6].value="1";
			board_mock_1.squares[3][8].value="1";
			board_mock_1.squares[4][4].value="1";
			board_mock_1.squares[4][5].value="1";
			board_mock_1.squares[4][6].value="3";
			board_mock_1.squares[4][7].value="2";
			board_mock_1.squares[4][8].value="2";
		
		//Tercera fila de minas
			board_mock_1.squares[5][5].makeBomb();
			board_mock_1.squares[5][7].makeBomb();
			//Valor de las casillas
			board_mock_1.squares[5][4].value="1";
			board_mock_1.squares[5][6].value="2";
			board_mock_1.squares[5][8].value="1";
			board_mock_1.squares[6][4].value="1";
			board_mock_1.squares[6][5].value="1";
			board_mock_1.squares[6][6].value="3";
			board_mock_1.squares[6][7].value="2";
			board_mock_1.squares[6][8].value="2";
			
		//Cuarta fila de minas
			board_mock_1.squares[7][7].makeBomb();
			//Valor casillas
			board_mock_1.squares[7][6].value="2";
			board_mock_1.squares[7][8].value="2";
		//Quinta fila de minas
			board_mock_1.squares[8][7].makeBomb();
			//Valor casillas
			board_mock_1.squares[8][6].value="2";
			board_mock_1.squares[8][8].value="2";
			board_mock_1.squares[9][6].value="1";
			board_mock_1.squares[8][7].value="1";
			board_mock_1.squares[8][8].value="1";
			
		Board board_test_1 = new Board();
		board_test_1.setBoard(1);
		board_test_1.squares[0][0].makeBomb();
		board_test_1.squares[0][2].makeBomb();
		board_test_1.squares[0][3].makeBomb();
		board_test_1.squares[0][4].makeBomb();
		board_test_1.squares[0][5].makeBomb();
		board_test_1.squares[3][7].makeBomb();
		board_test_1.squares[5][5].makeBomb();
		board_test_1.squares[5][7].makeBomb();
		board_test_1.squares[7][7].makeBomb();
		board_test_1.squares[8][7].makeBomb();
		
		boolean check=true;
		
		int i=0;
		int j=0;
		while(check && i < test_1)
		{
			while(check && j < test_1)
			{
				if (!board_test_1.squares[i][j].value.equals(board_mock_1.squares[i][j].value))
					check=false;
				j++;
			}
			j=0;
			i++;
		}
		assertTrue(check);
	}
	

}
