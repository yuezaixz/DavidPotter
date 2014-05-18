package com.david.codejourney.salestrategy.calc;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Run with cucumber.
 * User: David
 * Date: 14-05-18
 * Time: 下午11:58
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"})
public class RunCukesTest {
}
