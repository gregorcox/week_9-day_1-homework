import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static spark.Spark.get;

public class NameController {

    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        ArrayList<String> names = new ArrayList<>();

        names.add("John");
        names.add("Zsolt");
        names.add("Tony");
        names.add("Jarrod");
        names.add("Joe");
        names.add("Simon");




        get("/one", (req, res) -> {
            Collections.shuffle(names);
            String randomName = names.get(0);
            HashMap<String, Object> model = new HashMap<>();
            model.put("names", randomName);
            return new ModelAndView(model, "name.vtl");
        }, velocityTemplateEngine);


        get("/two", (req, res) -> {
            Collections.shuffle(names);
            String randomOne = names.get(0);
            String randomTwo = names.get(1);
            String twoNames = randomOne + " and " + randomTwo;
            HashMap<String, Object> model = new HashMap<>();
            model.put("names", twoNames);
            return new ModelAndView(model, "name.vtl");
        }, velocityTemplateEngine);

    }
}
