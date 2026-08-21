class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        
        int low = 0;
        int high = column -1;

        while(low<=high){
            int mid = low + (high - low)/2;
            int maxRow = 0;

            for(int i =0;i<row;i++){
                if(mat[i][mid]>mat[maxRow][mid]){
                    maxRow = i;
                }
            }
            int left, right;
            if(mid-1>=0){
                left = mat[maxRow][mid-1];
            }
            else{
                left = -1;

            }
            if(mid+1<column){
                right = mat[maxRow][mid+1];
            }else{
                right =-1;
            }

        if (mat[maxRow][mid] > left &&
                mat[maxRow][mid] > right) {

                return new int[]{maxRow, mid};
            }

            // Peak must exist on the left
            else if (left > mat[maxRow][mid]) {
                high = mid - 1;
            }

            // Peak must exist on the right
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}