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
package org.teavm.jso.dom.html;

import org.teavm.jso.JSMethod;
import org.teavm.jso.JSProperty;
import org.teavm.jso.dom.events.MouseEvent;
import org.teavm.jso.dom.xml.Element;

/**
 * https://developer.mozilla.org/en-US/docs/Web/API/HTMLDialogElement
 */
public interface HTMLDialogElement extends HTMLElement {

    @JSProperty
    boolean isOpen();

    @JSProperty
    void setOpen(boolean open);

    @JSProperty
    String getReturnValue();

    @JSMethod
    void show();

    @JSMethod
    void show(MouseEvent anchor);

    @JSMethod
    void show(Element anchor);

    @JSMethod
    void showModal();

    @JSMethod
    void showModal(MouseEvent anchor);

    @JSMethod
    void showModal(Element anchor);

    @JSMethod
    void close();

    @JSMethod
    void close(String returnValue);
}
