class FoodRatings {

    static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    // Map from food name → latest Food object (with current rating)
    private Map<String, Food> foodMap;

    // Map from cuisine → max heap of foods
    private Map<String, PriorityQueue<Food>> cuisineToMaxHeap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineToMaxHeap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);

            cuisineToMaxHeap
                .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                    (a, b) -> {
                        if (b.rating != a.rating) {
                            return b.rating - a.rating; // max heap by rating
                        }
                        return a.name.compareTo(b.name); // lex order tie breaker
                    }
                ))
                .add(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food oldFood = foodMap.get(foodName);
        Food updatedFood = new Food(foodName, oldFood.cuisine, newRating);
        
        // Update the map
        foodMap.put(foodName, updatedFood);
        
        // Add new version to the heap (lazy deletion: old one will be ignored)
        cuisineToMaxHeap.get(oldFood.cuisine).add(updatedFood);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineToMaxHeap.get(cuisine);

        while (!pq.isEmpty()) {
            Food top = pq.peek();
            Food latest = foodMap.get(top.name);
            if (top.rating == latest.rating) {
                return top.name;
            } else {
                pq.poll(); // stale entry, discard
            }
        }
        return "";
    }
}