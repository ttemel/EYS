package org.tutev.envanterys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.envanterys.entity.enm.DosyaTip;

@Entity
@Table(name = "Dosya")
public class Dosya extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5760447495977777703L;
	Long id;
	String dosyaAdi;
	DosyaTip dosyaTip;
	byte[] dosya;
	String aciklama;
	
	public Dosya() {
		// TODO Auto-generated constructor stub
	}

	public Dosya(Long id, String dosyaAdi, DosyaTip dosyaTip, byte[] dosya,
			String aciklama) {
		super();
		this.id = id;
		this.dosyaAdi = dosyaAdi;
		this.dosyaTip = dosyaTip;
		this.dosya = dosya;
		this.aciklama = aciklama;
	}

	@Id
    @Column(name = "dosya_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_dosya", sequenceName = "seq_dosya")
    @GeneratedValue(generator = "seq_dosya", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=400,name="dosya_adi")
	public String getDosyaAdi() {
		return dosyaAdi;
	}

	public void setDosyaAdi(String dosyaAdi) {
		this.dosyaAdi = dosyaAdi;
	}

	@Enumerated
	@Column(name="dosya_tip")
	public DosyaTip getDosyaTip() {
		return dosyaTip;
	}

	public void setDosyaTip(DosyaTip dosyaTip) {
		this.dosyaTip = dosyaTip;
	}

	@Lob
	@Column(name="dosya")
	public byte[] getDosya() {
		return dosya;
	}

	public void setDosya(byte[] dosya) {
		this.dosya = dosya;
	}

	@Column(length=400,name="aciklama")
	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

}
