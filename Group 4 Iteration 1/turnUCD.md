# Take A Turn
# A Use Case Description

# Primary Actors:

* There will be up to four primary actors when taking a turn.
The actors are the players playing the game.

# Stakeholders and Interests:

* The Stakeholders for a turn are the actors.  They will be affected by how a turn is taken.

# Preconditions:

* The preconditions for taking a turn are as follows:
** The game board has been successfully set-up, and if there are any automated players, their skill level has been set.

# Postconditions:

* A player has succeeded in getting a target chip

# Main Success Scenario:

* This success scenario is described for an individual player who bets the lowest number of moves and wins the target chip.

	1.	the system displays a target chip for the round;
	2.	a player makes a bet on how many moves it will take to move
	the robot of color matching the target chip to the corresponding chip on 
	the board;
	3.	the system starts a countdown from 60 seconds;
	4.	the player then has the 60 seconds to bet on how many moves it will
	take to move the robot of color matching the target chip to the corresponding chip on the board (note: the player can improve his/her bet but cannot bid a higher number of moves than he/she previously bet);
	5.	the system then initializes a move counter to 0;
	6.	the player selects which row or column to move any robot down;
	7.	the system changes the location of the robot;
	8.	the system increases the move counter;
	9.	while the robot is not on the target chip, jump to 6;
	10.	the system verifies it has not taken any more moves than was bet to
	move the robot onto the target chip;
	11.	the system awards the target chip to the player.

# Alternative Flows:

* The alternative flows that can happen when a player takes a turn are as follows. 
** note: many of these flows can occur in conjunction with each other.

* Alternative Flow 1:
** The player is the first to bid. In this case, the only modification to the main success scenario is as follows:

	2. the player makes a bet on how many moves it will take to move the robot of color matching the target chip to the corresponding chip on the board;

* Alternative Flow 2:
** The player does not make the lowest bid on how many moves it will take to
move the robot to the target chip. The change to the Main success scenario is as follows:
	
	4.	the player waits while the other players take their turn in order determined by the number they bid (lowest to highest);
	5.	jump to line 5 on the main success scenario.

* Alternative Flow 3:
** The player takes more moves to put the robot on the target chip than their 
bet. In this case, the modifications to the main success scenario are as follows:
	10.	the system checks the move count against the bid;
	11.	the player who bet the next smallest number of moves tries to move the robot onto the target chip within the bound of their bet.


# Exceptions:

* If no player is able to move the robot onto the target chip with a number of moves that is less than or equal to their bet, then no one gets the target chip, and a new round is started

* If the target space is the multicolored vortex, then there is no specific robot which must be moved onto it. A robot of any color can be moved onto the target chip.

* If a robot can move onto the target chip without ricocheting at least once, it may not take that path and must choose another.

# Special Requirements:

* There are no special requirements to take a turn.

# Open Issues:

* There are no open issuses to take a turn.