import java.util.*;

public class CurrentLocation {

	WarriorClass warrior=new WarriorClass();
	Inventory inventory=new Inventory();
	private int health,damage,money;
	Scanner scan=new Scanner(System.in);

	public CurrentLocation(int h , int d , int m)
	{
		this.health=h;
		this.damage=d;
		this.money=m;			
	}
	
	public void SafeHouse(WarriorClass warrior,Inventory inventory)
	{
		if(inventory.getFireWood()==true && inventory.getFood()==true && inventory.getWater()==true)
		{
			
			System.out.println("Bitirdiniz");
			
		}
		else{
			if(inventory.getFireWood()==true && inventory.getFood()==true)
			{
				System.out.println("Level 2 Completed. ");
				
			}
			else if(inventory.getFood()==true )
			{
				System.out.println("Level 1 completed. ");
			}	
		System.out.println("You are healed!!");
		System.out.println("You are in the SAFEHOUSE now!!");
		health=warrior.getHealth();	
		printMenu(warrior, inventory);
		
		
	
	}
	
	}
	
	public int obstacleNumber(Obstacle o)
	{	Random random=new Random();
		if(o.id==3)
		{
			return 	random.nextInt(2)+1;
		}
		else
		{
			return 	random.nextInt(3)+1;
		}
		
		
	}
	public void Restaurant(WarriorClass warrior,Inventory inventory)
	{
		
			System.out.println("You are in the Restaurant!");
			Obstacle zombie=new Obstacle("Zombie", 1, 3,10,4);
			int obsNum=obstacleNumber(zombie);
			System.out.println("!!Be Careful!! There are " + obsNum + " Zombie<s> in the Restaurant!");
			System.out.print("<C>ombat or <F>lee?:");
			String combat=scan.next();
			if(combat.equals("c")){	
				if(Battle(warrior , zombie,inventory,obsNum)==true){
						System.out.println("You KILLED all the enemies in the RESTAURANT!!!");
						if(inventory.getFood()==false){
						inventory.setFood(true);
						System.out.println("You win FOOD item :) :)");
						printMenu(warrior, inventory);
						}
						else{
							printMenu(warrior, inventory);
						}
					}
					else{
					
						System.out.println("You are lose!!");
						System.out.println("Game Over!");
					}
				
		
			}
			else
			{
				printMenu(warrior,inventory);
			}
			
	}
		
	
	
	
	public void Forest(WarriorClass warrior,Inventory inventory)
	{
		
			System.out.println("You are in the Forest!");
			Obstacle vampire=new Obstacle("Vampire", 2, 4,14,7);
			int obsNum=obstacleNumber(vampire);
			System.out.println("!!Be Careful!! There are " + obsNum + " Vampire<s> in the Forest!");
		
			System.out.print("<C>ombat or <F>lee?:");
			String combat=scan.next();
			if(combat.equals("c"))
			{	
				
					if(Battle(warrior , vampire , inventory,obsNum)==true)
					{
						System.out.println("You KILLED all the enemies in the Forest!!!");
						if(inventory.getFireWood()==false){
						inventory.setFireWood(true);
						System.out.println("You win Firewood item :) :)");
						printMenu(warrior, inventory);
						}
						else
						{
							printMenu(warrior, inventory);
						}
					}
					else
					{
						System.out.println("You are lose!!");
						System.out.println("Game Over!");
					}
				
					
				
			}
			else
			{
				printMenu(warrior,inventory);
			}
			
	
	}
	
	
	public void River(WarriorClass warrior,Inventory inventory)
	{
		
			System.out.println("You are in the River!");
			Obstacle bear=new Obstacle("Bear", 3, 7,20,12);
			int obsNum=obstacleNumber(bear);
			System.out.println("!!Be Careful!! There are " + obsNum + " Bear<s> in the River!");
			
			System.out.print("<C>ombat or <F>lee?:");
			String combat=scan.next();
			if(combat.equals("c"))
			{	
				
					if(Battle(warrior , bear,inventory,obsNum)==true)
					{
						System.out.println("You KILLED all the enemies in the River!!!");
						if(inventory.getWater()==false){
						inventory.setWater(true);
						System.out.println("You win WATER item :) :)");
						printMenu(warrior, inventory);
						}
						else
						{
							printMenu(warrior,inventory);
						}
					}
					else
					{
						System.out.println("You are lose!!");
						System.out.println("Game Over!");
					}
				
					
				
				
					
			}
			else{
				printMenu(warrior,inventory);
			}
	
		
	}
	
	public void ToolStore(WarriorClass w , Inventory e )
	{
		
		System.out.println("Welcome to Tool Store!");
		System.out.println("What do you want to purchase??\n1. Weapon\n2. Armor\n3. Cancel");
		System.out.print("Your choice:");
		int select=scan.nextInt();
		if(select==1)
		{
			buyWeaponMenu(w,e);
			
		}
		else if(select==2)
		{
			buyArmorMenu(w,e);
		}
		else
		{
			printMenu(warrior, e);
		}
		
		
		
		
	}
	
	public void buyWeaponMenu(WarriorClass w,Inventory e)
	{
		Toolstore t=new Toolstore();
		System.out.println("1. Pistol <Price: 25 - Damage : +2>");
		System.out.println("2. Sword <Price: 34 - Damage : +4>");
		System.out.println("3. Pistol <Price: 45 - Damage : +7>");
		System.out.println("4. Cancel");
		System.out.print("Your Choice");
		int select=scan.nextInt();
		if(select!=4){
			t.buyWeapon(w, select, e);
			printMenu(w, e);
		}
		else
			printMenu(w, e);
	}
	
	
	public void buyArmorMenu(WarriorClass c,Inventory e)
	{
		Toolstore t=new Toolstore();
		Obstacle o=new Obstacle();
		System.out.println("1. Light <Price: 15 - Damage : -1>");
		System.out.println("2. Medium <Price: 25 - Damage : -3>");
		System.out.println("3. Heavy <Price: 40 - Damage : -5>");
		System.out.println("4. Cancel");
		System.out.print("Your Choice");
		int select=scan.nextInt();
		if(select!=4){
			t.buyArmor(c,o, e, select);
			printMenu(c, e);
		}
		else
			printMenu(c, e);
	}
	
	public boolean Battle(WarriorClass warrior , Obstacle o , Inventory e, int num )
	{	
		int obsNum=num;
		
		for(int i=0; i<obsNum;i++)
		{
				
				int obstacleHealth=o.getHealth();
				player(e);
				enemy(o);
				while(health>0 && o.health>0)
				{	
				
				System.out.print("<H>it or <F>lee?: ");
				String hits=scan.next();
				if(hits.equals("h"))
					{
			
					System.out.println("You hit the enemy!!");
					o.health=o.health-warrior.getDamage();
					System.out.println("Player Health: " + health);
					System.out.println("Enemy Health: " + o.health );
					System.out.println();
					System.out.println("Enemy hits you!!!");
					health=health-(o.damage+e.getDefend());
					System.out.println("Player Health: " + health);
					System.out.println("Enemy Health: " + o.health );
					}
					else
					{
						printMenu(warrior, e);
						break;
					}
				}
				if(o.health<health)
				{
					System.out.println("You KILLED an enemmy!!");
					money=money+o.getMoney();
					warrior.setMoney(money);
					System.out.println("You current money:" + 	warrior.getMoney());
					o.setHealth(obstacleHealth);
				
				}
				else
				{
				
					return false;
					
				}
				
		}
		return true;
		}
	

	public void player(Inventory e)
	{			
		String weapon;
		if(e.weaponString!=null)
			 weapon=e.weaponString;
		else
			weapon="Bat +0 damage.";
	
		System.out.println("Player Stats\n----------\nHealth: " + health +"\nDamage: " + damage + "\nWeapon:"+ weapon + "\nMoney:" + money);
		if(e.armorString!=null)
		{
			System.out.println(e.armorString);
		}
	}
	
	public void enemy(Obstacle o)
	{
		System.out.println("\nEnemy Stats\n----------\nName: " + o.getName() + "\nHealth: " +  o.getHealth() +"\nDamage: " + o.getDamage());

	}
	
	public void helpCenter(WarriorClass warrior , Inventory inventory)
	{
		System.out.println("LOCATIONS");
		System.out.println("******************************************");
		System.out.println("1. Safehouse --> Your village , no enemies!");
		System.out.println("2. Restaurant --> There will be zombies!");
		System.out.println("3. Forest --> There will be vampires!");
		System.out.println("4. River --> There will be bears!");
		System.out.println("5. Toolstore --> You can buy stuff!");
		System.out.println("\nENEMIES");
		System.out.println("******************************************");
		System.out.println("1.Zombies <Encountered in the Restaurant from #1 to #3 --> Health:10, Damage:3, Money:10");
		System.out.println("2.Vampires <Encountered in the Forest from #1 to #3 --> Health:14, Damage:4, Money:14");
		System.out.println("3.Bears <Encountered near the River from #1 to #2 --> Health:20, Damage:7, Money:20");
		System.out.println("\nWEAPONS");
		System.out.println("******************************************");
		System.out.println("1. Bat <Player's default weapon> --> Damage +0, Money +0");
		System.out.println("2. Pistol <Purchased in the Tool Store> --> Damage +2, Money 25");
		System.out.println("3. Sword <Purchased in the Tool Store> --> Damage +4, Money 35");
		System.out.println("4. Rifle <Purchased in the Tool Store> --> Damage +7, Money 45");
		System.out.println("\nARMORS");
		System.out.println("******************************************");
		System.out.println("1. Light <Purchased in the Tool Store> --> Damage -1, Money 15");
		System.out.println("2. Medium <Purchased in the Tool Store> --> Damage -3, Money 25");
		System.out.println("3. Heavy <Purchased in the Tool Store> --> Damage -5, Money 40");
		System.out.println("\nMISSION");
		System.out.println("******************************************");
		System.out.println("1. Go to the Restaurant. Kill all the zombies .Gain FOOD item!");
		System.out.println("2. Go to the Forest. Kill all the vampires .Gain FIREWOOD item!");
		System.out.println("3. Go to the Riverside. Kill all the bears .Gain WATER item!");	
		System.out.println("4. Return to the SAFEHOUSE and bring all the ITEMS to the village!!");
		printMenu(warrior,inventory);
	}
	public void printMenu(WarriorClass k,Inventory e)
	{
		
		System.out.println("Please select location you want to go!");
		System.out.println("1. Safehouse --> Your village , no enemies!");
		System.out.println("2. Restaurant --> There will be zombies!");
		System.out.println("3. Forest --> There will be vampires!");
		System.out.println("4. River --> There will be bears!");
		System.out.println("5. Toolstore --> You can buy stuff!");
		System.out.println("0. Need Help??");
		System.out.print("Your choice:");
		int select=scan.nextInt();
		while(select<0 || select>=6)
		{	
			System.out.print("Your choice:");
			select=scan.nextInt();
		}
		if(select==1)
			SafeHouse(k,e);
		else if(select==2)
			Restaurant(k, e);
		else if(select==3)
			Forest(k, e);
		else if(select==4)
			River(k,e);
		else if(select==5)
			ToolStore(k,e);
		else if(select==0)
			helpCenter(k,e);

	}
	
}

