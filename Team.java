import java.util.Date;

public class Team {
    int WIN = 3;
    int DRAW = 1;
    int LOSS = 0;

    String name;
    int matchPoints;
    int totalGoals;
    int win;
    int draw;
    int loss;
    Date registrationDate;

    public Team(String name, Date registrationDate) {
        this.name = name;
        this.matchPoints = 0;
        this.totalGoals = 0;
        this.win = 0;
        this.draw = 0;
        this.loss = 0;
        this.registrationDate = registrationDate;
    }
}
