class Solution {
    public int countPrimes(int n) {
		if(n<=2){
            return 0;
        }
        return PrimeSieve(n);
	}
    public static int PrimeSieve(int n) {
		int[] prime = new int[n];
		prime[0] = 1; // ye prime number nhi hai
		prime[1] = 1; // ye prime number nhi hai
		for (int i = 2; i * i < prime.length; i++) {
			if (prime[i] == 0) {
				for (int j = 2; i*j < prime.length; j++) {
					prime[i*j]=1;
				}
			}
		}
		int c=0;
		for (int i = 2; i < prime.length; i++) {
			if(prime[i]==0) {
				c++;
			}
		}
		return c;
		
	}
    }
