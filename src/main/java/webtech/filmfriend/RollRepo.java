package webtech.filmfriend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollRepo extends CrudRepository<Roll, Long> {
}
