/**
 * Created by Wina Gen Sotto; last modified on 9/26/2016
 */
 public class Date {		// made a 'check' method because vince ugh
	private int year;
	private int month;
	private int day;

	public Date() {
		this(1000, 1, 1);
	}

	public Date(int year, int month , int day) {
		check(year, month, day);
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void check(int year, int month, int day) {
		if (year > 9999 || year < 1000) {
			throw new IllegalArgumentException("Invalid year!");
		}

		if (month > 12 || month < 1) {
			throw new IllegalArgumentException("Invalid month!");
		}

		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day > 31 || day < 1)) {
			throw new IllegalArgumentException("Invalid day!");
		}

		else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30 || day < 1)) {
			throw new IllegalArgumentException("Invalid day!");
		}

		else if (year % 4 != 0 && month == 2 && (day > 28 || day < 1)) {
			throw new IllegalArgumentException("Invalid day!");
		}

		else if (year % 4 == 0 && month == 2 && (day > 29 || day < 1)) {
			throw new IllegalArgumentException("Invalid day!");
		}
	}

	public void setYear(int year) {
		check(year, 1, 1);
		this.year = year;
	}

	public void setMonth(int month) {
		check(this.year, month, 1);
		this.month = month;
	}

	public void setDay(int day) {
		check(this.year, this.month, day);
		this.day = day;
	}

	public void setDate(int year,int month,int day) {
		check(year, month, day);
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public String toString() {
		return String.format("%02d/%02d/%d", day, month, year);
	}
}