import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
	static final int JANUARY = 0;
	static final int FEBRUARY = 1;
	static final int MARCH = 2;
	static final int APRIL = 3;
	static final int MAY = 4;
	static final int JUNE = 5;
	static final int JULY = 6;
	static final int AUGUST = 7;
	static final int SEPTEMBER = 8;
	static final int OCTOBER = 9;
	static final int NOVEMBER = 10;
	static final int DECEMBER = 11;
	private Calendar date;
	private SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");

	/*
	 * public static void main(String... args) { Date a = new Date(JANUARY, 1,
	 * 1996); System.out.println(a); Date b = new Date(JANUARY, 22, 1996);
	 * System.out.println(b); System.out.println(daysBetween(a, b)); }
	 */

	/**
	 * A date constructor.
	 * @param month the month
	 * @param day the day
	 * @param year the year
	 */
	public Date(int month, int day, int year) {
		this.date = Calendar.getInstance();
		date.set(year, month, day);
	}

	/**
	 * Calculates the number of days between two dates.
	 * @param date1 first date
	 * @param date2 second date
	 * @return number of days in between.
	 */
	public static long daysBetween(Date date1, Date date2) {
		long diff = date2.getDate().getTimeInMillis() - date1.getDate().getTimeInMillis();
		return diff / (24 * 60 * 60 * 1000);
	}

	/**
	 * Returns the calendar object associated with the date.
	 * @return the calendar object
	 */
	public Calendar getDate() {
		return this.date;
	}

	/**
	 * Compares one date with another to see if one is before the other.
	 * @param date the date to compare to.
	 * @return -1 is this is before, 1 if after, 0 if same day.
	 */
	public int compareTo(Date date) {
		return this.date.compareTo(date.getDate());
	}

	/**
	 * toString method for the date.
	 */
	@Override
	public String toString() {
		return f.format(date.getTime());
	}
}