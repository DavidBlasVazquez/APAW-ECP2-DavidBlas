package es.upm.miw.user.theme.api.resources.exceptions;

public class SportInvalidException extends Exception {
	private static final long serialVersionUID = -6843007179373474952L;
	public static final String DESCRIPTION = "Id del sport no localizado";

    public SportInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public SportInvalidException() {
        this("");
    }

}
