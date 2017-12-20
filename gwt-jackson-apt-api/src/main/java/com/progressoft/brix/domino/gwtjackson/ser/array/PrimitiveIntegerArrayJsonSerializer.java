/*
 * Copyright 2013 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.progressoft.brix.domino.gwtjackson.ser.array;

import com.progressoft.brix.domino.gwtjackson.JsonSerializationContext;
import com.progressoft.brix.domino.gwtjackson.JsonSerializer;
import com.progressoft.brix.domino.gwtjackson.JsonSerializerParameters;
import com.progressoft.brix.domino.gwtjackson.stream.JsonWriter;

/**
 * Default {@link JsonSerializer} implementation for array of int.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveIntegerArrayJsonSerializer extends JsonSerializer<int[]> {

    private static final PrimitiveIntegerArrayJsonSerializer INSTANCE = new PrimitiveIntegerArrayJsonSerializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveIntegerArrayJsonSerializer}
     */
    public static PrimitiveIntegerArrayJsonSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveIntegerArrayJsonSerializer() { }

    /** {@inheritDoc} */
    @Override
    protected boolean isEmpty( int[] value ) {
        return null == value || value.length == 0;
    }

    /** {@inheritDoc} */
    @Override
    public void doSerialize( JsonWriter writer, int[] values, JsonSerializationContext ctx, JsonSerializerParameters params ) {
        if ( !ctx.isWriteEmptyJsonArrays() && values.length == 0 ) {
            writer.cancelName();
            return;
        }

        if ( ctx.isWriteSingleElemArraysUnwrapped() && values.length == 1 ) {
            writer.value( values[0] );
        } else {
            writer.beginArray();
            for ( int value : values ) {
                writer.value( value );
            }
            writer.endArray();
        }
    }
}
