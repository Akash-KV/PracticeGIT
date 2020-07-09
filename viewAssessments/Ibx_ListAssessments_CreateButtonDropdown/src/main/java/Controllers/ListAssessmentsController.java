package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JSExecutorHelper;
import Pom.Dashboard;
import Utils.Config;
import Utils.ConsoleLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

//List Assessments Controller class
public class ListAssessmentsController {
    //Create button class
    public static class CreateButton {
        private static Config config = new Config();
        static Dashboard dashboard = new Dashboard();
        private static String browser;

        // Click create button method
        public static void clickCreateButton() {
            try {
                DriverHelper.clickXpath(dashboard.getDropdown());
            } catch (Exception e) {
                ConsoleLogger.DebugLog("Create button not found" + e);
            }
        }

        // Method for click Specific Assessment
        public static void clickSpecificAssessment(String assessmentType) {
            try {
                DriverHelper.clickXpath("//ul[@class='dropdown-menu']//a[contains(text(),'" + assessmentType + "')]");
            } catch (Exception e) {
                ConsoleLogger.DebugLog(assessmentType + " not found!");
            }
        }

        //Method for click All
        public static void clickAll() {
            config.readProperties();
            browser = config.getBrowser();
            String assessment = null;
            String currentUrl = BrowserInitHelper.getInstance().getCurrentUrl();
            DriverHelper.waitTill(3);
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();

            //int numberOfElements = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='assessment-create-assessment-tab']//h4")).size();
            List<WebElement> listOfAssessments = BrowserInitHelper.getInstance().findElements(By.xpath(dashboard.getListOfAssessment()));
            List<String> assessmentList = new ArrayList<String>();

            for (WebElement e : listOfAssessments) {
                String assessmentName = e.getText();
                System.out.println("Assessment Names inside list ==>" + assessmentName);
                if (assessmentName.equalsIgnoreCase(" ")) {
                    System.out.println("Empty values....");
                } else {
                    assessmentList.add(assessmentName);
                }
            }

            System.out.println("assessmentList ==>" + assessmentList);

            for (int i = 0; i < assessmentList.size(); i++) {
                try {
                    int j = i + 1;
                    assessment = assessmentList.get(i);
                    System.out.println("After assignment in list ==>" + assessment);
                    DriverHelper.clickXpath("(//div[@id='assessment-create-assessment-tab']//h4)[" + j + "]");

                    //On the Fly
                    if (assessment.equalsIgnoreCase("On the Fly")) {
                        //Click and check popup
                        DriverHelper.waitTill(3);
                        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getOnTheFlyAssement())));
                        ConsoleLogger.SuccessLog("On the fly assessment Popup is displayed.....");

                        //Click back
                        DriverHelper.clickXpath(dashboard.getClickBack());
                        DriverHelper.waitTill(3);

                        DriverHelper.clickXpath(dashboard.getCreateAssessmentModel());
                        DriverHelper.waitTill(3);
                    }

                    //Flexible
                    if (assessment.equalsIgnoreCase("Flexible")) {
                        try {
                            //Click and check popup
                            DriverHelper.waitTill(5);
                            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getFlexibleCreateModelBody())));
                            ConsoleLogger.SuccessLog("Flexible is displayed.....");

                            js.executeScript("window.history.back()", "");
                            DriverHelper.waitTill(5);
                        } catch (Exception e) {
                            System.out.println("Exception handled ==>" + e);
                        }
                    }

                    //Item Bank
                    if (assessment.equalsIgnoreCase("Item Bank")) {
                        //Click and check popup
                        DriverHelper.waitTill(3);
                        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getItemBankCreateModelBody())));
                        ConsoleLogger.SuccessLog("Item Bank is displayed.....");

                        js.executeScript("window.history.back()", "");
                        DriverHelper.waitTill(5);
                    }

                    //Skills
                    if (assessment.equalsIgnoreCase("Skills")) {
                        //Click and check popup
                        DriverHelper.waitTill(3);
                        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getSkillsCreate())));
                        ConsoleLogger.SuccessLog("Skills is displayed.....");

                        js.executeScript("window.history.back()", "");
                        DriverHelper.waitTill(5);
                    }

                    if (!browser.equals("safari")) {
                        JSExecutorHelper.waitUntilDocumentIsReady();
                    } else {
                        DriverHelper.waitTill(1);
                        JSExecutorHelper.waitUntilDocumentIsReady();
                    }

                    NavbarController.getListAssessments();
                    DriverHelper.waitTill(3);
                    //clickCreateButton();
                    BrowserInitHelper.getInstance().findElement(By.xpath(dashboard.getClickCreateButton())).click();
                    DriverHelper.waitTill(3);
                } catch (Exception e) {
                    ConsoleLogger.DebugLog(assessment + " not found!" + e);
                }
                ConsoleLogger.SuccessLog(assessment + " displayed and able to navigate to the page");
                DriverHelper.waitTill(5);
            }
        }

        //Method for clicking on Other Tab
        public static void clickAllInOtherTab() {
            config.readProperties();
            browser = config.getBrowser();
            String assessment = null;
            DriverHelper.waitTill(3);
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();

            boolean checkOtherTab = false;
            try {
                DriverHelper.waitTill(3);
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getClickOtherTab())));
                DriverHelper.clickXpath(dashboard.getClickOtherTab());
                checkOtherTab = true;
            } catch (Exception e) {
                System.out.println("Exception handled for checkOtherTab" + e);
            }

            if (checkOtherTab) {
                List<WebElement> listOfAssessments = BrowserInitHelper.getInstance().findElements(By.xpath(dashboard.getOtherCreateAssessmentTab()));
                List<String> assessmentList = new ArrayList<String>();

                for (WebElement e : listOfAssessments) {
                    String assessmentName = e.getText();
                    System.out.println("Assessment Names inside list ==>" + assessmentName);
                    if (assessmentName.equalsIgnoreCase(" ")) {
                        System.out.println("Empty values....");
                    } else {
                        assessmentList.add(assessmentName);
                    }
                }

                System.out.println("assessmentList ==>" + assessmentList);

                for (int i = 0; i < assessmentList.size(); i++) {
                    try {
                        int j = i + 1;
                        assessment = assessmentList.get(i);
                        System.out.println("After assignment in list ==>" + assessment);
                        DriverHelper.clickXpath("(//div[@id='other-create-assessment-tab']//h4)[" + j + "]");

                        //Summary
                        if (assessment.equalsIgnoreCase("Summary")) {
                            //Click and check popup
                            DriverHelper.waitTill(3);
                            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getSummaryCreateModel())));
                            ConsoleLogger.SuccessLog("Summary is displayed.....");

                            js.executeScript("window.history.back()", "");
                            DriverHelper.waitTill(5);
                        }

                        //Demographic
                        if (assessment.equalsIgnoreCase("Demographic")) {
                            try {
                                //Click and check popup
                                DriverHelper.waitTill(5);
                                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getDemographicCreateModel())));
                                ConsoleLogger.SuccessLog("Demographic is displayed.....");

                                js.executeScript("window.history.back()", "");
                                DriverHelper.waitTill(5);
                            } catch (Exception e) {
                                System.out.println("Exception handled ==>" + e);
                            }
                        }

                        NavbarController.getListAssessments();
                        DriverHelper.waitTill(3);
                        //clickCreateButton();
                        BrowserInitHelper.getInstance().findElement(By.xpath(dashboard.getClickCreateButton())).click();
                        DriverHelper.waitTill(3);

                        BrowserInitHelper.getInstance().findElement(By.xpath(dashboard.getClickOtherTab())).click();
                        DriverHelper.waitTill(3);
                    } catch (Exception e) {
                        ConsoleLogger.DebugLog(assessment + " not found!" + e);
                    }
                    ConsoleLogger.SuccessLog(assessment + " displayed and able to navigate to the page");
                }
            }
        }

        //Method for clicking On Legacy Tab
        public static void clickAllInLegacyTab() {
            config.readProperties();
            browser = config.getBrowser();
            String assessment = null;
            DriverHelper.waitTill(3);
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();

            boolean checkLegacyTab = false;
            try {
                DriverHelper.waitTill(2);
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getLegacyCreateModel())));
                DriverHelper.clickXpath(dashboard.getLegacyText());
                checkLegacyTab = true;
            } catch (Exception e) {
                System.out.println("Exception handled for checkOtherTab" + e);
            }

            if (checkLegacyTab == false) {
                try {
                    DriverHelper.waitTill(2);
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getLegacyCreateModelTwo())));
                    DriverHelper.clickXpath(dashboard.getLegacyTextTwo());
                    checkLegacyTab = true;
                } catch (Exception e) {
                    System.out.println("Exception handled for checkLegacyTab" + e);
                }
            }

            if (checkLegacyTab) {
                List<WebElement> listOfAssessments = BrowserInitHelper.getInstance().findElements(By.xpath(dashboard.getCheckLegacyTab()));
                List<String> assessmentList = new ArrayList<String>();

                for (WebElement e : listOfAssessments) {
                    String assessmentName = e.getText();
                    System.out.println("Assessment Names inside list ==>" + assessmentName);
                    if (assessmentName.equalsIgnoreCase(" ")) {
                        System.out.println("Empty values....");
                    } else {
                        assessmentList.add(assessmentName);
                    }
                }

                System.out.println("assessmentList ==>" + assessmentList);

                for (int i = 0; i < assessmentList.size(); i++) {
                    try {
                        int j = i + 1;
                        assessment = assessmentList.get(i);
                        System.out.println("After assignment in list ==>" + assessment);
                        DriverHelper.clickXpath("(//div[@id='legacy-create-assessment-tab']//h4)[" + j + "]");


                        //Manual / Hybrid
                        if (assessment.equalsIgnoreCase("Manual / Hybrid")) {
                            //Click and check popup
                            DriverHelper.waitTill(3);
                            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getManualHybridAssessment())));
                            ConsoleLogger.SuccessLog("Manual / Hybrid is displayed.....");

                            //Click back
                            DriverHelper.clickXpath(dashboard.getClickBackManualHybrid());
                            DriverHelper.waitTill(3);

                            DriverHelper.clickXpath(dashboard.getCreateAssessmentModel());
                            DriverHelper.waitTill(3);
                        }

                        //Survey
                        if (assessment.equalsIgnoreCase("Survey")) {
                            try {
                                //Click and check popup
                                DriverHelper.waitTill(5);
                                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboard.getSurveyClick())));
                                ConsoleLogger.SuccessLog("Survey is displayed.....");

                                js.executeScript("window.history.back()", "");
                                DriverHelper.waitTill(5);
                            } catch (Exception e) {
                                System.out.println("Exception handled ==>" + e);
                            }
                        }


                        NavbarController.getListAssessments();
                        DriverHelper.waitTill(3);
                        //clickCreateButton();
                        BrowserInitHelper.getInstance().findElement(By.xpath(dashboard.getDropdown())).click();
                        DriverHelper.waitTill(3);

                        try {
                            BrowserInitHelper.getInstance().findElement(By.xpath(dashboard.getLegacyText())).click();
                            DriverHelper.waitTill(3);
                        } catch (Exception e) {
                            try {
                                BrowserInitHelper.getInstance().findElement(By.xpath(dashboard.getLegacyCreateModelTwo())).click();
                                DriverHelper.waitTill(3);
                            } catch (Exception e1) {
                                System.out.println("Exception handled for inner legacy try catch block....");
                            }
                        }
                    } catch (Exception e) {
                        ConsoleLogger.DebugLog(assessment + " not found!" + e);
                    }
                    ConsoleLogger.SuccessLog(assessment + " displayed and able to navigate to the page");
                }
            }
        }
    }
}
