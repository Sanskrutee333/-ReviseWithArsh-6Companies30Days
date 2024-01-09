class Solution {
   public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        TreeSet<Integer> set = new TreeSet<>();
        for(int[] envelope: envelopes) 
        {
            Integer height = set.ceiling(envelope[1]);        
            if (height != null) 
            {
                set.remove(height);
            }
            set.add(envelope[1]);
        }
        return set.size();
    }
}
