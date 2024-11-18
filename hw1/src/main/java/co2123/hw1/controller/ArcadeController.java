package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Arcade;
import co2123.hw1.domain.Machine;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class ArcadeController {

    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(new ArcadeValidator());
    }


    @RequestMapping(path="/arcades", method=RequestMethod.GET)
    public String listArcades(final Model model) {
        model.addAttribute("arcades", Hw1Application.arcades);
        return "arcades/list";
    }

    @RequestMapping("/newArcade")
    public String newArcade(final Model model) {
        model.addAttribute("arcade", new Arcade());
        return "arcades/form";
    }

    @RequestMapping(path="/addArcade", method=RequestMethod.POST)
    public String addArcade(final @Valid @ModelAttribute Arcade arcade, final BindingResult result) {
        if (result.hasErrors()) {
            return "arcades/form";
        }

        arcade.setMachines(new ArrayList<Machine>());
        Hw1Application.arcades.add(arcade);
        return "redirect:/arcades";
    }
}
