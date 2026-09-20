class Solution {
    public int largestRectangleArea(int[] heights) {
        return Histogram(heights);
    }
    public static int Histogram(int [] arr) {
		Stack<Integer> st = new Stack<>();
		int area=0;
		for (int i = 0; i < arr.length; i++) {
			while(!st.isEmpty() && arr[i]<arr[st.peek()]) {
				int r=i;
				int h=arr[st.pop()];
				if(st.isEmpty()) {
					area=Math.max(area, h*r);
				}
				else {
					int l=st.peek();
					area=Math.max(area, h*(r-l-1));
				}
			}
			st.push(i);
		}
		int r=arr.length;
		while(!st.isEmpty()) {
			int h=arr[st.pop()];
			if(st.isEmpty()) {
				area=Math.max(area, h*r);
			}
			else {
				int l=st.peek();
				area=Math.max(area, h*(r-l-1));
			}
		}
		return area;
		
	}

}