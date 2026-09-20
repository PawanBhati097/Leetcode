class Solution {
    public int maximalRectangle(char[][] matrix) {
     int[] arr=new int[matrix[0].length];
		int ans=0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]=='1') {
					arr[j]++;
				}else {
					arr[j]=0;
				}
			}
			ans=Math.max(ans, Histogram(arr));
		}
		return ans;
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
