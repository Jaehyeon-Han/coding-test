import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Node root = new Node(false);

        for (String phoneNumber : phoneBook) {
            if (!root.add(phoneNumber)) {
                return false;
            }
        }

        return true;
    }
    
    private static class Node {
        private Map<Integer, Node> children = new HashMap<>();
        private boolean isLeafNode;

        public Node(boolean isLeafNode) {
            this.isLeafNode = isLeafNode;
        }

        public boolean add(String string) {
            if (isLeafNode && string.length() >= 1) {
                return false;
            }

            Integer firstNumber = Integer.parseInt(string.substring(0, 1));
            if (string.length() > 1) {
                String rest = string.substring(1);
                if(children.containsKey(firstNumber)) {
                    return children.get(firstNumber).add(rest);
                }

                Node newNode = new Node(false);
                children.put(firstNumber, newNode);
                newNode.add(rest);
                return true;
            }

            // string.length() == 1
            if(children.containsKey(firstNumber)) {
                return false;
            }

            Node newNode = new Node(true);
            children.put(firstNumber, newNode);
            return true;
        }
    }
}