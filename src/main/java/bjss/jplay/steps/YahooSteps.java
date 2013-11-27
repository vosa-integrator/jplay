/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjss.jplay.steps;

import bjss.jplay.testing.web.PageFactory;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

/**
 *
 * @author Luke.Evans
 *Story file is: yahooSearch.story (jplay\src\main\resources\bjss\jplay\automation\stories\yahooSearch.story)
 */ 
public class YahooSteps {

    final private PageFactory pages;
    
    public YahooSteps(PageFactory pages) {
        this.pages = pages;
    }
    
    @Given("I am on the $pagename")
    public void givenPageName(@Named("pagename") String pagename) {
        System.out.println("lsce");
        
        if (pagename.equalsIgnoreCase("YahooHomepage")) {
            //Go to yahoo home page
            pages.yahoohomepage().navigateToHomepage();            
        }        
    }
        
    @When("I search for the keyword $searchterm")
    public void whenSearchForTerm(@Named("searchterm") String searchterm) {
        pages.yahoohomepage().enterSearchTerm(searchterm);      
    }    
    
    
    //@When("I click Submit")
    //public void whenClickSearchButton() {
    //    pages.yahoohomepage().clickSearch();
    //}   

    @Then("search box will contain the term $searchterm")
    public void thenSearchBoxContainTerm(@Named("searchterm") String searchterm) {
        //Does search box contents contain entered search term
        boolean retVal= pages.yahoohomepage().getSearchBoxText().equalsIgnoreCase(searchterm);
                
        //Evaluate if search term exists or not
        Assert.assertEquals(true, retVal);
    }
}