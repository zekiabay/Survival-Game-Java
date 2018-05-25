
public class Inventory {
	
	private boolean water,food,fireWood=false;
	private int id,weaponID,armorID;
	public String weaponString;
	public String armorString;
	public int defend=0;
	
	public int getWeaponID() {
		return weaponID;
	}
	
	public void setWeaponID(int weaponID) {
		this.weaponID = weaponID;
	}

	Toolstore tools=new Toolstore();
	
	public void addWeapon(int id , String name , int damage)
	{
		this.weaponID=id;
		this.weaponString=name + " " + "+" + damage +" damage";
		
	}
	public void addArmor(int id ,String name , int avoid)
	{
		this.setArmorID(id);
		this.armorString="Armor: " + name + " Armor " + avoid + " avoid.";
	}

	public void defend(int avoid)
	{
		defend=avoid;
	}
	public int getDefend()
	{
		return defend;
	}
	

	public boolean getFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean getWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean getFireWood() {
		return fireWood;
	}

	public void setFireWood(boolean fireWood) {
		this.fireWood = fireWood;
	}
	public int getArmorID() {
		return armorID;
	}
	public void setArmorID(int armorID) {
		this.armorID = armorID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
