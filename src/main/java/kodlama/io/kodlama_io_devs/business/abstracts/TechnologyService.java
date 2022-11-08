package kodlama.io.kodlama_io_devs.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama_io_devs.business.requests.CreateTechnologyRequest;
import kodlama.io.kodlama_io_devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.kodlama_io_devs.entities.Technology;

@Service
public interface TechnologyService {
    List<Technology> getAll();

    Technology create(CreateTechnologyRequest createTechnologyRequest);

    void delete(int id) throws Exception;
    Technology update(int id, UpdateTechnologyRequest updateTechnologyRequest);
}
