import javax.swing.JLabel;

public class Minion extends Card implements Attackable{

	private int maxHealth;
	private int curHealth;
	private int attack;
	private boolean canAttack;
	
	private JLabel stats = new JLabel();
	
	private Location location;
	
	public Minion(String name, int cost, int attack, int health)
	{	
		super(name, cost);
		this.maxHealth = health;
		this.curHealth = health;
		this.attack = attack;
		this.canAttack = false;
		
		this.location = Location.DECK;
		
		this.stats.setBounds(0, 90, 20, 20);
		this.stats.setText(attack + " / " + health);
		this.add(stats);
		
	}
	
	public void fight(Attackable enemy)
	{
		if(this.canAttack)
		{
			if(enemy instanceof Minion)
			{
				Minion target = (Minion) enemy;
				
				curHealth = curHealth - target.getAttack();
				target.setHealth(target.getHealth() - attack);
				
				if(curHealth < 0)
				{
					location = Location.DISCARD;
				}
				
				if(target.getHealth() < 0)
				{
					target.setGameLocation(Location.DISCARD);
				}
			}
			else if(enemy instanceof Hero)
			{
				Hero target = (Hero) enemy;
				
				target.setHealth(target.getHealth() - attack);
			}
		}
		else
		{
			System.out.println("Give that minion a turn to get ready");
		}
	}
	
	public Integer getHealth() {
		return curHealth;
	}

	public void setHealth(int curHealth) {
		this.curHealth = curHealth;
	}

	public Location getGameLocation() {
		return location;
	}

	public void setGameLocation(Location location) {
		location = location;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public Integer getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		attack = attack;
	}
}
