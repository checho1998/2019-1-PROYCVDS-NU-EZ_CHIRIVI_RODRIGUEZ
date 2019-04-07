package com.registerLab.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

@ManagedBean(name="sesBean")
@SessionScoped
public class SessionBean {
	private String email;
	private String password;
	public SessionBean() {
		
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		try {
			if(SecurityUtils.getSubject().getPrincipal()!=null) FacesContext.getCurrentInstance().getExternalContext().redirect("faces/useradmin.xhtml");
		} catch (IOException e) {
		}
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void login() {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			String hex = new Sha256Hash(password).toHex();
			UsernamePasswordToken token = new UsernamePasswordToken(email, hex);
			token.setRememberMe(true);
			currentUser.login(token);
			FacesContext.getCurrentInstance().getExternalContext().redirect("useradmin.xhtml");
			//System.out.println("userAdmin");
		}catch(Exception e) {
			//System.out.println(SecurityUtils.getSubject().getPrincipal());		}
	}
}
}