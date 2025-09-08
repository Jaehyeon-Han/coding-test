import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        prices[prices.length - 1] = 0;

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            Node node = new Node(prices[i], i);
            nodes.add(node);
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(nodes.get(0));
        for (int i = 1; i < nodes.size(); i++) {
            int lastPrice = stack.peek().getPrice();
            int currentPrice = nodes.get(i).getPrice();

            if (currentPrice < lastPrice) {
                while (!stack.isEmpty() && stack.peek().getPrice() > currentPrice) {
                    Node poppedNode = stack.pop();
                    answer[poppedNode.getIndex()] = i - poppedNode.getIndex();
                }
            }

            stack.push(nodes.get(i));
        }
        
        return answer;
    }

    private static class Node {
        private final int price;
        private final int index;

        public Node(int price, int index) {
            this.price = price;
            this.index = index;
        }

        public int getPrice() {
            return price;
        }

        public int getIndex() {
            return index;
        }
    }
}