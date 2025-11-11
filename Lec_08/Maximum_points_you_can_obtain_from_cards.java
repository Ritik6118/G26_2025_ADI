package Lec_08;
class Maximum_points_you_can_obtain_from_cards {
    public int maxScore(int[] cardPoints, int k) {
        int max =0;
        int sum = 0;
        int i;
        for( i =0 ; i<k ; i++){
            sum += cardPoints[i];
        }
        i--;
        max = sum;
        for(int j =cardPoints.length-1 ; j>=cardPoints.length-k ; j--){
            sum -= cardPoints[i] ;
            i--;
            sum += cardPoints[j];
            max = Math.max(max , sum);
        }
        return max;
    }
}