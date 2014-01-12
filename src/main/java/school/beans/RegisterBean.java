package school.beans;

import static school.beans.BeanUtils.CREATE_WS;
import static school.beans.BeanUtils.EXISTS_WS;
import static school.beans.BeanUtils.LOGIN_PAGE;
import static school.beans.BeanUtils.REGISTER_PAGE;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import school.encrypt.MD5Encrypt;
import school.model.User;

@ManagedBean(name = "registerBean")
@ViewScoped
public class RegisterBean {

	private User user = new User();
	private Date date;

	@SuppressWarnings("deprecation")
	public String register() throws Exception {
		if (user.getUsername() != "") {
			String readWS = EXISTS_WS + user.getUsername();
			
			ClientRequest request = new ClientRequest(readWS);
			request.accept("application/json");
			ClientResponse<Boolean> response = request.get(Boolean.class);

			int apiResponseCode = response.getResponseStatus().getStatusCode();
			if (response.getResponseStatus().getStatusCode() != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + apiResponseCode);
			}
			Boolean userExists = response.getEntity();
			if (!userExists) {
				user.setType("User");
				user.setPassword(MD5Encrypt.hashPassword(user.getPassword()));
				serverRegister();

				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("message", new FacesMessage("Account succesfully created"));
				return LOGIN_PAGE;
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("message", new FacesMessage("Userneame already exist in DB"));
				return REGISTER_PAGE;
			}
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("message", new FacesMessage("Please provide valid data"));
		return REGISTER_PAGE;
	}

	@SuppressWarnings("deprecation")
	public void serverRegister() {
		try {
			
			ClientRequest request = new ClientRequest(CREATE_WS);
			request.accept("application/json");
			request.body("application/json", user);

			ClientResponse<Boolean> response = request.post(Boolean.class);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
