package testSuit;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;

import com.seleniumeasy.functionalTests.data.Data;
import com.seleniumeasy.jBehave.steps.AjaxFormSubmitSteps;
import com.seleniumeasy.jBehave.steps.BasicFirstFormSteps;
import com.seleniumeasy.jBehave.steps.BasicSelectDropdownSteps;

public class JBehaveTestSuite{
	private static Embedder embedder = new Embedder();
    private static List<String> storyPaths = Arrays.asList(
    		"BasicFirstFormPage.story", 
    		"AjaxFormSubmitPage.story",
    		"BasicSelectDropdownPage.story"
    		);
    
    public static void main(String[] args) {
   	 System.setProperty("webdriver.chrome.driver",Data.DRIVER_PATH);
       embedder.candidateSteps().add(new BasicFirstFormSteps());
       embedder.candidateSteps().add(new AjaxFormSubmitSteps());
       embedder.candidateSteps().add(new BasicSelectDropdownSteps());
       
       try {
       embedder.runStoriesAsPaths(storyPaths);}
       catch(Exception e) {
       	System.out.println("ERROR OCCURRED DURING THE TEST");
       	System.out.println(e.getMessage());
       }
   }
}