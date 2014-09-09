package ru.telran.sel;

public class OptionsSettingData {
	public String companyName;
	public String companyAddress;
	public String countryfromList;

	public OptionsSettingData(String companyName, String companyAddress,
			String countryfromList) {
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.countryfromList = countryfromList;
	}
	
	public OptionsSettingData() {
		
	}
}