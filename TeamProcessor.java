public class TeamProcessor {
    int WIN = 3;
    int DRAW = 1;
    int LOSS = 0;

    int ALT_WIN = 5;
    int ALT_DRAW = 3;
    int ALT_LOSS = 1;

    public void processGoal(Team a, Team b, int goalA, int goalB) {
        a.addGoal(goalA);
        b.addGoal(goalB);
    }

    public void processMatchPoints(Team a, Team b, int goalA, int goalB) {
        if (goalA > goalB) {
            a.addMatchPoints(WIN);
            b.addAltMatchPoints(LOSS);
        } else if (goalA == goalB) {
            a.addMatchPoints(DRAW);
            b.addAltMatchPoints(DRAW);
        } else {
            a.addMatchPoints(LOSS);
            b.addAltMatchPoints(WIN);
        }
    }

    public void processAltMatchPoints(Team a, Team b, int goalA, int goalB) {
        if (goalA > goalB) {
            a.addMatchPoints(ALT_WIN);
            b.addAltMatchPoints(ALT_LOSS);
        } else if (goalA == goalB) {
            a.addMatchPoints(ALT_DRAW);
            b.addAltMatchPoints(ALT_DRAW);
        } else {
            a.addMatchPoints(ALT_LOSS);
            b.addAltMatchPoints(ALT_WIN);
        }
    }

    public void processMatchResult(Team a, Team b, int goalA, int goalB) {
        if (goalA > goalB) {
            a.addWin();
            b.addLoss();
        } else if (goalA == goalB) {
            a.addDraw();
            b.addDraw();
        } else {
            a.addLoss();
            b.addWin();
        }
    }

    public void processTeams(Team a, Team b, int goalA, int goalB) {
        processGoal(a, b, goalA, goalB);
        processMatchPoints(a, b, goalA, goalB);
        processAltMatchPoints(a, b, goalA, goalB);
        processMatchResult(a, b, goalA, goalB);
    }
}
