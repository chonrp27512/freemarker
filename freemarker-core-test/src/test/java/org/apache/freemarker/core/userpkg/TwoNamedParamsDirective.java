/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.freemarker.core.userpkg;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

import org.apache.freemarker.core.Environment;
import org.apache.freemarker.core.TemplateException;
import org.apache.freemarker.core.model.CallPlace;
import org.apache.freemarker.core.model.TemplateModel;
import org.apache.freemarker.core.util.StringToIndexMap;

public class TwoNamedParamsDirective extends TestTemplateDirectiveModel {

    private static final String N1_ARG_NAME = "n1";
    private static final String N2_ARG_NAME = "n2";
    private static final int N1_ARG_IDX = 0;
    private static final int N2_ARG_IDX = 1;

    private static final StringToIndexMap PARAM_NAME_TO_IDX = StringToIndexMap.of(
            N1_ARG_NAME, N1_ARG_IDX,
            N2_ARG_NAME, N2_ARG_IDX);

    @Override
    public void execute(TemplateModel[] args, CallPlace callPlace, Writer out, Environment env)
            throws TemplateException, IOException {
        out.write("#n(");
        printParam(N1_ARG_NAME, args[N1_ARG_IDX], out, true);
        printParam(N2_ARG_NAME, args[N2_ARG_IDX], out);
        out.write(")");
    }

    @Override
    public int getPredefinedPositionalArgumentCount() {
        return 0;
    }

    @Override
    public boolean hasPositionalVarargsArgument() {
        return false;
    }

    @Override
    public int getPredefinedNamedArgumentIndex(String name) {
        return PARAM_NAME_TO_IDX.get(name);
    }

    @Override
    public int getNamedVarargsArgumentIndex() {
        return -1;
    }

    @Override
    public int getArgumentArraySize() {
        return PARAM_NAME_TO_IDX.size();
    }

    @Override
    public Collection<String> getPredefinedNamedArgumentNames() {
        return PARAM_NAME_TO_IDX.getKeys();
    }
}
