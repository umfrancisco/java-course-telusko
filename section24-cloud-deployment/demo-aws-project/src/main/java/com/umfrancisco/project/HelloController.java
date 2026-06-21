package com.umfrancisco.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String greet() {
		String os = System.getProperty("os.name");
		String version = System.getProperty("os.version");
		String architecture = System.getProperty("os.arch");
		String javaVersion = System.getProperty("java.version");
		String user = System.getProperty("user.name");
		return """
		<style>
				body {
						background-color: #506b84;
						color: white;
				}
				div {
						margin: 0 auto;
				}
		</style>
		<div>
				<h2>About this machine</h2>
				<p>OS: %s</p>
				<p>Version: %s</p>
				<p>Architecture: %s</p>
				<p>Java version: %s</p>
				<p>User: %s</p>
		</div>		
		""".formatted(os, version, architecture, javaVersion, user);
	}
	
}
