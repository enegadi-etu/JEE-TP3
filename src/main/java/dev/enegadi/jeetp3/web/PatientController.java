package dev.enegadi.jeetp3.web;

import dev.enegadi.jeetp3.Entities.Patient;
import dev.enegadi.jeetp3.Reposotories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model){
        List<Patient> patientsList = patientRepository.findAll();
        model.addAttribute("patientsList", patientsList);
        return "patients";
    }
}
