/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tutev.envanterys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Soner
 */
@Entity
@Table(name = "sozluk")
public class Sozluk extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7098048540887974178L;
	Long id;
    String tanim;
    String kod;
    String sozluktip;
    
    public Sozluk() {
    }

    public Sozluk(Long id, String kod, String tanim, String sozluktip) {
        this.id = id;
        this.tanim = tanim;
        this.kod = kod;
        this.sozluktip = sozluktip;
    }
   
    @Id
    @Column(name = "sozluk_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_sozluk", sequenceName = "seq_sozluk")
    @GeneratedValue(generator = "seq_sozluk", strategy = GenerationType.SEQUENCE)
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

    public String getTip() {
        return sozluktip;
    }

    public void setTip(String tip) {
        this.sozluktip = tip;
    }
    
    
}
