/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * 
 * @author Serkan
 */
@Entity
@Table(name = "Personel")
public class Personel extends BaseEntity {

	private static final long serialVersionUID = 4340535558169054325L;
	private Long id;
	private long tcKimlikNo;
	private String isim;
	private String soyad;
	private String bolum;
	private Date isBaslama;
	private Date isCikis;

	@Id
	@Column(name = "Personel_id")
	@SequenceGenerator(allocationSize = 1, name = "seq_Personel", sequenceName = "seq_Personel")
	@GeneratedValue(generator = "seq_Personel", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Personel_TcKimlikNo", length = 11, nullable = false)
	public long getTcKimlikNo() {
		return tcKimlikNo;
	}

	public void setTcKimlikNo(long tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}

	@Column(name = "Personel_Ad", length = 50)
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	@Column(name = "Personel_Soyad", length = 50)
	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@Column(name = "Personel_Bolum", length = 50)
	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	@Column(name = "Personel_IsBaslama", length = 50)
	public Date getIsBaslama() {
		return isBaslama;
	}

	public void setIsBaslama(Date isBaslama) {
		this.isBaslama = isBaslama;
	}

	@Column(name = "Personel_IsCıkıs", length = 50)
	public Date getIsCikis() {
		return isCikis;
	}
	
	public void setIsCikis(Date isCikis) {
		this.isCikis = isCikis;
	}

}
