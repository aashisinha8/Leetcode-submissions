class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1)
                    return jumps;

                // left
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // right
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // same value
                if (map.containsKey(arr[idx])) {

                    for (int next : map.get(arr[idx])) {

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    map.remove(arr[idx]);
                }
            }

            jumps++;
        }

        return -1;
    }
}