package com.registerLab.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="ElmBeanReq")
@RequestScoped
public class ElementoBeanRequest {
	@ManagedProperty(value="#{param.elemento}")
	private int elemento;
	public ElementoBeanRequest() {
		
	}
	public int getElemento() {
		return elemento;
	}
	public void setElemento(int elemento) {
		this.elemento = elemento;
	}
	
}
