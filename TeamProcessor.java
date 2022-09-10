import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TeamProcessor {
    int WIN = 3;
    int DRAW = 1;
    int LOSS = 0;

    int ALT_WIN = 5;
    int ALT_DRAW = 3;
    int ALT_LOSS = 1;

    HashMap<String, Team> teamMap;

    public TeamProcessor() {
        this.teamMap = new HashMap<>();
    }

    public void processTeamInformationInput(String input) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");

        String[] inputParts = input.split(" ");

        String name = inputParts[0];
        Date registrationDate = formatter.parse(inputParts[1]);
        Group group = inputParts[2].equals("1") ? Group.GROUP_ONE : Group.GROUP_TWO;

        Team team = new Team(name, registrationDate, group);
        this.teamMap.put(name, team);
    }

    public void processMatchResultsInput(String input) {
        String[] inputParts = input.split(" ");

        String teamA = inputParts[0];
        String teamB = inputParts[1];
        int goalA = Integer.parseInt(inputParts[2]);
        int goalB = Integer.parseInt(inputParts[3]);

        processTeams(this.teamMap.get(teamA), this.teamMap.get(teamB), goalA, goalB);
    }

    public void outputRank() {
        PriorityQueue<Team> group1Queue = new PriorityQueue<>(new TeamComparator());
        PriorityQueue<Team> group2Queue = new PriorityQueue<>(new TeamComparator());

        for (String teamName : this.teamMap.keySet()) {
            Team team = this.teamMap.get(teamName);
            if (team.getGroup() == Group.GROUP_ONE) {
                group1Queue.add(team);
            } else {
                group2Queue.add(team);
            }
        }

        int group1Rank = 1;
        int group2Rank = 1;

        System.out.println("Group 1 Ranking");

        while (!group1Queue.isEmpty()) {
            System.out.println(group1Rank + " " + group1Queue.poll());
            group1Rank++;
        }

        System.out.println("Group 2 Ranking");

        while (!group2Queue.isEmpty()) {
            System.out.println(group2Rank + " " + group2Queue.poll());
            group2Rank++;
        }
    }

    public void processGoal(Team a, Team b, int goalA, int goalB) {
        a.addGoal(goalA);
        b.addGoal(goalB);
    }

    public void processMatchPoints(Team a, Team b, int goalA, int goalB) {
        if (goalA > goalB) {
            a.addMatchPoints(WIN);
            b.addMatchPoints(LOSS);
        } else if (goalA == goalB) {
            a.addMatchPoints(DRAW);
            b.addMatchPoints(DRAW);
        } else {
            a.addMatchPoints(LOSS);
            b.addMatchPoints(WIN);
        }
    }

    public void processAltMatchPoints(Team a, Team b, int goalA, int goalB) {
        if (goalA > goalB) {
            a.addAltMatchPoints(ALT_WIN);
            b.addAltMatchPoints(ALT_LOSS);
        } else if (goalA == goalB) {
            a.addAltMatchPoints(ALT_DRAW);
            b.addAltMatchPoints(ALT_DRAW);
        } else {
            a.addAltMatchPoints(ALT_LOSS);
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
