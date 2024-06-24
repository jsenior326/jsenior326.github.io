// Author: Jacob Senior
//
// This file implements services for the Appointment class

package grandStrandSystems.Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {

	private ArrayList<Appointment> appointmentList;
	
	// Constructor for appointment service
	public AppointmentService() {
		appointmentList = new ArrayList<Appointment>();
	}
	
	// Add appointment to appointment list
	public void addAppointment(Appointment a) {
		// Search for unique appointment id
		for (Appointment appointment : appointmentList) {
			// throw exception if id not unique
			if (appointment.getAppointmentID().equals(a.getAppointmentID())) {
				throw new IllegalArgumentException("AppointmentID must be unique");
			}
		}
		
		// Add appointment to the list
		appointmentList.add(a);
	}
	
	// Delete appointment from the appointment list
	public void deleteAppointment(String appointmentID) {
		Appointment a = null;
		
		// Search for appointment with the given id
		for (Appointment appointment : appointmentList) {
			if (appointment.getAppointmentID().equals(appointmentID)) {
				a = appointment;
			}
		}
		
		// If appointment was found, remove it from appointment list
		if (a != null) {
			appointmentList.remove(a);
		} else {
			// throw exception if no appointment was found
			throw new IllegalArgumentException("Appointment with the given appointmentID not found");
		}
	}
	
	// Update appointment by appointmentID
	public void updateAppointment(String appointmentID, Date appointmentDate, String description) {
		Appointment a = null;
		
		// Search for an appointment with a matching ID
		for (Appointment apt : appointmentList) {
			// Update appointment with new fields
			if (apt.getAppointmentID().equals(appointmentID)) {
				a = apt;
			}
		}
		
		// If no appointments matched the given ID, throw exception
		if (a != null) {
			a.setAppointmentDate(appointmentDate);
			a.setDescription(description);
		} else {
			throw new IllegalArgumentException("Appointment with the given appointmentID not found");
		}
	}
	
	// Returns first appointment occurring on the given date
	public Appointment findAppointment(Date date) {
		Appointment a = null;
		
		// Find appointment with matching appointmentID
		for (Appointment apt : appointmentList) {
			if(apt.getAppointmentDate().equals(date)) {
				a = apt;
				break;
			}
		}
		
		// If no appointment with the given appointmentID was found, throw exception
		if (a != null) {
			return a;
		} else {
			throw new IllegalArgumentException("Appointment with the given appointmentID not found");
		}
	}
	
	// Accessor for appointment list
	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}
}
