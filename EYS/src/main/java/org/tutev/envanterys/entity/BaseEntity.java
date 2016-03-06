/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tütev
 */
@MappedSuperclass
public abstract class BaseEntity implements  Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5856232449352111611L;
	String ekleyen;
    Date eklemeTarihi;
    String guncelleyen;
    Date guncellemeTarihi;
    Boolean durum;

    @Column(name = "ekleyen",length =50)
    public String getEkleyen() {
        return ekleyen;
    }

    public void setEkleyen(String ekleyen) {
        this.ekleyen = ekleyen;
    }

    @Column(name = "ekleme_tarihi")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEklemeTarihi() {
        return eklemeTarihi;
    }

    public void setEklemeTarihi(Date eklemeTarihi) {
        this.eklemeTarihi = eklemeTarihi;
    }

    @Column(name = "guncelleyen",length =50)
    public String getGuncelleyen() {
        return guncelleyen;
    }

    public void setGuncelleyen(String guncelleyen) {
        this.guncelleyen = guncelleyen;
    }

    @Column(name = "guncelleme_tarihi")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(Date guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }

    @Column(name = "durum")
    public Boolean getDurum() {
        return durum;
    }

    public void setDurum(Boolean durum) {
        this.durum = durum;
    }
    
    
}
