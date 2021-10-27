package StepDefinitions;


import java.io.IOException;

import com.test.base.BaseSetup;
import com.test.module.APIAssignmentdata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

/**
* This class has all the API Step Definitions for football API which can be used by other Features
* Feature files path (<current project directory>/src/test/resources/Features)
* 
* @return null
*/
public class APIAssignmentDefinition extends BaseSetup{
	
	APIAssignmentdata apiData = new APIAssignmentdata();
	Response playerstatsResponse;
	Response teamstatsResponse;
	Response OverallTeamstatsResponse;
	
	@Given("I perform an API request to fetch all available player scoring stats for the season")
	public void fetchAvailablePlayerStats() throws IOException {
	 playerstatsResponse= apiData.fetchAvailablePlayerStats();
	}

	@Then("I create a list of Top ten players based on points")
	public void listTopTenPlayers() {
		apiData.listTopTenPlayers(playerstatsResponse);
	}

	@Given("I perform an API request to fetch all available team scoring stats for the season")
	public void fetchAvailableTeamStats() throws IOException {
		teamstatsResponse=	apiData.fetchAvailableTeamStats();
	}

	@Then("I create a list of Top ten teams based on points")
	public void listTopTenTeams() {
	     apiData.listTopTenTeams(teamstatsResponse);
	}

	@Given("I perform an API request to fetch the overall team standings at the end of the season")
	public void fetchOverallTeamStandingsEndofTheSeason() throws IOException {
		OverallTeamstatsResponse= apiData.fetchOverallTeamStandingsEndofTheSeason();

	}

	@Then("I create a list of team standings")
	public void listTeamStandingsEndOftheSeason() {
		apiData.listTeamStandingsEndOftheSeason(OverallTeamstatsResponse);

	}
	
}
