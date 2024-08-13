import java.util.*;
import java.io.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int Num1, Num2, Num3;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int count = 1;
    static int[] checked;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Num1 = Integer.parseInt(st.nextToken());
        Num2 = Integer.parseInt(st.nextToken());
        Num3 = Integer.parseInt(st.nextToken());

        checked = new int[Num1 + 1];

        for(int i = 0; i <= Num1; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < Num2; i++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());

            arr.get(N).add(N2);
            arr.get(N2).add(N);
        }

        for(int i = 1; i <= Num1; i++) {
            Collections.sort(arr.get(i), Collections.reverseOrder());
        }

        StringBuilder sb = new StringBuilder();
        dfs(Num3);

        for(int i = 1; i <= Num1; i++) {
            sb.append(checked[i]).append("\n");
        }
        System.out.print(sb);

    }

    public static void dfs(int Num3) {

        checked[Num3] = count;

        for(int i = 0; i < arr.get(Num3).size(); i++) {
            int newNum3 = arr.get(Num3).get(i);
            if(checked[newNum3] == 0) {
                count++;
                dfs(newNum3);
            }
        }
    }

}