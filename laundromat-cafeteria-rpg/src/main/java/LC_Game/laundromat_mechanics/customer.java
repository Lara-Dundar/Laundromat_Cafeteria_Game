package LC_Game.laundromat_mechanics;

import java.util.ArrayList;

import LC_Game.laundromat_mechanics.coins.dryingCoin;
import LC_Game.laundromat_mechanics.coins.washingCoin;

public class customer {
    private ArrayList<Double> times;
	private ArrayList<String> events;
	private ArrayList<String> stations;

	public dryingCoin dCoin;
	public washingCoin wCoin;
	public cycle selectedCycle;
    public customer(dryingCoin dCoin, washingCoin wCoin, cycle selectedCycle) {
        times = new ArrayList<>();
		events = new ArrayList<>();
		stations = new ArrayList<>();
		this.dCoin = dCoin;
		this.wCoin = wCoin;
		this.selectedCycle = selectedCycle;
    }

    public void stamp(double time,String event,String station) {
		times.add(time);
		events.add(event);
		stations.add(station);
	}
	
	public ArrayList<Double> getTimes() {
		return times;
	}

	public ArrayList<String> getEvents() {
		return events;
	}

	public ArrayList<String> getStations() {
		return stations;
	}

    public double[] getTimesAsArray() {
		times.trimToSize();
		double[] tmp = new double[times.size()];
		for (int i=0; i < times.size(); i++) {
			tmp[i] = (times.get(i)).doubleValue();
		}
		return tmp;
	}

	public String[] getEventsAsArray() {
		String[] tmp = new String[events.size()];
		tmp = events.toArray(tmp);
		return tmp;
	}

	public String[] getStationsAsArray() {
		String[] tmp = new String[stations.size()];
		tmp = stations.toArray(tmp);
		return tmp;
	}
}
