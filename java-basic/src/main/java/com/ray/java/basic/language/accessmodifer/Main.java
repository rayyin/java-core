package com.ray.java.basic.language.accessmodifer;

import com.ray.java.basic.language.accessmodifer.inner.AccessModifierExt;

public class Main {

    public static void main(String[] args) {
        AccessModifier accessModifier = new AccessModifier();
        System.out.println("public variable = " + accessModifier.publicVar);
        System.out.println("default variable = " + accessModifier.defaultVar);
        System.out.println("protected variable = " + accessModifier.protectedVar);
    }

    public static void testExtendClass() {
        AccessModifierExt accessModifierExt = new AccessModifierExt();
        accessModifierExt.printVars();
    }
}
