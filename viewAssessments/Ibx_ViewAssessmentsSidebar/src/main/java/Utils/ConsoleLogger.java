package Utils;

import Helpers.BrowserInitHelper;
import org.openqa.selenium.logging.LogEntries;

public class ConsoleLogger {

        public static void DebugLog(String str) {
                System.out.println(Colors.Color.YELLOW_BOLD + "[MBT-DEBUGGER] " + str + Colors.Color.RESET);
        }

        public static void ErrorLog(String str) {
                System.out.println(Colors.Color.RED_BOLD + "[MBT-ERROR] " + str + Colors.Color.RESET);
                BrowserInitHelper.tearDown();
                System.exit(0);
        }

        public static void FailedTestCase(String str) {
                System.out.println(Colors.Color.RED_BOLD + "[MBT-FAILED-TEST-CASE] " + str + Colors.Color.RESET);
        }

        public static void JSErrorLog(LogEntries logs) {
                System.out.println(Colors.Color.RED_BOLD + "[MBT-JS-ERROR] " + logs + Colors.Color.RESET);
        }

        public static void SuccessLog(String str) {
                System.out.println(Colors.Color.GREEN_BOLD + "[MBT-SUCCESS] " + str + Colors.Color.RESET);
        }
}
