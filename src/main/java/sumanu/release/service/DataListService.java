package sumanu.release.service;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class DataListService {

	public String greeting(String name) {
		System.out.println("Call Service dataListService.greeting(" + name + ")");
		return doGreeting(name);
	}

	private String doGreeting(String name) {
		System.out.println("Call Service dataListService.doGreeting(" + name + ")");

		if (StringUtils.isEmpty(name)) {
			return "Hello unknown";
		}
		return "Hello " + name;
	}
}
