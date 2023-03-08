package array;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if(T[i] < T[j]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}