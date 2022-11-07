package kodlama.io.kodlama_io_devs.web_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama_io_devs.business.abstracts.TechnologyService;
import kodlama.io.kodlama_io_devs.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama_io_devs.entities.Technology;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
    private TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    // http://localhost:8080/swagger-ui/index.html

    @PostMapping("/create")
    public Technology create(CreateTechnologyRequest createTechnologyRequest) {
        return technologyService.create(createTechnologyRequest);
    }

    @GetMapping("/getall")
    public List<Technology> getAll(){
        return technologyService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) throws Exception{
        technologyService.delete(id);
    }
}
