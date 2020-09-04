import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
public class Main {
    }

}

class Ordenamientos {
    public static void burbuja(ArrayList<Integer> v) {
        for (short i = 0; i < v.size() - 1; ++i) {
            for (short j = 1; j < v.size() - i; ++j)
                if (v.get(j) <= v.get(j - 1)) Collections.swap(v, j, j - 1);
        }
    }
    public static void insercion(ArrayList<Integer> v) {
        for (short i = 0; i < v.size(); ++i) {
            Integer aux = v.get(i);
            short j = (short) (i - 1);
            while (j >= 0 && aux < v.get(j))
                v.set(j + 1, v.get(j--));
            v.set(j + 1, aux);
        }
    }
    static void mSort(ArrayList<Integer> v, short primero, short ultimo) {
        if (primero < ultimo) {
            short centro = (short) ((primero + ultimo) / 2);
            mSort(v, primero, centro);
            mSort(v, (short) (centro + 1), ultimo);
            merge(v, primero, centro, ultimo);
        }
    }
    private static void merge(ArrayList<Integer> v, short primero, short centro, short ultimo) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (short i = 0; i < centro - primero + 1; ++i) A.add(v.get(primero + i));
        for (short i = 0; i < ultimo - centro; ++i) B.add(v.get(centro + i + 1));
        short i = primero;
        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.get(0) > B.get(0)) {
                v.set(i++, B.get(0));
                B.remove(0);
            } else {
                v.set(i++, A.get(0));
                A.remove(0);
            }
        }
        while (!A.isEmpty()) {
            v.set(i++, A.get(0));
            A.remove(0);
        }
        while (!B.isEmpty()) {
            v.set(i++, B.get(0));
            B.remove(0);
        }
    }
  public static void qSort(ArrayList<Integer> v, short pvtIzq, short pvtDer){
        if(pvtIzq < pvtDer){
            short pvt = pvts(v, pvtIzq, pvtDer);
            qSort(v, pvtIzq, (short) (pvt - 1));
            qSort(v, (short) (pvt + 1), pvtDer);
        }
    }
    private static short pvts(ArrayList<Integer> v, short pvtIzq, short pvtDer){
        short pvt = (short) Integer.parseInt(String.valueOf(v.get(pvtIzq)));
        short pIzq = pvtIzq;
        short pDer = pvtDer;
        while(pIzq < pDer){
            for(; v.get(pDer) > pvt; --pDer){}
            for(; pIzq < pDer && v.get(pIzq) <= pvt; ++pIzq){}
            if(pIzq < pDer)Collections.swap(v, pIzq, pDer);
        }
        Collections.swap(v,pvtIzq, pDer);
        return pIzq;
    }
}
