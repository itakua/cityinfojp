/*
 * Copyright 2020 Toshiki Iga
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
package jp.igapyon.cityinfojp.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON の prefjp.json にアクセスするための Bean のユーティリティ。
 * 
 * @author Tosihki Iga
 */
public class JsonPrefEntryUtil {
    public static List<JsonPrefEntry> readEntryListFromClasspath() throws IOException {
        try (InputStream is = new ClassPathResource("static/input/prefjp.json").getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            StringBuffer buf = new StringBuffer();
            char[] copyBuf = new char[8192];
            for (;;) {
                int length = br.read(copyBuf);
                if (length <= 0) {
                    break;
                }
                buf.append(new String(copyBuf, 0, length));
            }
            return readEntryList(buf.toString());
        }
    }

    public static List<JsonPrefEntry> readEntryList(File jsonInputFile) throws IOException {
        String jsonInput = FileUtils.readFileToString(jsonInputFile, "UTF-8");
        return readEntryList(jsonInput);
    }

    public static List<JsonPrefEntry> readEntryList(String jsonInput) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(jsonInput, JsonPrefEntry[].class));
    }
}
