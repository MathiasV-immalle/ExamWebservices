package edu.ap.newdate.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public String date(){
        return "date";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("dates", dateRepository.findAll());
        return "list";
    }

    @PostMapping("/date")
    public RedirectView setDate(
        @RequestParam("checkDate") String checkDateString,
        @RequestParam("startDate") String startDateString,
        @RequestParam("endDate") String endDateString) throws ParseException{
        Date checkDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkDateString);
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);
        String between = "";
            if(checkDate.after(startDate) && checkDate.before(endDate)){
                between = "Yes";
            } else {
                between = "No";
            }
            System.out.println(checkDate);
            System.out.println(startDate);
            System.out.println(endDate);
            System.out.println(between);

            dateRepository.save(new NewDate(checkDate, startDate, endDate, between));

            return new RedirectView("/list");
        }

    @GetMapping("/{checkDate}")
    public String getDetail(@PathVariable("checkDate") String checkDate, Model model) {
        Date date = dateRepository.findByCheckDate(checkDate);
        model.addAttribute("date", date);
        return "detail";
    }
    
}