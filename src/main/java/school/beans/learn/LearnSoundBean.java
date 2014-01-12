package school.beans.learn;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import school.model.Image;
import school.model.Sound;
import school.resourceHandler.ResourceHandler;
import static school.utils.Utils.*;

@ManagedBean(name = "learnSoundBean")
@SessionScoped
public class LearnSoundBean {

	private List<Image> images;
	private List<Sound> sounds;
	private ResourceHandler resourceHandler;

	public LearnSoundBean() throws Exception {
		resourceHandler = new ResourceHandler();
		setImages(resourceHandler.getImages(1));
	}

	public String getImage(String path) {
		if (!path.equals("") && path.length() > 4) {
			if (path.substring(0, 1).matches("[0-9]*")) {
				return IMAGE_DIGITS + path;
			} else if (path.length() > 1 && path.substring(0, 1).matches("[a-z]*") && path.length() < 6) {
				return IMAGE_LETTERS + path;
			}
		}
		return "";
	}

	public String play(String path) {
		if (!path.equals("")) {
			if (path.substring(0, 1).matches("[0-9]*")) {
				return SOUND_DIGITS + path.substring(0, path.length() - 3) + "wav";
			} else if (path.substring(0, 1).matches("[a-z]*") && path.length() < 6) {
				return SOUND_LETTERS + path.substring(0, path.length() - 3) + "wav";
			}
		}
		return "";
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
