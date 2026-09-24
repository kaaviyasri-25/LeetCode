class Solution {
    public static int days(String s){
        int [] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int months = Integer.parseInt(s.substring(0,2));
        int no_days = Integer.parseInt(s.substring(3,5));
        int total = 0;
        for(int i = 0; i < months - 1; i++){
            total += month[i];
        }
        total += no_days;
        return total;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceStart = days(arriveAlice);
        int aliceEnd = days(leaveAlice);
        int bobStart = days(arriveBob);
        int bobEnd = days(leaveBob);
        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);
        if(start <= end){
            return end - start + 1;
        }else{
            return 0;
        }
    }
}