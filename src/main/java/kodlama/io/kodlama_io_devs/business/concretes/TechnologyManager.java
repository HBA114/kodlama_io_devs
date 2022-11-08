package kodlama.io.kodlama_io_devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama_io_devs.business.abstracts.TechnologyService;
import kodlama.io.kodlama_io_devs.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama_io_devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.kodlama_io_devs.data_access.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama_io_devs.data_access.abstracts.TechnologyRepository;
import kodlama.io.kodlama_io_devs.entities.ProgrammingLanguage;
import kodlama.io.kodlama_io_devs.entities.Technology;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyRepository technologyRepository;
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public TechnologyManager(TechnologyRepository technologyRepository,
            ProgrammingLanguageRepository programmingLanguageRepository) {
        this.technologyRepository = technologyRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public Technology create(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = new Technology();
        technology.setName(createTechnologyRequest.getName());
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository
                .findById(createTechnologyRequest.getProgrammingLanguageId()).get();
        technology.setProgrammingLanguage(programmingLanguage);
        Technology savedTechnology = technologyRepository.save(technology);
        return savedTechnology;
    }

    @Override
    public List<Technology> getAll() {
        return technologyRepository.findAll();
    }

    @Override
    public void delete(int id) throws Exception {
        Technology technologyToDelete = technologyRepository.findById(id).get();
        technologyToDelete.setProgrammingLanguage(null);
        technologyRepository.delete(technologyToDelete);
    }

    @Override
    public Technology update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technologyToUpdate = technologyRepository.findById(id).get();
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository
                .findById(updateTechnologyRequest.getProgrammingLanguageId()).get();

        technologyToUpdate.setName(updateTechnologyRequest.getName());
        technologyToUpdate.setProgrammingLanguage(programmingLanguage);

        return technologyRepository.save(technologyToUpdate);
    }

}
