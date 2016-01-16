/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package Company.CommerceHub;

/**
 *
 * @author Wu
 */
public class Result {

    private final boolean success;
    private final int amount;
    private final int inventory_amount;

    public Result(boolean success, int amount, int inventory_amount) {
        this.success = success;
        this.amount = amount;
        this.inventory_amount = inventory_amount;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getAmount() {
        return amount;
    }

    public int getInventory_amount() {
        return inventory_amount;
    }

}
