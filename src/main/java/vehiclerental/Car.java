package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable{
	private String id;
	private LocalTime rentingTime;
	private int pricePerMinute;

	public Car(String id, int pricePerMinute) {
		this.id = id;
		this.pricePerMinute = pricePerMinute;
	}

	public String getId() {
		return id;
	}

	public int getPricePerMinute() {
		return pricePerMinute;
	}

	@Override
	public int calculateSumPrice(long minutes) {
		return (int) (pricePerMinute * minutes);
	}

	@Override
	public LocalTime getRentingTime() {
		return null;
	}

	@Override
	public void rent(LocalTime time) {

	}

	@Override
	public void closeRent() {

	}

	@Override
	public int compareTo(Rentable o) {
		return this.getRentingTime().compareTo(o.getRentingTime());
	}
}
