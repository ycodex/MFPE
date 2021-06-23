package com.pensionerDetailsMicroservice.Model;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import com.opencsv.bean.CsvRecurse;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PensionerDetail {
	@CsvBindByName(column = "AadhaarNo")
	@CsvNumber("")
	private long aadharNo;
	
	@CsvBindByName(column = "Name")
	private String name;
	
	@CsvBindByName(column = "DOB")
	@CsvDate("dd-MM-yyyy")
	private Date dateOfBirth;
	
	@CsvBindByName(column = "PAN")
	private String pan;
	
	@CsvBindByName(column = "SALARY")
	private double salary;
	
	@CsvBindByName(column = "ALLOWANCE")
	private double allowance;
	
	@CsvBindByName(column = "PENSION_TYPE")
	private String pensionType;
	
	@CsvRecurse
	private Bank bank;
	
	public String getName() {
		return name;
	}

	public PensionerDetail(String name, Date dateOfBirth, String pan, double salary, double allowance,
			String pensionType, Bank bank) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.pan = pan;
		this.salary = salary;
		this.allowance = allowance;
		this.pensionType = pensionType;
		this.bank = bank;
	}

	public PensionerDetail() {
		super();
	}

	@Override
	public String toString() {
		return "PensionerDetail [name=" + name + ", dateOfBirth=" + dateOfBirth + ", pan=" + pan + ", salary=" + salary
				+ ", allowance=" + allowance + ", pensionType=" + pensionType + ", bank=" + bank + "]";
	}
	
}
