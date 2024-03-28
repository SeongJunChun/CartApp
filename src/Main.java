import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {

		HashSet<Product> productSet = readCSVFile();

		System.out.println("고유한 상품 목록:");
		for (Product product : productSet) {
			System.out.println(product.getName() + " : " + product.getPrice());
		}

		Cart cart = new Cart(productSet);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("--------------------");
			System.out.println("기능을 선택해 주세요!");
			System.out.println("1.장바구니에 상품 담기 2.장바구니에 상품 뺴기 3.장바구니 목록 보기 4.종료");
			int n = 0;
			try {
				n = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("올바른 입력이 아닙니다!");
			}

			if (n == 1) {
				System.out.println("추가할 상품과 갯수를 입력해주세요");
				System.out.println("예시) 우유 2");
				String[] s = br.readLine().split(" ");
				try {
					cart.addProduct(s[0], Integer.parseInt(s[1]));
				} catch (Exception e) {
					System.out.println("올바른 입력이 아닙니다!");
				}

			} else if (n == 2) {
				System.out.println("추가할 상품과 갯수를 입력해주세요");
				System.out.println("예시) 우유 2");
				String[] s = br.readLine().split(" ");
				try {
					cart.removeProduct(s[0], Integer.parseInt(s[1]));
				} catch (Exception e) {
					System.out.println("올바른 입력이 아닙니다!");
				}
			} else if (n == 3)
				cart.showItems();
			else if (n == 4)
				return;

		}

	}

	public static HashSet<Product> readCSVFile() {
		HashSet<Product> set = new HashSet<>();
		Charset charset = StandardCharsets.UTF_8;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
			new FileInputStream("src/상품목록.csv"), charset))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] s = line.split(",");
				Product product = new Product(s[0], Integer.parseInt(s[1]));
				set.add(product);
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return set;
	}

}
