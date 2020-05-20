package com.globant.web.data.dataProvider;

import com.globant.web.data.entities.SearchOptions;
import com.globant.web.properties.MyProperties;
import org.testng.annotations.DataProvider;

/**
 * Class provide data as Data Provider class
 *
 * @author Sebastian Mesa
 */
public class Data {
    @DataProvider(name = "jiraData")
    public Object[][] jiraData() {
        MyProperties myProperties = new MyProperties();
        return new Object[][]{{
                SearchOptions.builder().nameBacklog(myProperties.getProperty("label.name.backlog"))
                        .urlBacklog("https://ftrjira.ftr.com/secure/RapidBoard.jspa?rapidView=1469&projectKey=PT&view=planning")
                        .nameNewDash(myProperties.getProperty("label.name.newDash"))
                        .urlNewDash("https://ftrjira.ftr.com/secure/Dashboard.jspa?selectPageId=14503#Filter-Results/21043")
                        .nameQuery(myProperties.getProperty("label.name.query"))
                        .urlQuery("https://ftrjira.ftr.com/browse/PT-1073?filter=21370")
                        .build()
        }};
    }
}
