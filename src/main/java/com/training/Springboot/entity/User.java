package com.training.Springboot.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity  //will create table and sequnce by itself which doesnt work in hibernate
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String firstName;
	private String lastName;
	private int age;
	private char gender;
	
	public User(String firstName,String lastName,int age,char gender) {
		this.userId=userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.gender=gender;		
	}
	}

