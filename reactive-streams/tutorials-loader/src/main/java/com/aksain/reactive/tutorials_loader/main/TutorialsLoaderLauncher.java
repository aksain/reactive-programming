package com.aksain.reactive.tutorials_loader.main;

import com.aksain.reactive.tutorials_loader.ds.TutorialIterator;
import com.aksain.reactive.tutorials_loader.models.Tutorial;

import reactor.core.publisher.Flux;

/**
 * @author Amit Kumar
 *
 */
public class TutorialsLoaderLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Flux.fromIterable(TutorialIterator::new).parallel().doOnNext((tutorial) -> {
		}).map((tutorial) -> {
			return new Tutorial();
		}).doOnError((throwable) -> {
			
		});
	}

}
