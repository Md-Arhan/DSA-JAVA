class Solution {

     public int isMax(int arr[]){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int nextSmaller[] = new int[n];
        int prevSmaller[] = new int[n];
        
        
        for(int i=n-1; i>=0; i--){
            
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                nextSmaller[i] = n;
            }else{
                nextSmaller[i] = st.peek();
            }
            
            st.push(i);
        }
        
        st = new Stack<>();
        
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                prevSmaller[i] = -1;
            }else{
                prevSmaller[i] = st.peek();
            }
            
            st.push(i);
        }
        
        int max = 0;
        
        for(int i=0; i<n; i++){
            int heigth = arr[i];
            int width = nextSmaller[i] - prevSmaller[i] -1;
            max = Math.max(heigth*width, max);
        }
        
        return max;
        
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][]mat = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = matrix[i][j] - '0';
                System.out.println(mat[i][j]);
            }
        }

        int max = 0;
        int temp[] = new int[m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    temp[j] = 0;
                }else{
                    temp[j]++;
                }
            }
            max = Math.max(max, isMax(temp));
        }
        
        return max;
    }
}