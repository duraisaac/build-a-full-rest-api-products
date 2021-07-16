package contract;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contract {
	
	private @Id @GeneratedValue Long id;
	private String employeeClassification;
	private int daysHolidays;
	private Date employmentPeriod;
	
	Contract() {}
	
	public Contract(String employeeClassification, int daysHolidays, Date employmentPeriod){
		
		this.employeeClassification = employeeClassification;
		this.daysHolidays = daysHolidays;
		this.employmentPeriod = employmentPeriod;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeClassification() {
		return employeeClassification;
	}

	public void setEmployeeClassification(String employeeClassification) {
		this.employeeClassification = employeeClassification;
	}

	public int getDaysHolidays() {
		return daysHolidays;
	}

	public void setDaysHolidays(int daysHolidays) {
		this.daysHolidays = daysHolidays;
	}

	public Date getEmploymentPeriod() {
		return employmentPeriod;
	}

	public void setEmploymentPeriod(Date employmentPeriod) {
		this.employmentPeriod = employmentPeriod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + daysHolidays;
		result = prime * result + ((employeeClassification == null) ? 0 : employeeClassification.hashCode());
		result = prime * result + ((employmentPeriod == null) ? 0 : employmentPeriod.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contract other = (Contract) obj;
		if (daysHolidays != other.daysHolidays)
			return false;
		if (employeeClassification == null) {
			if (other.employeeClassification != null)
				return false;
		} else if (!employeeClassification.equals(other.employeeClassification))
			return false;
		if (employmentPeriod == null) {
			if (other.employmentPeriod != null)
				return false;
		} else if (!employmentPeriod.equals(other.employmentPeriod))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", employeeClassification=" + employeeClassification + ", daysHolidays="
				+ daysHolidays + ", employmentPeriod=" + employmentPeriod + "]";
	}
	
	
	
	

}
