package streams.ch07;

import java.util.List;

import lambdas.employee.Designation;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

public class Employee{
	
	private int id;

	private String name;

	private int experience;

	private Designation designation;

	private Unit unit;

	private List<Skill> skills;
	
	private String email;


	public Employee(int id, String name, int experience, Designation designation) {
		this.id=id;
		this.name = name;
		this.experience = experience;
		this.designation = designation;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String toString() {

		return this.getName() + " with " + this.getExperience() + " years of experience \n";
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static boolean hasJavaSkills(Employee employee) {
		System.out.println("Checking if employee has Java skils : " + employee.getName());
		return employee.getSkills().contains(Skill.JAVA);
	}



}
