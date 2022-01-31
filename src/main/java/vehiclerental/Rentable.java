package vehiclerental;

import java.time.LocalTime;

public interface Rentable extends Comparable<Rentable> {
	abstract int calculateSumPrice(long minutes);
	abstract LocalTime getRentingTime();
	abstract void rent(LocalTime time);
	abstract void closeRent();
}
