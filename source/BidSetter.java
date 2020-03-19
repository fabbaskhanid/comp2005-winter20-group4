import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Timer;
import java.util.Collections;


public class BidSetter
{

	private JDialog bidPopUp;
	private boolean timerFinished;
	private ArrayList<Player> playerOrder;


	BidSetter(JFrame frame, Player a, Player b, Player c, Player d)
	{
		this.bidPopUp = new JDialog(frame);
		this.bidPopUp.setPreferredSize(new Dimension(800, 800));
		this.bidPopUp.pack();
		this.timerFinished = false;
		
		startBidding(frame, a, b, c, d);

	}

	public void startBidding(JFrame frame, Player a, Player b, Player c, Player d)
	{
		this.bidPopUp.setLayout(new BorderLayout());
		this.bidPopUp.setVisible(true);
		time(frame, a, b, c, d);
		bidSlots(a, b, c, d);
	}

	public void time(JFrame frame, Player a, Player b, Player c, Player d)
	{
		final Counter counter = new Counter();
		JPanel timePanel = new JPanel();
		JLabel timeLabel = new JLabel("" + 60);
		timePanel.add(timeLabel);
		timeLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		this.bidPopUp.add(timePanel, BorderLayout.WEST);

		Timer timer = new Timer(1000, t ->
			{
				counter.count();
				timeLabel.setText("" + (60 - counter.getCount()));
				if(counter.getCount() == 60)
				{
					((Timer) (t.getSource())).stop();
					this.bidPopUp.dispose();
					this.timerFinished = true;
					updatePlayerOrder(a, b, c, d);
				}					
			});
		timer.setInitialDelay(0);
		timer.start();
		
		
	}

	public void bidSlots(Player a, Player b, Player c, Player d)
	{
		JPanel bidPanel = new JPanel();
		this.bidPopUp.add(bidPanel, BorderLayout.EAST);
		bidPanel.setLayout(new GridLayout(5, 3));
		
		bidPanel.add(new JLabel("Place or update bids"));
		bidPanel.add(new JLabel(""));
		bidPanel.add(new JLabel(""));
		
		bidPanel.add(new JLabel(a.getName()));
		JTextField fieldA = new JTextField();
		bidPanel.add(fieldA);
		JButton updateA = new JButton("Update");
		updateA.addActionListener(p -> 
		{
			if(fieldA.getText() != "")
			{
				a.setBid(Integer.parseInt(fieldA.getText()));
			}
		});
		bidPanel.add(updateA);


		bidPanel.add(new JLabel(b.getName()));
		JTextField fieldB = new JTextField();
		bidPanel.add(fieldB);
		JButton updateB = new JButton("Update");
		updateB.addActionListener(p -> 
		{
			if(fieldB.getText() != "")
			{
				b.setBid(Integer.parseInt(fieldB.getText()));
			}
		});
		bidPanel.add(updateB);

		bidPanel.add(new JLabel(c.getName()));
		JTextField fieldC = new JTextField();
		bidPanel.add(fieldC);
		JButton updateC = new JButton("Update");
		updateC.addActionListener(p -> 
		{
			if(fieldC.getText() != "")
			{
				c.setBid(Integer.parseInt(fieldC.getText()));
			}
		});
		bidPanel.add(updateC);

		bidPanel.add(new JLabel(d.getName()));
		JTextField fieldD = new JTextField();
		bidPanel.add(fieldD);
		JButton updateD = new JButton("Update");
		updateD.addActionListener(p -> 
		{
			if(fieldD.getText() != "")
			{
				d.setBid(Integer.parseInt(fieldD.getText()));
			}
		});
				
		bidPanel.add(updateD);
		
	}

	public void updatePlayerOrder(Player a, Player b, Player c, Player d)
	{
		this.playerOrder = new ArrayList<Player>(Arrays.asList(a, b, c, d));

		for(int i = 0; i < 4; i++)
		{
			for(int j = i; j < 4; j++)
			{
				if(playerOrder.get(i).getBid() > playerOrder.get(j).getBid())
				{
					Collections.swap(this.playerOrder, i, j);
				} 
			}
		}
	}

	public ArrayList<Player> getPlayerOrder()
	{
		return this.playerOrder;
	}

	public boolean isTimerFinished()
	{
		return this.timerFinished;
	}

}

