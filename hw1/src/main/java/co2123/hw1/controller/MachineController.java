package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Arcade;
import co2123.hw1.domain.Machine;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MachineController {

    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(new MachineValidator());
    }

    @RequestMapping(path="/machines", method=RequestMethod.GET)
    public String showMachines(final @RequestParam(value = "arcade", defaultValue = "-1") int arcadeId, final Model model) {

        Arcade arcade = null;

        for (Arcade a : Hw1Application.arcades) {
            if (a.getId() == arcadeId) {
                arcade = a;
                break;
            }
        }

        if (arcade != null) {
            model.addAttribute("machines", arcade.getMachines());
        }

        model.addAttribute("arcadeId", arcadeId);
        return "machines/list";
    }

    @RequestMapping("/newMachine")
    public String newMachine(final @RequestParam(value = "arcade", defaultValue = "-1") int arcadeId, final Model model) {
        model.addAttribute("machine", new Machine());
        model.addAttribute("arcadeId", arcadeId);
        return "machines/form";
    }

    @RequestMapping(path="/addMachine", method=RequestMethod.POST)
    public String addMachine(final @Valid @ModelAttribute Machine machine, final BindingResult result, final @RequestParam(value = "arcade", defaultValue = "-1") int arcadeId, final Model model) {

        if (result.hasErrors()) {
            model.addAttribute("arcadeId", arcadeId);
            return "machines/form";
        }

        Arcade arcade = null;

        for (Arcade a : Hw1Application.arcades) {
            if (a.getId() == arcadeId) {
                arcade = a;
                break;
            }
        }

        if (arcade != null) {
            final List<Machine> machineList = arcade.getMachines();
            machineList.add(machine);
            arcade.setMachines(machineList);
        }

        return "redirect:/arcades";
    }

}
