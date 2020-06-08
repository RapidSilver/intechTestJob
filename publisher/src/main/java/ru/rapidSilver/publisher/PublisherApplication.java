package ru.rapidSilver.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.rapidSilver.publisher.domain.Action;
import ru.rapidSilver.publisher.domain.Publisher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PublisherApplication {
	static Logger logger = LoggerFactory.getLogger(Publisher.class);

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			executor.submit(() -> {
				logger.info("происходит отправка POST запроса");
				RestTemplate restTemplate = new RestTemplate();
				var response = restTemplate.exchange("http://localhost:8091/save",
						HttpMethod.POST,
						new HttpEntity<>(new Publisher()),
						Publisher.class);
				logger.info("Статус ответа" + response.getStatusCode());
				try {
					TimeUnit.SECONDS.sleep(15);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				executor.shutdown();
			});
		}
	}

}
