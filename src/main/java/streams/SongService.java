package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SongService {
	private List<Song> songs = new ArrayList<>();

	public void addSong(Song song) {
		songs.add(song);
	}

	public Optional<Song> shortestSong() {
		Optional<Song> shortestSong = Optional.empty();
		shortestSong = songs.stream().min(Comparator.comparing(Song::getLength));
		return shortestSong;
	}

	public List<Song> findSongByTitle(String title) {
		return songs.stream()
			.filter(song -> song.getTitle().equals(title))
			.collect(Collectors.toList());
	}

	public boolean isPerformerInSong(Song song, String performer) {
		return songs.stream()
			.anyMatch(actualSong -> song.getPerformers().contains(performer));
	}

	public List<String> titlesBeforeDate(LocalDate date) {
		return songs.stream()
			.filter(song -> song.getRelease().isBefore(date))
			.map(song -> song.getTitle())
			.collect(Collectors.toList());
	}
}
