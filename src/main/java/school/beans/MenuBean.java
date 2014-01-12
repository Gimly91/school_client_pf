package school.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name = "menuBean")
@ViewScoped
public class MenuBean {

	private MenuModel model;

	public MenuBean() {
		model = new DefaultMenuModel();

		// First submenu
		DefaultSubMenu firstSubmenu = new DefaultSubMenu("Learn");

		DefaultMenuItem item = new DefaultMenuItem("Sound Learning");
		item.setIcon("ui-icon-home");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(1)}");
		firstSubmenu.addElement(item);

		item = new DefaultMenuItem("Color Learning");
		item.setIcon("ui-icon-home");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(2)}");
		firstSubmenu.addElement(item);

		item = new DefaultMenuItem("Operation Learning");
		item.setIcon("ui-icon-home");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(3)}");
		firstSubmenu.addElement(item);

		item = new DefaultMenuItem("Words Learning");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(4)}");
		item.setIcon("ui-icon-home");
		firstSubmenu.addElement(item);

		model.addElement(firstSubmenu);

		// Second submenu
		DefaultSubMenu secondSubmenu = new DefaultSubMenu("Repeat");

		item = new DefaultMenuItem("Sounds Repeat");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(5)}");
		item.setIcon("ui-icon-refresh");
		secondSubmenu.addElement(item);

		item = new DefaultMenuItem("Operation Repeat");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(6)}");
		item.setIcon("ui-icon-refresh");
		secondSubmenu.addElement(item);

		item = new DefaultMenuItem("Color Repeat");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(7)}");
		item.setIcon("ui-icon-refresh");
		secondSubmenu.addElement(item);

		model.addElement(secondSubmenu);

		// Third submenu
		DefaultSubMenu thirdSubMenu = new DefaultSubMenu("Play");

		item = new DefaultMenuItem("Puzzle");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(8)}");
		item.setIcon("ui-icon-play");
		thirdSubMenu.addElement(item);

		item = new DefaultMenuItem("Blocks");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(9)}");
		item.setIcon("ui-icon-play");
		thirdSubMenu.addElement(item);

		item = new DefaultMenuItem("Find Me");
		item.setAjax(false);
		item.setCommand("#{layoutBean.setMenuAction(10)}");
		item.setIcon("ui-icon-play");
		thirdSubMenu.addElement(item);

		model.addElement(thirdSubMenu);
	}

	public MenuModel getModel() {
		return model;
	}

	public void save() {
		addMessage("Data saved");
	}

	public void update() {
		addMessage("Data updated");
	}

	public void delete() {
		addMessage("Data deleted");
	}

	public String redirect() {
		return "home?faces-redirect=true";
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}