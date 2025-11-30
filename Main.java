public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Cache with Capacity 4...");
        // Initialize State using the definition in LRUFunctions
        LRUFunctions.CacheState myCache = new LRUFunctions.CacheState(4);

        System.out.println("put(1, A)");
        LRUFunctions.put(myCache, 1, "A");

        System.out.println("put(2, B)");
        LRUFunctions.put(myCache, 2, "B");

        System.out.println("get(1) -> " + LRUFunctions.get(myCache, 1));

        System.out.println("put(3, C)");
        LRUFunctions.put(myCache, 3, "C");

        System.out.println("put(4, D)");
        LRUFunctions.put(myCache, 4, "D");

        System.out.println("put(5, E)");
        LRUFunctions.put(myCache, 5, "E");

        System.out.println("get(3) -> " + LRUFunctions.get(myCache, 3));

        System.out.println("\nFinal Cache Contents (MRU -> LRU):");
        LRUFunctions.Node current = myCache.head;
        while (current != null) {
            System.out.println(current.key + ":" + current.value);
            current = current.next;
        }
    }
}