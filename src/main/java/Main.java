

public class Main {

    public static void main(String[] args) {
        Comparable[]  quickarray= {"aa","bb","cc","ff","aa", "cc"};
        ArraySorter sorterThis = new ArraySorter(quickarray, quickarray.length);
        sorterThis.sortAscending();
        for (int x = 0 ; x<quickarray.length;x++)
        System.out.println(sorterThis.pop() );
    }
}
