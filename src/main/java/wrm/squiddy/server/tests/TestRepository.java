package wrm.squiddy.server.tests;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TestRepository extends ReactiveCrudRepository<TestDescription, String>{

}
