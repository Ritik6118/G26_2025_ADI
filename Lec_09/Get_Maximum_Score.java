package Lec_09;
class Get_Maximum_Score {
    public int maxSum(int[] nums1, int[] nums2) {
        int i=0;   // pointer for nums 1
		int j=0;   // pointer for nums 2
		long si=0;	// sum by path of pointer i
		long sj=0;	// sum by path of pointer j
		long sum=0;  // global sum
		
		while(i<nums1.length && j<nums2.length) {
			if(nums1[i]<nums2[j]) {
				si+=nums1[i];
				i++;
			}
			else if(nums2[j]<nums1[i]) {
				sj+=nums2[j];
				j++;
			}
			else {
				sum+=Math.max(si, sj)+nums1[i];
				i++;
				j++;
				si=0;
				sj=0;
			}
		}
		while(i<nums1.length) {
			si+=nums1[i];
			i++;			
		}
		while(j<nums2.length) {
			sj+=nums2[j];
			j++;			
		}
		sum+=Math.max(si, sj);
		sum%=1000000007;
		return (int)sum;
    }
}