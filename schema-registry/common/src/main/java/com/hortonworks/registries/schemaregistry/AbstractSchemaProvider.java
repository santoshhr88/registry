/*
 * Copyright 2016-2019 Cloudera, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hortonworks.registries.schemaregistry;

import com.hortonworks.registries.schemaregistry.errors.InvalidSchemaException;
import com.hortonworks.registries.schemaregistry.errors.SchemaNotFoundException;

import java.util.Map;

/**
 *
 */
public abstract class AbstractSchemaProvider implements SchemaProvider {

    protected Map<String, Object> config;
    private String defaultSerializerClassName;
    private String defaultDeserializerClassName;
    private SchemaVersionRetriever schemaVersionRetriever;

    @Override
    public void init(Map<String, Object> config) {
        this.config = config;
        schemaVersionRetriever = (SchemaVersionRetriever) config.get(SchemaProvider.SCHEMA_VERSION_RETRIEVER_CONFIG);
        defaultSerializerClassName = (String) config.get("defaultSerializerClass");
        defaultDeserializerClassName = (String) config.get("defaultDeserializerClass");
    }

    @Override
    public String getDefaultSerializerClassName() {
        return defaultSerializerClassName;
    }

    @Override
    public String getDefaultDeserializerClassName() {
        return defaultDeserializerClassName;
    }

    @Override
    public String getResultantSchema(String schemaText) throws InvalidSchemaException, SchemaNotFoundException {
        return schemaText;
    }

    public SchemaVersionRetriever getSchemaVersionRetriever() {
        return schemaVersionRetriever;
    }

}
