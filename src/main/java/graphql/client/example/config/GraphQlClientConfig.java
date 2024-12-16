package graphql.client.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQlClientConfig {

	@Bean
	public HttpGraphQlClient getGraphQlClient() {
		WebClient webClient = WebClient.builder()
				.baseUrl("http://localhost:8081/graphql")
				.build();
		return HttpGraphQlClient.builder(webClient).build();
	}
}
