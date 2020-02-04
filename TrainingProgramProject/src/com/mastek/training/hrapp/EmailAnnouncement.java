package com.mastek.training.hrapp;

public class EmailAnnouncement extends Announcement {

	@Override
	public void sendAnnouncement() {
		System.out.println("sending emails TO: " + getForGroup()+ " by "+ getFrom()
			+ "with title: "+ getSubject() + "and text: " +getContentText());

	}

}
