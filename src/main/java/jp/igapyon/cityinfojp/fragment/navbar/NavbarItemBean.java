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
package jp.igapyon.cityinfojp.fragment.navbar;

/**
 * Thymeleaf + Bootstrap の Navbar にぶら下がるメニューアイテム のための Bean.
 * 
 * @author Toshiki Iga
 */
public class NavbarItemBean {
    private String text = "Menu1";
    private String href = "#";
    private boolean current = false;
    private boolean dropdown = false;
    private NavbarDropdownBean dropdownBean = null;

    public boolean isDropdown() {
        return dropdown;
    }

    public void setDropdown(boolean dropdown) {
        this.dropdown = dropdown;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public NavbarDropdownBean getDropdownBean() {
        return dropdownBean;
    }

    public void setDropdownBean(NavbarDropdownBean dropdownBean) {
        this.dropdownBean = dropdownBean;
    }
}
