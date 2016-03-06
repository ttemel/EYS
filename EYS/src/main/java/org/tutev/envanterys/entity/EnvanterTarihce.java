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
 * @author Tütev
 */
@Entity
@Table(name = "Envanter_Tarihce")
public class EnvanterTarihce extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7295720859826146579L;
	private Long id;
    private Date tarih;
    private Kisi kisi;
    private Yerlesim yerlesim;
    private Envanter envanter;

    @Id
    @Column(name = "Envanter_tarihce_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_Envanter_tarihce", sequenceName = "seq_Envanter_tarihce")
    @GeneratedValue(generator = "seq_Envanter_tarihce", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "kisi_id")
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "yerlesim_id")
    public Yerlesim getYerlesim() {
        return yerlesim;
    }

    public void setYerlesim(Yerlesim yerlesim) {
        this.yerlesim = yerlesim;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "envanter_id")
    public Envanter getEnvanter() {
        return envanter;
    }

    public void setEnvanter(Envanter envanter) {
        this.envanter = envanter;
    }

}
