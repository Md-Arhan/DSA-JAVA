public class Additional {
    class Student {
        private int id;
        private String name;
    
        // Constructor
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    
        // Override hashCode
        @Override
        public int hashCode() {
            int result = 17; // Start with a non-zero constant
            result = 31 * result + id; // Multiply by a prime number and add `id`
            result = 31 * result + (name == null ? 0 : name.hashCode()); // Handle `name`
            return result;
        }
    
        // Override equals to ensure consistent behavior
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Student other = (Student) obj;
            return id == other.id && (name != null ? name.equals(other.name) : other.name == null);
        }
    }
}
