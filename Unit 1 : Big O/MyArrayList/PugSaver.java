import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		Collections.copy(list, Stream.concat (
			list.stream().filter(d -> !d.getBreed().equals("Pug")),
			list.stream().filter(d -> d.getBreed().equals("Pug"))
		).toList());
	}
}