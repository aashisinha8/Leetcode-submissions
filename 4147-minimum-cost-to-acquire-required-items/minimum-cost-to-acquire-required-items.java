class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        long common = Math.min(need1, need2);

        long cost = common * Math.min(costBoth, cost1 + cost2);

        if (need1 > need2) {
            long remaining = need1 - need2;
            cost += remaining * Math.min(cost1, costBoth);
        } 
        else {
            long remaining = need2 - need1;
            cost += remaining * Math.min(cost2, costBoth);
        }

        return cost;
    }
}