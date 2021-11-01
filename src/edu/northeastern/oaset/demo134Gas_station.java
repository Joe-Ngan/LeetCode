package edu.northeastern.oaset;

public class demo134Gas_station {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int startRun = 0;
        int ans = 0;
        for(int i = 0; i < gas.length; i++ ){
            startRun += (gas[i] - cost[i]);
            totalCost += (gas[i] - cost[i]);
            if(startRun<0){
                startRun = 0;
                ans = i + 1;
            }
        }
        if(totalCost<0){
            return -1;
        }else{
            return ans;
        }
    }
}
