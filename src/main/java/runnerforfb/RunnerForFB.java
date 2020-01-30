package runnerforfb;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features", glue= {"FB"})

public class RunnerForFB {
	
	
}
