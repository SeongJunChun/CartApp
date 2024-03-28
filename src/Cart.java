import java.util.HashMap;
import java.util.HashSet;

public class Cart {

	private HashSet<Product> productSet;
	public HashMap<Product, Integer> map;

	public int sum;

	public Cart(HashSet<Product> productSet) {
		map = new HashMap<>();
		this.productSet = productSet;
	}

	public void addProduct(String name, int amount) {
		Product product = new Product(name, 0);
		if (!productSet.contains(product)) {
			System.out.println("상품이 존재하지 않습니다!");
			return;
		}
		for (Product p : productSet) {
			if (p.equals(product)) {
				map.put(p, map.getOrDefault(p, 0) + amount);
				sum = sum + p.getPrice() * amount;
				showItems();
			}
		}
	}

	public void removeProduct(String name, int amount) {
		Product product = new Product(name, 0);
		if (!map.containsKey(product)) {
			System.out.println("상품이 존재하지 않습니다!");
			return;
		} else if (map.get(product) < amount) {
			System.out.println("뺄수 있는 상품의 수량을 초과했습니다!");
			return;
		}
		for (Product p : productSet) {
			if (p.equals(product)) {
				map.put(p, map.get(p) - amount);
				sum = sum - p.getPrice() * amount;
				showItems();
			}
		}
	}

	public void showItems() {
		if (map.isEmpty()) {
			System.out.println("장바구니가 비어있습니다!");
			return;
		}
		System.out.println("-----장바구니 목록------");
		map.forEach((product, amount) -> {
			System.out.println(product.getName() + " : " + amount + "개");
		});
		System.out.println("총 %d원 입니다.".formatted(sum));
	}

}
