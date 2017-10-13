package es.upm.miw.apaw.user.api.entities;

public class Sport {
	private Long id;
    private String title;
	private String category;
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		assert id != null;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		assert title != null;
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		assert category != null;
		this.category = category;
	}
}
