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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Okan
 */
@Entity
@Table(name = "Envanter")
public class Envanter extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5693008187895395147L;
	private Long id;
    private String tanim;
    private String barkod;
    private String ureticiKodu;
    private String kod;
    private Date kurulumTarihi;
    private SKart sKart;
    private Kisi ilgili;
    private Yerlesim yerlesim;

    @Id
    @Column(name = "Envanter_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_Envanter", sequenceName = "seq_Envanter")
    @GeneratedValue(generator = "seq_Envanter", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public String getUreticiKodu() {
        return ureticiKodu;
    }

    public void setUreticiKodu(String ureticiKodu) {
        this.ureticiKodu = ureticiKodu;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Date getKurulumTarihi() {
        return kurulumTarihi;
    }

    public void setKurulumTarihi(Date kurulumTarihi) {
        this.kurulumTarihi = kurulumTarihi;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "skart_id")
    public SKart getsKart() {
        return sKart;
    }

    public void setsKart(SKart sKart) {
        this.sKart = sKart;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "ilgili_id")
    public Kisi getIlgili() {
        return ilgili;
    }

    public void setIlgili(Kisi ilgili) {
        this.ilgili = ilgili;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "yerlesim_id")
    public Yerlesim getYerlesim() {
        return yerlesim;
    }

    public void setYerlesim(Yerlesim yerlesim) {
        this.yerlesim = yerlesim;
    }

}
