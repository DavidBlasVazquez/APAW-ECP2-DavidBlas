package es.upm.miw.user.api.resources.exceptions;

public class RequestInvalidException extends Exception {
	private static final long serialVersionUID = 2941400890233246479L;
	public static final String DESCRIPTION = "Petición no implementada";

    public RequestInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public RequestInvalidException() {
        this("");
    }

}
