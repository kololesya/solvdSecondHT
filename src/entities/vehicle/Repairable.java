package entities.vehicle;

public interface Repairable {
    void repair(boolean isRepairNeeded);
    void performRepair(String vinNumber, String repairDetails);
}
