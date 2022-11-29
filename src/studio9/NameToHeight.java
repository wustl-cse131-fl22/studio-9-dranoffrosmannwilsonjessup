package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		System.out.println("Enter name to get height?");
		Scanner in = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Charles", 68);
		map.put("Mimi", 67);
		map.put("Eva", 66);
		map.put("Hailey", 65);

		String name = in.nextLine();
		boolean b = false;

		while (b == false) {
			System.out.println(map.get(name));
			System.out.println("Enter name to get height?");
			name = in.nextLine();
			if (name.equals("quit")) {
				b = true;
			}
			
		}



	}
}
