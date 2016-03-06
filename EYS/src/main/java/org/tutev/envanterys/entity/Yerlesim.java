/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.envanterys.entity.enm.YerlesimTip;

/**
 *
 * @author Hayrullah
 */
@Entity
@Table(name = "Yerlesim")
public class Yerlesim extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4340535558169054325L;
	private Long id;
    private String tanim;
    private String kod;
    private Yerlesim ustYerlesim;
    private YerlesimTip yerlesimTip;

    @Id
    @Column(name = "Yerlesim_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_Yerlesim", sequenceName = "seq_Yerlesim")
    @GeneratedValue(generator = "seq_Yerlesim", strategy = GenerationType.SEQUENCE)
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

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "ust_yerlesim_id")
    public Yerlesim getUstYerlesim() {
        return ustYerlesim;
    }

    public void setUstYerlesim(Yerlesim ustYerlesim) {
        this.ustYerlesim = ustYerlesim;
    }

    @Enumerated
    public YerlesimTip getYerlesimTip() {
        return yerlesimTip;
    }

    public void setYerlesimTip(YerlesimTip yerlesimTip) {
        this.yerlesimTip = yerlesimTip;
    }

}
