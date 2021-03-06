package ProjecteProblemas;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class BoardTest {

	@Test
	public void testSetBoard() {
		
		//Test de Caja negra - Particiones equivalentes y valores l�mites/frontera
		//Caja Blanca - Decision, Condition y Path Coverage
		//Check si se ha inizializado bien (todas las casillas = 0)
		int test_1=10; //V�lido
		int test_2=16; //V�lido
		int test_3=20; //V�lido
		int test_4=0; //Inv�lido
		int test_5=-1; //Inv�lido
		int test_6=100; //Inv�lido
		
		
		Square[][] squares;
		squares = new Square[10][10];
		boolean check = true;
		Board b = new Board();
		
		b.setBoard(1);
		
		assertEquals(test_1, b.size);
		
		
		
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
		//Check si se ha inizializado bien (dificultad 3)
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
			
			
		//Pasamos por el Default - Coverage y Path
			Board b_4 = new Board();
			b_4.setBoard(test_4);
			assertEquals(0,b_4.size);
			
		//Valores frontera
			Board b_5 = new Board();
			check = true;
			b_5.setBoard(test_5);
			//Comprobamos que el tablero no se inicializa correctamente
			assertEquals(0,b_5.size);
			
			
			Square[][] squares_6;
			Board b_6 = new Board();
			check = true;
			b_6.setBoard(test_6);
			//Comprobamos que el tablero no se inicializa correctamente
			assertEquals(0,b_6.size);
	}

	@Test
	public void testRestartBoard() {
		//Coverage
		Board b = new Board();
		b.restartBoard();
		assertEquals(0,b.size);
	}

	
	@Test
	public void testGenerateRandomMines() {
		//Coverage Testing
		//Caixa negre
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
		
		//Loop Testing - Caja Blanca
			//No pasa por el bucle 
			Board board_2 = new Board();
			board_2.size=0;
			board_2.generateRandomMines();
			
			//Pasar� 1 vez por el bucle
			Board board_3 = new Board();
			board_3.size=1;
			board_3.generateRandomMines();
			
			//Pasar� 2 vez por el bucle
			Board board_4 = new Board();
			board_4.size=2;
			board_4.generateRandomMines();
			
			//Pasar� n<m vez por el bucle
			Board board_5 = new Board();
			board_5.setBoard(1);
			board_5.size=board_5.size-1;
			board_5.generateRandomMines();
			
			//Pasar� n=m veces por el bucle
			board_5.size=board_5.size+1;
			board_5.generateRandomMines();
			
			
		
		
	}
	
	@Test
	public void testOpenSquare()
	{
		//Caja Negra - Particion equivalentes y valores frontera
		//Valores v�lidos
		//Test Coverage, Decision y Condition
		//Test Path Coverage: El m�todo tiene 2 caminos
			//Check para verificar si el m�todo cambia el valor de un Square ( Camino 1: Casilla est� cerrada y la abrimos)
			boolean check=false;
			int test_1=10;
			Board board_1 = new Board();
			board_1.setBoard(1);
			board_1.openSquare(0, 0);
			
			assertEquals(true,board_1.squares[0][0].open);
			
			
			//Como el Test anterior pero provando el nuevo dise�o del c�digo 
			boolean check_2=false;
			int test_2=10;
			Board board_2 = new Board();
			board_2.setBoard(2);
			
			assertTrue(board_2.openSquare(1, 1));
			
			//Camino 2: La casilla ya est� abierta
			//Ahora probamos que no se puede volver abrir una casilla abierta
			assertFalse(board_2.openSquare(1, 1));
			//Valores inv�lidos, se salen de frontera
			assertEquals(false,board_2.putFlag(-1,-1));
			assertEquals(false,board_2.putFlag(-1,1));
			assertEquals(false,board_2.putFlag(1,-1));
			
			assertEquals(false,board_2.putFlag(100,-1));
			assertEquals(false,board_2.putFlag(-1,100));
			
			assertEquals(false,board_2.putFlag(1,100));
			assertEquals(false,board_2.putFlag(100,100));
			
		
		
		
	}
	
	@Test
	public void testCalculateValue()
	{
		//Coverage Test
		//Crearemos un tablero resultado (board_mock_1) y un tablero normal (board_test)
		//los cuales al final compararemos si los valores de las casillas son iguales
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
		board_mock_1.squares[0][1].value=2;
			board_mock_1.squares[0][6].value=1;
			board_mock_1.squares[1][0].value=1;
			board_mock_1.squares[1][1].value=2;
			board_mock_1.squares[1][2].value=2;
			board_mock_1.squares[1][3].value=3;
			board_mock_1.squares[1][4].value=3;
			board_mock_1.squares[1][5].value=2;
			board_mock_1.squares[1][6].value=1;
			
		//Segunda fila de minas
			board_mock_1.squares[3][7].makeBomb();
			//Valor de las casillas
			board_mock_1.squares[2][6].value=1;
			board_mock_1.squares[2][7].value=1;
			board_mock_1.squares[2][8].value=1;
			board_mock_1.squares[3][6].value=1;
			board_mock_1.squares[3][8].value=1;
			board_mock_1.squares[4][4].value=1;
			board_mock_1.squares[4][5].value=1;
			board_mock_1.squares[4][6].value=3;
			board_mock_1.squares[4][7].value=2;
			board_mock_1.squares[4][8].value=2;
		
		//Tercera fila de minas
			board_mock_1.squares[5][5].makeBomb();
			board_mock_1.squares[5][7].makeBomb();
			//Valor de las casillas
			board_mock_1.squares[5][4].value=1;
			board_mock_1.squares[5][6].value=2;
			board_mock_1.squares[5][8].value=1;
			board_mock_1.squares[6][4].value=1;
			board_mock_1.squares[6][5].value=1;
			board_mock_1.squares[6][6].value=3;
			board_mock_1.squares[6][7].value=2;
			board_mock_1.squares[6][8].value=2;
			
		//Cuarta fila de minas
			board_mock_1.squares[7][7].makeBomb();
			//Valor casillas
			board_mock_1.squares[7][6].value=2;
			board_mock_1.squares[7][8].value=2;
		//Quinta fila de minas
			board_mock_1.squares[8][7].makeBomb();
			//Valor casillas
			board_mock_1.squares[8][6].value=2;
			board_mock_1.squares[8][8].value=2;
			board_mock_1.squares[9][6].value=1;
			board_mock_1.squares[8][7].value=1;
			board_mock_1.squares[8][8].value=1;
			
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
		
		board_test_1.calculateValue();
		
		boolean check=true;
		
		int i=0;
		int j=0;
		while(check && i < test_1)
		{
			while(check && j < test_1)
			{
				if (board_test_1.squares[i][j].bomb != board_mock_1.squares[i][j].bomb)
					check=false;
				j++;
			}
			j=0;
			i++;
		}
		assertTrue(check);
	}
	
	
	@Test
	public void testPutFlag()
	{
		//Path coverage, Cubrimos los 3 caminos que tiene la funci�n
		//Ponemos bandera
		Board b = new Board();
		b.setBoard(1); // Size= 10
		b.putFlag(1,1);
		
		assertEquals(true,b.squares[1][1].flag);
		
		//Ponemos otra vez bandera (osea la quitamos)
		b.putFlag(1,1);
		assertEquals(false,b.squares[1][1].flag);
		//Decision Coverage 
		//Condition Coverage y Caja Negra ( Valores l�mite y frontera)
			//Nos salimos de los l�mites de la matriz
			assertEquals(false,b.putFlag(-1,-1));
			assertEquals(false,b.putFlag(-1,1));
			assertEquals(false,b.putFlag(1,-1));
			
			assertEquals(false,b.putFlag(100,-1));
			assertEquals(false,b.putFlag(-1,100));
			
			assertEquals(false,b.putFlag(1,100));
			
			//Nos salimos de los l�mites de la matriz
			assertEquals(false,b.putFlag(100,100));
			
		
			assertEquals(true,b.putFlag(0,0));
			assertEquals(true,b.putFlag(0,1));
			assertEquals(true,b.putFlag(0,2));
			assertEquals(true,b.putFlag(0,3));
			assertEquals(true,b.putFlag(0,4));
			assertEquals(true,b.putFlag(0,5));
			assertEquals(true,b.putFlag(0,6));
			assertEquals(true,b.putFlag(0,7));
			assertEquals(true,b.putFlag(0,8));
			assertEquals(true,b.putFlag(0,9));
			//No le dejar�
			assertEquals(false,b.putFlag(1,0));
			//
			assertEquals(false,b.putFlag(0,9));
			assertEquals(true,b.putFlag(1,0));
			
	}
	
	@Test
    public void testgameOver()
    {
     
        Board b = new Board();
        b.setBoard(1); //10 minas
       
        //Caso no hay minas
        assertEquals(true,b.gameOver());
       
        //Ponemos las 10 minas en el tablero
        b.squares[0][0].makeBomb();
        b.squares[0][1].makeBomb();
        b.squares[0][2].makeBomb();
        b.squares[0][3].makeBomb();
        b.squares[0][4].makeBomb();
        b.squares[0][5].makeBomb();
        b.squares[0][6].makeBomb();
        b.squares[0][7].makeBomb();
        b.squares[0][8].makeBomb();
        b.squares[0][9].makeBomb();
       
        //Indicamos al tablero las posiciones de las minas
        for(int i=0;i<b.size;i++) {
            Pair e= new Pair(0,i);
            b.mines_position.add(e);
        }
       
        //Ponemos las banderas en las minas puestas
        for(int i=0;i<b.size;i++) {
            b.putFlag(b.mines_position.get(i).x, b.mines_position.get(i).y);
        }
        assertEquals(true,b.gameOver());
       
       
        //Ponemos las banderas en las minas puestas menos en la 8
        for(int i=0;i<b.size;i++) {
            if (i==8){
                i=i;
            }
            else
                b.putFlag(b.mines_position.get(i).x, b.mines_position.get(i).y);
        }
        assertEquals(false,b.gameOver());
       
    }
	
	
	@Test
	public void testRecursiveOpenSquare()
	{
		
		//Test Caja Negra - Valores l�mites/Frontera
		//Valor v�lido
		//No pondremos ninguna bomba, as� que todas las casillas deber�n ser abiertas
		Board b = new Board();
		b.setBoard(1); //10x10
		b.recursiveOpenSquare(0, 0);
		boolean check=true;
		int i=0;
		int j=0;
		while(check && i < b.size)
		{
			while(check && j < b.size)
			{
				if (!b.squares[i][j].open)
					check=false;
				j++;
			}
			j=0;
			i++;
		}
		assertEquals(true,check);
		//Valor v�lido
		//Pondremos bombas, calcularemos valores para las casillas y verificaremos
		//si el m�todo nos da igual al tablero "Mock"
		
		Board b_2 = new Board();
		b_2.setBoard(1);
		b_2.squares[0][0].makeBomb();
		b_2.squares[0][2].makeBomb();
		b_2.squares[0][3].makeBomb();
		b_2.squares[0][4].makeBomb();
		b_2.squares[0][5].makeBomb();
		b_2.squares[3][7].makeBomb();
		b_2.squares[5][5].makeBomb();
		b_2.squares[5][7].makeBomb();
		b_2.squares[7][7].makeBomb();
		b_2.squares[8][7].makeBomb();
		
		b_2.calculateValue();
		b_2.recursiveOpenSquare(0, 9);
		
		Board b_mock2 = new Board();
		b_mock2.setBoard(1);
		b_mock2.openSquare(0, 6);
		b_mock2.openSquare(0, 7);
		b_mock2.openSquare(0, 8);
		b_mock2.openSquare(0, 9);
		b_mock2.openSquare(1, 6);
		b_mock2.openSquare(1, 7);
		b_mock2.openSquare(1, 8);
		b_mock2.openSquare(1, 9);
		b_mock2.openSquare(2, 6);
		b_mock2.openSquare(2, 7);
		b_mock2.openSquare(2, 8);
		b_mock2.openSquare(2, 9);
		b_mock2.openSquare(3, 8);
		b_mock2.openSquare(3, 9);
		b_mock2.openSquare(4, 8);
		b_mock2.openSquare(4, 9);
		b_mock2.openSquare(5, 8);
		b_mock2.openSquare(5, 9);
		b_mock2.openSquare(6, 8);
		b_mock2.openSquare(6, 9);
		b_mock2.openSquare(7, 8);
		b_mock2.openSquare(7, 9);
		b_mock2.openSquare(8, 8);
		b_mock2.openSquare(8, 9);
		b_mock2.openSquare(9, 8);
		b_mock2.openSquare(9, 9);
		
		boolean check_2=true;
		int i_2=0;
		int j_2=0;
		while(check_2 && i_2 < b_2.size)
		{
			while(check_2 && j_2 < b_2.size)
			{
				if (b_2.squares[i_2][j_2].open != b_mock2.squares[i_2][j_2].open)
				{
					check_2=false;
				}
				j_2++;
			}
			j_2=0;
			i_2++;
		}
		assertEquals(true,check);
		
		//Caixa Blanca - Valores frontera/l�mite
		b.recursiveOpenSquare(-1,-1);
		b.recursiveOpenSquare(-1,1);
		b.recursiveOpenSquare(1,-1);
		b.recursiveOpenSquare(100,-1);
		b.recursiveOpenSquare(-1,100);
		b.recursiveOpenSquare(1,100);
		b.recursiveOpenSquare(100,100);
	}
	
	@Test
	public void testLoseGame()
	{
		
		//Caso jugador abre mina
		Board b=new Board();
		randomMock rand = new randomMock();
		Pair[] pairs=new Pair[1];
		pairs[0]=new Pair(1,1);
		b.setBoard(1);
		rand.setMinesPosition(pairs,b.size);
		
		b.setRandom(rand);
		b.generateRandomMines();
		//b.squares[1][1].makeBomb();
		b.openSquare(1, 1);
		
		assertEquals(true,b.loseGame());
		
		//Caso jugador no abre mina
		
		Board b_2=new Board();
		randomMock rand_2 = new randomMock();
		Pair[] pairs_2=new Pair[1];
		pairs_2[0]=new Pair(1,1);
		b_2.setBoard(1);
		rand_2.setMinesPosition(pairs_2,b_2.size);
		b_2.setRandom(rand_2);
		b_2.generateRandomMines();
		
		assertEquals(false,b_2.loseGame());
	
	}
	
	@Test
	public void testDrawBoard()
	{
		//Test Caixa blanca: Decision y Condition
		Board b=new Board();
		b.setBoard(1);
		b.squares[0][0].value=1;
		b.squares[0][0].open=true;
		b.squares[0][1].makeBomb();
		b.squares[0][1].open=true;
		b.putFlag(0, 2);
		
		b.drawBoard();
	}
	

}
