package qwr.dz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qwr.dz.controller.forms.Fdemand;
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
    @PostMapping("/service-handler")
    public String serviceHandler(@RequestParam double sideFirst, @RequestParam double sideSecond,
                                 @RequestParam double corner, @RequestParam(defaultValue = "g") String measure,
                                 Model model,
                                 RedirectAttributes rda){
        Answer z = elm.action(new Demand(sideFirst, sideSecond, corner, measure));
        String str = " "+sideFirst +"*"+sideFirst+"+"+sideSecond+"*"+sideSecond+"-2*"+sideFirst+"*"+
                sideSecond+"* cos("+corner+" "+measure+" )";
        System.out.println("******************** "+z.oppositeSide());
//        model.addAttribute("zzz", "ziiii");
//        model.addAttribute("zzz", z.oppositeSide().toString());
//        model.addAttribute("str", str);
//        return "service-form";
        rda.addFlashAttribute("zzz", z.oppositeSide().toString());
        rda.addFlashAttribute("str", str);
        return "redirect:service";
    }

    //второй способ получения данных из формы
    // ФОРМЫ: СПОСОБ 2
    @GetMapping("/service-2") //обработчик получения формы
    public String serviceForm2(Model model) {
        Fdemand demand = new Fdemand();
        model.addAttribute("demand",demand);
        return "service-form-2";
    }
    // обработчик формы
    @PostMapping("/service-handler-2")
    public String serviceHandler2(Fdemand y, RedirectAttributes rda) {
        // 1. решим КВУР
//        Answer z = elm.action(new Demand(y.getSideFirst(), y.getSideSecond(), y.getCorner(), y.getMeasure()));
        Answer z = elm.action( y.Demand());
        // 2. отправить ответы
        String str = " "+y.getSideFirst() +"*"+y.getSideFirst()+"+"+y.getSideSecond()+"*"+y.getSideSecond()+"-2*"+y.getSideFirst()+"*"+
                y.getSideSecond()+"* cos("+y.getCorner()+" "+y.getMeasure()+" )";
        rda.addFlashAttribute("zzz", z.oppositeSide().toString());
        rda.addFlashAttribute("str", str);
        return "redirect:service-2";
    }
}
