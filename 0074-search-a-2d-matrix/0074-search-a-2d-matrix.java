class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int row = mat.length;
        int column = mat[0].length;
        int low = 0;
        int high = row * column - 1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int rows = mid/column;
            int cols = mid%column;

            if(mat[rows][cols]==target){
                return true;
            }
            else if(mat[rows][cols]<target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return false;
    }
}
