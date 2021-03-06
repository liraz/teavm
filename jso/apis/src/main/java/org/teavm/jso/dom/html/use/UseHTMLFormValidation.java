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
package org.teavm.jso.dom.html.use;

import org.teavm.jso.JSMethod;
import org.teavm.jso.JSProperty;
import org.teavm.jso.dom.html.ValidityState;

/**
 * All elements containing html form validation methods - instead of doing duplicated code.
 * Not a real element.
 */
public interface UseHTMLFormValidation {

    @JSProperty
    boolean isWillValidate();

    @JSProperty
    ValidityState getValidity();

    @JSProperty
    String getValidationMessage();

    @JSMethod
    boolean checkValidity();

    @JSMethod
    boolean reportValidity();

    @JSMethod
    void setCustomValidity(String error);
}
