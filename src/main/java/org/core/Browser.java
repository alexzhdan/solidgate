package org.core;

public enum Browser {
        CHROME("chrome"),
        FIREFOX("firefox"),
        SAFARI("safari"),
        EDGE("edge"),
        OPERA("opera");

        private final String browserName;

        Browser(String browserName) {
            this.browserName = browserName;
        }

        public String getBrowserName() {
            return browserName;
        }
}
