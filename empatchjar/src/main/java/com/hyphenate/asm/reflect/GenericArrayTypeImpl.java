/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hyphenate.asm.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

public final class GenericArrayTypeImpl implements GenericArrayType {
    private final Type componentType;


    public GenericArrayTypeImpl(Type componentType) {
        this.componentType = componentType;
    }

    public Type getGenericComponentType() {
//        try {
//            return ((ParameterizedTypeImpl)componentType).getResolvedType();
//        } catch (ClassCastException e) {
//            return componentType;
//        }
        return componentType;
//        return GenericArrayTypeImpl.class;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GenericArrayType)) {
            return false;
        }
        GenericArrayType that = (GenericArrayType) o;
        return Objects.equals(getGenericComponentType(), that.getGenericComponentType());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getGenericComponentType());
    }

    public String toString() {
        return componentType.toString() + "[]";
    }
}
