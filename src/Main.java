
import java.util.Scanner;
import com.service.ProductService;
import com.model.Product;
import com.service.CartService;
import com.service.OrderService;
import com.service.CouponService;
import com.service.LogService;
import com.utils.ConcurrentUserSimulator;
import com.utils.FailureSimulator;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        CouponService couponService = new CouponService();
        LogService logService = new LogService();
        ConcurrentUserSimulator simulator = new ConcurrentUserSimulator();
        FailureSimulator failureSimulator = new FailureSimulator();

        while (true) {

            System.out.println("\n===== ECOMMERCE CLI =====");

            System.out.println("1 Add Product");
            System.out.println("2 View Products");
            System.out.println("3 Add To Cart");
            System.out.println("4 Remove From Cart");
            System.out.println("5 View Cart");
            System.out.println("6 Apply Coupon");
            System.out.println("7 Place Order");
            System.out.println("8 Cancel Order");
            System.out.println("9 View Orders");
            System.out.println("10 Low Stock Alert");
            System.out.println("11 Return Product");
            System.out.println("12 Simulate Concurrent Users");
            System.out.println("13 View Logs");
            System.out.println("14 Trigger Failure Mode");
            System.out.println("15 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                	System.out.println("Enter Product ID");
                    int id = sc.nextInt();

                    System.out.println("Enter Product Name");
                    String name = sc.next();

                    System.out.println("Enter Product Price");
                    double price = sc.nextDouble();

                    System.out.println("Enter Product Stock");
                    int stock = sc.nextInt();

                    Product product = new Product(id, name, price, stock);

                    productService.addProduct(product);
                    break;

                case 2:
                	productService.viewProducts();
                    break;

                case 3:
                	System.out.println("Enter Product ID");
                    int productId = sc.nextInt();

                    System.out.println("Enter Quantity");
                    int qty = sc.nextInt();

                    Product prod = productService.getProduct(productId);

                    cartService.addToCart(prod, qty);
                    break;

                case 4:
                	System.out.println("Enter Product ID to remove");

                    int removeId = sc.nextInt();

                    cartService.removeFromCart(removeId);
                    break;

                case 5:
                	cartService.viewCart();
                    break;

                case 6:
                	 System.out.println("Enter Coupon Code");

                	    String code = sc.next();

                	    couponService.applyCoupon(code);

                    break;

                case 7:
                	 orderService.placeOrder(cartService.getCartItems(), couponService);

                	    cartService.clearCart();

                	    couponService.resetCoupon();
                    break;

                case 8:
                	 System.out.println("Enter Order ID");

                	    int orderId = sc.nextInt();

                	    orderService.cancelOrder(orderId);
                    break;

                case 9:
                	orderService.viewOrders();
                    break;

                case 10:
                	 productService.lowStockAlert();
                    break;

                case 11:
                	System.out.println("Enter Order ID to return");

                    int returnId = sc.nextInt();

                    orderService.returnProduct(returnId);
                    break;

                case 12:
                	 simulator.simulateUsers();
                    break;

                case 13:
                	 logService.viewLogs();
                    break;

                case 14:
                	failureSimulator.triggerFailure();
                    break;

                case 15:
                	System.out.println("Exiting Application");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
