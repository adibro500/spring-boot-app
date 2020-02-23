package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="sayhello")
public class SayHello {
    @Id
    @Column
	private String text;
    @Column
	private String kio;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public SayHello(String str, String kio) {
		this.text = str;
		this.kio = kio;
	}
	
	public SayHello() {
		
	}

	public String getKio() {
		return kio;
	}

	public void setKio(String kio) {
		this.kio = kio;
	}

}
