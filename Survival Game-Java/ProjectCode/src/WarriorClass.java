import java.util.*;

public class WarriorClass  {
	private String playerName , name, type;
	private int id ,health , damage , money;
	
	public WarriorClass(){}
	
	public WarriorClass(String name)
	{
		this.playerName=name;
	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void WarriorClassMenu()
	{
		System.out.println("Welcome the Game " + playerName + " Select Warrior ! \n1)Samurai\n2)Sniper\n3)Knight");
		Scanner scan = new Scanner(System.in);
		System.out.print("Your Choice : ");
		id=scan.nextInt();
		selectWarrior(id);
	}
	
	public void selectWarrior(int id)
	{
		if(id==1)
		{
			name = "Samurai";
			health=21;
			damage=5;
			money =15;
			}
		else if(id==2)
		{
			name = "Sniper";
			health=18;
			damage=7;
			money =20;
		}
		else
		{
			name = "Knight";
			health=24;
			damage=8;
			money =5;
		}
	}
	
	public void setHealth(int health)
	{
		this.health=health;
	}
	public int getHealth()
	{
		return health;
	}
	
	public void toWarriorClass()
	{
		System.out.println("Warrior created successfully! ID=" + id + ",Name=" + name +",Health=" +health +",Damage=" + damage +",Money="+money);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
