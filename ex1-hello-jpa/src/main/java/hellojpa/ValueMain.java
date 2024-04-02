package hellojpa;

import javax.persistence.criteria.CriteriaBuilder;

public class ValueMain {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        a = 20;
        System.out.println("a="+a); //20
        System.out.println("b="+b); //10

        Integer c = new Integer(10);
        Integer d = c;
        System.out.println("c="+c);
        System.out.println("d="+d);
    }
}
