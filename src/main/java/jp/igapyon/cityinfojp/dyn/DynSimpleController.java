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
package jp.igapyon.cityinfojp.dyn;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.igapyon.cityinfojp.thvarmap.ThVarMapSimpleBuilder;

@Controller
public class DynSimpleController {
    @GetMapping({ "/dyn/about.html", //
            "/dyn/arch.html", //
            "/dyn/contributor.html", //
            "/dyn/faq.html", //
            "/dyn/link.html", //
            "/dyn/policy.html" })
    public String index(Model model, HttpServletRequest request) throws IOException {
        new ThVarMapSimpleBuilder(request.getRequestURI()).applyModelAttr(model);

        return ThVarMapSimpleBuilder.getPathStringWithoutExt(request.getRequestURI());
    }
}
