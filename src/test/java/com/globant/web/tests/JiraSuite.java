package com.globant.web.tests;

import com.globant.web.data.dataProvider.Data;
import com.globant.web.data.entities.SearchOptions;
import com.globant.web.pages.*;
import jdk.nashorn.internal.AssertsEnabled;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Suite to test the booking flow.
 *
 * @author Sebastian Mesa
 */
@Slf4j
public class JiraSuite extends BaseTest {

    @Test(description = "Test to compare data", dataProvider = "jiraData", dataProviderClass = Data.class)
    public void validateJiraData(SearchOptions options){

        // HOME PAGE
        HomePage homePage = getHomePage();

        // BACKLOG PAGE
        BacklogPage backlogPage = homePage.goToBacklog(options.getUrlBacklog());
        List<String> listBacklog = backlogPage.getListBacklogKeys();

        log.info("{} has : {} items", options.getNameBacklog(), listBacklog.size());

        // NEW DASH PAGE
        NewDashPage newDashPage = backlogPage.goToNewDash(options.getUrlNewDash());
        List<String> listNewDash = newDashPage.getListNewDashKeys();

        log.info("{} has : {} items", options.getNameNewDash(), listNewDash.size());

        // HOME PAGE
        QueryPage queryPage = newDashPage.goToQuery(options.getUrlQuery());
        List<String> listQuery = queryPage.getListQueryKeys();

        log.info("{} has : {} items", options.getNameQuery(), listQuery.size());

        // VALIDATIONS
        homePage.compareTwoLists(listBacklog, listNewDash, options.getNameBacklog(), options.getNameNewDash());
        homePage.compareTwoLists(listBacklog, listQuery, options.getNameBacklog(), options.getNameQuery());
        homePage.compareTwoLists(listNewDash, listQuery, options.getNameNewDash(), options.getNameQuery());
    }

}
