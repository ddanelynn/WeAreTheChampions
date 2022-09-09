public class TeamProcessor {
    int WIN = 3;
    int DRAW = 1;
    int LOSS = 0;

    public void processGoal(Team a, Team b, int goalA, int goalB) {
        a.totalGoals += goalA;
        b.totalGoals += goalB;
    }

    public void processMatchPoints(Team a, Team b, int goalA, int goalB) {
        if (goalA > goalB) {
            a.matchPoints += WIN;
            a.win++;
            b.loss++;
        } else if (goalA == goalB) {
            a.matchPoints += DRAW;
            b.matchPoints += DRAW;
            a.draw++;
            b.draw++;
        } else {
            b.matchPoints += WIN;
            a.loss++;
            b.win++;
        }
    }

    public void processTeams(Team a, Team b, int goalA, int goalB) {
        processGoal(a, b, goalA, goalB);
        processMatchPoints(a, b, goalA, goalB);
    }
}
