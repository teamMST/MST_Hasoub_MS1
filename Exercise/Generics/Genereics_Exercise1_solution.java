public class GenericMaxFinder {

    // Generic static method to find the maximum of two comparable objects
    public static <T extends Comparable<T>> T findMax(T first, T second) {
        // Use the compareTo method to compare the two objects
        return first.compareTo(second) >= 0 ? first : second;
    }

    public static void main(String[] args) {
        // Test the method with different types
        System.out.println(findMax(10, 20)); // Output: 20
        System.out.println(findMax(3.5, 2.8)); // Output: 3.5
        System.out.println(findMax("apple", "banana")); // Output: banana
		
		// Example:
		// findMax(findMax))
		// findMax(Box)
    }
}
