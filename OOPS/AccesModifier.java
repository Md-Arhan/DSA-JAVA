public class AccesModifier {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.userName = "arhan";
        System.out.println(ba.userName);
        System.out.println(ba.getPass());
        ba.setPassword("abcd@123");
        System.out.println(ba.getPass());
        System.out.println(ba.setPassword("jahdbgaklcn"));
    }
}

class BankAccount {
    public String userName;
    private String password = "arhan";

    public String setPassword(String pwd) {
        password = pwd;
        return this.password;
    }

    String getPass() {
        return this.password; // the this keyword is used to refer to the current object, that prints the object
    }

}
