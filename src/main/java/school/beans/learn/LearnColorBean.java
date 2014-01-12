package school.beans.learn;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import school.model.Image;
import school.model.Sound;
import school.resourceHandler.ResourceHandler;
import static school.utils.Utils.*;

@ManagedBean(name = "learnColorBean")
@SessionScoped
public class LearnColorBean {

	private List<Image> images;
	private List<Sound> sounds;
	private ResourceHandler resourceHandler;

	public LearnColorBean() throws Exception {
		resourceHandler = new ResourceHandler();
		setImages(resourceHandler.getImages(2));
		// setSounds(resourceHandler.getSounds(1));
	}

	public String getImage(String path) {
		return IMAGE_COLORS + path;
	}

	public String play(String path) {
		return IMAGE_COLORS + path.substring(0, path.length() - 3) + "wav";
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Sound> getSounds() {
		return sounds;
	}

	public void setSounds(List<Sound> sounds) {
		this.sounds = sounds;
	}
}
