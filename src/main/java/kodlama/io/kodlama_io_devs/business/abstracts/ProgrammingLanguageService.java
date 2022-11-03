package kodlama.io.kodlama_io_devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama_io_devs.entities.ProgrammingLanguage;

public interface ProgrammingLanguageService {
    List<ProgrammingLanguage> getAll();

    ProgrammingLanguage getById(int id) throws Exception;

    ProgrammingLanguage create(String name) throws Exception;

    void delete(int id) throws Exception;

    ProgrammingLanguage update(int id, String name) throws Exception;
}
