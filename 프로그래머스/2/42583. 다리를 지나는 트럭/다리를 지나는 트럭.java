import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridgeLength, int maxWeight, int[] truckWeights) {
        Bridge bridge = new Bridge(bridgeLength, maxWeight);
        Queue<Truck> trucks = new ArrayDeque<>();
        for (int truckWeight : truckWeights) {
            Truck truck = new Truck(truckWeight);
            trucks.offer(truck);
        }

        int time = 1;
        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            bridge.removeCrossedTruck(time);
            if(!trucks.isEmpty()) {
                if(bridge.canEnter(trucks.peek())) {
                    bridge.enter(trucks.poll(), time);
                }
            } else {
                if(bridge.isEmpty()) {
                    return time;
                }
            }

            time++;
        }

        return time;
    }
    
    private static class Bridge {
        private final int length;
        private final int maxWeight;
        private int currentWeight = 0;
        private final Queue<Truck> trucksOnBridge = new ArrayDeque<>();

        public Bridge(int length, int maxWeight) {
            this.length = length;
            this.maxWeight = maxWeight;
        }

        public boolean canEnter(Truck truck) {
            return currentWeight + truck.getWeight() <= maxWeight;
        }

        public void enter(Truck truck, int time) {
            truck.setEnterTime(time);
            trucksOnBridge.offer(truck);
            currentWeight += truck.getWeight();
        }

        public void removeCrossedTruck(int currentTime) {
            if(!trucksOnBridge.isEmpty()) {
                Truck leadingTruck = trucksOnBridge.peek();
                int travelDistance = currentTime - leadingTruck.getEnterTime();
                if (travelDistance >= length) {
                    trucksOnBridge.poll();
                    currentWeight -= leadingTruck.getWeight();
                }
            }
        }

        public boolean isEmpty() {
            return trucksOnBridge.isEmpty();
        }
    }

    private static class Truck {
        private final int weight;
        private int enterTime = Integer.MAX_VALUE / 2;

        public Truck(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getEnterTime() {
            return enterTime;
        }

        public void setEnterTime(int enterTime) {
            this.enterTime = enterTime;
        }
    }
}