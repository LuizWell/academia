package br.com.academia;

public class ExceptionAcademia extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
		public ExceptionAcademia(String msgErro) {
			super(msgErro);
		}

}
