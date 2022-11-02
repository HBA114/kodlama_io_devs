package kodlama.io.kodlama_io_devs.data_access.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.kodlama_io_devs.data_access.abstracts.ProgrammingLanguageRepository;
import kodlama.io.kodlama_io_devs.entities.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<ProgrammingLanguage>();
        programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
        programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
        programmingLanguages.add(new ProgrammingLanguage(3, "Dart"));
        programmingLanguages.add(new ProgrammingLanguage(4, "C"));
        programmingLanguages.add(new ProgrammingLanguage(5, "C++"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id)
                return programmingLanguage;
        }
        throw new Exception("Requested Programming Language Does Not Exists");
    }

    @Override
    public ProgrammingLanguage create(String name) throws Exception {
        boolean isValid = checkNameValid(name);

        if (!isValid)
            throw new Exception("Programming Language Exists");

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(generateId(), name);
        programmingLanguages.add(programmingLanguage);

        return programmingLanguage;
    }

    @Override
    public ProgrammingLanguage delete(int id) throws Exception {
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id) {
                programmingLanguages.remove(programmingLanguage);
                return programmingLanguage;
            }
        }

        throw new Exception("Requested Programming Language Does not Exists");
    }

    @Override
    public ProgrammingLanguage update(int id, String name) throws Exception {
        boolean isNameValid = checkNameValid(name);
        boolean isContainsId = checkIdExists(id);

        if (!isNameValid)
            throw new Exception("Programming Language Already Exists!");

        if (!isContainsId)
            throw new Exception("Programming Language Does Not Exists!");

        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id) {
                programmingLanguage.setName(name);
                return programmingLanguage;
            }
        }

        throw new Exception("Programming Language Could Not Update!");
    }

    private boolean checkNameValid(String name) {
        if (name.equals(""))
            return false;
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getName().toLowerCase().equals(name.toLowerCase()))
                return false;
        }
        return true;
    }

    private boolean checkIdExists(int id) {
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id)
                return true;
        }
        return false;
    }

    private int generateId() {
        for (int i = 1; i < programmingLanguages.size() + 2; i++) {
            boolean isContains = checkIdExists(i);
            if (!isContains)
                return i;
        }
        return 0;
    }
}
