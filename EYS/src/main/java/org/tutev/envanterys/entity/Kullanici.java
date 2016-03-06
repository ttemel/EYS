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
 * @author Cihangir
 */
@Entity
@Table(name = "AUTH_Kullanici")
public class Kullanici extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4523562421948245201L;
	Long id;
    String username;
    String pass;
    Kisi kisi;

    @Id
    @Column(name = "Kullanici_id")
    @SequenceGenerator(allocationSize = 1, name = "seq_Kullanici", sequenceName = "seq_Kullanici")
    @GeneratedValue(generator = "seq_Kullanici", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "kisi_id")
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @Override
    public String toString() {
        return this.kisi.getAdSoyad(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
