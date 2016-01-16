/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package Company.CommerceHub;

/**
 *
 * @author Wu
 */
public class Product {

    public enum Location {
        LOCATION1, LOCATION2, LOCATION3, LOCATION4
    }
    private final String productId;
    private int level;
    private Location location;

    public Product(String productId, int level, Location location) {
        this.productId = productId;
        this.level = level;
        this.location = location;
    }

    public String getProductId() {
        return productId;
    }

    public synchronized int getLevel() {
        return level;
    }

    public String getLocation() {
        return location.toString();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public synchronized int increment(int amount) {
        this.level += amount;
        return amount;
    }

    public synchronized int decrement(int amount) {
        if (this.level > amount) {
            this.level -= amount;
            return amount;
        } else {
            int tmp = this.level;
            this.level = 0;
            return tmp;
        }
    }
}
