package entity.accounting;

import entity.users.Specialist;
import entity.visits.PlannedVisit;
import entity.visits.Schedule;

import java.time.Month;

public class Salary {
    private static Month month;
    private static double salaryRate;
    private double award;
    private static int specId;
    static PlannedVisit[] plannedVisits;

    public static double getSalaryRate(int specId, PlannedVisit[] plannedVisits, Month month){
        salaryRate = BillsForPeriod.billsBySpecId(specId, plannedVisits, month) * 0.6;
        return salaryRate;
    }

    public double getAward(){
        //если проведено больше 20 визитов, то премия 30% от базовой ставки
        //если проведено больше 30 визитов - 40%
        //больше 40 - 50%
        return award;
    }
}
