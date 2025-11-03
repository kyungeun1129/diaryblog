
public class FoodDTO {
	String categorize;
    String name;
    String address;
    
    public FoodDTO() {
	}

	public FoodDTO(String categorize, String name, String address) {
		super();
		this.categorize = categorize;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		String str = String.format("%s\t%s\t%s", categorize, name, address);
	    return str;
	}

	public String getCategorize() {
		return categorize;
	}

	public void setCategorize(String categorize) {
		this.categorize = categorize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
    
}
