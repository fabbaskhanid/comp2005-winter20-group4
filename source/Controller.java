import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutionException;
import javax.swing.plaf.basic.BasicArrowButton;
import java.util.concurrent.CountDownLatch;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Controller
{
	private Settings gameSettings;
	private Window gameWindow;
	private GameMenu menu;
	private ArrayList<Player> curPlayerOrder;

	Controller()
	{
		this.gameWindow = new Window();
		this.gameSettings = new Settings();
		this.menu = new GameMenu(this.gameSettings, this.gameWindow);
		start();
	}

	public void start()
	{ 
		this.gameWindow.getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel settingsWindow = new JPanel(new BorderLayout());
		settingsWindow.add(new JLabel("<html>WELCOME TO RICOCHET ROBOTS!<br/>PLEASE SELECT THE DIFFICULTY LEVEL:</html>"), BorderLayout.NORTH);
		JButton easyButton = new JButton("EASY");
		easyButton.addActionListener(p -> 
		{
			GameBoard simpleBoard = new GameBoard();
			simpleBoard.setSimple(this.gameSettings.getTheme());
			this.gameSettings.setGameBoard(simpleBoard);
			enterNames();
		});
		JButton hardButton = new JButton("HARD");
		hardButton.addActionListener(p -> 
		{

			GameBoard complexBoard = new GameBoard();
			complexBoard.setComplex(this.gameSettings.getTheme());
			this.gameSettings.setGameBoard(complexBoard);
			enterNames();
		});
		settingsWindow.add(easyButton, BorderLayout.WEST);
		settingsWindow.add(hardButton, BorderLayout.EAST);
		this.gameWindow.getContentPane().add(settingsWindow);
		this.gameWindow.getFrame().pack();
		this.gameWindow.getFrame().setVisible(true);
	}

	public void enterNames()
	{
		
		this.gameWindow.getContentPane().removeAll();
		JPanel nameWindow = new JPanel(new BorderLayout());
		nameWindow.add(new JLabel("PLEASE ENTER EACH PLAYER'S NAME\n(up to 4 players)"), BorderLayout.NORTH);
		JPanel entries = new JPanel(new GridLayout(4, 2));
		String[] labels = {"Player 1: ", "Player 2: ", "Player 3: ", "Player 4: "};
		JTextField[] textFields = new JTextField[4];
		for(int i = 0; i < 4; i++)
		{
			JLabel line = new JLabel(labels[i], JLabel.TRAILING);
			entries.add(new JLabel(labels[i]));
			JTextField textField = new JTextField(10);
			entries.add(textField);
			textFields[i] = textField;
		}
		JButton done = new JButton("Done");
		
		done.addActionListener(p ->
		{
			int playerCount = 0;
			Player[] players = new Player[4];
			for(int i = 0; i < 4; i++)
			{
				if(textFields[i].getText().isEmpty() == false)
				{
					playerCount++;
					players[i] = new Player(textFields[i].getText());
				}
			}
			if(playerCount == 0)
			{
				return;
			}
			gameSettings.setPlayers(players[0], players[1], players[2], players[3]);
			if(playerCount != 4)
			{
				setDifficulty();
			}
			else if(0 < playerCount)
			{
				createGame();
			}
		});
		nameWindow.add(done, BorderLayout.SOUTH);
		nameWindow.add(entries, BorderLayout.CENTER);
		this.gameWindow.getContentPane().add(nameWindow);
		this.gameWindow.getFrame().revalidate();
		this.gameWindow.getFrame().repaint();
	}

	public void setDifficulty()
	{
		this.gameWindow.getContentPane().removeAll();
		JPanel difficultyPanel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Please enter the desired skill level of the CPU players");
		JButton novice = new JButton("Novice");
		novice.addActionListener(p ->
		{
			for(int i = 0; i < this.gameSettings.getPlayers().length; i++)
			{
				if(this.gameSettings.getPlayers()[i] == null)
				{
					 this.gameSettings.getPlayers()[i] = new SimpleAI("CPU" + i);
				}
			}
			createGame();
		});
	
		JButton pro = new JButton("Professional");
		pro.addActionListener(p ->
		{
			for(int i = 0; i < this.gameSettings.getPlayers().length; i++)
			{
				if(this.gameSettings.getPlayers()[i] == null)
				{
					this.gameSettings.getPlayers()[i] = new SmartAI("CPU" + i);
				}
			}
			createGame();
		});
		difficultyPanel.add(label, BorderLayout.NORTH);
		difficultyPanel.add(novice, BorderLayout.WEST);
		difficultyPanel.add(pro, BorderLayout.EAST);
		this.gameWindow.getContentPane().add(difficultyPanel);
		this.gameWindow.getFrame().revalidate();
		this.gameWindow.getFrame().repaint();
	}

	public void createGame()
	{
		this.gameWindow.getContentPane().removeAll();

		JPanel gameSpace = new JPanel(new BorderLayout());
		JPanel middlePanel = new JPanel(new BorderLayout());
		JPanel names = new JPanel(new GridLayout(5, 2));
		middlePanel.add(names, BorderLayout.CENTER);
		JPanel boardBase = new JPanel();
		names.add(new JLabel("Player Names  "));
		names.add(new JLabel("  Target Chips"));

		for(int i = 0; i < 4; i++)
		{
			names.add(new JLabel((this.gameSettings.getPlayers())[i].getName()));
			names.add(new JLabel(String.valueOf((this.gameSettings.getPlayers())[i].getTargetChips())));
		}
		
		JPanel bidSection = new JPanel(new GridLayout(5, 1));
		bidSection.add(new JPanel());
		
		for(int i = 0; i < 4; i++)
		{
			JButton bidButton = new JButton("Bid");
			bidSection.add(bidButton);
			bidButton.addActionListener(p ->
			{
				SwingWorker<BidSetter, Void> worker = new SwingWorker<BidSetter, Void>()
				{
		
					protected BidSetter doInBackground() throws Exception
					{
						BidSetter bids = new BidSetter(gameWindow.getFrame(), gameSettings.getPlayers()[0], gameSettings.getPlayers()[1], gameSettings.getPlayers()[2], gameSettings.getPlayers()[3]);                	 
						Thread.sleep(61000);
						return bids;
					}

					protected void done()
					{
						try
						{
							BidSetter curBids = get();
							curPlayerOrder = curBids.getPlayerOrder();
							setBids(bidSection);				
							playRound(middlePanel);
							gameWindow.getFrame().revalidate();
							gameWindow.getFrame().repaint();
							
						}
						catch(InterruptedException e)
						{
							System.out.println("iso");
						}
						catch(ExecutionException e)
						{
							System.out.println("iso");
						}
					}			
				};
				worker.execute();
			});

								
		}			
				
						
			
		
		gameSpace.add(bidSection, BorderLayout.EAST);
		boardBase.add(this.gameSettings.getGameBoard().getBoardPanel());
		this.gameSettings.getGameBoard().flipChip(this.gameSettings.getTheme());
		gameSpace.add(boardBase, BorderLayout.WEST);
		gameSpace.add(middlePanel, BorderLayout.CENTER);
		this.gameWindow.getContentPane().add(gameSpace);
		
		this.gameWindow.getFrame().setJMenuBar(this.menu.getMenuBar());

		this.gameWindow.getFrame().revalidate();
		this.gameWindow.getFrame().repaint();

	}

	private void setBids(JPanel panel)
	{
		panel.removeAll();
		
		panel.setLayout(new GridLayout(5, 1));
		JLabel bidLabel = new JLabel("Bid");
		JPanel bidPanel = new JPanel();
		bidPanel.add(bidLabel);
		panel.add(bidLabel);
		for(int i = 0; i < 4; i++)
		{
			panel.add(new JLabel("" + this.curPlayerOrder.get(i).getBid()));
		}
	}

	private void playRound(JPanel middlePanel)
	{
		BorderLayout layout = new BorderLayout();
		JPanel arrowPanel = new JPanel(layout);
		middlePanel.add(arrowPanel, BorderLayout.SOUTH);
		BasicArrowButton eastButton = new BasicArrowButton(BasicArrowButton.EAST);
		BasicArrowButton northButton = new BasicArrowButton(BasicArrowButton.NORTH);
		BasicArrowButton westButton = new BasicArrowButton(BasicArrowButton.WEST);
		BasicArrowButton southButton = new BasicArrowButton(BasicArrowButton.SOUTH);
		arrowPanel.add(eastButton, layout.EAST);
		arrowPanel.add(westButton, layout.WEST);
		arrowPanel.add(southButton, layout.SOUTH);
		arrowPanel.add(northButton, layout.CENTER);
		gameWindow.getFrame().revalidate();
		gameWindow.getFrame().repaint();

		// player 1 turn:

		Player player = curPlayerOrder.get(0);

		this.gameWindow.getFrame().revalidate();
		this.gameWindow.getFrame().repaint();

		eastButton.addActionListener(p ->
		{
			gameSettings.getGameBoard().makeMove(player, "E");
			gameWindow.getFrame().revalidate();
			gameWindow.getFrame().repaint();
		});

		westButton.addActionListener(p ->
		{		
			gameSettings.getGameBoard().makeMove(player, "W");
			gameWindow.getFrame().revalidate();
			gameWindow.getFrame().repaint();
		});

		southButton.addActionListener(p ->
		{
			gameSettings.getGameBoard().makeMove(player, "S");
			gameWindow.getFrame().revalidate();
			gameWindow.getFrame().repaint();
			
		});

		northButton.addActionListener(p ->
		{
			gameSettings.getGameBoard().makeMove(player, "N");
			gameWindow.getFrame().revalidate();
			gameWindow.getFrame().repaint();
		});
					
		SwingWorker<Boolean, Integer> turnWorker = new SwingWorker<Boolean, Integer>()
		{
			protected Boolean doInBackground() throws Exception
			{
				for(int i = 0; i < 4; i++)
				{	
					publish(i);
					Player player = curPlayerOrder.get(i);
					
					while(player.isSuccessful() == false)
					{
						Thread.sleep(250);

					}


				}
				return true;
			}

			protected void process(List<Integer> chunks)
			{
				int value = chunks.get(chunks.size() - 1);
				if(value != 0)
				{
					arrowPanel.remove(layout.getLayoutComponent(BorderLayout.NORTH));
				}
				arrowPanel.add(new JLabel("Turn:" + player.getName()), layout.NORTH);
				gameWindow.getFrame().revalidate();
				gameWindow.getFrame().repaint();	
			}

			protected void done()
			{
				try
				{
					if(get() == true)
					{}
				}
				catch(InterruptedException e)
				{}
				catch(ExecutionException e)
				{}
					
			}

			

		};	
		turnWorker.execute();	
	}


}
