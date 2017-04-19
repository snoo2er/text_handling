package by.hryshchanka.task4.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextReader {
	private static final Logger LOGGER = LogManager.getLogger(TextReader.class);
	private static final String INPUT_PATH = "data//text.txt";

	public static String readTxt() {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(INPUT_PATH), StandardCharsets.UTF_8);
			if (lines.isEmpty()) {
				LOGGER.log(Level.FATAL, "File is empty");
				throw new RuntimeException();
			}
		} catch (IOException e) {
			LOGGER.log(Level.FATAL, "File not found");
			throw new RuntimeException();
		}
		StringBuilder text = new StringBuilder("");
		lines.forEach(text::append);
		return text.toString();
	}
}