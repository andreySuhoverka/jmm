package com.sukhoverka.jmm;

import javassist.CannotCompileException;

public class JmmOutOfMemoryPermGetn {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();
    public static void main(String[] args) throws CannotCompileException {
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("com.sukhoverka.jmm.Generated" + i).toClass();
        }
    }

}