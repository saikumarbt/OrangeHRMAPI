package com.orangehrm.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

import groovyjarjarantlr.collections.List;

public class TestUtils {

	public static String firstName;
	public static String lastName;
	public static String code;
	public static String dob;
	public static String maritalStatus;
	public static String gender;
	public static String nationality;
	public static String companyName;
	public static String companyDesc;

	static Faker faker = new Faker();
	private static int companyId;

	/**
	 * @return the firstName
	 */
	public static String getFirstName() {
		firstName = faker.name().firstName();
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public static String getLastName() {
		lastName = faker.name().lastName();
		return lastName;
	}

	/**
	 * @return the code
	 */
	public static String getCode() {
		code = String.valueOf(faker.number().numberBetween(200, 999));
		return code;
	}

	/**
	 * 
	 * @return the dob
	 */
	public static String getDob() {

		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(1965, 1995);
		gc.set(Calendar.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		dob = gc.get(Calendar.MONTH) + "/" + (gc.get(Calendar.DAY_OF_MONTH) + 1) + "/" + gc.get(Calendar.YEAR);
		return dob;
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	
	
	/**
	 * @return the MaritalStatus
	 */
	public static String getMaritalStatus() {
		maritalStatus = faker.demographic().maritalStatus();
		return maritalStatus;
	}
	
	/**
	 * @return the Gender
	 * 
	 */
	public static String getGender() {
		gender = faker.demographic().sex();
		return gender;
	}
	
	/**
	 * 
	 * @return the nationality
	 */
	public static String getNationality() {
		
		String[] belongsTo={
		                     "Afghan",
		                     "Albanian",
		                     "Algerian",
		                     "American",
		                     "Andorran",
		                     "Angolan",
		                     "Antiguans",
		                     "Argentinean",
		                     "Armenian",
		                     "Australian",
		                     "Austrian",
		                     "Azerbaijani",
		                     "Bahamian",
		                     "Bahraini",
		                     "Bangladeshi",
		                     "Barbadian",
		                     "Barbudans",
		                     "Batswana",
		                     "Belarusian",
		                     "Belgian",
		                     "Belizean",
		                     "Beninese",
		                     "Bhutanese",
		                     "Bolivian",
		                     "Bosnian",
		                     "Brazilian",
		                     "British",
		                     "Bruneian",
		                     "Bulgarian",
		                     "Burkinabe",
		                     "Burmese",
		                     "Burundian",
		                     "Cambodian",
		                     "Cameroonian",
		                     "Canadian",
		                     "Cape Verdean",
		                     "Central African",
		                     "Chadian",
		                     "Chilean",
		                     "Chinese",
		                     "Colombian",
		                     "Comoran",
		                     "Congolese",
		                     "Costa Rican",
		                     "Croatian",
		                     "Cuban",
		                     "Cypriot",
		                     "Czech",
		                     "Danish",
		                     "Djibouti",
		                     "Dominican",
		                     "Dutch",
		                     "East Timorese",
		                     "Ecuadorean",
		                     "Egyptian",
		                     "Emirian",
		                     "Equatorial Guinean",
		                     "Eritrean",
		                     "Estonian",
		                     "Ethiopian",
		                     "Fijian",
		                     "Filipino",
		                     "Finnish",
		                     "French",
		                     "Gabonese",
		                     "Gambian",
		                     "Georgian",
		                     "German",
		                     "Ghanaian",
		                     "Greek",
		                     "Grenadian",
		                     "Guatemalan",
		                     "Guinea-Bissauan",
		                     "Guinean",
		                     "Guyanese",
		                     "Haitian",
		                     "Herzegovinian",
		                     "Honduran",
		                     "Hungarian",
		                     "I-Kiribati",
		                     "Icelander",
		                     "Indian",
		                     "Indonesian",
		                     "Iranian",
		                     "Iraqi",
		                     "Irish",
		                     "Israeli",
		                     "Italian",
		                     "Ivorian",
		                     "Jamaican",
		                     "Japanese",
		                     "Jordanian",
		                     "Kazakhstani",
		                     "Kenyan",
		                     "Kittian and Nevisian",
		                     "Kuwaiti",
		                     "Kyrgyz",
		                     "Laotian",
		                     "Latvian",
		                     "Lebanese",
		                     "Liberian",
		                     "Libyan",
		                     "Liechtensteiner",
		                     "Lithuanian",
		                     "Luxembourger",
		                     "Macedonian",
		                     "Malagasy",
		                     "Malawian",
		                     "Malaysian",
		                     "Maldivan",
		                     "Malian",
		                     "Maltese",
		                     "Marshallese",
		                     "Mauritanian",
		                     "Mauritian",
		                     "Mexican",
		                     "Micronesian",
		                     "Moldovan",
		                     "Monacan",
		                     "Mongolian",
		                     "Moroccan",
		                     "Mosotho",
		                     "Motswana",
		                     "Mozambican",
		                     "Namibian",
		                     "Nauruan",
		                     "Nepalese",
		                     "New Zealander",
		                     "Nicaraguan",
		                     "Nigerian",
		                     "Nigerien",
		                     "North Korean",
		                     "Northern Irish",
		                     "Norwegian",
		                     "Omani",
		                     "Pakistani",
		                     "Palauan",
		                     "Panamanian",
		                     "Papua New Guinean",
		                     "Paraguayan",
		                     "Peruvian",
		                     "Polish",
		                     "Portuguese",
		                     "Qatari",
		                     "Romanian",
		                     "Russian",
		                     "Rwandan",
		                     "Saint Lucian",
		                     "Salvadoran",
		                     "Samoan",
		                     "San Marinese",
		                     "Sao Tomean",
		                     "Saudi",
		                     "Scottish",
		                     "Senegalese",
		                     "Serbian",
		                     "Seychellois",
		                     "Sierra Leonean",
		                     "Singaporean",
		                     "Slovakian",
		                     "Slovenian",
		                     "Solomon Islander",
		                     "Somali",
		                     "South African",
		                     "South Korean",
		                     "Spanish",
		                     "Sri Lankan",
		                     "Sudanese",
		                     "Surinamer",
		                     "Swazi",
		                     "Swedish",
		                     "Swiss",
		                     "Syrian",
		                     "Taiwanese",
		                     "Tajik",
		                     "Tanzanian",
		                     "Thai",
		                     "Togolese",
		                     "Tongan",
		                     "Trinidadian or Tobagonian",
		                     "Tunisian",
		                     "Turkish",
		                     "Tuvaluan",
		                     "Ugandan",
		                     "Ukrainian",
		                     "Uruguayan",
		                     "Uzbekistani",
		                     "Venezuelan",
		                     "Vietnamese",
		                     "Welsh",
		                     "Yemenite",
		                     "Zambian",
		                     "Zimbabwean"
		                   };
        Random random =new Random();
        int randomNumber=random.nextInt(belongsTo.length);
        nationality = belongsTo[randomNumber];
        return nationality;
		
	}
	
	

	/**
	 * @return the companyName
	 */
	public static String getCompanyName() {
		companyName = faker.company().name();
		return companyName;
	}

	
	/**
	 * @return the companyDesc
	 */
	public static String getCompanyDesc() {
		companyDesc = faker.company().catchPhrase();
		return companyDesc;
	}
	
	/**
	 * @return the customerId
	 */
	public static int getCustomerId() {
		companyId = faker.number().numberBetween(1, 100);
		return companyId;
	}

	

	public static String generateRandomString() {
		int length = 3;
		boolean useLetters = false;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}
}
