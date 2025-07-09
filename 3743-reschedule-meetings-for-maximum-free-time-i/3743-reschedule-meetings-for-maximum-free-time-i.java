class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int l = 0, r = 0, n = startTime.length;
        int free = 0;
        int mx = 0;

        int right = 0;
        while (r < k) {
            // calculate gap before the r-th meeting
            int left = (r == 0) ? startTime[r] : startTime[r] - endTime[r - 1];
            free += left;
            r++;
        }

        // calculate gap after the last considered meeting
        right = (r == n) ? eventTime - endTime[n - 1] : startTime[r] - endTime[r - 1];
        mx = Math.max(mx, free + right);

        while (r < n) {
            // remove leftmost
            int left_l = (l == 0) ? startTime[l] : startTime[l] - endTime[l - 1];
            free -= left_l;
            l++;

            // add rightmost
            int left_r = (r == 0) ? startTime[r] : startTime[r] - endTime[r - 1];
            free += left_r;
            r++;

            // calculate right free time
            right = (r == n) ? eventTime - endTime[n - 1] : startTime[r] - endTime[r - 1];
            mx = Math.max(mx, free + right);
        }

        return mx;
    }
}
