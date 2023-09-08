package br.com.academia.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

public class AcademiaDialect extends AbstractProcessorDialect{
	
	public AcademiaDialect() {
		super("Academia", "academia", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
		return processadores;
	}

}
