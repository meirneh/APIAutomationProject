package apiNetaceSupport;

public class Link {
	private String name;
	private String status;
	private String speed;
	private String linkType;

	public Link(String name, String status, String speed, String linkType) {
		this.name = name;
		this.status = status;
		this.speed = speed;
		this.linkType = linkType;
	}

	@Override
	public String toString() {
		return "Link [name=" + name + ", status=" + status + ", speed=" + speed + ", linkType=" + linkType + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

}
