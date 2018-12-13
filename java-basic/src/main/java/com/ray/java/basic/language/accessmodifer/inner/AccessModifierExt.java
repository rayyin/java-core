package com.ray.java.basic.language.accessmodifer.inner;

import com.ray.java.basic.language.accessmodifer.AccessModifier;

public class AccessModifierExt extends AccessModifier {


    public void AccessModifierExt() {
    }

    public void printVars() {
        System.out.println("extends class public variable = " + this.publicVar);
        System.out.println("extends class protected variable = " + this.protectedVar);
    }
}
