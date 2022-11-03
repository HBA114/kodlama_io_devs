package kodlama.io.kodlama_io_devs.web_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama_io_devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlama_io_devs.entities.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    //! You can use swagger ui for sending requests
    // http://localhost:8080/swagger-ui/index.html

    @GetMapping("/getall")
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public ProgrammingLanguage getById(@PathVariable("id") int id) throws Exception {
        return programmingLanguageService.getById(id);
    }

    @PostMapping("/create")
    public ProgrammingLanguage create(String name) throws Exception {
        return programmingLanguageService.create(name);
    }

    @PutMapping("/update/{id}")
    public ProgrammingLanguage update(@PathVariable("id") int id, String name) throws Exception {
        return programmingLanguageService.update(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) throws Exception {
        programmingLanguageService.delete(id);
    }
}
