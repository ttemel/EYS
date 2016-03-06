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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Hoca
 */
@Entity
@Table(name = "AUTH_KULLANICI_ROL")
public class KullaniciRol extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6875198381506100463L;
	Long id;
    Kullanici kullanici;
    Rol rol;

    public KullaniciRol() {
    }

    public KullaniciRol(Long id, Kullanici kullanici, Rol rol) {
        this.id = id;
        this.kullanici = kullanici;
        this.rol = rol;
    }

    
    @Id
    @Column(name = "kullanici_rol_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_kullanici_rol", sequenceName = "seq_kullanici_rol")
    @GeneratedValue(generator = "seq_kullanici_rol", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "kullanici_id")
    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "rol_id")
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
