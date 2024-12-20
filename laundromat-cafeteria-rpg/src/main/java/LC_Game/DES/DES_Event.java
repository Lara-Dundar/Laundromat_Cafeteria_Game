package LC_Game.DES;

public class DES_Event {

	private DES_Process target;
	private int type;
	private double executionTime;

	public DES_Event(DES_Process target,int type, double time)
	{
		this.target = target;
		this.type = type;
		executionTime = time;
	}
	
	public void execute() {
		target.execute(type,executionTime);
	}
	
	public double getExecutionTime() {
		return executionTime;
	}
}
