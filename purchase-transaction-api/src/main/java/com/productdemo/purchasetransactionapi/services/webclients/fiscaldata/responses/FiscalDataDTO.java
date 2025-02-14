package com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.responses;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiscalDataDTO {
	
	@JsonProperty("data")
	private List<FiscalDataItemDTO> data = new ArrayList<FiscalDataItemDTO>();

	public FiscalDataDTO(List<FiscalDataItemDTO> data) {
		super();
		this.data = data;
	}

	public FiscalDataDTO() {
		super();
	}

	public List<FiscalDataItemDTO> getData() {
		return data;
	}

	public void setData(List<FiscalDataItemDTO> data) {
		this.data = data;
	}
	
	

}
