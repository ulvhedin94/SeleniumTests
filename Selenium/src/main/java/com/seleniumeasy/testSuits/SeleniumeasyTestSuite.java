package com.seleniumeasy.testSuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.seleniumeasy.functionalTests.testCases.AjaxFormSubmitTests;
import com.seleniumeasy.functionalTests.testCases.BasicFirstFormTests;
import com.seleniumeasy.functionalTests.testCases.BasicSelectDropdownDemoTests;
import com.seleniumeasy.functionalTests.testCases.BootstrapAlertMessagesTests;
import com.seleniumeasy.functionalTests.testCases.BootstrapDownloadProgressTests;
import com.seleniumeasy.functionalTests.testCases.BootstrapDualListBoxTests;
import com.seleniumeasy.functionalTests.testCases.DynamicDataLoadingTests;
import com.seleniumeasy.functionalTests.testCases.JQueryDownloadProgressBarTests;
import com.seleniumeasy.functionalTests.testCases.TablePaginationTests;
import com.seleniumeasy.functionalTests.testCases.TableRecordsFilterTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AjaxFormSubmitTests.class,
	BasicFirstFormTests.class,
	BasicSelectDropdownDemoTests.class,
	BootstrapAlertMessagesTests.class,
	BootstrapDownloadProgressTests.class,
	BootstrapDualListBoxTests.class,
	DynamicDataLoadingTests.class,
	JQueryDownloadProgressBarTests.class,
	TablePaginationTests.class,
	TableRecordsFilterTests.class
})
public class SeleniumeasyTestSuite {

}
