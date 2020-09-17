package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
@Repository
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void actuatorEndpointContainsGitInformation() {
		this.webTestClient
				.get()
				.uri("/actuator/info")
				.exchange()
				.expectBody()
				.jsonPath("$.git.branch").isNotEmpty()
				.jsonPath("$.git.commit.id").isNotEmpty()
				.jsonPath("$.git.commit.time").isNotEmpty();
	}

}