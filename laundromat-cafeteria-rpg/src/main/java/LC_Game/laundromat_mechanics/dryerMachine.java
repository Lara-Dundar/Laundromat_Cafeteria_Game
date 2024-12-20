package LC_Game.laundromat_mechanics;

import java.util.ArrayList;

import LC_Game.machine;

public class dryerMachine implements machine {

    public ArrayList<cycle> available_Drying_Cycles;

    public dryerMachine(ArrayList<cycle> available_Drying_Cycles) {
        this.available_Drying_Cycles = available_Drying_Cycles;
    }

    @Override
    public void startWorking(customer c) {
        if(c.dCoin != null) {
            c.selectedCycle.startCycle();
            c.selectedCycle.useElectricity();
            c.selectedCycle.useWater();
            c.selectedCycle.stopCycle(); 
        }
    }
 
    @Override
    public void stopWorking(customer c) {}
    
}
