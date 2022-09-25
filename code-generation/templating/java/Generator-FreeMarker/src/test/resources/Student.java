
package org.se.lab;

@Entity
@Table(name = "STUDENT")
public class Student {
	private String firstname;
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	private String lastname;
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	@Id
	private int matnr;
	
	public void setMatnr(int matnr) {
		this.matnr = matnr;
	}
	
	public int getMatnr() {
		return matnr;
	}
	
	
	public Student(String firstname, String lastname, int matnr) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.matnr = matnr;
	}
}