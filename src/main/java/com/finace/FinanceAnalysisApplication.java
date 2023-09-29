package com.finace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnablePrometheusEndpoint
//@EnableSpringBootMetricsCollector
//@EnableScheduling
public class FinanceAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceAnalysisApplication.class, args);
	}

}
