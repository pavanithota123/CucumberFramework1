package runner;


import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/features",
glue={"stepDefinitions","hooks"},
plugin= {"pretty","html:target/cucumber-reports.html"},
publish=true)

//Here i can put tags if i want to run particular test case but i didnt implemented for complete flow execution

public class MyRunner extends AbstractTestNGCucumberTests  

{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
	    return super.scenarios();
	}

}
