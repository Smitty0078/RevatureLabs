package resource.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/resources")
public class ResourceController {

	@GetMapping(path = "/{id}", produces="application/json")
	public Resource getResource(@PathVariable int id){
		System.out.println("Service Called");
		return new Resource("hello "+id);
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
