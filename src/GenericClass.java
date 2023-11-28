import java.io.Serializable;

public class GenericClass<T extends Comparable, V extends Animal & Serializable, K> {
    private T var1;
    private V var2;
    private K var3;

    public GenericClass(T var1, V var2, K var3) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public T getVar1() {
        return var1;
    }

    public V getVar2() {
        return var2;
    }

    public K getVar3() {
        return var3;
    }

    public void printClassNames() {
        System.out.println("Type of T: " + var1.getClass());
        System.out.println("Type of V: " + var2.getClass());
        System.out.println("Type of K: " + var3.getClass());
    }
}
