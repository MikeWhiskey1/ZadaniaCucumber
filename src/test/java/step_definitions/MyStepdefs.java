package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;


public class MyStepdefs {
    @Given("something is done")
    public void somethingIsDone() {
        System.out.println("Udalo sie skonfigurowac Ogorka");
    }

    @When("{string} is printed")
    public void isPrinted(String parameter) {
        System.out.println(parameter);
    }

    @And("{int} is printed correctly")
    public void isPrintedCorrectly(int parameter) {
        int i = parameter + 3;
        System.out.println(i);
    }

    @But("we can use a list a well")
    public void weCanUseAListAWell(List<String> list) {
        for (String animal : list)
            System.out.println(animal);

    }
}
