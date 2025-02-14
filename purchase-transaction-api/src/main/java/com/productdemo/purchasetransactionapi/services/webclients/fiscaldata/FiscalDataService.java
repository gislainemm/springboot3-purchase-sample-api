package com.productdemo.purchasetransactionapi.services.webclients.fiscaldata;

import com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.requests.FiscalDataFiltersDTO;
import com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.responses.FiscalDataDTO;

public interface FiscalDataService {

	public FiscalDataDTO getExchangeRates(FiscalDataFiltersDTO fiscalDataFiltersDTO);
}
