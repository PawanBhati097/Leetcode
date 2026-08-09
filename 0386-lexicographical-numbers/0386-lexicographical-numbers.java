class Solution {
    public List<Integer> lexicalOrder(int n) {
      List<Integer> ll=new ArrayList<>();
		Lexicographical(n, 0,ll);
		//System.out.println(ll);
        return ll;
	}
	public static void Lexicographical(int n,int curr,List<Integer> ll) {
		if(curr>n) {
			return;
		}
		//System.out.println(curr);
		if(curr!=0) {
			ll.add(curr);
		}
		int i=0;
		if(curr==0) {
			i=1;
		}
		for (; i <=9; i++) {
			Lexicographical(n, curr*10+i,ll);
		}
	}
}
