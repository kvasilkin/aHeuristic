# aHeuristic

Katherine Vasilkin
Lorenzo Schneiderman
Pd 6
 
   The end product ended up being a 1 player, person vs. computer game with an option to change difficulty. The difficulty is based on the depth of the algorithm, or how many turns into the future it sees. This is toggled by the slider on the right with the light blue showing how difficult it is. This is a standard ConnectFour game which you win by getting 4 in a row horizontally, vertically, or diagonally. The human player is always red and goes first, and the computer is black. You play by clicking the button under the column of your desired turn. 

   To Play:
   		1. Compile ConnectFourTest.java
   		2. Run start.pde
   		3. Select your difficulty using the slider (this can be changed between turns and is updated immediately)
   		4. Press the button under the column in which you wish to place your piece
	    5. Try to connect Four

   Bugs:	
   		There was a problem with the algorithm ignoring obvious winning / losing  moves, which was fixed by implementing a bot that looks for three in a row that can be blocked or used to win the game.

	   If the board gets too full, an indexOutOfBounds exception is thrown

	   The algorithm uses a depth first search, and therefore favors the left side of the board	

   Other Code:
		The code used for the buttons and slider was taken from http://www.sojamo.de, as well as the code within the button function that waits a ceratin amount of time before excecuting. The controlp5 library was used for the button and slider

	Progress:
	June 5th: ConnectFour.java was completed enough to have the capabilities of being checked through the main. At this point we transitioned to processing and therefore, there was never a completed terminal version of ConnectFour complete with user input
	June 10th: By this time the processing part of ConnectFour was complete and could be played by 2 players
	June 11th:  The algorithm and processing parts were brought together to create a game played by the computer
