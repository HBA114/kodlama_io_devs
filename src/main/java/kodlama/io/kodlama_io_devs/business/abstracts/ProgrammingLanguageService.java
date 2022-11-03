package kodlama.io.kodlama_io_devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama_io_devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.kodlama_io_devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlama_io_devs.entities.ProgrammingLanguage;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguagesResponse> getAll();

    ProgrammingLanguage getById(int id);

    ProgrammingLanguage create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

    void delete(int id) throws Exception;

    ProgrammingLanguage update(int id, String name) throws Exception;
}
