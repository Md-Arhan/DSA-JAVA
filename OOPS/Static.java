public class Static {

    public static void main(String[] args) {
        // Student st = new Student();
        // st.schoolName = "hkbk";
        // st.name = "arhan";
        // System.out.println(st.name);
        // System.out.println(st.schoolName);

    }
}

class Student {
    String name;
    int roll;

    static String schoolName;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
