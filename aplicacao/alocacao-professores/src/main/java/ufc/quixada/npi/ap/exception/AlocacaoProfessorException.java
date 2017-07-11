package ufc.quixada.npi.ap.exception;

public class AlocacaoProfessorException extends Exception {
	private static final long serialVersionUID = 1L;

	private String message;

	public AlocacaoProfessorException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
