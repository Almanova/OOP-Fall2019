package problem3;

import java.util.Vector;
import java.util.Iterator;

public class DragonLunch {
	Vector<Person> prison;

	public DragonLunch() {
		prison = new Vector<Person>();
	}

	public void kidnap(Person p) {
		prison.add(p);
	}

	public boolean willDragonEatOrNot() {
		int cnt=0;
		for (Person p: prison) {
			if (p.gender == Gender.FEMALE)
				cnt--;
			else cnt++;		
			if(cnt <0) return true;
		}
		return cnt==0;
	}

	public static void main(String []args) {
		DragonLunch dragonlunch = new DragonLunch();
		Person p1 = new Person(Gender.MALE, "aaa", 15);
		Person p2 = new Person(Gender.FEMALE, "bbb", 14);
		dragonlunch.kidnap(p1);
		dragonlunch.kidnap(p2);
		dragonlunch.kidnap(p1);
		dragonlunch.kidnap(p2);
		if (dragonlunch.willDragonEatOrNot())
			System.out.println("Dragon will have something to eat");
		else 
			System.out.println("Dragon won't have lunch");
	}
}
