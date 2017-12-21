package com.web.orchard.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Campusminds")
public class Campusminds implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;
	
	long mId;
	String name;
	Leads lead;
	
	public Campusminds() { /* Empty constructor */ }
	
	public Campusminds(long mId, String name) {
		super();
		this.mId = mId;
		this.name = name;
	}

	@Id
	@GeneratedValue
	@Column(name="MID")
	public long getmId() {
		return mId;
	}

	public void setmId(long mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name="leadId")
	public Leads getLead() {
		return lead;
	}

	public void setLead(Leads lead) {
		this.lead = lead;
	}
	
	
}
