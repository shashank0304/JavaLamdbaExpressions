package lambdas.ch06.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Solution to the exercise PremierLeagueComparatorExercise.
public class PremierLeagueComparatorTest {

	public static void main(String[] args) {
		
		//Using the usual way of sorting.
		System.out.println("Old style ");
		sortByTeamStandingsUsualWay();
		
		//Using static method on Comparator
		System.out.println("New style ");

		sortByTeamStandingsByComparing();

	}

	public static void sortByTeamStandingsByComparing() {
		List<PremierLeagueTeam> standings = getTeamStats();
		
		Comparator<PremierLeagueTeam> byPoints = Comparator.comparingInt(PremierLeagueTeam::getPoints)
				                                           .reversed(); 
		
		Comparator<PremierLeagueTeam> byGoalDiff = Comparator.comparingInt(PremierLeagueTeam::getGoalDifference)
				                                             .reversed();
		
		Comparator<PremierLeagueTeam> byGoalScored = Comparator.comparingInt(PremierLeagueTeam::getGoalsScored)
				                                               .reversed();
		
		Comparator<PremierLeagueTeam> BY_STANDINGS = byPoints.thenComparing(byGoalDiff)
				                                             .thenComparing(byGoalScored);
		
		
		standings.sort(BY_STANDINGS);
		
		for(PremierLeagueTeam team : standings) {
			System.out.println(team);	
		}
	}

	public static void sortByTeamStandingsUsualWay() {
		List<PremierLeagueTeam> standings = getTeamStats();
		Collections.sort(standings, PremierLeagueComparator.sortByStanding);
		
		for(PremierLeagueTeam team : standings) {
			System.out.println(team);	
		}
	}

	private static List<PremierLeagueTeam> getTeamStats() {

		List<PremierLeagueTeam> plTeams = new ArrayList<>();

		plTeams.add(new PremierLeagueTeam("Leicester City", 81, 68, 36));
		plTeams.add(new PremierLeagueTeam("Arsenal", 71, 65, 36));
		plTeams.add(new PremierLeagueTeam("Tottenham", 70, 69, 35));
		plTeams.add(new PremierLeagueTeam("Man City", 66, 71, 41));
		plTeams.add(new PremierLeagueTeam("Man United", 66, 49, 35));

		return plTeams;
	}

}
