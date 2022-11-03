package kodlama.io.kodlama_io_devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama_io_devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.kodlama_io_devs.data_access.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama_io_devs.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.findAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguageRepository.findById(id).get();
    }

    @Override
    public ProgrammingLanguage create(String name) throws Exception {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(name);
        return programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.deleteById(id);
    }

    @Override
    public ProgrammingLanguage update(int id, String name) throws Exception {
        ProgrammingLanguage programmingLanguage = getById(id);
        programmingLanguage.setName(name);
        return programmingLanguageRepository.save(programmingLanguage);
    }

}
