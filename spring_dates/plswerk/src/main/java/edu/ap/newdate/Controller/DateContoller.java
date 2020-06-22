package edu.ap.newdate.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import edu.ap.newdate.Model.NewDate;
import edu.ap.newdate.Repository.NewDateRepository;

@Controller
public class DateContoller {

    @Autowired
    NewDateRepository dateRepository;

    @GetMapping("/")
    public RedirectView index(){
        return new RedirectView("/list");
    }

    @GetMapping("/date")
    public String grade(){
        return "date";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("dates", dateRepository.findAll());
        return "list";
    }

    

    @PostMapping("/date")
    public RedirectView setGrade(
        @RequestParam("checkDate") String checkDate,
        @RequestParam("startDate") String startDate,
        @RequestParam("endDate") String endDate){
        //String between = "";
            // if(checkDate.after(startDate) && checkDate.before(endDate)){
            //     between = "Yes";
            // } else {
            //     between = "No";
            // }

            //dateRepository.save(new NewDate(checkDate, startDate, endDate));

            return new RedirectView("/list");
        }

    // @GetMapping("/{firstName}/{lastName}")
    // public String getDetail(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, Model model) {
    //     Date grade = dateRepository.findByFirstNameAndLastName(firstName, lastName);
    //     model.addAttribute("grade", grade);
    //     return "detail";
    // }
    
}