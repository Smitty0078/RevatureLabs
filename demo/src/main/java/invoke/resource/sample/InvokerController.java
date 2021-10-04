package invoke.resource.sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/invoker")
public class InvokerController {

	public String invoke() {
		RestTemplate rest = new RestTemplate();
		String resourceUrl = "http://localhost:8080/resources/5";
		//ResponseEntity<String> response = rest.getForEntity(resourceUrl, String...
		Resource response = rest.getForObject(resourceUrl, Resource.class);
		System.out.println(response);
		
		return "invoked";
	}
	
	
}


class Resource {

	private String name;

	public Resource(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Resource [name=" + name + "]";
	}
	
	
	
}