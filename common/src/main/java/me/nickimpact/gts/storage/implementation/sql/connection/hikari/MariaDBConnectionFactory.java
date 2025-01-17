/*
 * This file is part of LuckPerms, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.nickimpact.gts.storage.implementation.sql.connection.hikari;

import com.nickimpact.impactor.api.storage.StorageCredentials;
import com.zaxxer.hikari.HikariConfig;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MariaDBConnectionFactory extends HikariConnectionFactory {

    public MariaDBConnectionFactory(StorageCredentials configuration) {
        super(configuration);
    }

    @Override
    public String getImplementationName() {
        return "MariaDB";
    }

    @Override
    protected String getDriverClass() {
        return "org.mariadb.jdbc.MariaDbDataSource";
    }

    @Override
    protected void appendProperties(HikariConfig config, Map<String, String> properties) {
        if (properties.isEmpty()) {
            return;
        }

        String propertiesString = properties.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(";"));

        // kinda hacky. this will call #setProperties on the datasource, which will append these options
        // onto the connections.
        config.addDataSourceProperty("properties", propertiesString);
    }


    @Override
    public Function<String, String> getStatementProcessor() {
        return s -> s.replace("'", "`");
    }
}
