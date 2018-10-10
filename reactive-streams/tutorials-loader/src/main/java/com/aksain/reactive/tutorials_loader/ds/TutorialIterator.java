package com.aksain.reactive.tutorials_loader.ds;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.aksain.reactive.tutorials_loader.models.Tutorial;

public class TutorialIterator implements Iterator<Tutorial> {

	private static final String FILE_PATH = "";

	private final Scanner scanner;

	public TutorialIterator() {
		try {
			scanner = new Scanner(Paths.get(FILE_PATH));
		} catch (IOException e) {
			 throw new IllegalStateException(e);
		}
	}

	@Override
	public boolean hasNext() {
		return scanner.hasNextLine();
	}

	@Override
	public Tutorial next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		
		final String line = scanner.nextLine();
		final String[] lineTokens = line.split(",");

		return new Tutorial(Long.parseLong(lineTokens[0]), lineTokens[1], lineTokens[2], lineTokens[3]);
	}
}
