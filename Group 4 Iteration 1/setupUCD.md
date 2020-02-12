
# Set Up  A Game
## Use Case Description


# Primary Actor:
	
* The primary actor when setting up a game will be the person in front
 of the computer keyboard. This person will choose the game settings. 
 Even if there are multiple people playing the game, only one will 
 select the game settings.

# Stakeholders and Interests:

* The Stakeholders in the process of setting up the game are the players
 who are about to play the game.  As, their ability to play the game
  depends on if the game is set up in a way which allows them to play it.


# Preconditions:
	
* Setting up a game will assume that there are between one and four 
(inclusive) players willing to play the game.



# Postconditions:
	
* After a successful game setup, the next thing that will happen is the 
first turn will be taken. The game has been setup in such a way that all 
players will be able to partake without a handicap.

# Main Success Scenario:
* For the postconditions to be achieved, the following path will be followed. because there is one to four players can play the game, there are multiple different success scenarios for setting up a game. The following path will show path when two players wish to play.  Since only one player will actually be selecting the game settings, this player will be referred to as the user from here on.

\pagebreak

		1.	The user starts the program;
		2.	The system requests the user to load a previous saved game or
		 create a new game;
		3.	The user requests to start a new game;
		4.	The system requests the user to select the number of players;
		5.	The user selects the option for two players;
		6.	The system calculates the number of automated players who will 
		play the game;
		7. 	The system requests the user to select the skill level of the 
		automated players;
		8.	The user selects the "Novice" skill level;
		9.	The system sets the skill level of the automated players to 
		"Novice";
		10.	The system requests the user to select the theme of the 
		game-board between a variety of color combinations;
		11.	The user selects the "Classic" theme;
		12.	The system sets the theme to "Classic";
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
	The user can select between one and four players at line 5, and the only change in the main flow if the user selects 4 playes, in which case, the system would jump from line 7 to line 10, as there are no automated players.

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