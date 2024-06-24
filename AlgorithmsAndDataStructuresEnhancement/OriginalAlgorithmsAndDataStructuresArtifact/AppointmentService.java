// Author: Jacob Senior

package grandStrandSystems;

import java.util.ArrayList;

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
	
	// Accessor for appointment list
	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}
}
