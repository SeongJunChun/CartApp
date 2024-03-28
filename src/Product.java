import java.util.HashSet;
import java.util.Objects;

public class Product {
	private String name;
	private int price;

	public Product(String name,int price) {
		this.name=name;
		this.price=price;
	}

	public String getName(){
		return name;
	}
	public int getPrice(){
		return price;
	}

	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Product)) return false;
		return ((Product)object).name.equals(this.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
