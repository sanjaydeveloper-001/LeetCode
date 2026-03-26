class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = players.length-1;
        int t = trainers.length-1;
        while(t >=0) {
            while(p >= 0 && players[p] > trainers[t]) {
                p--;
            }
            if(p < 0) {
                break;
            }
            t--;
            p--;
        }

        return trainers.length - t - 1;
    }
}