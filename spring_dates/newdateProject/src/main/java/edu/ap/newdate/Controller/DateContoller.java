package edu.ap.newdate.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            Date today = new Date(dtf.format(now));  

            long minutes = checkDate.getTime() / 60000;
            long minutesToday = today.getTime() / 60000;
            long daysApart = (minutes-minutesToday)/60/24;

            /** +1 when it is a future date, because then it does not count the day itself */
            if(daysApart > 0){
                daysApart++;
            }

            dateRepository.save(new NewDate(checkDate, startDate, endDate, between, daysApart));

            return new RedirectView("/list");
        }    
}