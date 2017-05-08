import java.util.LinkedList;

public class Hero implements Attackable{

	private int health;
	private int mana;
	private int maxMana;
	private LinkedList<Card> side;
	private LinkedList<Card> hand = new LinkedList<Card>();
	private LinkedList<Card> deck = new LinkedList<Card>();
	
	public Hero(LinkedList<Card> deck)
	{
		this.health = 30;
		this.mana = 100;
		this.maxMana = 100;
		this.side = new LinkedList<Card>();
		this.deck = deck;
	}
	
	public Integer getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void playCard(int c)
	{
		Card card = hand.get(c);
		
		if(mana >= card.getCost()) //check if hero has sufficient mana
		{
			if(card instanceof Minion)
			{
				if(side.size() < 7) //check if hand is full
				{
					card.setGameLocation(Location.BOARD);  //card is played
					side.add(card);
					hand.remove(card);
					mana = mana - card.getCost();
				}
				else
				{
					System.out.println("Board is full.");
				}
			}
			else if(card instanceof Spell)
			{
				card.setGameLocation(Location.DISCARD);
				hand.remove(card);
				mana = mana - card.getCost();
			}
		}
		else
		{
			System.out.println("Not enough mana.");
		}
	}
	
	public void drawCard()
	{
		int r = (int) (Math.random() * deck.size());
		
		if(hand.size() < 10)
		{
			System.out.println(deck.get(r).toString());
			
			deck.get(r).setGameLocation(Location.HAND);
			hand.add(deck.get(r));
			deck.remove(r);	
		}
		else
		{
			deck.get(r).setGameLocation(Location.DISCARD);
			deck.remove(r);
			
			System.out.println("Your hand is full");
		}
	}
	
	public Integer getMana()
	{
		return mana;
	}
	
	public Card lastDrawn()
	{
		return hand.getLast();
	}
	
	public LinkedList<Card> getHand()
	{	
		return hand;
	}
	
	public LinkedList<Card> getSide()
	{
		return side;
	}
}
