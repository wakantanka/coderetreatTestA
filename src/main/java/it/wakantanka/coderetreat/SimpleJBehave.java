package it.wakantanka.coderetreat;

import java.util.Arrays;
import java.util.List;
 
import org.jbehave.core.embedder.Embedder;
 
public class SimpleJBehave {
 
	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays
			.asList("it/wakantanka/coderetreat/Parking.feature");
 
	public static void main(String[] args) {
		embedder.candidateSteps().add(new ParkingTestSteps());
		embedder.runStoriesAsPaths(storyPaths);
	}
}
