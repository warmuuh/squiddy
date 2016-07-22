package wrm.squiddy.server.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class TestController {

	@Autowired
	TestRepository repository;
	
	@GetMapping("/tests/{testId}")
	Mono<TestDescription> getTest(@PathVariable("testId") String testId) {
		return repository.findOne(testId);
	}
	
	@PostMapping("/tests")
	Mono<TestDescription> addTest(@RequestBody TestDescription newTest) {
		return repository.save(newTest);
	}
	
	@PutMapping("/tests/{testId}")
	Mono<TestDescription> updateTest(@PathVariable("testId") String testId, @RequestBody TestDescription newTest) {
		newTest.setId(testId);
		return repository.save(newTest);
	}
	
	
//	Flux<SseEvent> sse() {
//		return Flux
//			.interval(Duration.ofSeconds(1))
//			.take(3)
//			.map(l -> {
//				SseEvent event = new SseEvent();
//				event.setId(Long.toString(l));
//				event.setData("foo\nbar");
//				event.setComment("bar\nbaz");
//				return event;
//		});
//	}
}
