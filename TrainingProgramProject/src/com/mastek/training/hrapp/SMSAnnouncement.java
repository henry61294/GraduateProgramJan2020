package com.mastek.training.hrapp;

public class SMSAnnouncement extends Announcement {

	
	// each derived class of the base abstract class must override ALL asbtract methods 
	//from the base/parent class. 
	@Override
	public void sendAnnouncement() {
		System.out.println("sending sms: " + getForGroup()+ " by "+ getFrom()
				+ "with title: "+ getSubject() + "and text: " +getContentText());

	}

}
