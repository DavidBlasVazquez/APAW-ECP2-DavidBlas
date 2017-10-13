package es.upm.miw.user.api.resources.exceptions;

public class AddSportToUserException extends Exception {
	private static final long serialVersionUID = -8293999373452018536L;
	public static final String DESCRIPTION = "Add sport o User have failed.";

    public AddSportToUserException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public AddSportToUserException() {
        this("");
    }
}
