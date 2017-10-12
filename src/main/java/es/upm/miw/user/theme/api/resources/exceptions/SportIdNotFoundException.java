package es.upm.miw.user.theme.api.resources.exceptions;

public class SportIdNotFoundException extends Exception {
	private static final long serialVersionUID = -8293999373452018536L;
	public static final String DESCRIPTION = "El id del Sport no existe";

    public SportIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public SportIdNotFoundException() {
        this("");
    }
}
