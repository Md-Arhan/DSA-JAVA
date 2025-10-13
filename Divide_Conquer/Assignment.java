package Divide_Conquer;

//Assigment Questions



// public class Div_Con {
//     public static void print(String arr[]){
//                 for(int i=0; i<arr.length; i++){
//                     System.out.print(arr[i] + " ");
//                 }
//                 System.out.println();
//             }
        
//             public static void mergeSort(String arr[], int si, int ei){
        
//                 //base case
//                 if(si >= ei){
//                     return;
//                 }
//               //Work
//               int mid = si + (ei-si)/2;
//               mergeSort(arr, si, mid);
//               mergeSort(arr, mid+1, ei);
        
//               //Merging
//               merge(arr, si, ei, mid);
        
//             }
        
//             public static void merge(String arr[], int si, int ei, int mid){
//               String temp[] = new String[ei-si+1];
//               int i = si;
//               int j = mid+1;
//               int k = 0;
        
//               while (i<=mid && j <= ei) {
//                 if (arr[i].compareTo(arr[j])<0) {
//                     temp[k++] = arr[i++];
        
//                 }else{
//                     temp[k++] = arr[j++];
        
//                 }
        
//               }
        
//               while(i<=mid){
//                 temp[k++] = arr[i++];
//               }
        
//               while(j<=ei){
//                 temp[k++] = arr[j++];
//               }
        
//               //copy the temp into original
//               // for(int c=0; c<temp.length; c++){
//               //     arr[si + c] = temp[c];
//               // }
        
//               for(k=0, i=si; k<temp.length; k++, i++){
//                 arr[i] = temp[k];
//               }
        
//             }
        
//             public static void main(String args[]){
//                String arr[] = {"sun", "earth", "mars", "mercury"};
//                mergeSort(arr, 0, arr.length-1);
//                print(arr);
//             }
    
// }




//Count no of Inversion

// public class Div_Con {

//     public static void print(int arr[]){
//         for(int i=0; i<arr.length; i++){
//             System.out.print(arr[i] + " ");
//         }
//         System.out.println();
//     }

//     public static int mergeSort(int arr[], int si, int ei){

//         int count = 0;
//         if(si < ei){

//             int mid = si + (ei-si)/2;
//             count+= mergeSort(arr, si, mid);
//             count+=mergeSort(arr, mid+1, ei);
//             count+=merge(arr, si, ei, mid);
//         }
//         return count;

//       //Merging

//     }

//     public static int merge(int arr[], int si, int ei, int mid){
//       int temp[] = new int[ei-si+1];
//       int n = ei-si+1;
//       int i = si;
//       int j = mid+1;
//       int k = 0;
//       int ans = 0;

//       while (i<=mid && j <= ei) {
//         if (arr[i] < arr[j]) {
//             temp[k++] = arr[i++];

//         }else{
//             ans+=(n-i-1);  //in live seesion i was 0 here i is 1
//             temp[k++] = arr[j++];

//         }

//       }

//       while(i<=mid){
//         temp[k++] = arr[i++];
//       }

//       while(j<=ei){
//         temp[k++] = arr[j++];
//       }

//       //copy the temp into original
//       // for(int c=0; c<temp.length; c++){
//       //     arr[si + c] = temp[c];
//       // }

//       for(k=0, i=si; k<temp.length; k++, i++){
//         arr[i] = temp[k];
//       }
//       return ans;

//     }

//     public static void main(String args[]){
//        int arr[] = {9, 7, 5, 2};
//        int ans = mergeSort(arr, 0, arr.length-1);
//        System.out.println(ans);
       
//     }

// }