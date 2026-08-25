import java.util.ArrayList;
import java.util.Collections;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		int l = 0;
		int r = list.size() - 1;
		while (l < r) {
			while (!(list.get(l).getBreed().equals("Pug")) && l < r) l++;
			while ((list.get(r)).getBreed().equals("Pug") && l < r) r--;
			if (l < r) {
				Collections.swap(list, l, r);
				l++;
				r--;
			}
		}
	}
}