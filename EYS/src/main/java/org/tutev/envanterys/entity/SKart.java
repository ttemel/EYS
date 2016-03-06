/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Özgür
 */
@Entity
@Table(name = "skart")
public class SKart implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3218288630809940893L;
	private Long id;
    private String tanim;
    private String kod;
    private String stokKategorisi;
    private Boolean aktif;

    public SKart() {
    }

    public SKart(String tanim, String kod, String stokKategorisi) {
        this.tanim = tanim;
        this.kod = kod;
        this.stokKategorisi = stokKategorisi;
    }

    
    @Id
    @Column(name = "skart_id")
    @SequenceGenerator(allocationSize = 1,name = "seq_skart",sequenceName ="seq_skart" )
    @GeneratedValue(generator = "seq_skart",strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "skart_tanim",length = 400,nullable = false)
    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    @Column(name = "skart_kod",length = 40)
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @Column(name = "skart_kategori",length = 400)
    public String getStokKategorisi() {
        return stokKategorisi;
    }

    public void setStokKategorisi(String stokKategorisi) {
        this.stokKategorisi = stokKategorisi;
    }

    public Boolean getAktif() {
        return aktif;
    }

    public void setAktif(Boolean aktif) {
        this.aktif = aktif;
    }

    @Override
    public String toString() {
        return "SKart{" + "id=" + id + ", tanim=" + tanim + ", kod=" + kod + ", stokKategorisi=" + stokKategorisi + ", aktif=" + aktif + '}';
    }
    
}
