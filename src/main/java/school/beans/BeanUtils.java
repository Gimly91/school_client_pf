package school.beans;

public class BeanUtils {
	private BeanUtils() {
	}

	public static final String HOME_PAGE = "home.xhtml";
	public static final String LOGIN_PAGE = "login.xhtml";
	public static final String REGISTER_PAGE = "register.xhtml";

	public static final String HOME_PAGE_REDIRECT = "home.xhtml?faces-redirect=true";
	public static final String LOGIN_PAGE_REDIRECT = "login.xhtml?faces-redirect=true";
	public static final String REGISTER_PAGE_REDIRECT = "register.xhtml?faces-redirect=true";

	public static final String LOGIN_WS = "http://localhost:8081/SchoolServerRest/rest/LogInService/login/";
	public static final String READ_WS = "http://localhost:8081/SchoolServerRest/rest/UserService/read/";
	public static final String EXISTS_WS = "http://localhost:8081/SchoolServerRest/rest/UserService/exists/";
	public static final String CREATE_WS = "http://localhost:8081/SchoolServerRest/rest/UserService/create/";

	public static final String GET_IMAGES_WS = "http://localhost:8081/SchoolServerRest/rest/ResourcesService/getImages/";
	public static final String GET_SOUNDS_WS = "http://localhost:8081/SchoolServerRest/rest/ResourcesService/getSounds/";
}
