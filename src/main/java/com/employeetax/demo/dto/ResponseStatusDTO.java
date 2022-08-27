package com.employeetax.demo.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ResponseStatusDTO {

	private int statusCode;

	private String statusMessage;

	private Map<String, String> fieldResponse;

	private Long id;

	private Map<String, Map<String, String>> screenValidation;

	private List<String> values;
}
