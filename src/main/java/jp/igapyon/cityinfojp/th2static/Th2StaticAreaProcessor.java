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
package jp.igapyon.cityinfojp.th2static;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import jp.igapyon.cityinfojp.json.JsonAreaEntry;
import jp.igapyon.cityinfojp.json.JsonAreaEntryUtil;
import jp.igapyon.cityinfojp.thvarmap.ThVarMapAreaBuilder;

public class Th2StaticAreaProcessor {

    public static final void main(String[] args) throws IOException {
        SpringTemplateEngine templateEngine = Th2StaticUtil.getStandaloneSpringTemplateEngine();

        dyn2staticAreaList(templateEngine);
    }

    /**
     * Area ごとページを生成します。
     * 
     * @param templateEngine テンプレートエンジン。
     * @throws IOException 入出力例外が発生した場合。
     */
    static void dyn2staticAreaList(SpringTemplateEngine templateEngine) throws IOException {
        // areaごと静的ページ

        List<JsonAreaEntry> areaEntryList = JsonAreaEntryUtil.readEntryListFromClasspath();
        for (JsonAreaEntry areaEntry : areaEntryList) {
            final IContext ctx = new Context();

            new ThVarMapAreaBuilder(areaEntry).applyContextVariable(ctx);

            String result = templateEngine.process("/dyn/pref/area", ctx);
            FileUtils.writeStringToFile(
                    new File("src/main/resources/static/pref/" + areaEntry.getNameen().toLowerCase() + ".html"), result,
                    "UTF-8");
        }
    }
}
