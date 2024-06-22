package GOH.PastYear2020_Sem1.Q4;

public class Q4 {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        System.out.println("New directory entry: ");
        myHashMap.put("BruceW", "011-8998990");
        myHashMap.put("DeanW", "017-2274000");
        myHashMap.put("TonyS", "019-4550800");
        myHashMap.put("LaraC", "014-6402009");
        System.out.println("");

        System.out.println("Get directory: ");
        Entry e1 = myHashMap.get("DeanW");
        System.out.println("DeanW: " + e1.getValue());
        Entry e2 = myHashMap.get("BruceW");
        System.out.println("BruceW: " + e2.getValue());
        System.out.println("");

        System.out.println("Update directory: ");
        myHashMap.put("BruceW", "011-5677900");
        myHashMap.put("JeanG", "019-9001123");

        //System.out.println("Get directory: ");
        Entry e3 = myHashMap.get("BruceW");
        System.out.println("BruceW: " + e3.getValue());
        Entry e4 = myHashMap.get("JeanG");
        System.out.println("JeanG: " + e4.getValue());
        System.out.println();
    }
}

class MyHashMap {
    Entry head;
    
    public MyHashMap() {
        head = null;
    }

    public void put(String name, String contact) {
        if (head == null) {
            head = new Entry(name, contact);
        } else {
            boolean tf = false;
            Entry curr = head;
            while (curr != null) {
                if (curr.name.equals(name)) {
                    curr.contact = contact;
                    tf = true;
                    break;
                }
                curr = curr.next;
            }

            if (!tf) {
                Entry temp = new Entry(name, contact);
                temp.next = head;
                head = temp;
            }
        }
    }

    public Entry get(String name) {
        if (head == null) {
            return null;
        } else {
            Entry curr = head;
            while (curr != null) {
                if (curr.name.equals(name)) {
                    return curr;
                }
                curr = curr.next;
            }
            return null;
        }
    }
}

class Entry {
    String name;
    String contact;
    Entry next;

    public Entry(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getValue() {
        return contact;
    }
}
