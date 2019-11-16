package com.swen6301.builder.util;

/**
 * A utility class containing a set of utilities to perform input validations.
 */
public final class ValidationUtils {
	
	/**
	 * A private constructor to prevent accidental instantiations of this class.
	 */
	private ValidationUtils() {
		throw new IllegalAccessError("Cannot instantiate instance for ValidationUtils class");
	}
	
	/**
	 * Checks whether patient's info is correct. See comments associated with parameter to see required info and non-required info.
	 * 
	 * @param firstName Corresponds to the first name of the patient. This cannot be empty.
	 * @param middleName Corresponds to the middle name of the patient. This can be empty.
	 * @param lastName Corresponds to the last name of the patient. This cannot be empty.
	 * @param age Corresponds to the age of the patient. It should be between 0 and 120.
	 * @param weight Corresponds to the weight of the patient. It should be between 0 and 300kg.
	 * @param sex Corresponds to the sex of the patient. It should be either 'none', 'male', or 'female', it cannot be empty.
	 * @param height Corresponds to the height of the patient. It should be between 0 and 250cm.
	 * @param organDonor Corresponds to whether the patient is an organ donor.
	 * @param bloodType Corresponds to the blood type of the patient. It must be 'none', 'a+', 'a-', 'o+', 'o-', 'b+', 'b-', 'ab+', 'ab-'.
	 * @return true, if the patient info confirms to the requirement set forth, otherwise an {@link IllegalArgumentException} will be thrown.
	 */
	public static boolean checkPatientInfo(String firstName, String middleName, String lastName, int age, int weight, String sex, int height, boolean organDonor, String bloodType) {
		
		// Check whether the firstName is not null and not empty.
		if(firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("First name cannot be empty of null.");
		}
		
		// Check whether the middleName is no null.
		if(middleName == null) {
			throw new IllegalArgumentException("Middle name cannot be null.");
		}
		
		// Check whether the lastName is not null and not empty.
		if(lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException("Last name cannot be empty of null.");
		}
		
		// Check whether the age is between 0 and 120.
		if(age < 0 || age > 120) {
			throw new IllegalArgumentException("Age cannot be negative or larger than 120.");
		}
		
		// Check whether the weight is between 0 and 300.
		if(weight < 0 || weight > 300) {
			throw new IllegalArgumentException("Weight cannot negative or larger than 300.");
		}
		
		// Check whether the height is between 0 and 250.
		if(height < 0 || height > 250) {
			throw new IllegalArgumentException("Height cannot negative or larger than 250.");
		}
		
		// Check whether sex is not null and not empty.
		if(sex == null || sex.isEmpty()) {
			throw new IllegalArgumentException("Sex can only be either 'male', 'female', or 'none'.");
		}
		
		// Check whether the sex is equal to either 'male, 'female', or 'none'.
		if(!"male".equals(sex.toLowerCase()) && !"female".equals(sex.toLowerCase()) && !"none".equals(sex.toLowerCase())) {
			throw new IllegalArgumentException("Sex can only be either 'male', 'female', or 'none'.");
		}
		
		// Check whether bloodType is not null.
		if(bloodType == null) {
			throw new IllegalArgumentException("Blood type cannot be null.");
		}
		
		// Check whether bloodType is either A+, A-, B+, B-, O+, O-, AB+, AB-, or 'none'.
		if("a+".equals(bloodType.toLowerCase()) &&
				"a-".equals(bloodType.toLowerCase()) &&
				"b+".equals(bloodType.toLowerCase()) &&
				"b-".equals(bloodType.toLowerCase()) &&
				"ab+".equals(bloodType.toLowerCase()) && 
				"ab-".equals(bloodType.toLowerCase()) &&
				"o+".equals(bloodType.toLowerCase()) &&
				"o-".equals(bloodType.toLowerCase())) {
			throw new IllegalArgumentException("Blood type can be either A+, A-, B+, B-, O+, O-, AB+, AB-, or 'none' in case the patient does not her blood type.");
		}
		
		// patient's information is correct, therefore return "true".
		return true;
	}

}
