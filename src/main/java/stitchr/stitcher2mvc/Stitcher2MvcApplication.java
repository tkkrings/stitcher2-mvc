package stitchr.stitcher2mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import stitchr.stitcher2mvc.storage.StorageProperties;
import stitchr.stitcher2mvc.storage.StorageService;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)

public class Stitcher2MvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(Stitcher2MvcApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
