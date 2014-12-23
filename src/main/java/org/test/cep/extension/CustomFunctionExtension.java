package org.test.cep.extension;

/*
* Copyright 2004,2005 The Apache Software Foundation.
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

import org.apache.log4j.Logger;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.core.executor.function.FunctionExecutor;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.extension.annotation.SiddhiExtension;

import java.util.Date;


@SiddhiExtension(namespace = "custom", function = "getTimestamp")
public class CustomFunctionExtension extends FunctionExecutor {

    Logger log = Logger.getLogger(CustomFunctionExtension.class);
    Attribute.Type returnType;

    /**
     * Method will be called when initialising the custom function
     *
     * @param types
     * @param siddhiContext
     */
    @Override
    public void init(Attribute.Type[] types, SiddhiContext siddhiContext) {

        returnType = Attribute.Type.LONG;
    }

    /**
     * Method called when sending events to process
     *
     * @param obj
     * @return
     */
    @Override
    protected Object process(Object obj) {

        //Date now = new Date();
        return System.currentTimeMillis();
    }

    @Override
    public void destroy() {

    }

    /**
     * Return type of the custom function mentioned
     *
     * @return
     */
    @Override
    public Attribute.Type getReturnType() {
        return returnType;
    }


}
