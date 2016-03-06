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
import javax.persistence.Transient;

/**
 *
 * @author Hoca
 */
@Entity
@Table(name="AUTH_ROL")
public class Rol {
    
    private Long id;
    private String kod;
    private String tanim;

    @Id
    @Column(name = "rol_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_rol", sequenceName = "seq_rol")
    @GeneratedValue(generator = "seq_rol", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }
    
    @Transient
    public String getKodTanim(){
        return this.kod+"-"+this.tanim;
    }
    
                @Override //combo box düzenlemesi için
    public String toString() {
        return this.getKodTanim(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
