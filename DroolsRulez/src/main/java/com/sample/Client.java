package com.sample;

import java.io.File;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Client {
	
	public static final double MIN_AVERAGE_BALANCE = 0;
	public static final double MAX_AVERAGE_BALANCE = 6000;
	
	public static final double MIN_INCOME = 0;
	public static final double MAX_INCOME = 1000;
	
	public static final double MIN_LENDING = 0;
	public static final double MAX_LENDING = 30000;
	
	public static final double MIN_INVESTMENTS = 0;
	public static final double MAX_INVESTMENTS = 15000;

	public static void main(String[] args) throws JAXBException {
		 
  
		Random r = new Random();
    	Accounts accounts = new Accounts();
    	
    	JAXBContext jaxbContext = JAXBContext.newInstance(Accounts.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	
		//GENERATION FROM XML
		accounts = (Accounts) jaxbUnmarshaller.unmarshal( new File("src/main/resources/files/inputFile.xml") );

    	long startTime = System.currentTimeMillis();
    	
    	for (Account account: accounts.getAccounts()) {
    	ConditionActivator conditionInstance = new ConditionActivator();
    	conditionInstance.execute(account);
    	}
    	
    	File outputFile = new File("src/main/resources/files/outputFile.xml");
		jaxbMarshaller.marshal(accounts, outputFile);
    	
    	long endTime = System.currentTimeMillis();
    	System.out.println(endTime - startTime);
    	
    	
    	
    	//RANDOM GENERATION
    	long startTime2 = System.currentTimeMillis();
    	
    	for (int i=0; i<50000; i++){
    		Account accountRandom = new Account();
    		accountRandom.setAccountID(i+1);
    		accountRandom.setActiveConditions(Math.random() < 0.1);
    		accountRandom.setAverageBalance(MIN_AVERAGE_BALANCE + (MAX_AVERAGE_BALANCE - MIN_AVERAGE_BALANCE) * r.nextDouble());
    		accountRandom.setInvestmentBalance(MIN_INVESTMENTS + (MAX_INVESTMENTS - MIN_INVESTMENTS) * r.nextDouble());
    		accountRandom.setLendingBalance(MIN_LENDING + (MAX_LENDING - MIN_LENDING) * r.nextDouble());
    		accountRandom.setMaxIncome(MIN_INCOME + (MAX_INCOME - MIN_INCOME) * r.nextDouble());
    		ConditionActivator conditionInstance = new ConditionActivator();
    		conditionInstance.execute(accountRandom);
    	}
    		
    		
    	long endTime2 = System.currentTimeMillis();
    	System.out.println(endTime2 - startTime2);
	 }
	
		 
	}


