import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return helper(price, special, needs, memo);
    }

    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int result = calculatePrice(price, needs);

        for (List<Integer> offer : special) {
            List<Integer> remainingNeeds = new ArrayList<>(needs);
            boolean isValidOffer = true;

            for (int i = 0; i < needs.size(); i++) {
                remainingNeeds.set(i, remainingNeeds.get(i) - offer.get(i));
                if (remainingNeeds.get(i) < 0) {
                    isValidOffer = false;
                    break;
                }
            }

            if (isValidOffer) {
                result = Math.min(result, offer.get(needs.size()) + helper(price, special, remainingNeeds, memo));
            }
        }

        memo.put(needs, result);
        return result;
    }

    private int calculatePrice(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < price.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
}
