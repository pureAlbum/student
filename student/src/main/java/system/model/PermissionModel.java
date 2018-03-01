package system.model;

public class PermissionModel {
	private Integer id;
	private String permission_name;
	private String url;
	private String pcode;
	private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
