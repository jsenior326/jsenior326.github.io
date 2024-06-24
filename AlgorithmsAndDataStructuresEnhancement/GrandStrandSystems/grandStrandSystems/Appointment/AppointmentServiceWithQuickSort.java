// Author: Jacob Senior
//
// This file implements services for the Appointment class but instead utilizes
// a quicksort algorithm and binary search to improve performance

package grandStrandSystems.Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentServiceWithQuickSort {
	private ArrayList<Appointment> appointmentList;
	
	public AppointmentServiceWithQuickSort() {
		appointmentList = new ArrayList<>();
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
		quickSort(0, appointmentList.size()-1);
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
	
	// Accessor for appointment list
	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}
	
	// partition function assumes high as pivot, placing pivot in correct
	// position, placing smaller items the left of pivot, and larger items
	// to the right of pivot
	private int partition(int low, int high) {
		// Get pivot appointment
		Appointment pivot = appointmentList.get(high);
		
		int i = low - 1;
		for (int j = low; j < high - 1; j++) {
			// If date before pivot, swap them and increment index
			if (appointmentList.get(j).getAppointmentDate().compareTo(pivot.getAppointmentDate()) <= 0) {
				i++;
				Appointment temp = appointmentList.get(i);
				appointmentList.set(i, appointmentList.get(j));
				appointmentList.set(j, temp);
			}
		}
		Appointment temp = appointmentList.get(i + 1);
		appointmentList.set(i + 1, appointmentList.get(high));
		appointmentList.set(high, temp);
		
		return i + 1;
	}
	
	// Quicksort algorithm
	public void quickSort(int low, int high) {
		if (low < high) {
			int pivot = partition(low, high);
			
			// Sort segments before and after list
			quickSort(low, pivot - 1);
			quickSort(pivot + 1, high);
		}
	}
	
	// Find appointment using binary search algorithm
	public Appointment findAppointment(Date date) {
		int low = 0;
		int high = appointmentList.size() - 1;
		
		while (low <= high) {
			// Get middle of list
			int pivot = low + (high - low) / 2;
			
			// If target date equals current date, return current element
			// If current date less than target date, search again in left half
			// If current date greater than target date, search again in right half
			int comparison = appointmentList.get(pivot).getAppointmentDate().compareTo(date);
			if (comparison == 0) {
				return appointmentList.get(pivot);
			} else if (comparison < 0) {
				low = pivot + 1;
			} else {
				high = pivot - 1;
			}
		}
		
		return null;
	}
	
	public void displayAppointments() {
		for (Appointment a : appointmentList) {
			System.out.println(a);
		}
	}
	
}
