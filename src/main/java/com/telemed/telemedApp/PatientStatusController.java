package com.telemed.telemedApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientStatusController {
    List<PatientStatus> patientStatus= new ArrayList<>();

    public PatientStatusController() {
        patientStatus.add(new PatientStatus(new Date(), 120, 80, 80, "Dobro se osjecam"));
        patientStatus.add(new PatientStatus(new Date(), 150, 100, 94, "Lose se osjecam"));
        patientStatus.add(new PatientStatus(new Date(), 150, 100, 94, "Lose se osjecam"));
        patientStatus.add(new PatientStatus(new Date(), 150, 100, 94, "Lose se osjecam"));
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
    @GetMapping("/")
    public String loginIndex() {
        return "redirect:/login";
    }

    @GetMapping("/patientStatus")
    public String showStatus(Model model) {
        model.addAttribute("patientStatus", patientStatus);
        return "records.html";
    }

    @GetMapping("/addNewStatus")
    public String addNewStatus(@RequestParam("systolic") int systolic, @RequestParam("diastolic") int diastolic, @RequestParam("pulse") int pulse, @RequestParam("comment") String comment){
        PatientStatus newPatientStatus = new PatientStatus(new Date(), systolic, diastolic, pulse, comment);
        patientStatus.add(newPatientStatus);

        return "redirect:/patientStatus";
    }


    /*
    @GetMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("title") String title) {
        for (Todo t:todoList) {
            if(t.getTitle().equals(title)) {
                todoList.remove(t);
                break;
            }
        }
        return "redirect:/records";
    }
*/
}
