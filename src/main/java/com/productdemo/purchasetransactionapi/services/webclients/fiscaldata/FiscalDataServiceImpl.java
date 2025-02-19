package com.productdemo.purchasetransactionapi.services.webclients.fiscaldata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.requests.FiscalDataFiltersDTO;
import com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.responses.FiscalDataDTO;

@Service
public class FiscalDataServiceImpl implements FiscalDataService {
	
	@Autowired
	private FiscalDataWebClientConfig fiscalDataWebClientConfig;
	
	@Override
	public FiscalDataDTO getExchangeRates(FiscalDataFiltersDTO fiscalDataFiltersDTO) {
		FiscalDataDTO response = fiscalDataWebClientConfig.webClient()
				  .method(HttpMethod.GET)
				  .uri("v1/accounting/od/rates_of_exchange?filter=effective_date:gt:{dateFrom},currency:eq:{currency}&sort=-effective_date"
						  ,fiscalDataFiltersDTO.getDateFrom()
						  ,fiscalDataFiltersDTO.getCurrencyTo())
				  .accept(MediaType.APPLICATION_JSON)
				  .retrieve()
		            .bodyToMono(FiscalDataDTO.class)
		            .block();
		return response;
	}
}
