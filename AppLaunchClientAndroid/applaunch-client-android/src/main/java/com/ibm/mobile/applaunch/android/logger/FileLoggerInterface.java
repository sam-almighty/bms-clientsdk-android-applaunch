/*
    Copyright 2015 IBM Corp.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
        http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.ibm.mobile.applaunch.android.logger;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

// We do this abstract craziness to enable unit tests to override the fileLoggerInstance
// with their own implementation of FileLoggerInterface, so we don't have to do so
// much file i/o in test.
public abstract class FileLoggerInterface extends java.util.logging.Logger {
    protected FileLoggerInterface(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    public abstract void log(final JSONObject logData, String fileName) throws SecurityException, IOException;

    public abstract byte[] getFileContentsAsByteArray(File file) throws UnsupportedEncodingException;

}