package qwr.dz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qwr.dz.entity.Answer;
import qwr.dz.entity.Demand;
import qwr.dz.logic.ActionImpl;
import qwr.dz.logic.IAction;

@Controller
public class ApplicationController {
    //внедряем класс логики
    private final ActionImpl elm;

    public ApplicationController(ActionImpl elm) {
        this.elm = elm;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/service") //обработчик получения формы
    public String serviceForm() {
    return "service-form";
    }
    @PostMapping("/service")
    public String serviceForm(@RequestParam double sideFirst, @RequestParam double sideSecond,
                              @RequestParam double corner, @RequestParam String measure, Model model){
        System.out.println("*******************"+ measure);
        Answer z = elm.action(new Demand(sideFirst, sideSecond, corner, measure));
        System.out.println("******************** "+z.oppositeSide());
//        model.addAttribute("zzz", "ziiii");
        model.addAttribute("zzz", z.oppositeSide().toString());

        return "service-form";
    }
}
