package ro.ase.csie.cts.course3.entities;

public class Student {
	boolean hasScholarship;
	boolean isEnrolled;
	int age;
	int enrollmentYear;
	float typingFrequency;
	
	void payTax() {}
	void TakeOOPExam() {}
	void saveToDb() {}

	void incrementAge() {
		if (this.age < 20) {
			this.age += 1;
		} else {
			this.age += 2;
		}

		this.age = (this.age < 20) ? (this.age += 1) : (this.age += 2);
	}

	String getInfo() {

		if (!this.hasScholarship) {

		}

		if (this.hasScholarship) {
			return "The student has scholarship";
		} else {
			return "The student doesn't have scholarship";
		}
	}

	public int aSimpleFunction() {
		return 10;
	}

}
