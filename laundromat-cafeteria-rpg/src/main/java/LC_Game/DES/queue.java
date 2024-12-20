package LC_Game.DES;

import java.util.ArrayList;
import LC_Game.laundromat_mechanics.customer;

public class queue implements customerAcceptor {

    private ArrayList<customer> line;
	private ArrayList<cashRegister> requests;

    public queue() {
        line = new ArrayList<>();
        requests = new ArrayList<>();
    }

    public boolean askCustomer(cashRegister register) {
        if(line.size() > 0) {
			if(register.giveCustomer(line.get(0))) {
				line.remove(0);
				return true;
			}
			else {
				return false;
            }
		}
		else {
			requests.add(register);
			return false;
		}
    }

    @Override
    public boolean giveCustomer(customer person) {

		if(requests.size() < 1) {
        line.add(person);
        }
        else {
            boolean delivered = false;
            while(!delivered && (requests.size() > 0)) {
                delivered=requests.get(0).giveCustomer(person);
                requests.remove(0);
            }

            if(!delivered) {
                line.add(person);
            }
        }
        return true;
    }
    
}
