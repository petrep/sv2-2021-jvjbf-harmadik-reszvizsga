package movietheatres;

import java.time.LocalTime;
import java.util.Objects;

public class Movie {
	private String theatre;
	private String title;
	private LocalTime startTime;

	public Movie(String theatre, String title, LocalTime startTime) {
		this.theatre = theatre;
		this.title = title;
		this.startTime = startTime;
	}

	public Movie(String title, LocalTime startTime) {
		this.title = title;
		this.startTime = startTime;
	}

	public String getTitle() {
		return title;
	}

	public String getTheatre() {
		return theatre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Movie movie = (Movie) o;

		return title.equals(movie.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	public LocalTime getStartTime() {
		return startTime;
	}
}
