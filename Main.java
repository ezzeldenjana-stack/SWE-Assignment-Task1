import java.util.ArrayList;
abstract class Product { //abstract class uses abstraction
    private int id;  //PRIVATE SO ENCAPSULATION
    private String name;
    private double price;
    private float quantity;

    public Product (int i , String n , double p , float q ){
        id=i;
        name=n;
        price=p;
        quantity=q;
    }
    public int getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public float getQuantity() {
        return quantity;
    }
    public abstract void printProduct(); //FOR ABSTRACTION

    public void setQuantity(float quantity) {
       this.quantity=quantity;
    }
}
 class Electronicproduct extends Product{ //inheritance
 private int warranty;
    public Electronicproduct(int id, String name, double price, float quantity, int warranty){
        super( id , name , price , quantity ); //SUPER CALLS THE PARENT CONSTRUCTOR
        this.warranty=warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    @Override
    public void printProduct() {
        System.out.println("ID OF THIS PRODUCT : " + getId());
        System.out.println("Name:" + getName());
        System.out.println("Price:" + getPrice());
        System.out.println("Quantity:" + getQuantity());
        System.out.println("WarrantyYears: "  + getWarranty() );
    }
}
 class Clothes extends Product{
    private String size;
    public Clothes(int id, String name, double price, int quantity, String size) {
        super(id, name, price, quantity);
        this.size=size;
    }
    @Override
    public void printProduct(){
        System.out.println("Clothing Product: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Size: " + size);
    } }
    class Cart { //polymorphism
        private ArrayList<Product> cartItems;

        public Cart() {
            cartItems = new ArrayList<>();
        }

        public void addProduct(Product pro) {
            cartItems.add(pro);
            System.out.println(pro.getName() + "added successfully to cart");
        }

        public void removeProduct(int id) {
            boolean alreadyThere = false; //ASSUME THE PRODUCT ISNOT FOUND
            for (int i = 0; i < cartItems.size(); ++i) {
                if (cartItems.get(i).getId() == id) {
                    System.out.println(cartItems.get(i).getName() + "removed successfully from cart");
                    cartItems.remove(i);
                    alreadyThere = true; //MARK THAT WE FOUND IT
                    break;
                }
            }
            if (!alreadyThere) System.out.println("Product is not found in the cart");
        }

        public void viewCart() {
            if (cartItems.isEmpty()) {
                System.out.println("cart is empty");
                return;
            }
            for (Product p : cartItems) {
                p.printProduct();
            }
        }

        public double calculateTotal() {
            double totalMoney = 0;
            for (Product p : cartItems) {
                totalMoney += p.getPrice() * p.getQuantity();
            }
            return totalMoney;
        }
    }
public class Main {
    public static void main(String[] args ){
        Cart mycart=new Cart();
        Electronicproduct TV = new Electronicproduct(1,"TV ",15000,1,3);
        Electronicproduct phone = new Electronicproduct(2,"iPhone 17 ",40000,1,2);
        Clothes Tshirt = new Clothes(3, "T-Shirt ", 20, 3, "M");
        Clothes jeans = new Clothes(4, "Jeans ", 50, 2, "L");

        mycart.addProduct(TV);
        mycart.addProduct(phone);
        mycart.addProduct(Tshirt);
        mycart.addProduct(jeans);
        mycart.viewCart();
        mycart.removeProduct(2);
        mycart.viewCart();
        System.out.println("Total needed:" + mycart.calculateTotal());
    }
}
