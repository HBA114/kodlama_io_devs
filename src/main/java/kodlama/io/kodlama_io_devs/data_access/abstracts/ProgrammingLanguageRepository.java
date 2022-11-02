package kodlama.io.kodlama_io_devs.data_access.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.kodlama_io_devs.entities.ProgrammingLanguage;

@Repository
public interface ProgrammingLanguageRepository {
    public List<ProgrammingLanguage> getAll();

    public ProgrammingLanguage getById(int id) throws Exception;

    public ProgrammingLanguage create(String name) throws Exception;

    public ProgrammingLanguage delete(int id) throws Exception;

    public ProgrammingLanguage update(int id, String name) throws Exception;
}
