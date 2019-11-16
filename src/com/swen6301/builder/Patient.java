package com.swen6301.builder;

import com.swen6301.builder.util.PersistenceUtils;

public class Patient {
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private int weight;
	private int height;
	private boolean organDonor;
	private String sex;
	private String bloodType;
	
	
	//private constructor to enforce using the patientBuilder to create patients
	 private Patient(PatientBuilder builder){
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.weight = builder.weight;
        this.height = builder.height;
        this.organDonor = builder.organDonor;
        this.sex = builder.sex;
        this.bloodType = builder.bloodType;
    }
	 
	/**
	 * 
	 * @return String
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getLastName()
	{
		return this.lastName;
	}
		
	
	public static class PatientBuilder implements MedicalBuilder{
		private String firstName;
		private String middleName;
		private String lastName;
		private int age;
		private int weight;
		private int height;
		private boolean organDonor;
		private String sex;
		private String bloodType;

		public PatientBuilder() {};
		
		/**
		 * 
		 * @param String firstName
		 * @return PatientBuilder
		 */
		public PatientBuilder setFirstName (String firstName)
		{
			this.firstName = firstName;
			return this;
		}
		
		/**
		 * 
		 * @param String middleName
		 * @return PatientBuilder
		 */
		public PatientBuilder setMiddleName (String middleName)
		{
			this.middleName = middleName;
			return this;
		}
		
		/**
		 * 
		 * @param String lastName
		 * @return PatientBuilder
		 */
		public PatientBuilder setLastName (String lastName)
		{
			this.lastName = lastName;
			return this;
		}
		
		/**
		 * 
		 * @param int age
		 * @return PatientBuilder
		 */
		public PatientBuilder setAge (int age)
		{
			this.age = age;
			return this;
		}
		
		/**
		 * 
		 * @param int weight
		 * @return PatientBuilder
		 */
		public PatientBuilder setWeight (int weight)
		{
			this.weight = weight;
			return this;
		}
		
		/**
		 * 
		 * @param int height
		 * @return PatientBuilder
		 */
		public PatientBuilder setHeight (int height)
		{
			this.height = height;
			return this;
		}
		
		/**
		 * 
		 * @param String sex
		 * @return PatientBuilder
		 */
		public PatientBuilder setSex (String sex)
		{
			this.sex = sex;
			return this;
		}
		
		/**
		 * 
		 * @param String bloodType
		 * @return PatientBuilder
		 */
		public PatientBuilder setBloodType (String bloodType)
		{
			this.bloodType = bloodType;
			return this;
		}
		
		/**
		 * 
		 * @param boolean organDonor
		 * @return PatientBuilder
		 */
		public PatientBuilder setOrganDonor (boolean organDonor)
		{
			this.organDonor = organDonor;
			return this;
		}
		
		public Patient buildPatient() {
			Patient patient = new Patient(this);
			boolean success = PersistenceUtils.storePatientInfo(patient.firstName, patient.middleName, patient.lastName, patient.age, patient.weight, patient.sex, patient.height, patient.organDonor, patient.bloodType);
			
			if(success) {
				return patient;
			} else { // Error Occure
				return null;	
			}
		}
	}
}