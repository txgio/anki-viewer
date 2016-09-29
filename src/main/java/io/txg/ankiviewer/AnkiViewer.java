package io.txg.ankiviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "io.txg.ankiviewer" })
public class AnkiViewer {

	public static void main(String[] args) {
		SpringApplication.run(AnkiViewer.class, args);
	}

}
