package org.example;

public class Math {
    public static int add(String a, String b){
        if(a == null || b == null){
            throw new IllegalArgumentException("Arguments 'a' and 'b' are required");
        }else {
            return java.lang.Math.addExact(Integer.parseInt(a),Integer.parseInt(b));
        }
    }
}
