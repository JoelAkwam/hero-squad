import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
public class App {
  public static void main(String[] args) {
      String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

    setPort(port);
    
    get("/", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/squads/new", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/squadForm.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("/squads", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("squads", Squad.all());
  model.put("template", "templates/squadList.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());


     post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("squad-name");
            int maxNum = Integer.parseInt(request.queryParams("squad-size"));
            String Desc = request.queryParams("squad-cause");
            Squad newSquad = new Squad(maxNum, name, Desc);
            model.put("template", "templates/success.vtl");

            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

          get("/squads/:id", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
           model.put("squad", squad);
           model.put("template", "templates/squad.vtl");
           return new ModelAndView(model, layout);
         }, new VelocityTemplateEngine());

         get("squads/:id/newhero", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
          model.put("squad", squad);
          model.put("template", "templates/squad-hero-form.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


             get("/squad-heros", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("heros", Hero.all());
          model.put("template", "templates/hero.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


     post("/squad-heros", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Squad squad = Squad.find(Integer.parseInt(request.queryParams("squad-H-id")));
         String name = request.queryParams("name");
         int max = Integer.parseInt(request.queryParams("max"));
         String powers = request.queryParams("powers");
         String weakness = request.queryParams("weakness");
         Hero newHero = new Hero(name, max, powers, weakness);
         squad.addHero(newHero);
         model.put("Message", "Hero Added Successfuly!!");
         model.put("template", "templates/success.vtl");
         return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());





}


}
