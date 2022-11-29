package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	private String firstName, lastName;
	private int IDNum, attemptCred, passCred;
	private double qualPts, bearBucks;
	
	
	public Student(String initFirst, String initLast, int initID) {
		this.firstName = initFirst;
		this.lastName = initLast;
		this.IDNum = initID;
		//this.attemptCred = initAtt;
		//this.passCred = initPass;
		
	}
	
	public Student(int initAtt, int initPass, double initQualPts,double initBearBucks) {
		this.attemptCred = initAtt;
		this.passCred = initPass;	
		this.qualPts = initQualPts;
		this.bearBucks = initBearBucks;
	}
	
	/*
	public Student(double initBearBucks) {
		this.bearBucks = initBearBucks;
	}
	*/
	/**
	 * Get students first and last name
	 * @return the full name
	 */
	public String getFullName() {
		String studName = this.firstName +" " + this.lastName;
		return studName;
	}
	/**
	 * Get students ID number
	 * @return ID number
	 */
	public int getId() {
		return this.IDNum;
	}
	
	/**
	 * Allow a grade to be sub,itted with the corresponding number of credits
	 * @param grade is the grade submitted
	 * @param credits is the number of credits
	 * @return nothing since it is void
	 */
	public void submitGrade(double grade, int credits) {
		
		if (grade >= 1.7) {
			this.passCred += credits;
		}
		this.attemptCred += credits;
		this.qualPts = this.qualPts + credits*grade;
		
	}
	
	/**
	 * Get total number of credits attempted
	 * @return number of attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return this.attemptCred;
	}
	/**
	 * Get number of credits that student passed
	 * @return the number of passing credits
	 */
	public int getTotalPassingCredits() {
		return this.passCred;
	}
	
	/**
	 * Calculate the student's GPA
	 * @return the student's GPA
	 */
	public double calculateGradePointAverage() {
		double GPA = this.qualPts/this.attemptCred;
		return GPA;
	}
	 
	/**
	 * Get student's class standing
	 * @return the student's class standing
	 */
	public String getClassStanding() {
		String classSta="";
		if (this.passCred<30) {
			classSta = "First Year";
		}
		else if (this.passCred>=30&&this.passCred<60) {
			classSta = "Sophomore";
		}
		else if (this.passCred>=60&&this.passCred<90) {
			classSta = "Junior";
		}
		else if (this.passCred>=90) {
			classSta = "Senior";
		}
		return classSta;
	}
	/**
	 * Evaluate if the student is eligible for PBK
	 * @return whether or not the student is eligible for PBK
	 */
	public boolean isEligibleForPhiBetaKappa() {
		double GPA = calculateGradePointAverage();
		if (this.attemptCred>=98 && GPA>=3.60) {
			return true;
		}
		else if (this.attemptCred>= 75 && GPA>=3.80) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Allow student to deposit bear bucks
	 * @param amount is the amount of bear bucks to be deposited
	 * @return nothing since it is void
	 */
	public void depositBearBucks(double amount) {
		this.bearBucks += amount;
	}
	/**
	 * Deduct bear bucks when student spends them
	 * @param amount is the amount of bear bucks spent
	 * @return nothing since it is void
	 */
	public void deductBearBucks(double amount) {
		this.bearBucks -= amount;
	}
	/**
	 * Allow student to access his bear bucks balance
	 * @return the student's bear bucks balance
	 */
	public double getBearBucksBalance() {
		return this.bearBucks;
	}
	/**
	 * Allow student to cash out his bear bucks with a respective penalty
	 * @return the amount of bear bucks the student will cash out with after the penalty
	 */
	public double cashOutBearBucks() {
		double newAmt;
		if (bearBucks>10) {
			newAmt = bearBucks -10;	
			bearBucks = 0;
			return newAmt;
		}
		else {
			newAmt = 0;
			bearBucks = 0;
			return newAmt;
		}
	}
	/**
	 * Create a legacy from two parents (this and other)
	 * @param first name is the student's first name
	 * @param other is the second parent
	 * @param isHyphenated specifies if the last name of teh legacy should be hyphenated
	 * @param id is the student id
	 * @return the legacy student
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String lastN;
		if (isHyphenated == true) {
			lastN = this.lastName + "-" + other.lastName;
		}
		else {
			lastN = this.lastName;
		}
		Student legacy = new Student(firstName, lastN, id);
		
		
		
		this.bearBucks = this.cashOutBearBucks();
		
		other.bearBucks = other.cashOutBearBucks();
		
		
		
		legacy.bearBucks = (int) (this.bearBucks + other.bearBucks);
		
		this.bearBucks = 0;
		other.bearBucks = 0;
		

		
		return legacy;
	}
	/**
	 * Convert first name last name and ID number to a string
	 * @return String of the student's first name, last name, and ID number
	 */
	public String toString() {
		
		String str = this.firstName + " " + this.lastName + " " + this.IDNum;
		return str;
	}
	
	

}