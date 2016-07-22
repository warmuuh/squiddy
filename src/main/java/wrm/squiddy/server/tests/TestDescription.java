package wrm.squiddy.server.tests;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class TestDescription {
	@Id
	String id;
	String name;
	int frequencyInSeconds;
	TestScript test;
}
