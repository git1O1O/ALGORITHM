public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];
        int temp;
        int maxIndex;

        /*Prepare the data*/
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

        /*Output unsorted Ks*/
        System.out.println("Unsorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
        System.out.println();

        /*Kernel of the Algorithm!*/
        for(int j=N; j>=2; j--){
            maxIndex = j;
            for(int i=1; i<=j; i++){
                if(K[i] > K[maxIndex]){
                    maxIndex = i;
                }
            }
            temp = K[j];
            K[j] = K[maxIndex];
            K[maxIndex] = temp;
        }

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}
