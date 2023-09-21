/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.app.thirdparty.datasource.impl;

import org.apache.seatunnel.app.thirdparty.datasource.DataSourceConfigSwitcher;
import org.apache.seatunnel.common.utils.SeaTunnelException;

import com.google.auto.service.AutoService;

import java.util.List;
import java.util.Optional;

@AutoService(DataSourceConfigSwitcher.class)
public class OracleDataSourceConfigSwitcher extends BaseJdbcDataSourceConfigSwitcher {

    public static final String CATALOG_NAME = "Oracle";

    protected String tableFieldsToSql(List<String> tableFields, String database, String fullTable) {
        String[] split = fullTable.split("\\.");
        if (split.length != 2) {
            throw new SeaTunnelException(
                    "The tableName for oracle must be schemaName.tableName, but tableName is "
                            + fullTable);
        }

        String schemaName = split[0];
        String tableName = split[1];

        return generateSql(tableFields, database, schemaName, tableName);
    }

    protected String quoteIdentifier(String identifier) {
        return "\"" + identifier + "\"";
    }

    @Override
    protected String generateSql(
            List<String> tableFields, String database, String schema, String table) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        for (int i = 0; i < tableFields.size(); i++) {
            sb.append(quoteIdentifier(tableFields.get(i)));
            if (i < tableFields.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" FROM ")
                .append(quoteIdentifier(schema))
                .append(".")
                .append(quoteIdentifier(table));
        return sb.toString();
    }

    @Override
    public String getDataSourceName() {
        return "JDBC-ORACLE";
    }

    protected boolean isSupportDefaultSchema() {
        return true;
    }

    protected Optional<String> getCatalogName() {
        return Optional.of(CATALOG_NAME);
    }
}
