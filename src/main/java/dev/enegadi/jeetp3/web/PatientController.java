package dev.enegadi.jeetp3.web;

import dev.enegadi.jeetp3.Entities.Patient;
import dev.enegadi.jeetp3.Reposotories.PatientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patientsPage = patientRepository.findByNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patientsList", patientsPage.getContent());
        model.addAttribute("pages", new int[patientsPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id, int page, String keyword) {
        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&" + "keyword=" + keyword;
    }

    @GetMapping("/patientsForm")
    public String patientsForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientsForm";
    }

    @PostMapping(path = "/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.patient", bindingResult);
            return "patientsForm";
        }
        System.out.println(patient);
        patientRepository.save(patient);
        return "redirect:index";
    }


    @GetMapping("/editPatient")
    public String editPatient(Model model, Long patientId) {
        Patient patient = patientRepository.findById(patientId).get();
//        if(patient == null) throw new RuntimeException("Patient not found");
        System.out.println(patient);
        model.addAttribute("patient", patient);
        return "editPatient";
    }
}
