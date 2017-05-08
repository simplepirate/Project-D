import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JPanel{

	private String name;
	private int cost;
	
	private JLabel nameText = new JLabel();
	
	private Color borderColour;
	private Color textColour;
	
	private boolean isSelected;
	private Location location;
	
	public Card(String name, int cost)
	{
		this.name = name;
		this.cost = cost;
		this.borderColour = Color.BLACK;
		
		this.location = Location.DECK;
		
		this.setBorder(BorderFactory.createLineBorder(borderColour));
		this.setLayout(null);
		
		this.nameText.setBounds(0, 0, 72, 96);
		this.nameText.setText(name);
		this.add(nameText);
		
	}
	
	public void update()
	{
		setBorder(BorderFactory.createLineBorder(borderColour));
	}
	
	public void setBorderColour(Color color)
	{
		borderColour = color;
	}
	
	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}


	public Location getGameLocation() {
		return location;
	}

	public void setGameLocation(Location location) {
		this.location = location;
	}

	public Integer getCost() {
		return cost;
	}
	
	public String toString()
	{
		return name;
	}
}
