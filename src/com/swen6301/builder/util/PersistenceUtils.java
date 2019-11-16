package com.swen6301.builder.util;

/**
 * Contains utilities to communicate with internal storage.
 */
public final class PersistenceUtils {

	/**
	 * A private constructor to prevent accidental instantiations of this class.
	 */
	private PersistenceUtils() {
		throw new IllegalAccessError("Cannot instantiate instance for PersistenceUtils class");
	}
	
	/**
	 * Stores patient's info in internal storage See comments associated with parameter to see required info and non-required info.
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
	public static boolean storePatientInfo(String firstName, String middleName, String lastName, int age, int weight, String sex, int height, boolean organDonor, String bloodType) {
		try {
			ValidationUtils.checkPatientInfo(firstName, middleName, lastName, age, weight, sex, height, organDonor, bloodType);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
		// hidden implementation details for persisting patient info to internal storage.
		return true;
	}
	
}
