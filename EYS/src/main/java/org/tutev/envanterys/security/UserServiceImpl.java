package org.tutev.envanterys.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tutev.envanterys.TDbException;
import org.tutev.envanterys.entity.Kullanici;
import org.tutev.envanterys.service.KullaniciService;

@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private KullaniciService kullaniciService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kullanici kullanici=null;
		try {
			kullanici = kullaniciService.getKullaniciByUsernameAndPassword(username);
		} catch (TDbException e) {
			e.printStackTrace();
		}
		
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		if(kullanici!=null)
			return new User(kullanici.getUsername(), kullanici.getPass(), true, true, true, true, authorities);
		else
			throw new UsernameNotFoundException("Kullanýcý Bulunamadý");
	}

}
