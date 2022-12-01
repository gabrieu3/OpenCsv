package com.balestech.csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Random;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CsvApplication {

	public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
		SpringApplication.run(CsvApplication.class, args);

		List<ArquivoOpenCSV.Line> header = new ArrayList<>();
		List<ArquivoOpenCSV.Line> details = new ArrayList<>();
		List<ArquivoOpenCSV.Line> footer = new ArrayList<>();

		header.add(new ArquivoOpenCSV.Header());
		details.add(new ArquivoOpenCSV.Detail());
		details.add(new ArquivoOpenCSV.Detail());
		details.add(new ArquivoOpenCSV.Detail());
		footer.add(new ArquivoOpenCSV.Footer());

		Writer writer = new FileWriter("teste"+(new Random().nextInt(100))+".csv");
		gravaNoArquivoUsandoOpenCSV(writer, header);
		gravaNoArquivoUsandoOpenCSV(writer, details);
		gravaNoArquivoUsandoOpenCSV(writer, footer);
		writer.close();
	}

	public static void gravaNoArquivoUsandoOpenCSV(Writer writer, List<ArquivoOpenCSV.Line> line) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
		new StatefulBeanToCsvBuilder<ArquivoOpenCSV.Line>(writer)
				.withSeparator('|')
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
				.withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
				.withLineEnd(CSVWriter.DEFAULT_LINE_END)
				.build().write(line);
	}

}
