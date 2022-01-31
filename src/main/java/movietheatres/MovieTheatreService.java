package movietheatres;

import streams.Song;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieTheatreService {
	private Map<String, List<Movie>> shows = new HashMap<>();
	private List<Movie> movies = new ArrayList<>();

	public void readFromFile(Path path) {
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(path);
		}
		catch (IOException ioe) {
			throw new IllegalStateException("Can't read file!", ioe);
		}

		for (String line : lines) {
			String[] token=line.split("[-;]");
			String theatre = token[0];
			String title = token[1];
			String startTimeText = token[2];
			LocalTime startTime = LocalTime.parse(startTimeText);
			movies.add(new Movie(theatre, title, startTime));
//			loadShows(theatre, title, startTime);
			shows.putIfAbsent(theatre, new LinkedList<>());
			shows.get(theatre).add(new Movie(title, startTime));
		}
	}

//	private void loadShows(String theatre, String title, LocalTime startTime) {
//		if (shows.containsKey(theatre)) {
//			//shows.put(theatre, new ArrayList<>(List.of(shows.get(theatre)).add(new Movie(title, startTime))));
//		}
//	}

	public Map<String, List<Movie>> getShows() {
		return new LinkedHashMap<>(shows);
	}

	public List<String> findMovie(String title) {
		return movies.stream()
			.filter(movie -> movie.getTitle().equals(title))
			.map(movie -> movie.getTheatre())
			.distinct()
			.collect(Collectors.toList());
	}

	public LocalTime findLatestShow(String title) {
		return movies.stream()
			.filter(movie -> movie.getTitle().equals(title))
			.max(Comparator.comparing(Movie::getStartTime))
			.map(movie -> movie.getStartTime())
			.orElseThrow(()->new IllegalArgumentException("Wrong movie name"));
	}
}
