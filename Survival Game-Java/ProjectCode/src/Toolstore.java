
public class Toolstore {
	public int id,avoid,money,damage;
	public String name;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	
	public void weaponType(int id)
	{
		if(id==1)
		{
			this.id=1;
			this.name="Pistol";
			this.damage=2;
			this.money=25;
		}
		else if(id==2)
		{
			this.id=2;
			this.name="Sword";
			this.damage=4;
			this.money=34;
			
		}
		else
		{	this.id=3;
			this.name="Rifle";
			this.damage=7;
			this.money=45;
		}
			
	}
	
	
	public void armorType(int id)
	{
		if(id==1)
		{	this.id=1;
			this.name="Light";
			this.avoid=-1;
			this.money=15;
		}
		else if(id==2)
		{	this.id=2;
			this.name="Medium";
			this.avoid=-3;
			this.money=25;
			
		}
		else
		{	this.id=3;
			this.name="Heavy";
			this.avoid=-5;
			this.money=40;
		}
			
	}
	
	
	public void buyWeapon(WarriorClass c , int id , Inventory i)
	{
	
			weaponType(id);
			System.out.println(c.getMoney());
			if(c.getMoney()>=money)
			{
				
				c.setMoney(c.getMoney()-money);
				c.setDamage(c.getDamage()+damage);
				System.out.println("You have successfully bought and equipped the item " + name);
				i.addWeapon(this.id,this.name,this.damage);
				
			
			}
			else
			{
				System.out.println("The Item you want to purchase is TOO expensive for you!");
				
			}
		
		
	}
	
	public void buyArmor(WarriorClass c , Obstacle o,Inventory i ,  int id)
	{
	
			armorType(id);
		
			if(c.getMoney()>=money)
			{
				
				c.setMoney(c.getMoney()-money);
				i.defend(this.avoid);
				System.out.println("You have successfully bought and equipped the item " + name);
				i.addArmor(this.id,this.name,this.avoid);
				
			}
			else
			{
				System.out.println("The Item you want to purchase is TOO expensive for you!");
			}
		
		
	}
}
