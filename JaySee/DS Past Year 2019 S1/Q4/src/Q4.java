class MyHashMap {
    private Entry[] table;
    private int capacity = 10;

    public MyHashMap() {
        table = new Entry[capacity];
    }

    private class Entry {
        String key;
        String value;
        Entry next;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String getValue() {
            return value;
        }
    }

    private int hash(String key) {
        return key.hashCode() % capacity;
    }

    public Entry get(String key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void put(String key, String value) {
        int index = hash(key);
        Entry current = table[index];

        if (current == null) {
            table[index] = new Entry(key, value);
        } else {
            while (true) {
                if (current.key.equalsIgnoreCase(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Entry(key, value);
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("BruceW", "011-8998990");
        myHashMap.put("DeanW", "017-2274000");
        myHashMap.put("TonyS", "019-4550800");
        myHashMap.put("LaraC", "014-6402009");

        Entry e1 = myHashMap.get("DeanW");
        System.out.println("Value: " + e1.getValue());
        Entry e2 = myHashMap.get("TonyS");
        System.out.println("Value: " + e2.getValue());

        myHashMap.put("BruceW", "011-5677900");
        Entry e3 = myHashMap.get("BruceW");
        System.out.println("Value: " + e3.getValue());

        myHashMap.put("JeanG", "019-9001123");
        Entry e4 = myHashMap.get("JeanG");
        System.out.println("Value: " + e4.getValue());
    }
}
