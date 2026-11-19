package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(//C’est la configuration de Cucumber
	    features = "src/test/resources/Features",//Où se trouvent tes fichiers
	    glue = "stepdefinitions",//Où se trouvent tes classes Java (steps + hooks)
	    plugin  = {"pretty", "html:target/cucumber-report.html"},//pour créé un fichier cucumber pour voir les resulat d'exécution
	    monochrome = true,
	    tags = "@GestionAlert or @ReordonnerListe"
	    //tags = "@ReordonnerListe"
	    		
	)
public class   TestRunnerTest {

}