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
 * @author Cemal
 */
@Entity
@Table(name = "Demirbas")
public class Demirbas extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2827834781982429833L;
	private Long id;
    private String tanim;
    private String kod;

    public Demirbas() {
    }

    public Demirbas(Long id, String tanim, String kod) {
        this.id = id;
        this.tanim = tanim;
        this.kod = kod;
    }

    
    @Id
    @Column(name = "demirbas_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_demirbas", sequenceName = "seq_demirbas")
    @GeneratedValue(generator = "seq_demirbas", strategy = GenerationType.SEQUENCE)
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
    
    
    
}


