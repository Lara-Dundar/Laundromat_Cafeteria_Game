package LC_Game;

import LC_Game.laundromat_mechanics.customer;

public interface machine {
    public void startWorking(customer c);
    public void stopWorking(customer c);
}
