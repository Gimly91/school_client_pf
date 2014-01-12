package school.beans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.layout.LayoutUnit;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

@ManagedBean(name = "layoutBean")
@SessionScoped
public class LayoutBean {

	private int menuAction = 0;

	public LayoutBean() {
	}

	public void handleClose(CloseEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unit Closed", "Position:'" + ((LayoutUnit) event.getComponent()).getPosition()
				+ "'");

		addMessage(message);
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ((LayoutUnit) event.getComponent()).getPosition() + " toggled", "Status:"
				+ event.getVisibility().name());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void viewRegisterWindow() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", false);
		options.put("resizable", false);
		options.put("contentHeight", 380);
		options.put("contentWidth", 500);
		//
		// hint: available options are modal,
		// draggable, resizable, width, height,
		// contentWidth and contentHeight
		//
		RequestContext.getCurrentInstance().openDialog("Resources/User/register", options, null);
	}

	public int getMenuAction() {
		return menuAction;
	}

	// REMOVE HACK
	public void setMenuAction(Long menuAction) {
		this.menuAction = menuAction.intValue();
	}

	public void setMenuAction(int menuAction) {
		this.menuAction = menuAction;
	}

}
