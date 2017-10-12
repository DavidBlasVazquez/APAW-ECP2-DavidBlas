package es.upm.miw.user.theme.api.resources.exceptions;

public class UserFieldInvalidException extends Exception {
	private static final long serialVersionUID = 1822612022276800199L;
	public static final String DESCRIPTION = "Nombre del user no valido";

    public UserFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public UserFieldInvalidException() {
        this("");
    }

}
