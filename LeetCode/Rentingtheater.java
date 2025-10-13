public class Rentingtheater {
    class MovieRentingSystem {

        class Theater implements Comparable<Theater> {
            int shop;
            int movieId;
            int price;
            boolean isRented = false;

            Theater(int shop, int movie, int price) {
                this.shop = shop;
                this.movieId = movie;
                this.price = price;
            }

            @Override
            public int compareTo(Theater other) {
                if (this.price != other.price)
                    return this.price - other.price;
                if (this.shop != other.shop)
                    return this.shop - other.shop;
                return this.movieId - other.movieId;
            }
        }

        private final Map<Integer, TreeSet<Theater>> movies = new HashMap<>();
        private final Map<String, Theater> quick = new HashMap<>();
        private final TreeSet<Theater> rented = new TreeSet<>();
        private final int n;

        public MovieRentingSystem(int n, int[][] entries) {
            this.n = n;

            for (int i = 0; i < entries.length; i++) {
                int s = entries[i][0];
                int m = entries[i][1];
                int p = entries[i][2];

                Theater entry = new Theater(s, m, p);

                movies.putIfAbsent(m, new TreeSet<>());
                quick.putIfAbsent(s + "#" + m, entry);

                movies.get(m).add(entry);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> ans = new ArrayList<>();
            TreeSet<Theater> curr = movies.get(movie);
            if (curr == null)
                return ans;

            for (Theater t : curr) {
                if (!t.isRented) {
                    ans.add(t.shop);
                    if (ans.size() == 5)
                        break;
                }
            }
            return ans;
        }

        public void rent(int shop, int movie) {
            Theater t = quick.get(shop + "#" + movie);
            if (t != null && !t.isRented) {
                t.isRented = true;
                rented.add(t);
            }
        }

        public void drop(int shop, int movie) {
            Theater t = quick.get(shop + "#" + movie);
            if (t != null && t.isRented) {
                t.isRented = false;
                rented.remove(t);
            }
        }

        public List<List<Integer>> report() {
            List<List<Integer>> ans = new ArrayList<>();
            int count = 0;

            for (Theater t : rented) {
                if (count < 5) {
                    count++;
                    ans.add(Arrays.asList(t.shop, t.movieId));
                }
            }
            return ans;
        }
    }

    /**
     * Your MovieRentingSystem object will be instantiated and called as such:
     * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
     * List<Integer> param_1 = obj.search(movie);
     * obj.rent(shop,movie);
     * obj.drop(shop,movie);
     * List<List<Integer>> param_4 = obj.report();
     */
}
