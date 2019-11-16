package com.swen6301.builder;

import com.swen6301.builder.util.RandomUtils;

/**
 * A dummy driver class that simulates a driver class for this project.
 */
public class Driver {
	
	public static void main(String[] args) {
		
		// Create 1000 random samples.
		for(int i = 0; i < 1000; i++) {
			System.out.println("****************");
			createRandomPatientInfo();
			System.out.println("****************");
		}
	}
	
	/**
	 * Creates a sample patient info and store them on internal storage.
	 */
	public static void createRandomPatientInfo() {
		
		Patient patient = new Patient.PatientBuilder()
			.setFirstName(RandomUtils.randomIdentifier())
			.setMiddleName(RandomUtils.randomIdentifier())
			.setLastName(RandomUtils.randomIdentifier())
			.setAge(RandomUtils.randomNumber(150))
			.setWeight(RandomUtils.randomNumber(400))
			.setHeight(RandomUtils.randomNumber(300))
			.setOrganDonor(RandomUtils.randomBoolean())
			.setSex(RandomUtils.randomSexString())
			.setBloodType(RandomUtils.randomBloodType())
			.buildPatient();
		
		if(patient == null) {
			System.out.println("An error occurred while processing info for patient!");
		} else {
			System.out.println("Patient [" + patient.getFirstName() + patient.getLastName() + "] has been successfully processed!");
		}
	}
}
