package lambdas.ch06.exercise;

import java.util.Comparator;

public class PremierLeagueComparator {

	public static Comparator<PremierLeagueTeam> sortByStanding = new Comparator<PremierLeagueTeam>() {

		@Override
		public int compare(PremierLeagueTeam team1, PremierLeagueTeam team2) {
			
			 if(team1.getPoints() == team2.getPoints()) 
			 {
				 if(team1.getGoalDifference() ==  team2.getGoalDifference()) {	
					 
					 //Can use Integer.compare
					 if(team1.getGoalsScored() == team2.getGoalsScored() ) return 0;
					 return team1.getGoalsScored() > team2.getGoalsScored() ? -1  : 1;
					 
				 }
				 return team1.getGoalDifference() > team2.getGoalDifference() ? -1: 1;
			 }
			 return (team1.getPoints() > team2.getPoints() )?  -1 : 1;
			
	   }
   };
}
