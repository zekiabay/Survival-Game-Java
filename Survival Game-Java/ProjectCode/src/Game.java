import java.util.*;

public class Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please Enter Your Name : ");
		String name = scan.nextLine();
		WarriorClass warrior= new WarriorClass(name);
		Inventory inventory=new Inventory();
		warrior.WarriorClassMenu();
		warrior.toWarriorClass();
		CurrentLocation local=new CurrentLocation(warrior.getHealth(),warrior.getDamage(),warrior.getMoney());
		local.printMenu(warrior, inventory);
	}

}
