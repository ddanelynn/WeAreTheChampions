import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        TeamProcessor teamProcessor = new TeamProcessor();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Team Information");
        String teamInfoInput = sc.nextLine();
        while (teamInfoInput.length() > 1) {
            if (teamInfoInput.equals("clear")) {
                teamProcessor.clearTeamInformation();
            }
            teamProcessor.processTeamInformationInput(teamInfoInput);
            teamInfoInput = sc.nextLine();
        }

        System.out.println("Enter Match Results");
        String matchResult = sc.nextLine();
        while (matchResult.length() > 1) {
            if (teamInfoInput.equals("clear")) {
                teamProcessor.clearMatchResults();
            }
            teamProcessor.processMatchResultsInput(matchResult);
            matchResult = sc.nextLine();
        }

        teamProcessor.outputRank();

        sc.close();
    }
}