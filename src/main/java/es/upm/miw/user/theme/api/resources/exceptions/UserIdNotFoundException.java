package es.upm.miw.user.theme.api.resources.exceptions;

public class UserIdNotFoundException extends Exception {
	private static final long serialVersionUID = -8293999373452018536L;
	public static final String DESCRIPTION = "El id del User no existe";

    public UserIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public UserIdNotFoundException() {
        this("");
    }
}
