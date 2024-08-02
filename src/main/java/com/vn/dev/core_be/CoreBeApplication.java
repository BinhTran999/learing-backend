package com.vn.dev.core_be;

import com.vn.dev.core_be.repository.DDNhanVienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = DDNhanVienRepository.class)
public class CoreBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreBeApplication.class, args);
	}

}
