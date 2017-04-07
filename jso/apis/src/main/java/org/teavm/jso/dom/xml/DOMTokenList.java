/*
 *  Copyright 2014 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.jso.dom.xml;

import org.teavm.jso.JSMethod;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * https://developer.mozilla.org/en-US/docs/Web/API/DOMTokenList
 */
public interface DOMTokenList extends JSObject {

    @JSProperty
    String getValue();

    @JSMethod
    void add(String... tokens);

    @JSMethod
    boolean contains(String token);

    @JSMethod
    void remove(String... tokens);

    @JSMethod
    boolean toggle(String token);

    @JSMethod
    boolean toggle(String token, boolean force);

    @JSMethod
    void replace(String token, String newToken);

    @JSMethod
    boolean supports(String token);
}
