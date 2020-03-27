package com.capstone.cyberplace.common;



// chua cac hang so da duoc fix cung trong database
public class CommonConstant {

	// Role ID
	public static final int RoleID_Admin = 1;
	public static final int RoleID_Staff =2;
	public static final int RoleID_User = 4;

	// Checking Status ID
	public static final int Checking_Status_ID_Canceled = 0;
	public static final int Checking_Status_ID_Approved = 1;
	public static final int Checking_Status_ID_Pending = 2;

	// Contract Status ID
	public static final int Contract_Status_ID_Valid = 0;
	public static final int Contract_Status_ID_End = 1;

	// Order Status ID
	public static final int Order_Status_ID_Canceled = 0;
	public static final int Order_Status_ID_Approved = 1;
	public static final int Order_Status_ID_Pending = 2;

	// Payment Status ID
	public static final int Payment_Status_ID_Unpaid = 0;
	public static final int Payment_Status_ID_Paid = 1;

	// User Status ID
	public static final int User_Status_ID_Deactive = 0;
	public static final int User_Status_ID_Active = 1;

	// Place Status ID
	public static final int Place_Status_ID_Cancel = 0;
	public static final int Place_Status_ID_Active = 1;
	public static final int Place_Status_ID_Pending = 2;
	public static final int Place_Status_ID_Deactive = 3;
	
	
	// Number of loopin BCrypt.gensalt
	
	public static final int Number_Loop_BCrypt = 12 ;
	
	
	

}
