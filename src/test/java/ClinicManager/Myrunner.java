package ClinicManager;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Features/AddingPatients.feature" }, tags = "", publish = true, glue = {
		"ClinicManager", "Doctor", "Pharmacy", "Superadmin", "Homecareattendant",
		"RecommendationManager" }, plugin = { "html:target/Cucumberreport.html" })

public class Myrunner extends AbstractTestNGCucumberTests {
}
//paste this below line in features in invented commas- "" for StepDefinitions package. Done
//"src/test/java/StepDefinitions/AddingPatients.feature","src/test/java/StepDefinitions/BookingServices.feature","src/test/java/StepDefinitions/LabTechnician.feature","src/test/java/StepDefinitions/Bookinglabhome.feature","src/test/java/StepDefinitions/IPPackage.feature","src/test/java/StepDefinitions/Patientprofileicons.feature","src/test/java/StepDefinitions/Masterdata.feature"
//paste this below line in features in invented commas - "" for Doctor package Done
//"src/test/java/Doctor/Dashboardsearch.feature","src/test/java/Doctor/Favouriteprescription.feature","src/test/java/Doctor/Prescription.feature","src/test/java/Doctor/IPflow.feature","src/test/java/Doctor/Teleconsultation.feature"

//paste this below line in features in invented commas - "" for Pharmacy package Done
//"src/test/java/Pharmacy/Createorder.feature","srsc/test/java/Pharmacy/Inventory.feature","src/test/java/Pharmacy/PharmacyMasterdata.feature","src/test/java/Pharmacy/Pharmacyreports.feature"

//paste this below line in features in invented commas - "" for SuperAdmin package Done
//"src/test/java/Superadmin/Createcdp.feature"

//paste this below line in features in invented commas - "" for RecommendationManager package
//Open recommendationmanager java file in StepDefinitions package and right click->Run as->3 MyRunner(1) Junit