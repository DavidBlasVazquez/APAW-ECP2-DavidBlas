package es.upm.miw.apaw.user.api.dtos;

public class UserDto {
	
	private String data;
	
	public UserDto (String data) {
		this.data = data;
	}
	public String toString() {
		return data;	
	}
}
