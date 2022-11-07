package kodlama.io.kodlama_io_devs.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.kodlama_io_devs.entities.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
