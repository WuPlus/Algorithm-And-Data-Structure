/*
 *  Code by Jiadong Wu. No CopyRight.
 */
package Company.CommerceHub;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wu
 */
public class IMS implements InventoryManagementSystem {

    private final Map<String, Product> productList;

    private static IMS ims;

    private IMS() {
        productList = new HashMap();
    }

    public static IMS getInstance() {
        if (ims == null) {
            ims = new IMS();
        }
        return ims;
    }

    /**
     * Pick Product from inventory, if the inventory amount is not enough for this pick action, pick
     * all the rest.
     *
     * @param productId
     * @param amountToPick
     * @return
     */
    @Override
    public PickingResult pickProduct(String productId, int amountToPick) {
        PickingResult result;
        int actual_amount = productList.get(productId).decrement(amountToPick);
        int inventory_amount = productList.get(productId).getLevel();
        if (actual_amount == amountToPick) {
            result = new PickingResult(true, amountToPick, inventory_amount, "Success");
        } else {
            result = new PickingResult(false, actual_amount, inventory_amount, "Out of stock");
        }
        return result;
    }

    /**
     * Restock Product into inventory
     *
     * @param productId
     * @param amountToRestock
     * @return
     */
    @Override
    public RestockingResult restockProduct(String productId, int amountToRestock) {
        int actual_amount = productList.get(productId).increment(amountToRestock);
        int inventory_amount = productList.get(productId).getLevel();
        RestockingResult result = new RestockingResult(true, actual_amount, inventory_amount);
        return result;
    }

}
