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

/**
 * https://developer.mozilla.org/en-US/docs/Web/API/HTMLTableRowElement
 */
public interface HTMLTableRowElement extends HTMLElement {

    @JSProperty
    int getRowIndex();

    @JSProperty
    int getSectionRowIndex();

    @JSProperty
    HTMLCollection<HTMLTableCellElement> getCells();

    @JSMethod
    HTMLTableCellElement insertCell();

    @JSMethod
    HTMLTableCellElement insertCell(int index);

    @JSMethod
    void deleteCell(int index);
}
