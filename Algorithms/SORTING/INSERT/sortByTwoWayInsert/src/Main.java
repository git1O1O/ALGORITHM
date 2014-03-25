public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];
        int[] outputs = new int[2*N+1];

        //Prepare the data
        K[1] = 503;
        K[2] = 87;
        K[3] = 512;
        K[4] = 61;
        K[5] = 908;
        K[6] = 170;
        K[7] = 897;
        K[8] = 275;
        K[9] = 653;
        K[10] = 426;
        K[11] = 154;
        K[12] = 509;
        K[13] = 612;
        K[14] = 677;
        K[15] = 765;
        K[16] = 703;

        //Output unsorted Ks
        System.out.println("Unsorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
        System.out.println();

        //Kernel of the Algorithm!
        int dest = 0;
        int center = (2*N+1)/2;
        int i = center;
        int k = center;
        int left = center;
        int right = center;
        outputs[center] = K[1];
        for(int j=2; j<=N; j++){
            int Key = K[j];
            while(i <= k){
                int mid = (i+k)/2;
                if(outputs[mid] < Key){
                    i = ++mid;
                    dest = i;
                }else if(outputs[mid] == Key){
                    dest = ++mid;
                    break;
                }else {
                    dest = mid;
                    k = --mid;
                }
            }
            if(dest >= (left+right)/2){
                right++;
                //right move
                for(int n=right; n>dest; n--){
                    outputs[n] = outputs[n-1];
                }
                outputs[dest] = Key;
            }else {
                left--;
                //left move
                for(int l=left; l<dest-1; l++){
                    outputs[l] = outputs[l+1];
                }
                outputs[dest-1] = Key;
            }
            i = left;
            k = right;
        }

        //Output sorted Ks
        System.out.println("Sorted Ks:");
        int dist = i-1;
        while (i<=k){
            System.out.println((i-dist)+":"+outputs[i]);
            i++;
        }
    }
}
