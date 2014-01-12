package school.beans.learn;

import static school.utils.Utils.IMAGE_WORDS;
import static school.utils.Utils.SOUND_WORDS;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import school.model.Image;
import school.model.Sound;
import school.resourceHandler.ResourceHandler;
@ManagedBean(name = "learnWordsBean")
@SessionScoped
public class LearnWordsBean {

	private List<Image> images;
	private List<Sound> sounds;
	private ResourceHandler resourceHandler;

	public LearnWordsBean() throws Exception {
		resourceHandler = new ResourceHandler();
		setImages(resourceHandler.getImages(4));
		setSounds(resourceHandler.getSounds(4));
	}

	public String getImage(String path) {
		return IMAGE_WORDS + path;
	}

	public String play(String path) {
		return SOUND_WORDS + path.substring(0, path.length() - 3) + "wav";
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
