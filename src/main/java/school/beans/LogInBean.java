package school.beans;

import static school.beans.BeanUtils.LOGIN_WS;

import java.rmi.RemoteException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import school.encrypt.MD5Encrypt;
import school.model.User;

@SuppressWarnings("deprecation")
@ManagedBean(name = "logInBean")
@SessionScoped
public class LogInBean {

	private String username;
	private String password;
	private User user = new User();
	private boolean isAdmin;
	private FacesContext context;
	private boolean isLogged;

	public FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public void login() throws Exception {
		user.setUsername(getUsername());
		user.setPassword(MD5Encrypt.hashPassword(getPassword()));
		// user.setBirthDate();

		ClientRequest request = new ClientRequest(LOGIN_WS);

		request.accept("application/json");
		request.body("application/json", user);
		ClientResponse<String> response = request.post(String.class);

		// First validate the api status code
		int apiResponseCode = response.getResponseStatus().getStatusCode();
		if (response.getResponseStatus().getStatusCode() != 200) {
			throw new RuntimeException("Failed with HTTP error code : " + apiResponseCode);
		}
		String accountType = response.getEntity();

		if (!accountType.equals("noUser")) {
			if (accountType.equals("Admin")) {
				setIsAdmin(true);
			}
			setIsLogged(true);
			context = getContext();
			context.getExternalContext().getSessionMap().put("username", user.getUsername());
			context.getExternalContext().getSessionMap().put("option", "0");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Invalid input data!", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	/**
	 * Se redirecteaza catre pagina de login.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public void logout() throws RemoteException {
		setIsAdmin(false);
		setIsLogged(false);
		setUser(new User());
		setPassword("");
		setUsername("");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public boolean isUserLogged() {
		if (user.getUsername() != null) {
			return true;
		} else {
			return false;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
}
