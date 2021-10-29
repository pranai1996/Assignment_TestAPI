package com.test.module;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Properties;
import java.util.TreeMap;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.test.base.BaseSetup;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * This class has all the API methods for Journey Planner API which can be used by other Fixtures/ Step Definitions
 * Step Definition path (<current project directory>/src/test/java/StepDefinitions)
 * 
 * @return null
 */

public class APIAssignmentdata extends BaseSetup{


	public Response fetchAvailablePlayerStats() throws IOException {

		String PlayerStandingsGetURL= prop.getProperty("PlayerStandingsAPI");
		Map<String,Object> headerMap = new HashMap<String,Object>();
		headerMap.put("X-Auth-Token", prop.getProperty("XAuthToken"));
		Response response= apiHelpers.getWithHeaders(PlayerStandingsGetURL,headerMap);
		response.then().assertThat().statusCode(200);
		response.then().body("season.startDate",containsString("2021"));
		return response;
	}

	public void listTopTenPlayers(Response response) {

		Map<String, Integer> playermap = new TreeMap<String, Integer>();

		List<String> playerList= response.jsonPath().getList("scorers.player.name");
		List<Integer> noOfGoals = response.jsonPath().getList("scorers.numberOfGoals");
		for(int i=0;i<playerList.size()-1;i++)
		{
			playermap.put(playerList.get(i), noOfGoals.get(i));
		}	
		Map<String, Integer> result = playermap.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue, 
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		//printing top ten players in descending order

		List<String> alKeys = new ArrayList<String>(result.keySet());
		Collections.reverse(alKeys);
		for(String strKey : alKeys){
			System.out.println("| Player : "  + strKey + "\t\t"
					+ " | Number of goals : "  + result.get(strKey)+" |");}


	}

	public Response fetchAvailableTeamStats() throws IOException {

		String TeamStandingsGetURL= prop.getProperty("TeamsStandingsAPI");
		Map<String,Object> headerMap = new HashMap<String,Object>();
		headerMap.put("X-Auth-Token", prop.getProperty("XAuthToken"));
		Response response= apiHelpers.getWithHeaders(TeamStandingsGetURL,headerMap);
		response.then().assertThat().statusCode(200);
		return response;
	}

	public void listTopTenTeams(Response response) {
	//	Map<Map<String,Integer>, Integer> teamMap = new LinkedHashMap<>();
        Map<String, Integer> teamPositionMap = new TreeMap<String,Integer>();
		List<String> teamList= response.jsonPath().getList("standings[0].table.team.name");
		List<Integer> pointsList = response.jsonPath().getList("standings[0].table.points");
		List<Integer> positionList = response.jsonPath().getList("standings[0].table.position");
		for(int i=0;i<teamList.size()-1;i++)
		{
			teamPositionMap.put(teamList.get(i)+"_"+pointsList.get(i), positionList.get(i));
		}
		System.out.println(positionList);
		
/*		for(int i=0;i<teamList.size()-1;i++)
		{
			teamMap.put(teamPositionMap, pointsList.get(i));
		}*/
		
		Map<String, Integer> sortPoints = teamPositionMap.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue, 
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		int rank=1;
		for (Map.Entry<String, Integer> entry : sortPoints.entrySet()) {
			String Key[] = entry.getKey().split("_");
		if(rank<11){
			System.out.println("| Rank =  "+entry.getValue()+" | Team Name = "+ Key[0].trim()+" | Points = "+Key[1].trim());}
			rank++;
		}
	}

	public Response fetchOverallTeamStandingsEndofTheSeason() throws IOException {

		String overallTeamStandingsGetURL= prop.getProperty("OverallTeamStandingsAPI");
		Map<String,Object> headerMap = new HashMap<String,Object>();
		headerMap.put("X-Auth-Token", prop.getProperty("XAuthToken"));
		Response response= apiHelpers.getWithHeaders(overallTeamStandingsGetURL,headerMap);
		response.then().assertThat().statusCode(200);
		return response;
	}

	public void listTeamStandingsEndOftheSeason(Response response) {
		Map<String, Integer> teamDetailsMap = new TreeMap<String, Integer>();

		//printing team details with name & ID as we couldn't find an API to get the team standings at the end of the season
		List<String> teamDetailsList= response.jsonPath().getList("teams.name");
		List<Integer> teamIDList = response.jsonPath().getList("teams.id");
		for(int i=0;i<teamDetailsList.size()-1;i++)
		{
			teamDetailsMap.put(teamDetailsList.get(i), teamIDList.get(i));
		}

		Map<String, Integer> result = teamDetailsMap.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue, 
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			System.out.println("| Team Name = "+ entry.getKey()+"| ID =  "+entry.getValue()+" |");
		}

	}


}
