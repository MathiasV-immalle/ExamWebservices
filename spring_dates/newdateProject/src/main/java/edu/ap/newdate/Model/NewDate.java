package edu.ap.newdate.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NewDate {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date checkDate;

    @Column
    private Date startDate;

    @Column
	private Date endDate;
	
	@Column
	private String between;
	
	@Column
    private long daysApart;

	public NewDate() {
	}

	public NewDate(final Date checkDate, final Date startDate, final Date endDate) {
		this.checkDate = checkDate;
		this.startDate = startDate;
		this.endDate = endDate;
    }

	public NewDate(final Date checkDate, final Date startDate, final Date endDate, final String between, final long daysApart) {
		this.checkDate = checkDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.between = between;
		this.daysApart = daysApart;
	}
	
	public NewDate(final Date checkDate, final Date startDate, final Date endDate, final String between) {
		this.checkDate = checkDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.between = between;
    }

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(final Date checkDate) {
		this.checkDate = checkDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return startDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	public String getBetween() {
		return between;
	}

	public void setBetween(final String between) {
		this.between = between;
	}

	public long getDaysApart() {
		return daysApart;
	}

	public void setDaysApart(final long daysApart) {
		this.daysApart = daysApart;
	}
}