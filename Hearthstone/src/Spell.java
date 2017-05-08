
public class Spell extends Card{
	
	private Location location;

	public Spell(String name, int cost) {
		super(name, cost);
	}

	public Location getGameLocation() {
		return location;
	}

	public void setGameLocation(Location location) {
		this.location = location;
	}
	
}
