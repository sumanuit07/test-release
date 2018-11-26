package sumanu.release.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sumanu.release.service.DataListService;

@RestController
@RequestMapping("/greet")
public class DataListController {

	@Autowired
	private DataListService dataListService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> greeting(@RequestParam(name = "name") String name) {
		System.out.println("DataListController.greeting(" + name + ")");

		return new ResponseEntity<>(dataListService.greeting(name), HttpStatus.OK);
	}

	@GetMapping(path = "nogreeting", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> nogreeting(@RequestParam(name = "name") String name) {
		System.out.println("TEST");
		return new ResponseEntity<>(getNoGreeting(), HttpStatus.OK);
	}

	public String getNoGreeting() {
		return "nogreeting";
	}
}
