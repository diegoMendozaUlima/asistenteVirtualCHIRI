package com.example.demo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Nota {
	
	private String type;
	private ValueNota valueN;
	
	public Nota() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ValueNota getValueN() {
		return valueN;
	}

	public void setValueN(ValueNota valueN) {
		this.valueN = valueN;
	}

	@Override
	public String toString() {
		return "Nota [type=" + type + ", valueN=" + valueN + "]";
	}
	
	
	
	
	
	
}
