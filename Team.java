package WeAreTheChampions;

import java.util.Date;

public class Team {
    String name;
    int matchPoints;
    int totalGoals;
    Date registrationDate;

    public Team(String name, Date registrationDate) {
        this.name = name;
        this.matchPoints = 0;
        this.totalGoals = 0;
        this.registrationDate = registrationDate;
    }
}
