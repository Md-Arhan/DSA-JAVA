public class AddTwoNumbers {
    
    public int getNumber(ListNode list){
        //recursive function where need to pass (list , 1);
        // if(list == null) {
        //     return 0;
        // }

        // int sum = list.val * place;

        // return sum + getNumber(list.next, place * 10);

        ListNode temp = list;
        int numbers = 0;
        while(temp!= null){
            numbers = (numbers * 10 + temp.val);
            temp = temp.next;
        }

        return numbers;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        int number1 = getNumber(l1);
        int number2 = getNumber(l2);

        int sum = number1 + number2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        if(sum == 0){
            return new ListNode(0);
        }

        while(sum > 0){
            int lastDigi = sum % 10;
            temp.next = new ListNode(lastDigi);
            temp = temp.next;
            sum = sum/10;
        }

        return dummy.next;   
    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){ 
            int sum = carry;

            if(l1!= null){
                sum+=l1.val;
                l1 = l1.next;
            }

            if(l2!= null){
                sum+=l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
        }

        return dummy.next;
    }
}
