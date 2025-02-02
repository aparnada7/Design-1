/*
 * HashMap design using LinkedList.
 * Used in-built hashCode from Integer to generate keys/unique indexes.
 * */
class MyHashMap {
        final ListNode[] nodes = new ListNode[10000];

        public void put(int key, int value) {
        	//generate key value from idx()
            int i = idx(key);
            if (nodes[i] == null)
                nodes[i] = new ListNode(-1, -1);
            ListNode prev = find(nodes[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key) {
            int i = idx(key);
            //If no value at index found, return -1
            if (nodes[i] == null)
                return -1;
            ListNode node = find(nodes[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = idx(key);
            if (nodes[i] == null) return;
            ListNode prev = find(nodes[i], key);
            if (prev.next == null) return;
            //To get rid of a node, de-link from Link list by using pre.next.next
            prev.next = prev.next.next;
        }
        
        //Used in-built hashCode from Integer to generate keys/unique indexes.
        int idx(int key) { return Integer.hashCode(key) % nodes.length;}
        
        //Find function
        ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            //Check until the key matches 
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }
        
        //Defining node class
        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
