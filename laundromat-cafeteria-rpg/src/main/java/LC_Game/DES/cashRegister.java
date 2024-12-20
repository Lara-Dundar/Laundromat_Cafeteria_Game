package LC_Game.DES;

import LC_Game.laundromat_mechanics.customer;

public class cashRegister implements customerAcceptor, DES_Process {

	private customer cust;
	private final DES_EventList eventlist;
	private queue queue;
	private customerAcceptor sink;
	private char status;
	private final String name;
	private double meanProcTime;
	private double[] processingTimes;
	private int procCount;

	public cashRegister(queue q, customerAcceptor s, DES_EventList e, String n) {
		status = 'i';
		queue = q;
		sink = s;
		eventlist = e;
		name = n;
		meanProcTime = 30;
		queue.askCustomer(this);
	}

    public cashRegister(queue q, customerAcceptor s, DES_EventList e, String n, double m) {
        status = 'i';
		queue = q;
		sink = s;
		eventlist = e;
		name = n;
		meanProcTime = m;
		queue.askCustomer(this);
    }

    public cashRegister(queue q, customerAcceptor s, DES_EventList e, String n, double[] st) {
        status = 'i';
		queue = q;
		sink = s;
		eventlist = e;
		name = n;
		meanProcTime = -1;
		processingTimes = st;
		procCount = 0;
		queue.askCustomer(this);
    }

    @Override
    public boolean giveCustomer(customer person) {
        if(status == 'i') {

			cust = person;
			cust.stamp(eventlist.getTime(),"Production started", name);
			startProduction();
			return true;
		}

		else {
            return false;
        }
    }

    private void startProduction() {
        if(meanProcTime > 0) {
			double duration = drawRandomExponential(meanProcTime);
			double tme = eventlist.getTime();
			eventlist.add(this, 0, tme+duration);
			status = 'b';
		}
		else {
			if(processingTimes.length>procCount) {
				eventlist.add(this,0,eventlist.getTime()+processingTimes[procCount]);
				status='b';
				procCount++;
			}
			else {
				eventlist.stop();
			}
		}
    }

    @Override
    public void execute(int type, double currentTime) {
        System.out.println("Product finished at time = " + currentTime);
		cust.stamp(currentTime, "Production complete", name);
		sink.giveCustomer(cust);
		cust = null;
		status = 'i';
		queue.askCustomer(this);
    }

    public static double drawRandomExponential(double mean) {
		double u = Math.random();
		double res = -mean*Math.log(u);
		return res;
	} 
}
