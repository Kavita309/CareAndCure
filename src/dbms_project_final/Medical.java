package dbms_project_final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

public class Medical {

	public static void main(String[] args) throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_centre_1?autoReconnect=true&useSSL=false", "root",
					"isnam123");
			Statement stmt = con.createStatement();
			Scanner scn = new Scanner(System.in);
			System.out.println("\t\t\tWELCOME TO THE");
			System.out.println("\n\t\tCARE AND CURE MEDICAL CENTRE");
			System.out.println("                           ...Because we care for you :)");
			System.out.println("\n HELLO SIR/MA'AM!");
			int ch = -1;
			do {
				System.out.println();
				System.out.println("\nKindly choose an option to work and proceed:");
				System.out.println("1. Admin");
				System.out.println("2. User");
				System.out.println("\n0. Exit");
				ch = scn.nextInt();

				switch (ch) {
				case 1:
					AdminView(stmt, con, scn);
					break;
				case 2:
					UserView(stmt, con, scn);
					break;
				case 0:
					// Clear Statement
					System.out.println("Thank you :)\n For Visiting");
					break;
				default:
					System.out.println("Oops!!! \n Not a valid Choice");
					break;
				}
				// add a clear Statement here

			} while (ch != 0);
			scn.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void AdminView(Statement stmt, Connection con, Scanner scn) throws IOException, SQLException {

		// Add a clear statement here
		int ch = -1;
		do {
			System.out.println("\n\nWELCOME ADMIN!\n\n");
			System.out.println(" What task would you like to carry out?");
			System.out.println("1. View information");
			System.out.println("2. Insert new information");
			System.out.println("3. Update existing information");
			System.out.println("4. Delete some existing information");
			System.out.println("\n0. Exit Admin Page");
			ch = scn.nextInt();

			switch (ch) {
			case 1:
				SelectViewAdmin(stmt, con, scn);
				break;
			case 2:
				InsertViewAdmin(stmt, con, scn);
				break;
			case 3:
				UpdateViewAdmin(stmt, con, scn);
				break;
			case 4:
				DeleteViewAdmin(stmt, con, scn);
				break;
			case 0:
				break;
			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// add a clear Statement here
		} while (ch != 0);
	}

	public static void UserView(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// Add a clear statement here
		int ch = -1;
		do {
			System.out.println("\n\nWELCOME USER!\n\n");
			System.out.println("CHOOSE AN OPTION TO WORK AND PROCEED:");
			System.out.println("1. Doctor");
			System.out.println("2. Nurse");
			System.out.println("3. Receptionist");
			System.out.println("0. Exit");
			ch = scn.nextInt();

			switch (ch) {
			case 1:
				DoctorView(stmt, con, scn);
				break;
			case 2:
				NurseView(stmt, con, scn);
				break;
			case 3:
				ReceptionistView(stmt, con, scn);
				break;
			case 0:
				break;
			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// add a clear Statement here
		} while (ch != 0);
	}

	public static void SelectViewAdmin(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		int ch = -1;
		do {
			System.out.println("\n\nWhat information would you like to view?\n");
			System.out.println("Details related to:");
			System.out.println("1. Patients");
			System.out.println("2. Doctors");
			System.out.println("3. Nurses");
			System.out.println("4. Receptionists");
			System.out.println("5. Rooms");
			System.out.println("6. Records");
			System.out.println("0. Exit");

			ch = scn.nextInt();
			switch (ch) {
			case 1:
				displayAllPatientsDetails(stmt, con, scn);
				break;
			case 2:
				dislayAllDoctorsDetails(stmt, con, scn);
				break;
			case 3:
				displayAllNurseDetails(stmt, con, scn);
				break;
			case 4:
				displayAllReceptionistDetails(stmt, con, scn);
				break;
			case 5:
				displayAllRoomDetails(stmt, con, scn);
				break;
			case 6:
				displayAllRecords(stmt, con, scn);
				break;
			case 0:
				break;
			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// add a clear Statement here
		} while (ch != 0);

	}

	public static void InsertViewAdmin(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		int ch = -1;
		do {
			System.out.println("Select your task:");
			System.out.println("1. Insert new Employee");
			System.out.println("2. Insert new medicine");
			System.out.println("3. Insert new Equipment");
			System.out.println("0. Exit");

			ch = scn.nextInt();
			switch (ch) {
			case 1:
				// Add a clear statement here
				int c = -1;
				do {
					System.out.println("\nCHOOSE AN OPTION:\n");
					System.out.println("1. Doctor");
					System.out.println("2. Nurse");
					System.out.println("3. Receptionist");
					System.out.println("0. Return");
					c = scn.nextInt();

					switch (c) {
					case 1:
						insertDoctor(stmt, con, scn);
						break;
					case 2:
						insertNurse(stmt, con, scn);
						break;
					case 3:
						insertReceptionist(stmt, con, scn);
						break;
					case 0:
						break;
					default:
						System.out.println("Oops!!! \n Not a valid Choice");
						break;
					}
					// add a clear Statement here
				} while (c != 0);
				break;
			case 2:
				insertMedicine(stmt, con, scn);
				break;
			// case 3:
			// insertEquipment(stmt, con, scn);
			// break;
			case 0:
				break;
			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// add a clear Statement here
		} while (ch != 0);

	}

	public static void UpdateViewAdmin(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		int ch = -1;
		do {
			System.out.println("\nSelect your task:\n");
			System.out.println("1. Update information of Employee");
			System.out.println("2. Update information of medicine");
			System.out.println("3. Update room details");
			System.out.println("0. Exit");

			ch = scn.nextInt();
			switch (ch) {
			case 1:
				// Add a clear statement here
				int c = -1;
				do {
					System.out.println("\nCHOOSE AN OPTION:\n");
					System.out.println("1. Doctor");
					System.out.println("2. Nurse");
					System.out.println("3. Receptionist");
					System.out.println("0. Return");
					c = scn.nextInt();

					switch (c) {
					case 1:
						UpdateDoctor(stmt, con, scn);
						break;
					case 2:
						UpdateNurse(stmt, con, scn);
						break;
					case 3:
						UpdateReceptionist(stmt, con, scn);
						break;
					case 0:
						break;
					default:
						System.out.println("Oops!!! \n Not a valid Choice");
						break;
					}
					// add a clear Statement here
				} while (c != 0);
				break;
			case 2:
				UpdateMedicine(stmt, con, scn);
				break;
			case 3:
				UpdateRoom(stmt, con, scn);
				break;
			case 0:
				break;
			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// add a clear Statement here
		} while (ch != 0);

	}

	public static void DeleteViewAdmin(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		int ch = -1;
		do {
			System.out.println("\nSelect your task:\n");
			System.out.println("1. Delete Record of Doctor");
			System.out.println("2. Delete Record of Nurse");
			System.out.println("3. Delete Record of Receptionist");
			System.out.println("0. Exit");

			ch = scn.nextInt();
			switch (ch) {
			case 1:
				deleteDoctor(stmt, con, scn);
				break;
			case 2:
				deleteNurse(stmt, con, scn);
				break;
			case 3:
				deleteReceptionist(stmt, con, scn);
				break;
			case 0:
				break;
			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// add a clear Statement here
		} while (ch != 0);

	}

	public static void DoctorView(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		int ch = -1;
		do {
			System.out.println("\nSelect your task:\n");
			System.out.println("1. See all patient details");
			System.out.println("2. See all nurse details");
			System.out.println("3. See all records");
			System.out.println("0. Exit");

			ch = scn.nextInt();

			switch (ch) {
			case 1:
				displayAllPatientsDetails(stmt, con, scn);
				break;
			case 2:
				displayAllNurseDetails(stmt, con, scn);
				break;
			case 3:
				displayAllRecords(stmt, con, scn);
				break;
			case 0:
				break;
			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// Clear statement
		} while (ch != 0);

	}

	public static void NurseView(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		int ch = -1;
		do {
			System.out.println("\nSelect your task:\n");
			System.out.println("1. See all medicine details");
			System.out.println("2. See all equipment details");
			System.out.println("0. Exit");

			ch = scn.nextInt();

			switch (ch) {
			case 1:
				displayAllmedicine(stmt, con, scn);
				break;
			case 2:
				displayAllEquipments(stmt, con, scn);
				break;
			case 0:
				break;

			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// Clear statement
		} while (ch != 0);

	}

	public static void ReceptionistView(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		int ch = -1;
		do {
			System.out.println("\nSelect your task:\n");
			System.out.println("1. View information");
			System.out.println("2. Patient related");
			System.out.println("3. Record Related");
			System.out.println("0. Exit");

			ch = scn.nextInt();
			switch (ch) {
			case 1:
				// Add a clear statement here
				int c1 = -1;
				do {
					System.out.println("\nCHOOSE AN OPTION:\n");
					System.out.println("1. Doctors");
					System.out.println("2. Nurses");
					System.out.println("3. Records");
					System.out.println("4. Patients");
					System.out.println("0. Return");
					c1 = scn.nextInt();

					switch (c1) {
					case 1:
						dislayAllDoctorsDetails(stmt, con, scn);
						break;
					case 2:
						displayAllEquipments(stmt, con, scn);
						break;
					case 3:
						displayAllRecords(stmt, con, scn);
						break;
					case 4:
						displayAllPatientsDetails(stmt, con, scn);
						break;
					case 0:
						break;
					default:
						System.out.println("Oops!!! \n Not a valid Choice");
						break;
					}
					// add a clear Statement here
				} while (c1 != 0);
				break;
			case 2:
				// Add a clear statement here
				int c2 = -1;
				do {
					System.out.println("\nCHOOSE AN OPTION:\n");
					System.out.println("1. Add");
					System.out.println("2. Update");
					System.out.println("3. Delete");
					System.out.println("0. Return");
					c2 = scn.nextInt();

					switch (c2) {
					case 1:
						insertPatient(stmt, con, scn);
						break;
					case 2:
						UpdatePatient(stmt, con, scn);
						break;
					case 3:
						deletePatient(stmt, con, scn);
						break;
					case 0:
						break;
					default:
						System.out.println("Oops!!! \n Not a valid Choice");
						break;
					}
					// add a clear Statement here
				} while (c2 != 0);
				break;
			case 3:
				// Add a clear statement here
				int c3 = -1;
				do {
					System.out.println("\nCHOOSE AN OPTION:\n");
					System.out.println("1. Add");
					System.out.println("2. Update");
					System.out.println("3. Delete");
					System.out.println("0. Return");
					c3 = scn.nextInt();

					switch (c3) {
					case 1:
						insertRecord(stmt, con, scn);
						break;
					case 2:
						UpdateRecord(stmt, con, scn);
						break;
					case 3:
						deleteRecord(stmt, con, scn);
						break;
					case 0:
						break;
					default:
						System.out.println("Oops!!! \n Not a valid Choice");
						break;
					}
					// add a clear Statement here
				} while (c3 != 0);
				break;
			case 4:
				break;

			default:
				System.out.println("Oops!!! \n Not a valid Choice");
				break;
			}
			// Clear statement
		} while (ch != 0);

	}

	// Completed
	public static void displayAllPatientsDetails(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		// Execute query Select* from Patient table and Print it in format
		ResultSet rs1 = stmt.executeQuery("select p_id , p_name from patient");
		System.out.println("\tID\tNAME\n");
		while (rs1.next()) {
			System.out.println("\t" + rs1.getInt(1) + "\t" + rs1.getString(2));
		}
		int ch = -1;
		do {
			System.out.println("\nEnter a patient's ID to view complete details :");
			int pid = scn.nextInt();
			specificPatientDetail(stmt, con, scn, pid);
			System.out.println("\nDo you wish to view details of any other patient ?(Enter 1 for yes and 0 for no):");
			ch = scn.nextInt();
		} while (ch != 0);

	}

	// Completed
	public static void specificPatientDetail(Statement stmt, Connection con, Scanner scn, int pid) throws SQLException {
		ResultSet rs2 = stmt.executeQuery("select * from patient,room,doctor,medicine where p_id= " + pid
				+ " and p_r_id=r_id and p_d_id=d_id and p_m_code=m_code;");
		if (!rs2.next()) {
			System.out.println("No Data Found !!!!");
			return;
		}
		System.out.println("\n*******************************************");
		System.out.println("Patient id : " + rs2.getInt(1));
		System.out.println("Name : " + rs2.getString(2));
		System.out.println("ADDRESS : ");
		System.out.println("House No. : " + rs2.getString(3));
		System.out.println("Street : " + rs2.getString(4));
		System.out.println("City : " + rs2.getString(5));
		System.out.println("Gender : " + rs2.getString(6));
		System.out.println("Age : " + rs2.getInt(7));
		System.out.println("Admitted Date : " + rs2.getDate(8));
		if (rs2.getDate(9) != null) {
			System.out.println("Discharged Date : " + rs2.getDate(9));
		} else
			System.out.println("Discharged Date : " + " still admitted");

		System.out.println("Room No. : " + rs2.getInt(10));
		System.out.println("Room Type : " + rs2.getString(14));
		int did = rs2.getInt(16);
		if (rs2.getDate(9) != null) {
			double total_price = 0;
			Date ad = rs2.getDate(8);
			Date dd = rs2.getDate(9);
			long days = daysBetween(ad, dd);
			total_price += rs2.getDouble(15) * days;
			total_price += rs2.getDouble(24);

			ResultSet rs6 = stmt.executeQuery("select equip_price from equipment where p_id=" + pid);
			while (rs6.next()) {
				total_price += rs6.getDouble(1);
			}
			System.out.println("Total amount paid : " + total_price);
		}
		ResultSet rs3 = stmt.executeQuery("select e_name from employee where e_id = " + did);
		rs3.next();
		System.out.println("Doctor assigned : " + rs3.getString(1));
		System.out.print("Patient's Contact No/No.s : ");
		ResultSet rs4 = stmt.executeQuery("select p_contact_no from patient_contact_no where p_id=" + pid);
		while (rs4.next()) {
			System.out.print(rs4.getString(1) + "     ");
		}
		System.out.println();
		System.out.println("******************************************\n");
	}

	// Completed
	public static void dislayAllDoctorsDetails(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery("select * from doctor_name");
		System.out.println("\tID\tName\n");
		while (rs1.next()) {
			System.out.println("\t" + rs1.getInt(1) + "\t" + rs1.getString(2));
		}
		int ch = -1;
		do {
			System.out.println("\nEnter a doctor's ID to view complete details :");
			int did = scn.nextInt();
			specificdoctordetail(stmt, con, scn, did);
			System.out.println("\nDo you wish to view details of any other doctor ?(Enter 1 for yes and 0 for no):");
			ch = scn.nextInt();
		} while (ch != 0);
	}

	// completed
	public static void specificdoctordetail(Statement stmt, Connection con, Scanner scn, int did) throws SQLException {
		ResultSet rs2 = stmt
				.executeQuery(" select * from doctor natural join employee where e_id=d_id and d_id = " + did);
		if (!rs2.next()) {
			System.out.println("No Data Found !!!!");
			return;
		}
		System.out.println("\n*******************************************");
		System.out.println("Id : " + rs2.getInt(1));
		System.out.println("Name : " + rs2.getString(8));
		System.out.println("Gender : " + rs2.getString(9));
		System.out.println("Doctor is : " + rs2.getString(2));
		System.out.println("Speciality : " + rs2.getString(5));
		System.out.println("Degree : " + rs2.getString(6));
		System.out.println("Days of Visit : " + rs2.getString(3));
		System.out.println("Time : " + rs2.getTime(4));
		System.out.println("Salary : " + rs2.getDouble(11));
		System.out.println("Experience : " + rs2.getString(12));

		System.out.print("Doctor's Contact No/No.s : ");
		ResultSet rs4 = stmt.executeQuery("select e_contact from emp_contact_no where e_id=" + did);
		while (rs4.next()) {
			System.out.print(rs4.getString(1) + "   ");
		}
		System.out.println();
		System.out.println("******************************************\n");
	}

	// Completed
	public static void displayAllNurseDetails(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery(" select * from nurse_name");
		System.out.println("\tID\tName\n");
		while (rs1.next()) {
			System.out.println("\t" + rs1.getInt(1) + "\t" + rs1.getString(2));
		}
		int ch = -1;
		do {
			System.out.println("\nEnter a nurse's ID to view complete details :");
			int nid = scn.nextInt();
			SpecificNurseDetail(stmt, con, scn, nid);
			System.out.println("\nDo you wish to view details of any other nurse ?(Enter 1 for yes and 0 for no):");
			ch = scn.nextInt();
		} while (ch != 0);
	}

	// Completed
	public static void SpecificNurseDetail(Statement stmt, Connection con, Scanner scn, int nid) throws SQLException {
		ResultSet rs2 = stmt
				.executeQuery("select * from nurse natural join employee where n_id = e_id and n_id =" + nid);
		if (!rs2.next()) {
			System.out.println("No Data Found !!!!");
			return;
		}
		System.out.println("\n*******************************************");
		System.out.println("Id : " + rs2.getInt(1));
		System.out.println("Name : " + rs2.getString(4));
		System.out.println("Work Shift : " + rs2.getString(2));
		System.out.println("Gender : " + rs2.getString(5));
		System.out.println("Salary : " + rs2.getDouble(7));
		System.out.println("Experience : " + rs2.getString(8));

		ResultSet rs3 = stmt.executeQuery("select r_id from governs where n_id = " + nid);
		System.out.print("Incharge of Room Nos. :");
		while (rs3.next())
			System.out.print(rs3.getInt(1) + " , ");
		System.out.println("END");
		System.out.print("Nurse's Contact No/No.s :");
		ResultSet rs4 = stmt.executeQuery("select e_contact from emp_contact_no where e_id=" + nid);
		while (rs4.next()) {
			System.out.print(rs4.getString(1) + "   ");
		}
		System.out.println();
		System.out.println("******************************************\n");
	}

	// Completed
	public static void displayAllReceptionistDetails(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery("select * from recep_name");
		System.out.println("\tID\tName\n");
		while (rs1.next()) {
			System.out.println("\t" + rs1.getInt(1) + "\t" + rs1.getString(2));
		}
		int ch1 = -1;
		do {
			System.out.println("\nEnter a receptionist's ID to view complete details :");
			int id = scn.nextInt();
			specificReceptDetails(stmt, con, scn, id);
			System.out.println(
					"\nDo you wish to view details of any other receptionist ?(Enter 1 for yes and 0 for no):");
			ch1 = scn.nextInt();
		} while (ch1 != 0);

	}

	// Completed
	public static void specificReceptDetails(Statement stmt, Connection con, Scanner scn, int rid) throws SQLException {
		ResultSet rs2 = stmt.executeQuery(
				"select * from receptionist natural join employee where e_id=recep_id and recep_id=" + rid);
		if (!rs2.next()) {
			System.out.println("No data found");
			return;
		}
		System.out.println("\n******************************************************");
		System.out.println("ID : " + rs2.getInt(1));
		System.out.println("Name : " + rs2.getString(4));
		System.out.println("Gender : " + rs2.getString(5));
		System.out.println("Salary : " + rs2.getDouble(7));
		System.out.println("Experience : " + rs2.getString(8));

		System.out.print("Contact No/No.s : ");
		ResultSet rs4 = stmt.executeQuery("select e_contact from emp_contact_no where e_id=" + rid);
		while (rs4.next()) {
			System.out.print(rs4.getString(1) + "   ");
		}
		System.out.println();

		ResultSet rs3 = stmt.executeQuery(" select * from record where recep_id=" + rid);
		System.out.println("Handle records of :  ");
		while (rs3.next()) {
			System.out.println(rs3.getString(2) + " of month " + rs3.getString(3) + " of year " + rs3.getInt(4));
		}
		System.out.println("********************************************************\n");
	}

	// Completed
	public static void displayAllRoomDetails(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery("Select r_id from room");
		System.out.println("\tRoom Number\n");
		while (rs1.next())
			System.out.println("\t" + rs1.getInt(1));
		int ch = -1;
		do {
			System.out.println("\nEnter a room number to view complete details :");
			int rid = scn.nextInt();
			specificRoomDetail(stmt, con, scn, rid);
			System.out.println("\nDo you wish to view details of any other room ?(Enter 1 for yes and 0 for no):");
			ch = scn.nextInt();
		} while (ch != 0);

	}

	// Completed
	public static void specificRoomDetail(Statement stmt, Connection con, Scanner scn, int rid) throws SQLException {

		System.out.println("******************************************");
		ResultSet rs2 = stmt.executeQuery("select * from room where r_id = " + rid);
		if (!rs2.next()) {
			System.out.println("No Data Found !!!!");
			return;
		}
		System.out.println("Room No. : " + rs2.getInt(1));
		System.out.println("Room Type: " + rs2.getString(2));
		System.out.println("Room charge for one day : " + rs2.getDouble(3));
		System.out.print("Nurse Id and name of Room Incharge :\n ");
		ResultSet rs3 = stmt.executeQuery(
				"select n_id , e_name from governs natural join employee where n_id = e_id and r_id=" + rid);
		if (!rs3.next()) {
			System.out.println("NIL");
		} else {
			System.out.print(rs3.getInt(1) + "\t");
			System.out.println(rs3.getString(2));
			while (rs3.next()) {
				System.out.print(rs3.getInt(1) + "\t");
				System.out.println(rs3.getString(2));
			}
		}
		ResultSet rs4 = stmt.executeQuery("select p_id , p_name from patient where p_r_id=" + rid);
		if (!rs4.next()) {
			System.out.println("ROOM IS EMPTY");
		} else {
			System.out.println("ID and Name of admitted patient : ");
			System.out.println(rs4.getInt(1) + "\t" + rs4.getString(2));
			while (rs4.next()) {
				System.out.println(rs4.getInt(1) + "\t" + rs4.getString(2));
			}
		}
		System.out.println("******************************************");
	}

	// Check it
	public static void displayAllRecords(Statement stmt, Connection con, Scanner scn) throws SQLException {

		ResultSet rs = stmt.executeQuery("select rec_id from record");
		System.out.println("\tRecord ID\n");
		while (rs.next()) {
			System.out.println("\t" + rs.getInt(1));
		}
		int ch = -1;
		do {
			System.out.println("\nEnter a record's ID to view complete details :");
			int rid = scn.nextInt();
			specificRecord(stmt, con, scn, rid);
			System.out.println("\nDo you wish to view details of any other record ?(Enter 1 for yes and 0 for no):");
			ch = scn.nextInt();
		} while (ch != 0);

	}

	public static void specificRecord(Statement stmt, Connection con, Scanner scn, int rec_id) throws SQLException {
		ResultSet rs = stmt
				.executeQuery("select * from record natural join employee where recep_id=e_id and rec_id=" + rec_id);
		if (!rs.next()) {
			System.out.println("Record not found");
			return;
		}
		System.out.println("\n*************************************************");
		System.out.println("Details of the record are as follows");
		System.out.println("Record Id : " + rs.getInt(1));
		System.out.println("Record of : " + rs.getString(2));
		System.out.println("Record Month : " + rs.getString(3));
		System.out.println("Record Year : " + rs.getInt(4));
		System.out.println("Handled By : " + rs.getString(7));
		System.out.println("**************************************************\n");
	}

	// Completed
	public static void displayAllmedicine(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		System.out.println("****************************************************");
		System.out.println("Medicine code    ||    Medicine name          Price");
		System.out.println("----------------------------------------------------");
		ResultSet rs = stmt.executeQuery("select * from medicine");
		while (rs.next()) {
			System.out.print(rs.getInt(1) + "              ||     ");
			String str = rs.getString(2);
			int l = str.length();
			System.out.print(str);
			int i = 0;
			while (i < 23 - l) {
				System.out.print(" ");
				i++;
			}
			System.out.print(rs.getDouble(3));
			System.out.println();
		}
		System.out.println("****************************************************");
	}

	// Completed
	public static void displayAllEquipments(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		System.out.println("****************************************************");
		System.out.println("Patient Id       ||    Equipment name          Price");
		System.out.println("----------------------------------------------------");
		ResultSet rs = stmt.executeQuery("select * from equipment");
		while (rs.next()) {
			System.out.print(rs.getInt(3) + "              ||     ");
			String str = rs.getString(1);
			int l = str.length();
			System.out.print(str);
			int i = 0;
			while (i < 23 - l) {
				System.out.print(" ");
				i++;
			}
			System.out.print(rs.getDouble(2));
			System.out.println();
		}

	}

	public static void insertDoctor(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		String temp = null;
		System.out.println("\nEnter details of the Doctor\n");
		System.out.println("Enter id:");
		int id = scn.nextInt();
		System.out.println("Enter the name of doctor: ");
		temp = scn.nextLine();
		String name = scn.nextLine();
		System.out.println("Enter Gender: ");
		String Gender = scn.nextLine();
		System.out.println("Enter Date-Of-Birth:");
		System.out.println("Enter year:");
		int y = scn.nextInt();
		System.out.println("Enter month(1-12): ");
		int m = scn.nextInt();
		System.out.println("Enter day(1-30): ");
		int da = scn.nextInt();
		@SuppressWarnings("deprecation")
		java.sql.Date d = new java.sql.Date(y, m, da);
		System.out.println("Enter type (visiting, permanent or trainee):");
		temp = scn.nextLine();
		String type = scn.nextLine();
		System.out.println("Enter availabilty days (MON-SUN):");
		String day = scn.nextLine();
		System.out.println("Enter visiting time :");
		System.out.println("Enter hour:");
		int h = scn.nextInt();
		System.out.println("Enter minutes:");
		int mt = scn.nextInt();
		@SuppressWarnings("deprecation")
		Time time = new Time(h, mt, 0);
		System.out.println("Enter the speciality of Doctor: ");
		temp = scn.nextLine();
		String spec = scn.nextLine();
		System.out.println("Enter qualification:");
		String degree = scn.nextLine();
		System.out.println("Enter salary: ");
		double sal = scn.nextDouble();
		System.out.println("Enter experience: ");
		temp = scn.nextLine();
		String exp = scn.nextLine();

		System.out.println("Enter how many contact numbers do you want to add:");
		int n = scn.nextInt();
		long[] cn = new long[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter contact no:");
			cn[i] = scn.nextLong();
		}
		PreparedStatement ps2 = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		ps2.setInt(1, id);
		ps2.setString(2, name);
		ps2.setString(3, Gender);
		ps2.setDate(4, d);
		ps2.setDouble(5, sal);
		ps2.setString(6, exp);
		ps2.executeUpdate();
		for (int i = 0; i < n; i++) {
			PreparedStatement ps1 = con.prepareStatement("insert into emp_contact_no values(?,?)");
			ps1.setInt(1, id);
			ps1.setLong(2, cn[i]);
			ps1.executeUpdate();
		}
		PreparedStatement ps = con.prepareStatement("insert into doctor values(?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, type);
		ps.setString(3, day);
		ps.setTime(4, time);
		ps.setString(5, spec);
		ps.setString(6, degree);
		ps.executeUpdate();
		System.out.println("\nDoctor added to the database.");
	}

	// Completed
	public static void insertNurse(Statement stmt, Connection con, Scanner scn) throws SQLException {

		String temp = null;
		System.out.println("\nEnter details of the Nurse\n");
		System.out.println("Enter id:");
		int id = scn.nextInt();
		System.out.println("Enter the name of the nurse: ");
		temp = scn.nextLine();
		String name = scn.nextLine();
		System.out.println("Enter Gender: ");
		String Gender = scn.nextLine();
		System.out.println("Enter Date-Of-Birth:");
		System.out.println("Enter year:");
		int y = scn.nextInt();
		System.out.println("Enter month(1-12): ");
		int m = scn.nextInt();
		System.out.println("Enter day(1-30):");
		int da = scn.nextInt();
		@SuppressWarnings("deprecation")
		java.sql.Date d = new java.sql.Date(y, m, da);
		System.out.println("Enter salary: ");
		double sal = scn.nextDouble();
		System.out.println("Enter Experience: ");
		temp = scn.nextLine();
		String exp = scn.nextLine();
		System.out.println("Enter Work shift(morning,evening,night): ");
		String w_s = scn.nextLine();

		System.out.println("Enter how many contact numbers do you want to add:");
		int n = scn.nextInt();
		long[] cn = new long[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter contact no:");
			cn[i] = scn.nextLong();
		}

		PreparedStatement ps2 = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		ps2.setInt(1, id);
		ps2.setString(2, name);
		ps2.setString(3, Gender);
		ps2.setDate(4, d);
		ps2.setDouble(5, sal);
		ps2.setString(6, exp);
		ps2.executeUpdate();
		for (int i = 0; i < n; i++) {
			PreparedStatement ps1 = con.prepareStatement("insert into emp_contact_no values(?,?)");
			ps1.setInt(1, id);
			ps1.setLong(2, cn[i]);
			ps1.executeUpdate();
		}
		PreparedStatement ps = con.prepareStatement("insert into nurse values(?,?)");
		ps.setInt(1, id);
		ps.setString(2, w_s);
		ps.executeUpdate();
		System.out.println("\nNurse added to the database.");
	}

	// Completed
	public static void insertReceptionist(Statement stmt, Connection con, Scanner scn) throws SQLException {

		System.out.println("\nEnter details of the Receptionist\n");
		String temp = null;
		System.out.println("Enter id:");
		int id = scn.nextInt();
		System.out.println("Enter the name of the receptionist: ");
		temp = scn.nextLine();
		String name = scn.nextLine();
		System.out.println("Enter Gender: ");
		String Gender = scn.nextLine();
		System.out.println("Enter Date-Of-Birth:");
		System.out.println("Enter year:");
		int y = scn.nextInt();
		System.out.println("Enter month(1-12): ");
		int m = scn.nextInt();
		System.out.println("Enter day(1-30)");
		int da = scn.nextInt();
		@SuppressWarnings("deprecation")
		java.sql.Date d = new java.sql.Date(y, m, da);
		System.out.println("Enter salary: ");
		double sal = scn.nextDouble();
		System.out.println("Enter Experience: ");
		temp = scn.nextLine();
		String exp = scn.nextLine();
		System.out.println("Enter Work shift(morning,evening,night): ");
		String w_s = scn.nextLine();

		System.out.println("Enter how many contact numbers do you want to add:");
		int n = scn.nextInt();
		long[] cn = new long[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter contact no:");
			cn[i] = scn.nextLong();
		}
		PreparedStatement ps2 = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		ps2.setInt(1, id);
		ps2.setString(2, name);
		ps2.setString(3, Gender);
		ps2.setDate(4, d);
		ps2.setDouble(5, sal);
		ps2.setString(6, exp);
		ps2.executeUpdate();
		for (int i = 0; i < n; i++) {
			PreparedStatement ps1 = con.prepareStatement("insert into emp_contact_no values(?,?)");
			ps1.setInt(1, id);
			ps1.setLong(2, cn[i]);
			ps1.executeUpdate();
		}
		PreparedStatement ps = con.prepareStatement("insert into receptionist values(?,?)");
		ps.setInt(1, id);
		ps.setString(2, w_s);
		ps.executeUpdate();
		System.out.println("Receptionist added to the database.");

	}

	// Completed
	public static void insertPatient(Statement stmt, Connection con, Scanner scn) throws SQLException {

		System.out.println("\nEnter details of the Patient\n");
		String temp = null;
		System.out.println("Enter patient id:");
		int id = scn.nextInt();
		System.out.println("Enter patient's name:");
		temp = scn.nextLine();
		String name = scn.nextLine();
		System.out.println("Enter address:");
		System.out.println("Enter house number:");
		String house_no = scn.nextLine();
		System.out.println("Enter street name:");
		temp = scn.nextLine();
		String street_name = scn.nextLine();
		System.out.println("Enter city:");
		String city = scn.nextLine();
		System.out.println("Enter gender:");
		String gender = scn.nextLine();
		System.out.println("Enter age:");
		int age = scn.nextInt();
		System.out.println("Enter Date of Admission of patient:");
		System.out.println("Enter year:");
		int y = scn.nextInt();
		System.out.println("Enter month(1-12): ");
		int m = scn.nextInt();
		System.out.println("Enter day(1-30)");
		int da = scn.nextInt();
		@SuppressWarnings("deprecation")
		java.sql.Date d = new java.sql.Date(y, m, da);
		// String date_admit = scn.nextLine();
		ResultSet rs1 = stmt
				.executeQuery("select d_id, e_name , speciality from employee natural join doctor where e_id=d_id");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2) + "\t\t" + rs1.getString(2));
		}
		System.out.println("Enter doctor id for this patient:");
		int did = scn.nextInt();

		ResultSet rs2 = stmt.executeQuery("Select r_id from room");
		while (rs2.next())
			System.out.println(rs1.getInt(1));
		System.out.println("Enter room id for this patient:");
		int rid = scn.nextInt();
		displayAllmedicine(stmt, con, scn);
		System.out.println("Enter medicine code for this patient:");
		int mid = scn.nextInt();
		System.out.println("Enter how many contact numbers do you want to add:");
		int n = scn.nextInt();
		long[] cn = new long[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter contact no:");
			cn[i] = scn.nextLong();
		}

		PreparedStatement ps2 = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
		ps2.setInt(1, id);
		ps2.setString(2, name);
		ps2.setString(3, house_no);
		ps2.setString(4, street_name);
		ps2.setString(5, city);
		ps2.setString(6, gender);
		ps2.setInt(7, age);
		ps2.setDate(8, d);
		ps2.setDate(9, null);
		ps2.setInt(10, did);
		ps2.setInt(11, rid);
		ps2.setInt(12, mid);

		ps2.executeUpdate();
		for (int i = 0; i < n; i++) {
			PreparedStatement ps1 = con.prepareStatement("insert into patient_contact_no values(?,?)");
			ps1.setInt(1, id);
			ps1.setLong(2, cn[i]);
			ps1.executeUpdate();
		}

		System.out.println("Patient admitted.");
	}

	// Completed
	public static void insertRecord(Statement stmt, Connection con, Scanner scn) throws SQLException {
		String temp = null;
		System.out.println("Enter record-id:");
		int id = scn.nextInt();
		System.out.println("Enter record name:");
		temp = scn.nextLine();
		String name = scn.nextLine();
		System.out.println("Enter month of record:");
		String mnth = scn.nextLine();
		System.out.println("Enter year of record:");
		int yr = scn.nextInt();
		ResultSet rs1 = stmt
				.executeQuery(" select recep_id , e_name from employee natural join receptionist where recep_id=e_id");
		while (rs1.next()) {
			System.out.println(" " + rs1.getInt(1) + "   " + rs1.getString(2));
		}
		System.out.println("Enter receptionist id of the receptionist maintaining this record:");
		int recpid = scn.nextInt();

		PreparedStatement ps2 = con.prepareStatement("insert into record values(?,?,?,?,?)");
		ps2.setInt(1, id);
		ps2.setString(2, name);
		ps2.setString(3, mnth);
		ps2.setInt(4, yr);
		ps2.setInt(5, recpid);

		ps2.executeUpdate();
		System.out.println("Record added to the database.");
	}

	// Completed
	public static void insertEquipment(Statement stmt, Connection con, Scanner scn, int pid) throws SQLException {
		// add a clear Statement here

		System.out.println("Enter equipment's name:");
		String name = scn.next();
		System.out.println("Enter price :");
		double price = scn.nextDouble();
		PreparedStatement ps = con.prepareStatement("insert into equipment values(?,?,?)");
		ps.setString(1, name);
		ps.setDouble(2, price);
		ps.setInt(3, pid);
		ps.executeUpdate();
		System.out.println("Equipment added to the database.");
	}

	// Completed
	public static void insertMedicine(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		System.out.println("Enter medicine code:");
		int mcode = scn.nextInt();
		System.out.println("Enter medicine's name:");
		String name = scn.next();
		System.out.println("Enter price:");
		double price = scn.nextDouble();
		PreparedStatement ps = con.prepareStatement("insert into medicine values(?,?,?)");
		ps.setInt(1, mcode);
		ps.setString(2, name);
		ps.setDouble(3, price);
		ps.executeUpdate();
		System.out.println("Medicine added to the database.");
	}

	public static void UpdateDoctor(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery("Select * from doctor_name");
		System.out.println("\tID\tName\n");
		while (rs1.next()) {
			System.out.println("\t" + rs1.getInt(1) + "\t" + rs1.getString(2));
		}
		System.out.println("Enter id of doctor whose details you want to modify: ");
		int did = scn.nextInt();
		System.out.println("Old Details:->->->->->...");
		specificdoctordetail(stmt, con, scn, did);
		int ch = -1;
		int i = 0;
		PreparedStatement ps = null;
		String temp;
		do {
			System.out.println("\nChoose the field you wish to update:\n");
			{
				System.out.println("1.  Name");
				System.out.println("2.  Speciality");
				System.out.println("3.  Type");
				System.out.println("4.  Qualification");
				System.out.println("5.  Visiting days");
				System.out.println("6.  Time");
				System.out.println("7.  Salary");
				System.out.println("8.  Experience");
				System.out.println("9.  Contact Nos.");
				System.out.println("0.  Return");
				ch = scn.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the correct name : ");
					temp = scn.nextLine();
					String name = scn.nextLine();
					ps = con.prepareStatement("update employee set e_name=? where e_id=?");
					ps.setString(1, name);
					ps.setInt(2, did);
					i = ps.executeUpdate();
					System.out.println(i + " record updated");
					break;
				case 2:
					System.out.println("Enter speciality;");
					temp = scn.nextLine();
					String spec = scn.nextLine();
					ps = con.prepareStatement("update doctor set speciality=? where d_id=?");
					ps.setString(1, spec);
					ps.setInt(2, did);
					i = ps.executeUpdate();
					System.out.println(i + " record updated");
					break;
				case 3:
					System.out.println("Enter Type(visting , permanent or trainee):");
					temp = scn.nextLine();
					String type = scn.nextLine();
					ps = con.prepareStatement("update doctor set d_type=? where d_id=?");
					ps.setString(1, type);
					ps.setInt(2, did);
					i = ps.executeUpdate();
					System.out.println(i + " record updated");
					break;
				case 4:
					System.out.println("Enter Degree");
					temp = scn.nextLine();
					String degree = scn.nextLine();
					ps = con.prepareStatement("update doctor set degree =? where d_id=?");
					ps.setString(1, degree);
					ps.setInt(2, did);
					i = ps.executeUpdate();
					System.out.println(i + " record updated");
					break;
				case 5:
					System.out.println("Enter visiting days");
					temp = scn.nextLine();
					String days = scn.nextLine();
					ps = con.prepareStatement("update doctor set d_day=? where d_id=?");
					ps.setString(1, days);
					ps.setInt(2, did);
					i = ps.executeUpdate();
					System.out.println(i + " record updated");
					break;
				case 6:
					System.out.println("Enter time");
					System.out.println("Enter hour");
					int h = scn.nextInt();
					System.out.println("Enter minutes");
					int m = scn.nextInt();
					@SuppressWarnings("deprecation")
					Time t = new Time(h, m, 0);
					ps = con.prepareStatement("update doctor set d_time=? where d_id=?");
					ps.setTime(1, t);
					ps.setInt(2, did);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 7:
					System.out.println("Enter salary;");
					double sal = scn.nextDouble();
					ps = con.prepareStatement("update employee set e_salary=? where e_id=?");
					ps.setDouble(1, sal);
					ps.setInt(2, did);
					i = ps.executeUpdate();
					System.out.println(i + " record updated");
					break;

				case 8:
					System.out.println("Enter experience;");
					temp = scn.nextLine();
					String exp = scn.nextLine();
					ps = con.prepareStatement("update employee set e_experience=? where e_id=?");
					ps.setString(1, exp);
					ps.setInt(2, did);
					i = ps.executeUpdate();
					System.out.println(i + " record updated");
					break;
				case 9:
					UpdateEmpContactNo(stmt, con, scn, did);
					break;
				case 0:
					break;
				default:
					System.out.println("Wrong choice!");
					break;
				}
			}
		} while (ch != 0);
	}

	// Completed
	public static void UpdateEmpContactNo(Statement stmt, Connection con, Scanner scn, int eid) throws SQLException {
		ResultSet rs = stmt.executeQuery("select e_contact from emp_contact_no where e_id=" + eid);
		System.out.println("\nRecent Contact Nos. are : ");
		while (rs.next()) {
			System.out.println(rs.getLong(1));
		}
		int ch = -1;
		System.out.println("Do you want to :");
		do {
			System.out.println("1. Insert new contact No.");
			System.out.println("2. Delete existing contact No.");
			System.out.println("0. Return");
			ch = scn.nextInt();
			System.out.println("Enter contact No:");
			long no = scn.nextLong();
			if (ch == 1) {
				PreparedStatement ps = con.prepareStatement("insert into emp_contact_no values(?,?)");
				ps.setInt(1, eid);
				ps.setLong(2, no);
				ps.executeUpdate();
			} else if (ch == 2) {
				stmt.executeUpdate("delete from emp_contact_no where e_contact=" + no);
			} else if (ch != 0) {
				System.out.println("Wrong Choice!");
			}
		} while (ch != 0);
		System.out.println("Contact No. Updated");
	}

	// Completed
	public static void UpdatepatientContactNo(Statement stmt, Connection con, Scanner scn, int pid)
			throws SQLException {
		ResultSet rs = stmt.executeQuery("select p_contact_no from patient_contact_no where p_id=" + pid);
		System.out.println("Recent Contact Nos. are : ");
		while (rs.next()) {
			System.out.println(rs.getLong(1));
		}
		int ch = -1;
		System.out.println("Do you want to :");
		do {
			System.out.println("1. Insert new contact No.");
			System.out.println("2. Delete existing contact No.");
			System.out.println("0. Return");
			ch = scn.nextInt();
			System.out.println("Enter contact no:");
			long no = scn.nextLong();
			if (ch == 1) {
				PreparedStatement ps = con.prepareStatement("insert into patient_contact_no values(?,?)");
				ps.setInt(1, pid);
				ps.setLong(2, no);
				ps.executeUpdate();
			} else if (ch == 2) {
				stmt.executeUpdate("delete from patient_contact_no where p_contact_no=" + no);
			} else if (ch != 0) {
				System.out.println("Wrong Choice ......");
			}
		} while (ch != 0);
		System.out.println("Contact No. Updated");
	}

	// Completed
	public static void UpdateNurse(Statement stmt, Connection con, Scanner scn) throws SQLException {
		ResultSet rs1 = stmt.executeQuery("Select n_id , e_name from employee natural join nurse where n_id= e_id");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the id of nurse whose details you want to modify: ");
		int nid = scn.nextInt();
		System.out.println("Old Details:->->->->->....");
		SpecificNurseDetail(stmt, con, scn, nid);
		int ch = -1;
		int i = 0;
		PreparedStatement ps = null;
		String temp;
		do {
			System.out.println("\nChoose the field you wish to update:\n");
			{
				System.out.println("1. Name");
				System.out.println("2. Salary");
				System.out.println("3. Experience");
				System.out.println("4. Contact Nos.");
				System.out.println("5. Work shift of nurse");
				System.out.println("0. Return");
				ch = scn.nextInt();
				switch (ch) {

				case 1:
					System.out.println("Enter the correct name :");
					temp = scn.nextLine();
					String name = scn.nextLine();
					ps = con.prepareStatement("update employee set e_name=? where e_id=?");
					ps.setString(1, name);
					ps.setInt(2, nid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 2:
					System.out.println("Enter salary:");
					double sal = scn.nextDouble();
					ps = con.prepareStatement("update employee set e_salary=? where e_id=?");
					ps.setDouble(1, sal);
					ps.setInt(2, nid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;

				case 3:
					System.out.println("Enter experience:");
					temp = scn.nextLine();
					String exp = scn.nextLine();
					ps = con.prepareStatement("update employee set e_experience=? where e_id=?");
					ps.setString(1, exp);
					ps.setInt(2, nid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 4:
					UpdateEmpContactNo(stmt, con, scn, nid);
					break;
				case 5:
					System.out.println("Enter work shift (morning,evening and night)");
					temp = scn.nextLine();
					String w_s = scn.nextLine();
					ps = con.prepareStatement("update nurse set n_work_shift=? where n_id=?");
					ps.setString(1, w_s);
					ps.setInt(2, nid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 0:
					break;
				default:
					System.out.println("Wrong choice!");
					break;
				}
			}
		} while (ch != 0);

	}

	// Completed
	public static void UpdateReceptionist(Statement stmt, Connection con, Scanner scn) throws SQLException {
		ResultSet rs1 = stmt
				.executeQuery("Select recep_id , e_name from employee natural join receptionist where recep_id= e_id");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the receptionist_id whose details you want to modify: ");
		int recpid = scn.nextInt();
		System.out.println("Old Details:->->->->->....");
		specificReceptDetails(stmt, con, scn, recpid);
		int ch = -1;
		int i = 0;
		PreparedStatement ps = null;
		String temp;
		do {
			System.out.println("\nChoose the field you wish to update:\n");
			{
				System.out.println("1. Name");
				System.out.println("2. Work shift of receptionist");
				System.out.println("3. Salary");
				System.out.println("4. Experience");
				System.out.println("5. Contact Nos.");
				System.out.println("0. Return");
				ch = scn.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the correct name :");
					temp = scn.nextLine();
					String name = scn.nextLine();
					ps = con.prepareStatement("update employee set e_name=? where e_id=?");
					ps.setString(1, name);
					ps.setInt(2, recpid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 2:
					System.out.println("Enter work shift;");
					temp = scn.nextLine();
					String w_s = scn.nextLine();
					ps = con.prepareStatement("update receptionist set work_shift=? where recep_id=?");
					ps.setString(1, w_s);
					ps.setInt(2, recpid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 3:
					System.out.println("Enter salary;");
					double sal = scn.nextDouble();
					ps = con.prepareStatement("update employee set e_salary=? where e_id=?");
					ps.setDouble(1, sal);
					ps.setInt(2, recpid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;

				case 4:
					System.out.println("Enter experience;");
					temp = scn.nextLine();
					String exp = scn.nextLine();
					ps = con.prepareStatement("update employee set e_experience=? where e_id=?");
					ps.setString(1, exp);
					ps.setInt(2, recpid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 5:
					UpdateEmpContactNo(stmt, con, scn, recpid);
				case 0:
					break;

				default:
					System.out.println("Wrong choice!");
					break;
				}
			}
		} while (ch != 0);
	}

	// Completed
	public static void UpdateMedicine(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		displayAllmedicine(stmt, con, scn);
		System.out.println("Enter code of the medicine do you want to modify:");
		int m_code = scn.nextInt();
		int ch = -1;
		int i = 0;
		String temp;
		do {
			System.out.println("1. Name");
			System.out.println("2. Price");
			System.out.println("0. Return");
			ch = scn.nextInt();
			System.out.println("\nChoose the field you wish to update:\n");
			switch (ch) {
			case 1:
				System.out.println("Enter the correct name:");
				temp = scn.nextLine();
				String name = scn.nextLine();
				PreparedStatement ps = con.prepareStatement("Update medicine set m_name =? where m_code=?");
				ps.setString(1, name);
				ps.setInt(2, m_code);
				i = ps.executeUpdate();
				System.out.println(i + "record updated");
				break;
			case 2:
				System.out.println("Enter new Price:");
				double price = scn.nextDouble();
				PreparedStatement ps1 = con.prepareStatement("Update medicine set m_price =? where m_code=?");
				ps1.setDouble(1, price);
				ps1.setInt(2, m_code);
				i = ps1.executeUpdate();
				System.out.println(i + "record updated");
				break;
			case 0:
				break;
			default:
				System.out.println("Wrong Choice!");
				break;
			}
		} while (ch != 0);
	}

	public static void UpdateRoom(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery("Select r_id from room");
		while (rs1.next())
			System.out.println(rs1.getInt(1));
		int ch = -1;
		String temp;
		System.out.println("Enter the room number whose details you want to modify:");
		int rn = scn.nextInt();
		System.out.println("Room Details:");
		specificRoomDetail(stmt, con, scn, rn);
		do {
			System.out.println("\nChoose the field you wish to update:\n");
			System.out.println("1. Room type");
			System.out.println("2. Room charge");
			System.out.println("3. Incharge nurse");
			System.out.println("0. Return");

			ch = scn.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter type(AC/NON-AC) :");
				temp = scn.nextLine();
				String type = scn.nextLine();
				PreparedStatement ps = con.prepareStatement("update room set r_type = ? where r_id=?");
				ps.setString(1, type);
				ps.setInt(2, rn);
				int rs = ps.executeUpdate();
				System.out.println(rs + " record updated");
				break;
			case 2:
				System.out.println("Enter the new room charge:");
				double charge = scn.nextDouble();
				PreparedStatement ps1 = con.prepareStatement("update room set r_charge = ? where r_id=?");
				ps1.setDouble(1, charge);
				ps1.setInt(2, rn);
				int rs2 = ps1.executeUpdate();
				System.out.println(rs2 + " record updated");
				break;
			case 3:
				ResultSet rs6 = stmt
						.executeQuery("Select n_id , e_name from employee natural join nurse where e_id= n_id");
				while (rs6.next()) {
					System.out.println("   " + rs6.getInt(1) + "     " + rs6.getString(2));
				}
				System.out.println("Enter the nurse id to be incharged of room:");
				int ni = scn.nextInt();
				System.out.println("Enter start date:");
				System.out.println("Enter year:");
				int y = scn.nextInt();
				System.out.println("Enter month(1-12): ");
				int m = scn.nextInt();
				System.out.println("Enter day(1-30)");
				int da = scn.nextInt();
				@SuppressWarnings("deprecation")
				java.sql.Date d = new java.sql.Date(y, m, da);
				PreparedStatement ps3 = con.prepareStatement("insert into governs values(?,?,?)");
				ps3.setInt(1, ni);
				ps3.setInt(2, rn);
				ps3.setDate(3, d);
				ps3.executeUpdate();
				System.out.println("record updated");
				break;
			case 0:
				break;
			default:
				System.out.println("Wrong Choice...");
				break;
			}
		} while (ch != 0);

	}

	// Complete it
	public static void UpdatePatient(Statement stmt, Connection con, Scanner scn) throws SQLException {

		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery("Select p_id , p_name from patient");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the id of the patient whose details you want to modify: ");
		int pid = scn.nextInt();
		System.out.println("Old Details:->->->->->....");
		specificPatientDetail(stmt, con, scn, pid);
		int ch = -1;
		int i = 0;
		PreparedStatement ps = null;
		String temp;
		do {
			System.out.println("Choose the field you wish to update:");
			{
				System.out.println("1. Name");
				System.out.println("2. Address");
				System.out.println("3. Date Discharged");
				System.out.println("4. Contact Nos.");
				System.out.println("5. Insert equipment used");
				System.out.println("0. Return");
				ch = scn.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the correct name :");
					temp = scn.nextLine();
					String name = scn.nextLine();
					ps = con.prepareStatement("update patient set p_name=? where p_id=?");
					ps.setString(1, name);
					ps.setInt(2, pid);
					i = ps.executeUpdate();
					System.out.println(i + " records Updated");
					break;
				case 2:
					System.out.println("Enter address:");
					System.out.println("Enter house number:");
					temp = scn.nextLine();
					String house_no = scn.nextLine();
					System.out.println("Enter street name:");
					// temp = scn.nextLine();
					String street_name = scn.nextLine();
					System.out.println("Enter city:");
					String city = scn.nextLine();
					ps = con.prepareStatement(
							"update patient set p_address_house_no=?,p_address_street=?,p_address_city=? where p_id=?");
					ps.setString(1, house_no);
					ps.setString(2, street_name);
					ps.setString(3, city);
					ps.setInt(4, pid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 3:
					System.out.println("Enter Date-Of-Discharged:");
					System.out.println("Enter year:");
					int y = scn.nextInt();
					System.out.println("Enter month(1-12): ");
					int m = scn.nextInt();
					System.out.println("Enter day(1-30)");
					int da = scn.nextInt();
					@SuppressWarnings("deprecation")
					java.sql.Date d = new java.sql.Date(y, m, da);
					ps = con.prepareStatement("update patient set  p_date_discharged =? where p_id=?");
					ps.setDate(1, d);
					ps.setInt(2, pid);
					i = ps.executeUpdate();
					System.out.println(i + " record Updated");
					break;
				case 4:
					UpdatepatientContactNo(stmt, con, scn, pid);
					break;
				case 5:
					insertEquipment(stmt, con, scn, pid);
					break;
				case 0:
					break;
				default:
					System.out.println("Wrong choice");
					break;
				}
			}
		} while (ch != 0);
	}

	// Completed
	public static void UpdateRecord(Statement stmt, Connection con, Scanner scn) throws SQLException {
		ResultSet rs1 = stmt.executeQuery("Select rec_id , rec_name from record");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the rec_id whose details you want to modify: ");
		int recid = scn.nextInt();
		System.out.println("Old Details:->->->->->....");
		specificRecord(stmt, con, scn, recid);
		int ch = -1;
		int i = 0;
		PreparedStatement ps = null;
		String temp;
		do {
			System.out.println("Choose an option:");
			{
				System.out.println("1. Receptionist id handling this record");
				System.out.println("0. Return");
				ch = scn.nextInt();
				switch (ch) {
				case 1:
					ResultSet rs2 = stmt.executeQuery("select * from recep_name");
					System.out.println("\tID\tName\n");
					while (rs1.next()) {
						System.out.println("\t" + rs2.getInt(1) + "\t" + rs2.getString(2));
					}
					System.out.println("Enter receptionist id:");
					temp = scn.nextLine();
					int id = scn.nextInt();
					ps = con.prepareStatement("update record set recep_id=? where rec_id=?");
					ps.setInt(1, id);
					ps.setInt(2, recid);
					i = ps.executeUpdate();
					System.out.println(i + " records Updated");
					break;

				case 0:
					break;
				default:
					System.out.println("Wrong Choice!");
					break;
				}
			}
		} while (ch != 0);
	}

	// Completed
	public static void deleteDoctor(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery("Select d_id , e_name from employee natural join doctor where e_id= d_id");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the doctor id whose record you want to delete:");
		int did = scn.nextInt();
		System.out.println("Details of Doctor: ");
		specificdoctordetail(stmt, con, scn, did);
		ResultSet rs2 = stmt.executeQuery("Select p_id from patient where p_d_id=" + did);
		boolean b = rs2.next();
		if (!b) {
			stmt.executeUpdate("delete from doctor where d_id =" + did);
			stmt.executeUpdate("delete from emp_contact_no where e_id=" + did);
			stmt.executeUpdate("delete from employee where e_id=" + did);
			System.out.println("Doctor's record removed from the database.");

		} else {
			System.out.println("Doctor's record can't be removed. He/She is assigned to some admitted patient.");
		}

	}

	// Completed
	public static void deleteNurse(Statement stmt, Connection con, Scanner scn) throws SQLException {
		// add a clear Statement here
		ResultSet rs1 = stmt.executeQuery("Select n_id , e_name from employee natural join nurse where e_id= n_id");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the nurse id whose record you want to delete:");
		int nid = scn.nextInt();
		SpecificNurseDetail(stmt, con, scn, nid);
		ResultSet rs2 = stmt.executeQuery("Select r_id from governs where n_id =" + nid);
		boolean b = rs2.next();
		if (!b) {
			stmt.executeUpdate("delete from nurse where n_id =" + nid);
			stmt.executeUpdate("delete from emp_contact_no where e_id=" + nid);
			stmt.executeUpdate("delete from employee where e_id=" + nid);
			System.out.println("Nurse's record removed from the database.");

		} else {
			System.out.println("Nurse's record can't be removed. He/She is governing some room currently!");
		}

	}

	// Completed
	public static void deleteReceptionist(Statement stmt, Connection con, Scanner scn) throws SQLException {
		ResultSet rs1 = stmt
				.executeQuery("Select recep_id , e_name from employee natural join receptionist where e_id= recep_id");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the receptionist id whose record you want to delete:");
		int recepid = scn.nextInt();
		specificReceptDetails(stmt, con, scn, recepid);
		ResultSet rs2 = stmt.executeQuery("Select recep_id from record where recep_id =" + recepid);
		boolean b = rs2.next();
		if (!b) {
			stmt.executeUpdate("delete from receptionist where recep_id =" + recepid);
			stmt.executeUpdate("delete from emp_contact_no where e_id=" + recepid);
			stmt.executeUpdate("delete from employee where e_id=" + recepid);
			System.out.println("Receptionist Deleted");

		} else {
			System.out.println("Receptionist's record can't removed. He/She is managing some record currently!");
		}
	}

	// Completed
	public static void deletePatient(Statement stmt, Connection con, Scanner scn) throws SQLException {
		ResultSet rs1 = stmt.executeQuery("Select p_id , p_name from patient");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the patient id whose record you want to delete:");
		int pid = scn.nextInt();
		specificPatientDetail(stmt, con, scn, pid);
		ResultSet rs2 = stmt.executeQuery("select p_r_id from patient where p_id=" + pid);
		rs2.next();
		int roomNo = rs2.getInt(1);
		stmt.executeUpdate("delete from patient where p_id =" + pid);
		stmt.executeUpdate("delete from patient_contact_no where p_id=" + pid);
		stmt.executeUpdate("delete from equipment where p_id=" + pid);
		System.out.println("Patient Deleted along with all his/her equipment records");
		ResultSet rs3 = stmt.executeQuery("select p_id from patient where p_r_id=" + roomNo);
		if (!rs3.next()) {
			stmt.executeUpdate("delete from governs where r_id=" + roomNo);
		}
	}

	// Completed
	public static void deleteRecord(Statement stmt, Connection con, Scanner scn) throws SQLException {
		ResultSet rs1 = stmt.executeQuery("Select rec_id , rec_name from record");
		while (rs1.next()) {
			System.out.println("   " + rs1.getInt(1) + "     " + rs1.getString(2));
		}
		System.out.println("Enter the record id you want to delete:");
		int recid = scn.nextInt();
		specificRecord(stmt, con, scn, recid);
		stmt.executeUpdate("delete from record where rec_id =" + recid);

		System.out.println("Record removed from the database.");
	}

	// // Completed
	// public static void deleteMedicine(Statement stmt, Connection con, Scanner
	// scn) throws SQLException {
	// // add a clear Statement here
	// displayAllmedicine(stmt, con, scn);
	// System.out.println("Enter the medicine code do you want to delete:");
	// int mi = scn.nextInt();
	// int result = stmt.executeUpdate("delete from medicine where m_code = " +
	// mi);
	// System.out.println(result + " rows deleted");
	// }

	public static long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}
}
