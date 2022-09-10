import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {
    @Override
    public int compare(Team a, Team b) {
        if (a.getMatchPoints() > b.getMatchPoints()) {
            return -1;
        } else if (a.getMatchPoints() == b.getMatchPoints()) {
            return compareTotalGoals(a, b);
        } else {
            return 1;
        }
    }

    public int compareTotalGoals(Team a, Team b) {
        if (a.getTotalGoal() > b.getTotalGoal()) {
            return -1;
        } else if (a.getTotalGoal() == b.getTotalGoal()) {
            return compareAltMatchPoints(a, b);
        } else {
            return 1;
        }
    }

    public int compareAltMatchPoints(Team a, Team b) {
        if (a.getAltMatchPoints() > b.getAltMatchPoints()) {
            return -1;
        } else if (a.getAltMatchPoints() == b.getAltMatchPoints()) {
            return a.getRegistrationDate().compareTo(b.getRegistrationDate());
        } else {
            return 1;
        }
    }
}
