/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package Company.CommerceHub;

/**
 *
 * @author Wu
 */
public class PickingResult extends Result {

    private final String message;

    public PickingResult(boolean success, int amount, int inventory_amount, String message) {
        super(success, amount, inventory_amount);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
