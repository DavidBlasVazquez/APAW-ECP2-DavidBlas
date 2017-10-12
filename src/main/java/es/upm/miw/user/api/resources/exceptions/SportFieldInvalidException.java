package es.upm.miw.user.api.resources.exceptions;

public class SportFieldInvalidException extends Exception {
	private static final long serialVersionUID = -6843007179373474952L;
	public static final String DESCRIPTION = "Id del sport no localizado";

    public SportFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public SportFieldInvalidException() {
        this("");
    }

}
