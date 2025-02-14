package com.productdemo.purchasetransactionapi.services.webclients.fiscaldata;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class FiscalDataWebClientConfig {
	private static final String BASE_URL = "https://api.fiscaldata.treasury.gov/services/api/fiscal_service/";

	@Bean
	public WebClient webClient() {
	   return WebClient.builder()
	    .baseUrl(BASE_URL)
	    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	    .build();
	}
}
