package stepdefinitions;

import Page.AcceuilPage;
import Page.AlertsPage;
import Page.AlertsWindowsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class GererUneAlerte {
	AcceuilPage acceuil = new AcceuilPage(Hooks.driver);
	AlertsWindowsPage alerteWindow = new AlertsWindowsPage(Hooks.driver);
	AlertsPage pageAlert = new AlertsPage(Hooks.driver);

	@Given("je suis dans la page demoQA")
	public void je_suis_dans_la_page_demo_qa() {
		 acceuil.isMenuAlerteFrameWindowDisplayed();
		 acceuil.clickToAlertFrameWindow();
		 alerteWindow.clickToMenuAlerte();
	}

	@When("je clique sur le bouton Click Button to see alert")
	public void je_clique_sur_le_bouton_click_button_to_see_alert() {
		pageAlert.clickToBoutton();
	}

	@Then("une alerte s'affiche")
	public void une_alerte_s_affiche() {
		pageAlert.checkAlert();
	}

	@When("je clique sur OK de l'alerte")
	public void je_clique_sur_ok_de_l_alerte() {
		pageAlert.acceptAlert();
	}

	@Then("l'alerte disparait")
	public void l_alerte_disparait() {
		boolean actualResult = pageAlert.isAlertPresent();
	    Assert.assertFalse("L'alerte doit dissparaitre", actualResult);
	}
}
