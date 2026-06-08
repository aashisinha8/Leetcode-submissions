class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events=new ArrayList<>();
        for(int[] b:buildings){
          int left =b[0];
           int right= b[1];
            int height= b[2];
             // start event
            events.add(new int[]{left,-height});
            //end event
            events.add(new int[]{right,height});
        }
        Collections.sort(events, (a, b) -> {

            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(0);

        int prevMax = 0;

        List<List<Integer>> result = new ArrayList<>();
         for (int[] event : events) {

            int x = event[0];
            int h = event[1];

            if (h < 0) {

                // start event
                maxHeap.offer(-h);

            } else {

                // end event
                maxHeap.remove(h);
            }
             int currentMax = maxHeap.peek();

            if (currentMax != prevMax) {

                result.add(Arrays.asList(x, currentMax));

                prevMax = currentMax;
            }
        }

        return result;
    }
}