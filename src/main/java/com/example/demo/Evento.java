package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Evento {
   	
   public String type;
   private ValueEvento valueE;
   
   public Evento() {
	   
   
   }

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public ValueEvento getValueE() {
	return valueE;
}

public void setValueE(ValueEvento valueE) {
	this.valueE = valueE;
}
   
   
   
}
