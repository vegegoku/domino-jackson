package com.progressoft.brix.domino.gwtjackson.deser.bean;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.progressoft.brix.domino.gwtjackson.JsonDeserializationContext;
import com.progressoft.brix.domino.gwtjackson.stream.JsonReader;


/**
 * <p>PropertyIdentityDeserializationInfo class.</p>
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PropertyIdentityDeserializationInfo<T> implements IdentityDeserializationInfo<T> {

    /**
     * Name of the property holding the identity
     */
    private final String propertyName;

    /**
     * Type of {@link ObjectIdGenerator} used for generating Object Id
     */
    private final Class<?> type;

    /**
     * Scope of the Object Id (may be null, to denote global)
     */
    private final Class<?> scope;

    /**
     * <p>Constructor for PropertyIdentityDeserializationInfo.</p>
     *
     * @param propertyName a {@link String} object.
     * @param type a {@link Class} object.
     * @param scope a {@link Class} object.
     */
    public PropertyIdentityDeserializationInfo( String propertyName, Class<?> type, Class<?> scope ) {
        this.propertyName = propertyName;
        this.type = type;
        this.scope = scope;
    }

    /** {@inheritDoc} */
    @Override
    public final String getPropertyName() {
        return propertyName;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isProperty() {
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public IdKey newIdKey( Object id ) {
        return new IdKey( type, scope, id );
    }

    /** {@inheritDoc} */
    @Override
    public final Object readId(JsonReader reader, JsonDeserializationContext ctx ) {
        throw ctx.traceError( "readId() is not supported by PropertyIdentitySerializationInfo" );
    }
}
