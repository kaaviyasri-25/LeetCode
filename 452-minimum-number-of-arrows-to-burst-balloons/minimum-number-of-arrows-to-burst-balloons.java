class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0])); // Sort balloons by their starting point
        int count=1; // Start with 1 arrow for the first balloon
        // Possible arrow range where the first arrow can be shot
        int start=points[0][0];
        int end=points[0][1];
        for(int i=1;i<points.length;i++){ // Start from the second balloon
            if(end>=points[i][0]){ // If current balloon overlaps with the arrow range
                // Keep only the common overlapping range
                start=points[i][0];
                end=Math.min(end,points[i][1]);
            }else{ // No overlap, current arrow cannot burst this balloon
                count++; // So we need another arrow
                // Start a new possible arrow range
                start=points[i][0];
                end=points[i][1];
            }
        }
        return count;
    }
}