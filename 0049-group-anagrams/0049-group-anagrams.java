class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return Anagram(strs);
    }
    public static  List<List<String>> Anagram(String[] arr){
		   HashMap<String,List<String>> map=new HashMap<>();
		   for (int i = 0; i < arr.length; i++) {
			String key=getkey(arr[i]);
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(arr[i]);
		}
		   List<List<String>> ll=new ArrayList<>();
		   for(String k : map.keySet()) {
			   ll.add(map.get(k));
		   }
		   return ll;
	}
	public static String getkey(String s) {
		int[] freq=new int[26];
		for (int i = 0; i < s.length(); i++) {
			char ch=s.charAt(i);
			freq[ch-'a']++;
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < freq.length; i++) {
			sb.append(freq[i]+" ");
		}
		return sb.toString();
	}
}