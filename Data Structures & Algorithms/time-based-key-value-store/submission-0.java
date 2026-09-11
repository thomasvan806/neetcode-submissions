class TimeMap {
    Map<String, List<Integer>> timeMap;
    Map<Integer, String> timestampToValue;

    public TimeMap() {
        timeMap = new HashMap<>();
        timestampToValue = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Integer> timestamps;
        if (!timeMap.containsKey(key)) {
            timestamps = new ArrayList<>();
            timeMap.put(key, timestamps);
        } else {
            timestamps = timeMap.get(key);
        }
        timestamps.add(timestamp);
        timestampToValue.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";

        List<Integer> timestamps = timeMap.get(key);
        
        int min = 0;
        int max = timestamps.size() - 1;
        int mid = (min + max) / 2;

        while (min <= max) {
            int curr = timestamps.get(mid);
            if (curr == timestamp) return timestampToValue.get(curr);

            if (curr < timestamp) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }

            mid = (min + max) / 2;
            // 1, 2, 3, 4, 7, 8, 9
        }

        int curr = timestamps.get(mid);
        return curr > timestamp ? "" : timestampToValue.get(curr);
    }
}
