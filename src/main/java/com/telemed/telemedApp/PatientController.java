package com.telemed.telemedApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientController {
    private List<Patient> patients = new ArrayList<>();

    public PatientController() {
        patients.add(new Patient(1, "Ivo", "Ivić", "1990-01-01", "Muško", "Adresa 1", 10000, "Zagreb", 123456789, "ivo.ivic@example.com", "ivoivic", "lozinka123"));
        patients.add(new Patient(2, "Ana", "Anić", "1995-05-05", "Žensko", "Adresa 2", 21000, "Split", 987654321, "ana.anic@example.com", "anaanic", "lozinka321"));
    }



    @GetMapping("/listaPacijenata")
    public String getAllPatients(Model model) {
        model.addAttribute("patients", patients);
        return "listaPacijenata.html";
    }

    @GetMapping("/addPatientForm")
    public String showAddPatientForm() {
        return "new_patient.html";
    }


    @GetMapping("/addNewPatient")
    public String addNewPatient(
            @RequestParam("mb") int mb,
            @RequestParam("ime") String ime,
            @RequestParam("prezime") String prezime,
            @RequestParam("datumRodjenja") String datumRodjenja,
            @RequestParam("spol") String spol,
            @RequestParam("adresa") String adresa,
            @RequestParam("pb") int pb,
            @RequestParam("grad") String grad,
            @RequestParam("kontakt") int kontakt,
            @RequestParam("email") String email,
            @RequestParam("korisnickoIme") String korisnickoIme,
            @RequestParam("lozinka") String lozinka) {
        patients.add(new Patient(mb, ime, prezime, datumRodjenja, spol, adresa, pb, grad, kontakt, email, korisnickoIme, lozinka));
        return "redirect:/listaPacijenata";
    }
}
