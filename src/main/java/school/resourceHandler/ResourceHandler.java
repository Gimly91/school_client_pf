package school.resourceHandler;

import static school.beans.BeanUtils.GET_IMAGES_WS;
import static school.beans.BeanUtils.GET_SOUNDS_WS;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;

import school.model.Image;
import school.model.Sound;

public class ResourceHandler {

	public ResourceHandler() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public List<Image> getImages(int id) throws Exception {
		ClientRequest request = new ClientRequest(GET_IMAGES_WS+id);
		ClientResponse<List<Image>> response = request.get(new GenericType<List<Image>>(){});
		List<Image> images = response.getEntity();
		return images;
	}

	@SuppressWarnings("deprecation")
	public List<Sound> getSounds(int id) throws Exception {
		ClientRequest request = new ClientRequest(GET_SOUNDS_WS+id);
		ClientResponse<List<Sound>> response = request.get(new GenericType<List<Sound>>(){});
		List<Sound> sounds = response.getEntity();
		return sounds;
	}

}
