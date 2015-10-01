MyDealer (DPA) -- Group 11
Authors: Mariam Iskander, Mark Iskander, Ndubuisi Okonkwo, Ayobami O. Idowu, Scott Dennis
Description: This application manages prescriptions for Doctors, Patients and Pharmacists.
Release: DPA v1.0 (February 11, 2015); Iteration 1
Release: MyDealer(DPA) v2.0 (March 10, 2015); Iteration 2
--------------------------------------------------

Project location:
----------------
The repository, readme.txt and log.txt for this project can be found in: 
/home/student/umiskan2/cvs/repository/DPA

Project structure:
------------------
Application layer: comp3350.dpa.application
	- Main.java: the start of the application.
	- Services.java: initialized and sets up the stub database
Business layer: comp3350.dpa.business
	- AccessPatients.java: retrieve patient information
	- SearchPatients.java: Given a first name and/or last name, return a list of matching patients.
	- AccessDoctorPatients: retrieve DoctorPatients information
	- AccessDoctors: retrieve Doctor information
	- AccessEmail: retrieve a patients email
	- AccessPrescriptions: retrieve prescription information
	- ValidationCheck: makes checks for valid or invalid data
Objects layer: comp3350.dpa.objects
	- Patient.java: patient object
	- Doctor.java: doctor object
	- DoctorPatient.java: DoctorPateint object
	- Prescription.java: prescription object
Persistence layer: comp3350.dpa.persistence
	- DataAccess: An interface for the databases used with this project
	- DataAccessObject: An implementation of DataAccess using HSQLDB as the database.
Presentation layer: comp3350.dpa.presentation
	- CLI.java: Run the command-line version of the application
	- HomeActivity.java: Activity for the home page
	- PatientListActivity.java: Activity to display the patient list
	- PatientInfoActivity.java: Activity for displaying patient information
	- PatientLoginActivity.java: Activity for a patient to login with there email
	- DoctorLoginActivity.java: Activity for a doctor to login with there doctor ID
	- PatientInfoViewActivity.java: Activity that a patient sees after login in showing all there information
	- AddPrescriptonActivity.java: Activity to add a new prescription to a patient
	- OrderPrescriptionActivity.java: Activity for a patient to re order there prescription
Tests: comp3350.tests
	- AllTests.java: Run JUnit tests
Business Layer tests: comp3350.dpa.tests.business
	- SearchPatientsTest.java: Tests for the SearchPatients class
	- AccessDoctorTest.java: Tests for AccessDoctors
	- AccessPatientsTest.java: Tests for AccessPatients
	- BusinessTests.java: All tests for the business layer
	- SearchEmailTests.java: Tests for SearchEmail class
	- SearchPatientsTests.java: Tests for SearchPatients class
Objects layer tests: comp3350.dpa.tests.objects
	- PatientTest.java: Tests for the patient object
	- DoctorPatientsTest.java: Tests for the DoctorPatients object
	- DoctorTest.java: Tests for the doctor object
	- ObjectTest: Tests for all objects
	- PrescriptionTest: Tests for prescription object
Persistence Layer tests: comp3350.tests.persistence
	- DataAccessStub: An implementation of DataAccess using a volatile stub db for testing purposes.
	- DataAccessTests: Tests for the database
	- PersistenceTests: Tests for the database
	
Library:
--------
lib:
	-commons-lang3.3.3.2.jar
		-used to allow commons-lang jar files 
	-commons-validator-1.4.1.jar
		-used to validate an email in the PatientLoginActivity file
		
Command-Line Interface:
-----------------------
	The command line interface can access and retrieve patient information.
Usage:
	To get patient information: 		get patient [6-digit health ID]
	To get doctor information:			get doctor [6-digit doctorID]
	To get prescription information:	get prescription [patient ID] [drug name]
	To get all patients:				get all patients
	To get all doctors:					get all doctors
	To quit the application:			quit | q | bye
	
Stub Database:
---------------
To facilitate testing of the app, below are the login information for all doctors and patients:
Patient Name:		Patient Email:
Master Chief		cortana4ever@hotmail.com
Arbiter Smith		covenant4life@gmail.com
John Shepard		omgmiranda@aol.com
Super Mario			wrongcastle@gmail.com
Michael DeSanta		wtfjimmy@gmail.com
Michael DeSanta		othermike@hotmail.com
Trevor Philips		pinkteddybear@hotmail.com

Doctor ID:		Doctor Name:
351222			Max Payne
933206			Sam Fisher
785044			Mona Sax		
