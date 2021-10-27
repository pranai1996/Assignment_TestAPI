package StepDefinitions;

import com.test.base.BaseSetup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
/**
* This class has all the utilities used for the project
* These utility classes can be used by other page classes
* 
* @return null
*/
public class Hooks extends BaseSetup{
	
	@Before
    public void beforeScenario(){
        System.out.println("Starting this scenario");
    } 
 
    @After
    public void afterScenario(Scenario scenario) throws InterruptedException{
        System.out.println("Ending up the scenario");
    }
    }
	

