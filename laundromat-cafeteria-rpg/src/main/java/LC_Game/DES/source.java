package LC_Game.DES;

import LC_Game.laundromat_mechanics.customer;

public class source implements DES_Process {

	private DES_EventList list;
	private customerAcceptor queue;
	private String name;
	private double meanArrTime;
	private double[] interArrivalTimes;
	private int interArrCount;

    public source(customerAcceptor q, DES_EventList l, String n) {
		list = l;
		queue = q;
		name = n;
		meanArrTime = 33;
		list.add(this,0,drawRandomExponential(meanArrTime));
	}

	public source(customerAcceptor q, DES_EventList l, String n, double m) {
		list = l;
		queue = q;
		name = n;
		meanArrTime = m;
		list.add(this,0,drawRandomExponential(meanArrTime));
	}

	public source(customerAcceptor q, DES_EventList l, String n, double[] ia) {
		list = l;
		queue = q;
		name = n;
		meanArrTime = -1;
		interArrivalTimes = ia;
		interArrCount = 0;
		list.add(this, 0, interArrivalTimes[0]);
	}

	public static double drawRandomExponential(double mean) {
		double u = Math.random();
		double res = -mean*Math.log(u);
		return res;
	}

    @Override
    public void execute(int type, double currentTime) {
		System.out.println("Arrival at time = " + currentTime);
		customer person = new customer();
		person.stamp(currentTime,"Creation",name);
		queue.giveCustomer(person);
		if(meanArrTime > 0) {
			double duration = drawRandomExponential(meanArrTime);
			list.add(this, 0, currentTime + duration);
		}
		else {
			interArrCount++;
			if(interArrivalTimes.length > interArrCount) {
				list.add(this, 0, currentTime + interArrivalTimes[interArrCount]);
			}
			else {
				list.stop();
			}
		}
    }
    
}
