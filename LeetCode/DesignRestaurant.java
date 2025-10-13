import java.util.HashMap;
import java.util.List;

public class DesignRestaurant {
    class FoodRatings {

        class List implements Comparable<List> {
            String name;
            String cuisines;
            int rating;

            List(String name, String cuisines, int rating) {
                this.name = name;
                this.cuisines = cuisines;
                this.rating = rating;
            }

            @Override
            public int compareTo(List other) {

                if (this.rating == other.rating) {
                    return this.name.compareTo(other.name);
                }

                return Integer.compare(other.rating, this.rating);
            }
        }

        HashMap<String, PriorityQueue<List>> map = new HashMap<>();
        HashMap<String, List> foodItems = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                String f = foods[i];
                String c = cuisines[i];
                int r = ratings[i];

                List node = new List(f, c, r);

                map.computeIfAbsent(c, k -> new PriorityQueue<>()).add(node);
                foodItems.put(f, node);
            }
        }

        public void changeRating(String food, int newRating) {
            List curr = foodItems.get(food);
            PriorityQueue<List> pq = map.get(curr.cuisines);

            pq.remove(curr);
            curr.rating = newRating;
            pq.add(curr);
        }

        public String highestRated(String cuisine) {
            List curr = map.get(cuisine).peek();
            return curr.name;
        }
    }

}
