package LC_Game.DES;

public class simulation {
    
    public DES_EventList list;
    public queue queue;
    public source source;
    public sink sink;
    public cashRegister cr;

    public static void main(String[] args) {
        DES_EventList l = new DES_EventList();
	    queue q = new queue();
	    source s = new source(q,l,"Source 1");
	    sink si = new sink();
	    cashRegister m = new cashRegister(q,si,l,"Machine 1");
	    l.start(2000);
    }
}
