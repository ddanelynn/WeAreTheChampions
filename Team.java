import java.util.Date;

public class Team {
    int WIN = 3;
    int DRAW = 1;
    int LOSS = 0;

    private String name;
    private int matchPoints;
    private int alternativeMatchPoints;
    private int totalGoals;
    private int win;
    private int draw;
    private int loss;
    private Date registrationDate;
    private Group group;

    public Team(String name, Date registrationDate, Group group) {
        this.name = name;
        this.matchPoints = 0;
        this.alternativeMatchPoints = 0;
        this.totalGoals = 0;
        this.win = 0;
        this.draw = 0;
        this.loss = 0;
        this.registrationDate = registrationDate;
        this.group = group;
    }

    public void addGoal(int goals) {
        this.totalGoals += goals;
    }

    public void addMatchPoints(int matchPoints) {
        this.matchPoints += matchPoints;
    }

    public void addWin() {
        this.win++;
    }

    public void addDraw() {
        this.draw++;
    }

    public void addLoss() {
        this.loss++;
    }

    public void addAltMatchPoints(int matchPoints) {
        this.alternativeMatchPoints += matchPoints;
    }

    public int getTotalGoal() {
        return this.totalGoals;
    }

    public int getMatchPoints() {
        return this.matchPoints;
    }

    public int getWin() {
        return this.win;
    }

    public int getDraw() {
        return this.draw;
    }

    public int getLoss() {
        return this.loss;
    }

    public int getAltMatchPoints() {
        return this.alternativeMatchPoints;
    }

    public String getName() {
        return this.name;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public Group getGroup() {
        return this.group;
    }

    public String toString() {
        return this.name;
    }

    public void clear() {
        this.matchPoints = 0;
        this.alternativeMatchPoints = 0;
        this.totalGoals = 0;
        this.win = 0;
        this.draw = 0;
        this.loss = 0;
    }
}
