/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 
 * @author Musa
 */
@Entity
@Table(name = "Kisi")
public class Kisi extends BaseEntity {

	@Override
	public String toString() {
		return "Kisi [id=" + id + ", ad=" + ad + ", soyad=" + soyad
				+ ", tcKimlikNo=" + tcKimlikNo + ", mail=" + mail
				+ ", dogumTarihi=" + dogumTarihi + ", cinsiyet=" + cinsiyet
				+ ", uyruk=" + uyruk + ", adSoyad=" + adSoyad + ", resim="
				+ resim + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7167926317302434614L;
	private Long id;
	private String ad;
	private String soyad;
	private String tcKimlikNo;
	private String mail;
	private Date dogumTarihi;
	private Sozluk cinsiyet;
	private Sozluk uyruk;
	@SuppressWarnings("unused")
	private String adSoyad;
	private Dosya resim;

	
	
	
	public Kisi() {
		this.cinsiyet=new Sozluk();
		this.uyruk=new Sozluk();
	}

	@Id
	@Column(name = "Kisi_id")
	@SequenceGenerator(allocationSize = 1, name = "seq_Kisi", sequenceName = "seq_Kisi")
	@GeneratedValue(generator = "seq_Kisi", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "Kisi_TcKimlikNo", length = 11, nullable = false)
	public String getTcKimlikNo() {
		return tcKimlikNo;
	}

	public void setTcKimlikNo(String tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}

	@Column(name = "Kisi_Ad", length = 50)
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Column(name = "Kisi_Soyad", length = 50)
	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	@Column(name = "Kisi_mail", length = 100)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * 
	 * @return
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "Kisi_DogumTarihi", length = 10)
	public Date getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	@Transient
	public String getAdSoyad() {
		return this.ad + " " + this.soyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	@ManyToOne(optional = true)
	@JoinColumn(name = "resim_id")
	public Dosya getResim() {
		return resim;
	}

	public void setResim(Dosya resim) {
		this.resim = resim;
	}

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "CINSIYET_ID")
	public Sozluk getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Sozluk cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "UYRUK_ID")
	public Sozluk getUyruk() {
		return uyruk;
	}

	public void setUyruk(Sozluk uyruk) {
		this.uyruk = uyruk;
	}
	
	
	

}
