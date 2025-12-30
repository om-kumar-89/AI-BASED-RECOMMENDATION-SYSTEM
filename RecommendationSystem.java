import java.util.*;

public class RecommendationSystem {

    // Function to find recommendations for a target user
    public static Set<String> getRecommendations(
            Map<String, List<String>> userData,
            String targetUser) {

        Set<String> recommendations = new HashSet<>();

        List<String> targetItems = userData.get(targetUser);

        // Compare target user with every other user
        for (String user : userData.keySet()) {

            if (!user.equals(targetUser)) {

                List<String> otherItems = userData.get(user);

                for (String item : otherItems) {

                    // Recommend only if target user has not seen that item
                    if (!targetItems.contains(item)) {
                        recommendations.add(item);
                    }
                }
            }
        }
        return recommendations;
    }

    public static void main(String[] args) {

        // Sample user-item data
        Map<String, List<String>> userData = new HashMap<>();

        userData.put("User1", Arrays.asList("Laptop", "Mouse", "Keyboard"));
        userData.put("User2", Arrays.asList("Laptop", "Headphones"));
        userData.put("User3", Arrays.asList("Mouse", "Headphones", "Charger"));

        String targetUser = "User2";

        Set<String> result = getRecommendations(userData, targetUser);

        System.out.println("Items liked by similar users:");
        System.out.println(result);

        System.out.println("\nRecommended for " + targetUser + ":");
        result.removeAll(userData.get(targetUser));   // Remove already known items
        System.out.println(result);
    }
}
