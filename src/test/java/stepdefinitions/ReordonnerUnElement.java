package stepdefinitions;

import Page.AcceuilPage;
import Page.InterractionPage;
import Page.SortablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ReordonnerUnElement {
	AcceuilPage acceuil = new AcceuilPage(Hooks.driver);
	InterractionPage interraction = new InterractionPage(Hooks.driver);
	SortablePage sortable = new SortablePage(Hooks.driver);
	
	@Given("Je suis dans l'onglet sortable")
	public void je_suis_dans_l_onglet_sortable() {
		acceuil.clickToInterraction();
		 interraction.clickToMenuSortable();
	}

	@Then("La page se charge correctement avec les onglets {string} et {string} visibles")
	public void la_page_se_charge_correctement_avec_les_onglets_et_visibles(String string, String string2) {
		 boolean isListDisplayeddValue = sortable.isListDisplayed();
		 Assert.assertTrue("le menu list doit être affiché", isListDisplayeddValue);
		 boolean isGridDisplayedValue = sortable.isGridDisplayed();
		 Assert.assertTrue("le menu grid doit être affiché", isGridDisplayedValue);
	}

	@Then("L'onglet {string} est actif par défaut")
	public void l_onglet_est_actif_par_défaut(String string) {
		boolean isValueActive = sortable.isOngletListActive();
	    Assert.assertTrue("l'onglet list doit être active par défaut", isValueActive);
	}

	@Then("L'élément One est affiché")
	public void l_élément_one_est_affiché() {
	   boolean isOngletOneDisplayed = sortable.isOneDisplayed();
	    Assert.assertTrue("l'onglet One est affiché", isOngletOneDisplayed);
	}

	@Then("L'élément Two est affiché")
	public void l_élément_two_est_affiché() {
		boolean isOngletTwoDisplayed = sortable.isTwoDisplayed();
	    Assert.assertTrue("l'onglet One est affiché", isOngletTwoDisplayed);
	}

	@Then("L'élément Three est affiché")
	public void l_élément_three_est_affiché() {
		boolean isOngletThreeDisplayed = sortable.isThreeDisplayed();
	    Assert.assertTrue("l'onglet One est affiché", isOngletThreeDisplayed);
	}

	@Then("L'élément Four est affiché")
	public void l_élément_four_est_affiché() {
		boolean isOngletFourDisplayed = sortable.isThreeDisplayed();
	    Assert.assertTrue("l'onglet One est affiché", isOngletFourDisplayed);
	}

	@Then("L'élément Five est affiché")
	public void l_élément_five_est_affiché() {
		boolean isOngletFiveDisplayed = sortable.isFiveDisplayed();
	    Assert.assertTrue("l'onglet One est affiché", isOngletFiveDisplayed);
	}

	@Then("L'élément Six est affiché")
	public void l_élément_six_est_affiché() {
		boolean isOngletSixDisplayed = sortable.isSixDisplayed();
	    Assert.assertTrue("l'onglet One est affiché", isOngletSixDisplayed);
	}

	@When("Faire glisser {string} vers la position de {string}")
	public void faire_glisser_vers_la_position_de(String string, String string2) {
	    //sortable.clickToElement();
	    //sortable.elementThreeEnSurbreillance();
	    //sortable.dragAndDropElement();
	    //sortable.relacherElement();
		sortable.dragAndDropSeconMethod();
	}

	@Then("L'element {string} apparaît à la premiére position")
	public void l_element_apparaît_à_la_premiére_position(String string) {
	    String actualPosition = sortable.verifierTextPositonOne();
	    Assert.assertEquals("la position one doit avoir l'élément Three", "Three", actualPosition);
	}
}
