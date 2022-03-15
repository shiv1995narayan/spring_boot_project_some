package com.inn.main.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name="ExistTicketFamilycode",query="select tf from TicketFamily tf where tf.familyCode=:familyCode")
@Entity
@Table(name = "ticket_family")
public class TicketFamily implements Serializable {

	private static final long serialVersionUID = 5063751255256383296L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ticketfamilyid_pk;

	@Column(name = "NAME", length = 50)
	public String name;

	@Column(name = "DESCRIPTION", length = 500)
	public String description;

	@Column(name = "ACTIVE", length = 10)
	private String active;

	@Column(name = "REFERENCE_ID", length = 10, unique = true)
	private String familyCode;

	@Column(name = "SEARCH", length = 2000)
	private String ticketFamilySearch;

	@Column(name = "CREATOR_NAME", length = 100)
	private String creatorUserName;

	@Column(name = "MODIFIER_NAME", length = 100)
	private String lastModifierUserName;

	@Column(name = "MODIFIED_TIME")
	private Date modificationtime;

	@Column(name = "CREATED_TIME")
	private Date creationtime;


	@Column(name = "DELETED")
	private Boolean deleted;

	@Column(name = "INTEGRATION_TYPE")
	private String integrationType;

	@Column(name = "SOURCE")
	private String source;

	public Integer getTicketfamilyid_pk() {
		return ticketfamilyid_pk;
	}

	public void setTicketfamilyid_pk(Integer ticketfamilyid_pk) {
		this.ticketfamilyid_pk = ticketfamilyid_pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public String getTicketFamilySearch() {
		return ticketFamilySearch;
	}

	public void setTicketFamilySearch(String ticketFamilySearch) {
		this.ticketFamilySearch = ticketFamilySearch;
	}

	public String getCreatorUserName() {
		return creatorUserName;
	}

	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}

	public String getLastModifierUserName() {
		return lastModifierUserName;
	}

	public void setLastModifierUserName(String lastModifierUserName) {
		this.lastModifierUserName = lastModifierUserName;
	}

	public Date getModificationtime() {
		return modificationtime;
	}

	public void setModificationtime(Date modificationtime) {
		this.modificationtime = modificationtime;
	}

	public Date getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getIntegrationType() {
		return integrationType;
	}

	public void setIntegrationType(String integrationType) {
		this.integrationType = integrationType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TicketFamily [ticketfamilyid_pk=" + ticketfamilyid_pk + ", name=" + name + ", description="
				+ description + ", active=" + active + ", familyCode=" + familyCode + ", ticketFamilySearch="
				+ ticketFamilySearch + ", creatorUserName=" + creatorUserName + ", lastModifierUserName="
				+ lastModifierUserName + ", modificationtime=" + modificationtime + ", creationtime=" + creationtime
				+ ", deleted=" + deleted + ", integrationType=" + integrationType + ", source=" + source + "]";
	}
	
}
