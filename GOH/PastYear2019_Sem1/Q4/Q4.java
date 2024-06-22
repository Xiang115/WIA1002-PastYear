package GOH.PastYear2019_Sem1.Q4;

public class Q4 {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("Bruced", "011-8598350");
        myHashMap.put("DeanW", "017-2274000");
        myHashMap.put("TonyS", "019-4550800");
        myHashMap.put("LaraC", "014-6402003");
        Entry el = myHashMap.get("DeanW");
        System.out.println("Value: " + el.getValue());
        Entry e2 = myHashMap.get("TonyS");
        System.out.println("Value: " + e2.getValue());
        myHashMap.put("BruceW", "011-5677500");
        Entry e3 = myHashMap.get("BruceW");
        System.out.println("Value: " + e3.getValue());
        myHashMap.put("JeanG", "019-9001123");
        Entry e4 = myHashMap.get("JeanG");
        System.out.println("Value: " + e4.getValue());
    }
}

class MyHashMap {

    Entry[] map;
    int index;
    int capacity;

    public MyHashMap() {
        capacity = 10;
        index = 0;
        map = new Entry[capacity];
    }

    private void Enlarge() {
        capacity = 2 * capacity;
        Entry[] temp = new Entry[capacity];
        System.arraycopy(map, 0, temp, 0, index);
        map = temp;
    }

    public void put(String name, String contact) {
        for (int i = 0; i < index; i++) {
            if (map[i].getKey().equals(name)) {
                map[i].setValue(contact);
                return;
            }
        }

        if (index == capacity) {
            Enlarge();
        }
        map[index++] = new Entry(name, contact);
    }

    public Entry get(String name) {
        for (int i = 0; i < index; i++) {
            if (map[i].getKey().equals(name)) {
                return map[i];
            }
        }
        return null;
    }
}

class Entry {

    private String name;
    private String contact;

    public Entry(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getKey() {
        return this.name;
    }

    public String getValue() {
        return this.contact;
    }

    public void setValue(String contact) {
        this.contact = contact;
    }
}
