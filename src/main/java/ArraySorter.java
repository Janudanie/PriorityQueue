

public class ArraySorter  {
    private Comparable[] internalQue;
    private int N = 0;
    private boolean sortDesc = true;

    public ArraySorter (Comparable[] items , int size ) {
        this.internalQue = new Comparable[size+1];
        for (int i = 0; i<items.length; i++) {
            internalQue[++N] = (Comparable) items[i];
            swim(N);
        }

    }

    public void push (Comparable item ) {
        internalQue[++N] = (Comparable) item;
        swim(N);
    }

    public Comparable pop () {
        Comparable temp = internalQue[1];
        internalQue[1] = internalQue[N--];
        sink(1);
        //System.out.println("new top is : " + internalQue[1]);
        return temp;
    }

    public void sortAscending () {
        if(sortDesc) {
            sortDesc = false;
            resortQue();
        }
    }

    public void sortDescending ()
    {
        if(!sortDesc){
            sortDesc = true;
            resortQue();
        }
    }

    public void swim(int a) {
        if (sortDesc) {
            while (a > 1 && compareArray(internalQue[a / 2], internalQue[a])) {
                switchPlaces(a / 2, a);
                a = a / 2;
            }
        }
        if (!sortDesc) {
            while (a > 1 && compareArray(internalQue[a], internalQue[a/2])) {
                switchPlaces(a / 2, a);
                a = a / 2;
            }
        }
    }

    public void sink(int a) {
        if(sortDesc){
            while (2*a <= N) {
                int b = a * 2;
                //System.out.println(internalQue[b] + " is smaller then " + internalQue[b+1] + " " + compareArray(internalQue[b], internalQue[b+1]));
                if (compareArray(internalQue[b], internalQue[b+1])) b++;
                if (!compareArray(internalQue[a],internalQue[b])) break;
                switchPlaces(a,b);
                a=b;
                //System.out.println(compareArray(b, b+1));
                //System.out.println("doing it");
                //System.out.println(b + " " + N);;
            }
        }

        if(!sortDesc){
            while (2*a <= N) {
                int b = a * 2;
                if (compareArray(internalQue[b+1],internalQue[b])) b++;
                if (!compareArray(internalQue[b],internalQue[a])) break;
                switchPlaces(a,b);
                a=b;
            }
        }


    }


    private void resortQue(){
        for (int i = 1; i<N; i++) {
            swim(i);
        }

    }

    public void switchPlaces(int a, int b) {
        Comparable temp = internalQue[a];
        internalQue[a] = internalQue[b];
        internalQue[b] = temp;
    }

    public boolean compareArray(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


}
