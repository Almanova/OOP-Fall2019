package problem4;

public class Time implements Comparable {
	private int hour;
	private int minute;
	private int second;
	
	public Time(int hour, int minute, int second) {
		setTime(hour, minute, second);
	}
	
	public void setTime(int hour, int minute, int second) {
		if (hour < 24 && hour >= 0 && minute < 60 && minute >= 0 && second < 60 && second >= 0) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		else {
			System.out.println("Inavalid input");
		}
	}
	
	public String toUniversal() {
		String s = "";
		if (hour < 10) {
			s += "0";
			s += ""+hour;
			s += ":";
		}
		else {
			s += Integer.toString(hour);
			s += ":";
		}
		if (minute < 10) {
			s += "0";
			s += Integer.toString(minute);
			s += ":";
		}
		else {
			s += Integer.toString(minute);
			s += ":";
		}
		if (second < 10) {
			s += "0";
			s += Integer.toString(second);
		}
		else {
			s += Integer.toString(second);
		}
		return s;
	}
	
	public String toStandard() {
		String s = "";
		boolean pm = false;
		int temp = 0;
		if (hour >= 12) {
			temp = hour - 12;
			pm = true;
		}
		if (temp < 10) {
			s += "0";
			s += Integer.toString(temp);
			s += ":";
		}
		else {
			s += Integer.toString(temp);
			s += ":";
		}
		if (minute < 10) {
			s += "0";
			s += Integer.toString(minute);
			s += ":";
		}
		else {
			s += Integer.toString(minute);
			s += ":";
		}
		if (second < 10) {
			s += "0";
			s += Integer.toString(second);
		}
		else {
			s += Integer.toString(second);
		}
		if (pm == true) {
			s += " PM";
		}
		else {
			s += " AM";
		}
		return s;
	}
	
	public void add(Time time) {
		if (second + time.second >= 60) {
			second = second + time.second - 60;
			minute++;
		}
		else {
			second = second + time.second;
		}
		if (minute + time.minute >= 60) {
			minute = minute + time.minute - 60;
			hour++;
		}
		else {
			minute = minute + time.minute;
		}
		if (hour + time.hour >= 24) {
			hour = hour + time.hour - 24;
		}
		else {
			hour = hour + time.hour;
		}
	}
	
	public String toString() {
		return toUniversal();
	}

	@Override
	public int compareTo(Object object) {
		Time time = (Time)object;
		int thistotal = hour * 3600 + minute * 60 + second;
		int othertotal = time.hour * 3600 + time.minute * 60 + time.second;
		if (thistotal > othertotal) return 1;
		if (thistotal < othertotal) return -1;
		return 0;
	}
	
	public static void main (String []args) {
		Time t = new Time(23, 5, 6);
		System.out.println(t.toUniversal());
		System.out.println(t.toStandard());
		Time t2 = new Time(4, 24, 33);
		t.add(t2);
		System.out.println(t.toUniversal());
	}
}
