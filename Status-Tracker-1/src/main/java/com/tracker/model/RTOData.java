package com.tracker.model;
import java.time.LocalDate;

public class RTOData {
	
 
	private LocalDate date;
    private String dayStatus;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDayStatus() {
		return dayStatus;
	}
	public void setDayStatus(String dayStatus) {
		this.dayStatus = dayStatus;
	}
	
 
}