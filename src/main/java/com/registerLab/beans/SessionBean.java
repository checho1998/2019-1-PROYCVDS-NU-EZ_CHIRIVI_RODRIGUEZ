package com.registerLab.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import com.google.inject.Injector;
import com.registerLab.entities.Usuario;
import com.registerLab.servicios.ServiciosECILabImpl;

@ManagedBean(name="sesBean")
@SessionScoped
public class SessionBean extends BaseBeanRegisterLab{
	private String email;
	private String password;
	private Usuario user;
	private Injector injector;
	private ServiciosECILabImpl servicios;
	public SessionBean() {
		injector = super.getInjector();
		servicios = injector.getInstance(ServiciosECILabImpl.class);
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
			if(user==null) user = servicios.getUsuario(SecurityUtils.getSubject().getPrincipal().toString());
		}
			catch(Exception e) {
				
			}
}
		public Usuario getUsuario(){
			try {
				if(SecurityUtils.getSubject().getPrincipal()==null) FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");

			}catch(Exception e) {
			}
			if(user==null && SecurityUtils.getSubject().getPrincipal()!=null) user = servicios.getUsuario(SecurityUtils.getSubject().getPrincipal().toString());
			return user;
		}
		
		public void logout() {
			try {
				SecurityUtils.getSubject().logout();
				user =null;
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}