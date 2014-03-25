/**
 * Created with IntelliJ IDEA.
 * User: 1O1O
 * Date: 12/8/13
 * Time: 6:52 PM
 * :)~
 * Radix List Sort:Sorting by Distribution:Internal Sorting
 */
public class Main {

    public static void main(String[] args) {
        int N = 12;
        int[] K = new int[13];

        /*Prepare the ordered data table*/
        K[1] = 61;
        K[2] = 87;
        K[3] = 154;
        K[4] = 170;
        K[5] = 275;
        K[6] = 426;
        K[7] = 503;
        K[8] = 509;
        K[9] = 512;
        K[10] = 612;
        K[11] = 653;
        K[12] = 677;

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
        System.out.println();

        /*Kernel of the Algorithm!*/
        int Key = 653;                  /*Key to be found*/
        /*Fibonacci number:0,1,1,2,3,5,8,13,21,34,55...*/
        /*Fn = Fn-1 + Fn-2, F0 = 0, F1 = 1...*/
        /*In this case:N+1=13=F7=Fk+1, then k=6, i=Fk=F6=8, p=Fk-1=F5=5, q=Fk-2=F4=3*/
        int i = 8;
        int p = 5;
        int q = 3;

        do{
            if(Key < K[i]){
                if(q == 0){
                    System.out.println("Outputs: "+Key+" not found.");
                    break;
                }else {
                    i = i-q;
                    int temp = q;
                    q = p-q;
                    p = temp;
                }
            }else if(Key > K[i]){
                if(p == 1){
                    System.out.println("Outputs: "+Key+" not found.");
                    break;
                }else {
                    i = i+q;
                    p = p-q;
                    q = q-p;
                }
            }else {
                System.out.println("Outputs: "+Key+" in K["+i+"].");
                break;
            }
        }while (true);
    }
}