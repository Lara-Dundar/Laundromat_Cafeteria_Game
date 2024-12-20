package LC_Game.DES;

import java.util.ArrayList;

public class DES_EventList implements DES_Process {

	private double currentTime;
	private final ArrayList<DES_Event> events;
	private boolean stopFlag;

    public DES_EventList() {
        currentTime = 0;
        events = new ArrayList<>();
		stopFlag = false;
    }

    public void add(DES_Process target, int type, double time) {
        boolean success = false;
		DES_Event event;
        event = new DES_Event(target,type,time);
		for(int i=0 ; i<events.size() ; i++) {
			if(events.get(i).getExecutionTime()>event.getExecutionTime()) {
				success = true;
				events.add(i,event);
				break;
			}
		}
        
		if(!success) {
			events.add(event);
		}
    }

	public void start() {
		while((events.size()>0) && (!stopFlag)) {
			currentTime=events.get(0).getExecutionTime();
			events.get(0).execute();
			events.remove(0);
		}
	}

	public void start(double maximumTime) {
		add(this, -1, maximumTime);
		while((events.size()>0) && (!stopFlag)) {
			currentTime=events.get(0).getExecutionTime();
			events.get(0).execute();
			events.remove(0);
		}
	}

    public void stop() {
		stopFlag = true;
	}

	public double getTime() {
		return currentTime;
	}

    @Override
    public void execute(int type, double currentTime) {
        if(type == -1){
            stop();
        }
    }
}
