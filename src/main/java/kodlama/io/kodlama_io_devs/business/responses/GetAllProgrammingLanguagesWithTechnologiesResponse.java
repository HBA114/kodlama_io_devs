package kodlama.io.kodlama_io_devs.business.responses;

import java.util.List;

import kodlama.io.kodlama_io_devs.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguagesWithTechnologiesResponse {
    private int id;
    private String name;
    private List<Technology> technologies;
}