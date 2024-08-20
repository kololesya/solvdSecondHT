package entity.accounting;

import entity.visits.Visit;

import java.time.Month;

public class Salary {
    private static double salaryRate;
    static Visit[] completedVisits;

    public static double getSalaryRate(String fullName, Visit[] completedVisits, Month month){
        salaryRate = Bill.billsByMonthForSpec(fullName, completedVisits, month) * 0.6;
        return salaryRate;
    }

    public double getAward(){
        double award = 0;
        //если проведено больше 20 визитов, то премия 10% от базовой ставки
        //если проведено больше 30 визитов - 15%
        //больше 40 - 20%
        return award;
    }
}
