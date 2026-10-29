
class Solution {

    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int answer = Integer.MAX_VALUE;

        // Land -> Water
        for (int i = 0; i < landStartTime.length; i++) {

            int landFinish =
                    landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {

                // Water can start only when:
                // 1. Land is finished
                // 2. Water ride is open
                int waterStart = Math.max(
                        landFinish,
                        waterStartTime[j]
                );

                int finish =
                        waterStart + waterDuration[j];

                answer = Math.min(answer, finish);
            }
        }

        // Water -> Land
        for (int j = 0; j < waterStartTime.length; j++) {

            int waterFinish =
                    waterStartTime[j] + waterDuration[j];

            for (int i = 0; i < landStartTime.length; i++) {

                int landStart = Math.max(
                        waterFinish,
                        landStartTime[i]
                );

                int finish =
                        landStart + landDuration[i];

                answer = Math.min(answer, finish);
            }
        }

        return answer;
    }
}
