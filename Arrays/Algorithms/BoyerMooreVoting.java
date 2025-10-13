package Arrays.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class BoyerMooreVoting {
    class GFG
{

  // Function to find majority element
  public static int findMajority(int[] nums)
  {
    int count = 0, candidate = -1;

    // Finding majority candidate
    for (int index = 0; index < nums.length; index++) {
      if (count == 0) {
        candidate = nums[index];
        count = 1;
      }
      else {
        if (nums[index] == candidate)
          count++;
        else
          count--;
      }
    }

    // Checking if majority candidate occurs more than
    // n/2 times
    count = 0;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] == candidate)
        count++;
    }
    if (count > (nums.length / 2))
      return candidate;
    return -1;

    // The last for loop and the if statement step can
    // be skip if a majority element is confirmed to
    // be present in an array just return candidate
    // in that case
  }

  //LeetCode 229:
  public List<Integer> majorityElement(int[] nums) {
    /*
     * Go through the array: nums = {1, 2, 3, 3, 3, 3, 4, 4, 4}

1 → count1 == 0 → candidate1 = 1, count1 = 1
2 → count2 == 0 → candidate2 = 2, count2 = 1
3 → not equal to candidate1 or candidate2 → count1--, count2-- → count1 = 0, count2 = 0
3 → count1 == 0 → candidate1 = 3, count1 = 1
3 → candidate1 == 3 → count1 = 2
3 → candidate1 == 3 → count1 = 3
4 → not candidate1 → count2 == 0 → candidate2 = 4, count2 = 1
4 → candidate2 == 4 → count2 = 2
4 → candidate2 == 4 → count2 = 3
     */
        int n = nums.length;
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // Step 1: Finding potential candidates
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) count1++;
            if (candidate2 != null && num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }

  // Driver code
  public static void main(String[] args)
  {
    int arr[] = { 1, 1, 1, 1, 2, 3, 4 };
    int majority = findMajority(arr);
    System.out.println(" The majority element is : "
                       + majority);
  }
}
}
