package LC_Game.laundromat_mechanics;

import java.util.ArrayList;

import LC_Game.machine;

public class washingMachine implements machine {

    public ArrayList<cycle> available_Washing_Cycles;

    public washingMachine(ArrayList<cycle> available_Washing_Cycles) {
        this.available_Washing_Cycles = available_Washing_Cycles;
    }
    
    @Override
    public void startWorking(customer c) {
        if(c.wCoin != null) {
            c.selectedCycle.startCycle();
            c.selectedCycle.useElectricity();
            c.selectedCycle.useWater();
            c.selectedCycle.stopCycle();
        }
    }

    @Override
    public void stopWorking(customer c) {}
    
}
