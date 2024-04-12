package com.example.myapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasicInfoDTO {
	
	private String employeeCode;
    @JsonProperty("employeeNameKanji")
	private EmployeeNameKanji nameKanji;
    @JsonProperty("employeeNameKatakana")
	private EmployeeNameKatakana nameKatagana;
    @JsonProperty("employeeNameEnglish")
	private EmployeeNameEnglish nameEnglish;
	private int gender;
	private String birthDate;
	private int nationallity;
	private String placeOfBirth;
	private int spousePresent;
	
    public BasicInfoDTO() {
        // 无参构造函数
    }
	
	public static class EmployeeNameKanji {
		private String firstName;
		private String lastName;
		
		public EmployeeNameKanji() {
			
		}
		
		public EmployeeNameKanji(String firstNameKanji, String lastNameKanji) {
			this.firstName = firstNameKanji;
			this.lastName = lastNameKanji;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		@Override
		public String toString() {
			return "EmployeeNameKanji [firstName=" + firstName + ", lastName=" + lastName + "]";
		}
		
		
	}
	
	public static class EmployeeNameKatakana {
		private String firstName;
		private String lastName;
		
		public EmployeeNameKatakana() {
			
		}
		public EmployeeNameKatakana(String firstNameKana, String lastNameKana) {
			this.firstName = firstNameKana;
			this.lastName = lastNameKana;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		@Override
		public String toString() {
			return "EmployeeNameKatakana [firstName=" + firstName + ", lastName=" + lastName + "]";
		}
		
	}
	
	public static class EmployeeNameEnglish {
		private String firstName;
		private String lastName;
		
		public EmployeeNameEnglish() {
			
		}
		
		public EmployeeNameEnglish(String firstNameEigo, String lastNameEigo) {
			this.firstName = firstNameEigo;
			this.lastName = lastNameEigo;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		@Override
		public String toString() {
			return "EmployeeNameEnglish [firstName=" + firstName + ", lastName=" + lastName + "]";
		}
		
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public EmployeeNameKanji getNameKanji() {
		return nameKanji;
	}

	public void setNameKanji(EmployeeNameKanji nameKanji) {
		this.nameKanji = nameKanji;
	}

	public EmployeeNameKatakana getNameKatagana() {
		return nameKatagana;
	}

	public void setNameKatagana(EmployeeNameKatakana nameKatagana) {
		this.nameKatagana = nameKatagana;
	}

	public EmployeeNameEnglish getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(EmployeeNameEnglish nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getNationallity() {
		return nationallity;
	}

	public void setNationallity(int nationallity) {
		this.nationallity = nationallity;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public int getSpousePresent() {
		return spousePresent;
	}

	public void setSpousePresent(int spousePresent) {
		this.spousePresent = spousePresent;
	}

	@Override
	public String toString() {
		return "BasicInfoDTO [employeeCode=" + employeeCode + ", nameKanji=" + nameKanji + ", nameKatagana="
				+ nameKatagana + ", nameEnglish=" + nameEnglish + ", gender=" + gender + ", birthDate=" + birthDate
				+ ", nationallity=" + nationallity + ", placeOfBirth=" + placeOfBirth + ", spousePresent="
				+ spousePresent + "]";
	}
	
	

}
