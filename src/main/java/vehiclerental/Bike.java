package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable{
	private String id;
	private LocalTime rentingTime;

	public Bike(String id) {
		this.id = id;
	}

	@Override
	public int compareTo(Rentable o) {
		return this.getRentingTime().compareTo(o.getRentingTime());
	}

	@Override
	public int calculateSumPrice(long minutes) {
		return 0;
	}

	@Override
	public LocalTime getRentingTime() {
		return rentingTime;
	}

	@Override
	public void rent(LocalTime time) {

	}

	@Override
	public void closeRent() {

	}
}
