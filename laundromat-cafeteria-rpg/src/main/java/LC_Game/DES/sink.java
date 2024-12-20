package LC_Game.DES;

import java.util.ArrayList;
import LC_Game.laundromat_mechanics.customer;

public class sink implements customerAcceptor {

	private ArrayList<customer> customers;
	private ArrayList<Integer> numbers;
	private ArrayList<Double> times;
	private ArrayList<String> events;
	private ArrayList<String> stations;
	private int number;


    public sink() {
		customers = new ArrayList<>();
		numbers = new ArrayList<>();
		times = new ArrayList<>();
		events = new ArrayList<>();
		stations = new ArrayList<>();
		number = 0;
    }

    @Override
    public boolean giveCustomer(customer person) {
        number++;
		customers.add(person);
		ArrayList<Double> t = person.getTimes();
		ArrayList<String> e = person.getEvents();
		ArrayList<String> s = person.getStations();
		for(int i=0 ; i<t.size() ; i++) {
			numbers.add(number);
			times.add(t.get(i));
			events.add(e.get(i));
			stations.add(s.get(i));
		}
		return true;
    }

    public int[] getNumbers() {
		numbers.trimToSize();
		int[] tmp = new int[numbers.size()];
		for (int i=0 ; i < numbers.size() ; i++) {
			tmp[i] = (numbers.get(i)).intValue();
		}
		return tmp;
	}

	public double[] getTimes() {
		times.trimToSize();
		double[] tmp = new double[times.size()];
		for (int i=0 ; i < times.size() ; i++) {
			tmp[i] = (times.get(i)).doubleValue();
		}
		return tmp;
	}

	public String[] getEvents() {
		String[] tmp = new String[events.size()];
		tmp = events.toArray(tmp);
		return tmp;
	}

	public String[] getStations() {
		String[] tmp = new String[stations.size()];
		tmp = stations.toArray(tmp);
		return tmp;
	}
}
