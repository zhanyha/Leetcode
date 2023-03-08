package array;

class L251_Kth大的数 {
    public int findKthLargest(int[] nums, int k) {
        int l = 0,r = nums.length - 1;
        return selectK(nums,l,r,k);
    }

    private int selectK(int[] nums, int l, int r, int k) {
        int pos = partition(nums,l,r);
        if(pos+1 == k)
            return nums[pos];
        if(pos < k)
            return selectK(nums,pos + 1,r,k);
        else
            return selectK(nums,l,pos - 1,k);
    }

    private int partition(int[] nums, int l, int r) {
        int i = l + 1,j = r;
        while (i <= j){
            while (i <=j && nums[i] >= nums[l])
                i++;
            while (i <=j && nums[j] < nums[l])
                j--;
            if(i < j )
                swap(nums,i,j);
        }
        swap(nums,j,l);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int num = new L251_Kth大的数().findKthLargest(nums,k);
        System.out.println(num);
    }
}