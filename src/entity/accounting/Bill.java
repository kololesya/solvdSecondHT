package entity.accounting;

import entity.users.Specialist;

public class Bill {
    private Specialist specialist;

    public static int priceForPsycholog (){
        return 50;
    }

    public static int priceForOtherSpecialists (){
        return 40;
    }

    public int Bill(Specialist specialist, int priceForPsycholog, int priceForOtherSpecialists) {
        this.specialist = specialist;
        if (specialist.getSpecialization().equalsIgnoreCase("psycholog")){
            return priceForPsycholog;
        }
        return priceForOtherSpecialists;
    }
}
