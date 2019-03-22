package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();
    //static HashMap<String, String> cheeses = new HashMap<>();

    //Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
       // model.addAttribute("title", "Add Description");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        Cheese cheese = new Cheese(cheeseName, cheeseDescription);
        cheeses.add(cheese);

        //cheeses.put(cheeseName, cheeseDescription);

        //cheeses.put(cheeseDescription);
        //Redirect to /cheese
        return "redirect:";

    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Delete Cheese");
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheeseForm(@RequestParam ArrayList<Integer> cheeseIds) {
        for (Integer cheeseId : cheeseIds) {
            for (Cheese cheese: cheeses) {
                if (cheese.getId() == cheeseId) {
                    cheeses.remove(cheese);
                    break;
                }
            }
        }
        return "redirect:";
    }




}
