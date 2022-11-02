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
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public ProgrammingLanguage create(String name) throws Exception {
        return programmingLanguageRepository.create(name);
    }

    @Override
    public ProgrammingLanguage delete(int id) throws Exception {
        return programmingLanguageRepository.delete(id);
    }

    @Override
    public ProgrammingLanguage update(int id, String name) throws Exception {
        return programmingLanguageRepository.update(id, name);
    }

}
