
# Set Up  A Game
## Use Case Description


# Primary Actor:
	
* User

# Stakeholders and Interests:

* The Stakeholders in the process of setting up the game are the players
 of the game..


# Preconditions:
	
* User starts the program.



# Postconditions:
	
* Board type is chosen; 
* System holds all player information (human and automated);
* Automated players (if any) skill level has been chosen;
* Color Scheme of the board is set
* ready to start a turn

\pagebreak

# Main Success Scenario:



		1.	The user starts the program;
		2.	The system requests the user to load a previous saved game or
		 create a new game;
		3.	The user requests to start a new game;
		4.	The system requests the user to select the number of players;
		5.	The user selects the number of players;
		6.	The system calculates the number of automated players who will 
		play the game;
		7. 	The system requests the user to select the skill level of the 
		automated players;
		8.	The user selects the desired skill level of the automated players
		9. The system sets the desired skill level of the automated players;
		10.	The system requests the user to select the theme of the 
		game-board between a variety of color combinations;
		11.	The user selects the desired theme;
		12.	The system sets the desired theme;
		13.	The system creates the board and waits for the player to start 
			a turn.

# Alternative Flows:
* The points in the main success scenario where alternative flows may branch off are lines 3, 5, 8, and 11.

* Alternative Flow #1: 
** Loading a saved game
	3.	The user requests to "Load a Saved Game";
	4.	The system sets up the game board so that it matches the state of the saved game;
	5.	The system waits for the player to start a turn.

* Alternative Flow #2:
** Selecting the Number of Players
	The user selects 4 human players, in which case the system would jump from line 7 to line 10, as there are no automated players.

* Alternative Flow #3:
	** Changing the Automated Players's Skill Level
	The user can select the skill level of the automated players by choosing between "Novice" and "Professional". The only step this alternative flow would change would be line 9.

* Alternative Flow #4:
** Changing the Game's Theme
	The game's color scheme should not deter players from playing, or give them a handicap, therefore the game will be implemented to have multiple color schemes so that is someone has color-blindness, then they can select a theme such that they can see all distinctions between the colors.

# Special Requirements

The game must be written in Java and must run on linux machines without modification. The game will run on a single machine, but final version should allow extension into a networked version.

# Open Issue
	
Must determine how many games can be saved.