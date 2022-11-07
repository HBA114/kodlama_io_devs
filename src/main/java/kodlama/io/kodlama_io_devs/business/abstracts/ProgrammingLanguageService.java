package kodlama.io.kodlama_io_devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama_io_devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.kodlama_io_devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.kodlama_io_devs.business.responses.GetAllProgrammingLanguagesWithTechnologiesResponse;
import kodlama.io.kodlama_io_devs.entities.ProgrammingLanguage;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguagesResponse> getAll();

    List<GetAllProgrammingLanguagesWithTechnologiesResponse> getAllWithTechnologies();

    ProgrammingLanguage getById(int id);

    ProgrammingLanguage create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);

    void delete(int id) throws Exception;

    ProgrammingLanguage update(int id, String name) throws Exception;
}
