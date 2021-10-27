@APIAssignment
Feature: Features if API assignment for football teams
# This feature file consists of all required API test steps as per the scenarios given in the assignment
# This consists of a step Definition file backend  in <src/test/java/StepDefinitions/APIAssignmentDefinition.java>


  @APIAssignmentScenario1
  Scenario: 1. Get player scoring stats
    Given I perform an API request to fetch all available player scoring stats for the season
    And I create a list of Top ten players based on points
    
  @APIAssignmentScenario2
  Scenario: 2. Get team scoring stats
    Given I perform an API request to fetch all available team scoring stats for the season
    And I create a list of Top ten teams based on points
    
  @APIAssignmentScenario3
  Scenario: 2. Get overall team standings
    Given I perform an API request to fetch the overall team standings at the end of the season
    And I create a list of team standings